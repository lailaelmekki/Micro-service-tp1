package ma.enset.bank_account_service.exceptions;
import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CustomDataFetcherExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return new GraphQLError() {
            @Override
            public String getMessage() {
                return ex.getMessage(); // You can modify this to return a custom message if needed
            }

            @Override
            public List<SourceLocation> getLocations() {
                return null; // You can provide actual SourceLocation if applicable
            }

            @Override
            public ErrorClassification getErrorType() {
                return null;
            }

            @Override
            public List<Object> getPath() {
                return GraphQLError.super.getPath();
            }

            @Override
            public Map<String, Object> toSpecification() {
                return GraphQLError.super.toSpecification();
            }

            @Override
            public Map<String, Object> getExtensions() {
                return GraphQLError.super.getExtensions();
            }

//            @Override
//            public Map<String, Object> getExtensions() {
//                return null; // You can add extensions if needed
//            }
//
//            @Override
//            public List<Object> getPath() {
//                return null; // You can return the path of the error if applicable
//            }
//
//            @Override
//            public Map<String, Object> toSpecification() {
//                return null; // This can be modified to include error details in the GraphQL spec format
//            }
        };
    }
}
