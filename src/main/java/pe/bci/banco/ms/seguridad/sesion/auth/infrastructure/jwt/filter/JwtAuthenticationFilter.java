/*
 * @(#)JwtAuthenticationFilter.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.jwt.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pe.bci.banco.ms.seguridad.sesion.auth.application.UserDetailsGetUseCase;
import pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.jwt.provider.JwtProvider;

/**
 * JwtAuthenticationFilter.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    /** jwtProvider. */
    private final JwtProvider jwtProvider;
    /** userDetailsGetUseCase. */
    private final UserDetailsGetUseCase userDetailsGetUseCase;

    // -------------------------------------------------------------------
    // -- Metodos Sobreescritos  -----------------------------------------
    // -------------------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
        final FilterChain filterChain)
    throws ServletException, IOException {
        final var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        final var token = authorizationHeader.substring(7);
        final var username = jwtProvider.extractUsername(token);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            final var userDetails = userDetailsGetUseCase.loadUserByUsername(username);
            if (Boolean.TRUE.equals(jwtProvider.validateToken(token, userDetails))) {
                final var authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
                );
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

}
