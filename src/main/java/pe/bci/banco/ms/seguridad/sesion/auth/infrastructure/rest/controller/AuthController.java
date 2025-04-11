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

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
@Tag(name = "Seguridad", description = "API de autenticacion")
public class AuthController {

    /** authUserRegisterUseCase. */
    private final IAuthUserRegisterUseCase authUserRegisterUseCase;

    /**
     * Endpoint de creacion de usuarios
     *
     * @param userRegisterRequest {@link AuthUserRegisterRq}
     * @return {@link AuthUserRegisterRs}
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201", description = "Exito al crear un usuario")
    @ApiResponse(responseCode = "400", description = "Error en la informacion a enviar",
        content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse(responseCode = "500", description = "Error no esperado",
        content = @Content(schema = @Schema(hidden = true)))
    public AuthUserRegisterRs register(@Valid @RequestBody final AuthUserRegisterRq userRegisterRequest){
        return this.authUserRegisterUseCase.register(userRegisterRequest);
    }

}
