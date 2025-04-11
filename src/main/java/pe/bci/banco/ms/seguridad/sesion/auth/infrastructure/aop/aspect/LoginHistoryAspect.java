/*
 * @(#)LoginHistoryAspect.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.aop.aspect;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import pe.bci.banco.ms.seguridad.sesion.auth.application.IHistoryLoginCreateUseCase;

/**
 * LoginHistoryAspect.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 11-04-2025
 */
@Aspect
@Component
@RequiredArgsConstructor
public class LoginHistoryAspect {

    /** loginCreateUseCase. */
    private final IHistoryLoginCreateUseCase loginCreateUseCase;
    /** request. */
    private final HttpServletRequest request;

    /**
     * Interceptor for when generate token in la application
     *
     * @param joinPoint {@link JoinPoint}
     * @param token {@link Object}
     */
    @AfterReturning(
        pointcut = """
             execution(* pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.jwt.provider.JwtProvider.generateToken(..))
            """, returning = "token")
    public void afterLogin(final JoinPoint joinPoint, final Object token) {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof UserDetails userDetails) {
            this.loginCreateUseCase.createHistoryLogin(userDetails.getUsername(), request.getRemoteAddr(),
                LocalDateTime.now());
        }
    }

}
