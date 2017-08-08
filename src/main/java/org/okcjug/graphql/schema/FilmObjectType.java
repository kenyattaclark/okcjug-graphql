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
@GraphQLObject("Film")
public class FilmObjectType extends BaseObjectType {

    private String title;
    @JsonProperty("episode_id")
    private String episodeId;
    @JsonProperty("opening_crawl")
    private String openingCrawl;
    private String director;
    private String producer;
    @JsonProperty("release_date")
    private String releaseDate;
    private List<String> characters;
    private String created;
    private String edited;

    @GraphQLField
    public List<PersonObjectType> personConnection(DataFetchingEnvironmentImpl environment) {
        FilmObjectType source = environment.getSource();
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        headers.add("User-Agent", "something");
        return source.getCharacters().stream()
                .map(uri -> new RestTemplate().exchange(uri, GET, new HttpEntity<>(headers), PersonObjectType.class))
                .map(response -> response.getBody())
                .collect(Collectors.toList());
    }
}
