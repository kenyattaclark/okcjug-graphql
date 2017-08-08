package org.okcjug.graphql.schema;

import lombok.Data;

import java.util.List;

@Data
public class  Wrapper<T>  {
    private List<T> results;
}
