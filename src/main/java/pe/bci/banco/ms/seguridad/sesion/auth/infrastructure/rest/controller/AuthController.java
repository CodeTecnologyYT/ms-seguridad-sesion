/*
 * @(#)AuthController.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.bci.banco.ms.seguridad.sesion.auth.application.IAuthUserRegisterUseCase;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRq;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRs;

/**
 * AuthController.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/security/session/auth")
public class AuthController {

    private final IAuthUserRegisterUseCase authUserRegisterUseCase;


    @PostMapping("/register")
    public AuthUserRegisterRs register(@RequestBody final AuthUserRegisterRq userRegisterRequest){
        return authUserRegisterUseCase.register(userRegisterRequest);
    }

}
