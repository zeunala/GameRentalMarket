package com.zeunala.gamerental.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .version("v1.0.0")
                .title("GameRentalMarket API")
                .description("GameRentalMarket 프로젝트 API 명세");

        return new OpenAPI()
                .info(info);
    }
}
