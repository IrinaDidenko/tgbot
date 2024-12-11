package ru.skillfactorydemo.tgbot.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;


public class SwaggerConfig {

    @Bean
    public GroupedOpenApi botApi() {
        return GroupedOpenApi.builder()
                .group("ru.skillfactorydemo")
                .pathsToMatch("/getCurrencies")
                .build();
    }
}
