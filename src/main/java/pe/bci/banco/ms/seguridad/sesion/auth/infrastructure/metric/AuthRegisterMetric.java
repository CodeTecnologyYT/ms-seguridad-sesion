/*
 * @(#)AuthRegisterMetric.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.metric;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AuthRegisterMetric.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 11-04-2025
 */
@Configuration
public class AuthRegisterMetric {

    /**
     * loginSuccessCounter.
     *
     * @param registry {@link MeterRegistry}
     * @return {@link Counter}
     */
    @Bean
    public Counter loginSuccessCounter(MeterRegistry registry) {
        return Counter.builder("ms.security.session.auth.register.success")
            .description("Contador de logins exitosos")
            .register(registry);
    }

}
