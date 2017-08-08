package org.okcjug.graphql.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLField;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLIgnore;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLIn;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLObject;
import graphql.schema.DataFetchingEnvironmentImpl;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.math.NumberUtils.isParsable;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Data
@GraphQLObject("Person")
public class PersonObjectType extends BaseObjectType {

    private String name;
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("eye_color")
    private String eyeColor;
    private String gender;
    @JsonProperty("hair_color")
    private String hairColor;
    @GraphQLIgnore
    @JsonProperty("height")
    private String heightInCentimeters;
    private String mass;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("homeworld")
    private String homeWorldUrl;
    @JsonProperty("films")
    private List<String> filmUrls = new ArrayList<>();
    private String created;
    private String edited;

    @GraphQLField
    public String height(@GraphQLIn(value = "unit", defaultSpel = "'METERS'") String unit, DataFetchingEnvironmentImpl environment) {
        PersonObjectType source = environment.getSource();
        String height = source.getHeightInCentimeters();
        if (isParsable(height)) {
            double meters = Double.valueOf(height) / 100.;
            if (unit.equals("FEET")) {
                return String.valueOf(meters * 3.2808);
            }
            return String.valueOf(meters);
        }
        return heightInCentimeters;
    }

    @GraphQLField
    public List<FilmObjectType> films(DataFetchingEnvironmentImpl environment) {
        PersonObjectType source = environment.getSource();
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        headers.add("User-Agent", "");
        List<FilmObjectType> result = source.getFilmUrls().stream()
                .map(uri -> new RestTemplate().exchange(uri, GET, new HttpEntity<>(headers), FilmObjectType.class))
                .map(response -> response.getBody())
                .collect(Collectors.toList());
        return result;
    }

    @GraphQLField
    public PlanetObjectType homeWorld(DataFetchingEnvironmentImpl environment) {
        PersonObjectType source = environment.getSource();
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        headers.add("User-Agent", "");
        return new RestTemplate().exchange(source.getHomeWorldUrl(), GET, new HttpEntity<>(headers), PlanetObjectType.class).getBody();
    }
}
