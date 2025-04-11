/*
 * @(#)SwaggerConfig.java
 *
 * Copyright (c) BCI (Chile). All rights reserved.
 *
 * All rights to this product are owned by SEEK and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by SEEK.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package pe.bci.banco.ms.seguridad.sesion.shared.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.bci.banco.ms.seguridad.sesion.shared.property.SwaggerProperty;

/**
 * SwaggerConfig.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Configuration
@RequiredArgsConstructor
@OpenAPIDefinition(
    info = @Info(
        title = "API de Security Session User",
        version = "1.0",
        description = "Documentation of the API de Register User in Spring Boot 3"
    )
)
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
public class SwaggerConfig {

    /** swaggerProperty. */
    private final SwaggerProperty swaggerProperty;

    /**
     * Configuracion basica de swagger
     *
     * @return {@link OpenAPI}
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new io.swagger.v3.oas.models.info.Info()
                .title(this.swaggerProperty.getName())
                .version(this.swaggerProperty.getVersion())
                .description(this.swaggerProperty.getDescription())
                .contact(new Contact()
                    .name(this.swaggerProperty.getContact().getName())
                    .email(this.swaggerProperty.getContact().getEmail())));
    }

}
