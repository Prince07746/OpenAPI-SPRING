package org.openapi.openapispring.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.openapi.openapispring.OpenApiSpringApplication;
import org.openapi.openapispring.Repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;

@Configuration
public class Config {

    @Bean
    public OpenAPI customOpenAPI(){
        return  new OpenAPI()
                .info(new Info().title("Product API").version("1.0.0"))
                .servers(Arrays.asList(
                        new Server().url("http://localhost:8080").description("Local Development Server"),
                        new Server().url("https://fortesting.com/api").description("Testing Server"),
                        new Server().url("https://forproduction.com/api").description("Production Server")

                ));
    }
}
