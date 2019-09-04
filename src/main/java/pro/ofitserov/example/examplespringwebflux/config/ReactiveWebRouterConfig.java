package pro.ofitserov.example.examplespringwebflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import pro.ofitserov.example.examplespringwebflux.handler.ConcatenateHandler;

@Configuration
public class ReactiveWebRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(ConcatenateHandler concatenateHandler) {

        // We listen /concatenate and return our Concatenate Handler
        return RouterFunctions
                .route(RequestPredicates.GET("/concatenate")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        concatenateHandler::hello);
    }
}
