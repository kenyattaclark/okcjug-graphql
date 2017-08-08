package org.okcjug.graphql.schema;


import com.oembedler.moon.graphql.engine.stereotype.GraphQLField;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLIn;
import com.oembedler.moon.graphql.engine.stereotype.GraphQLObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@GraphQLObject("Query")
public class RootObjectType extends BaseObjectType {

    @GraphQLField
    public List<FilmObjectType> allFilms() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        headers.add("User-Agent", "something");
        ResponseEntity<Wrapper<FilmObjectType>> response = new RestTemplate().exchange("https://swapi.co/api/films", GET, new HttpEntity<>(headers), new ParameterizedTypeReference<Wrapper<FilmObjectType>>() {});

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody().getResults();
        }

        return null;
    }

    @GraphQLField
    public FilmObjectType film(@GraphQLIn(value = "id", defaultSpel = "'1'") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        headers.add("User-Agent", "something");
        ResponseEntity<FilmObjectType> response = new RestTemplate().exchange("https://swapi.co/api/films/{id}", GET, new HttpEntity<>(headers), FilmObjectType.class, id);

        if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
        }

        return null;
    }


    @GraphQLField
    public List<PersonObjectType> allPeople() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        headers.add("User-Agent", "something");
        ResponseEntity<Wrapper<PersonObjectType>> response = new RestTemplate().exchange("https://swapi.co/api/people", GET, new HttpEntity<>(headers), new ParameterizedTypeReference<Wrapper<PersonObjectType>>() {});

        if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody().getResults();
        }

        return null;
    }

    @GraphQLField
    public PersonObjectType person(@GraphQLIn(value = "id", defaultSpel = "'1'") String id) {
        if (StringUtils.isBlank(id)) {
            id = "1";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        headers.add("User-Agent", "something");
        ResponseEntity<PersonObjectType> response = new RestTemplate().exchange("https://swapi.co/api/people/{id}", GET, new HttpEntity<>(headers), PersonObjectType.class, id);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return null;
    }

    @GraphQLField
    public List<PlanetObjectType> allPlanets() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        headers.add("User-Agent", "something");
        ResponseEntity<Wrapper<PlanetObjectType>> response = new RestTemplate().exchange("https://swapi.co/api/planets", GET, new HttpEntity<>(headers), new ParameterizedTypeReference<Wrapper<PlanetObjectType>>() {});

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody().getResults();
        }

        return null;
    }

    @GraphQLField
    public PlanetObjectType planet(@GraphQLIn(value = "id", defaultSpel = "'1'") String id) {
        if (StringUtils.isBlank(id)) {
            id = "1";
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(APPLICATION_JSON));
        headers.add("User-Agent", "something");
        ResponseEntity<PlanetObjectType> response = new RestTemplate().exchange("https://swapi.co/api/planets/{id}", GET, new HttpEntity<>(headers), PlanetObjectType.class, id);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        return null;
    }
}
