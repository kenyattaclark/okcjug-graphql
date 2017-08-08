package org.okcjug.graphql.schema;

import com.oembedler.moon.graphql.engine.stereotype.*;

@GraphQLSchema
public class Schema {

    @GraphQLSchemaQuery
    private RootObjectType root;

    @GraphQLMutation
    @GraphQLDescription("Mutation to add review")
    public
    @GraphQLOut("review")
    RootObjectType addTodoMutation(@GraphQLIn("addTodoInput") AddReview addReview) {
        return null;
    }

    public static class AddReview {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
