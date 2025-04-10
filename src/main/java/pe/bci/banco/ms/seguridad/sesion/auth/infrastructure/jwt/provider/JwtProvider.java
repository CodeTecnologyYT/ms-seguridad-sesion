/*
 * @(#)JwtProvider.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.jwt.provider;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.provider.JwtProviderPort;
import pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.jwt.property.JwtSecurityProperty;

/**
 * JwtProvider.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Component
@RequiredArgsConstructor
public class JwtProvider implements JwtProviderPort {

    /** jwtSecurityProperty. */
    private final JwtSecurityProperty jwtSecurityProperty;

    // -------------------------------------------------------------------
    // -- Métodos Sobreescritos  -----------------------------------------
    // -------------------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public String generateToken(final UserDetails userDetails) {
        return JWT.create()
            .withSubject(userDetails.getUsername())
            .withIssuedAt(new Date())
            .withExpiresAt(new Date(System.currentTimeMillis() + jwtSecurityProperty.getExpireTime()))
            .sign(Algorithm.HMAC256(jwtSecurityProperty.getSecret()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean validateToken(final String token, final UserDetails userDetails) {
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String extractUsername(final String token) {
        return JWT.require(Algorithm.HMAC256(jwtSecurityProperty.getSecret()))
            .build()
            .verify(token)
            .getSubject();
    }

    // -------------------------------------------------------------------
    // -- Métodos Privados  ----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Verifica si el token ha expirado.
     *
     * @param token {@link String}
     * @return {@link Boolean}
     */
    private Boolean isTokenExpired(String token) {
        Date expiration = JWT.require(Algorithm.HMAC256(jwtSecurityProperty.getSecret()))
            .build()
            .verify(token)
            .getExpiresAt();
        return expiration.before(new Date());
    }

}
