package org.okcjug.graphql.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLField;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLObject;
import graphql.schema.DataFetchingEnvironmentImpl;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Data
@GraphQLObject("Planet")
public class PlanetObjectType {

    private String name;
    private String diameter;
    @JsonProperty("rotational_period")
    private String rotationalPeriod;
    @JsonProperty("orbital_period")
    private String orbitalPeriod;
    private String gravity;
    private String population;
    private String climate;
    private String terrain;
    @JsonProperty("surface_water")
    private String surfaceWater;
    @JsonProperty("residents")
    private List<String> residentUrls;
    @JsonProperty("films")
    private List<String> filmUrls;
    private String created;
    private String edited;

    @GraphQLField
    public List<FilmObjectType> films(DataFetchingEnvironmentImpl environment) {
        PlanetObjectType source = environment.getSource();
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        headers.add("User-Agent", "");
        return source.getFilmUrls().stream()
                .map(uri -> new RestTemplate().exchange(uri, GET, new HttpEntity<>(headers), FilmObjectType.class))
                .map(response -> response.getBody())
                .collect(Collectors.toList());
    }

    @GraphQLField
    public List<PersonObjectType> residents(DataFetchingEnvironmentImpl environment) {
        PlanetObjectType source = environment.getSource();
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        headers.add("User-Agent", "");
        return source.getResidentUrls().stream()
                .map(uri -> new RestTemplate().exchange(uri, GET, new HttpEntity<>(headers), PersonObjectType.class))
                .map(response -> response.getBody())
                .collect(Collectors.toList());
    }
}
