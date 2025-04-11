/*
 * @(#)JwtSecurityProperty.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.jwt.property;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JwtSecurityProperty.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Getter
@Setter
@Component
@NoArgsConstructor
@ConfigurationProperties("security")
public class JwtSecurityProperty {

    /** secret. */
    private String secret;
    /** expireTime. */
    private Long expireTime;

}
