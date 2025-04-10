/*
 * @(#)UserController.java
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
package pe.bci.banco.ms.seguridad.sesion.user.infrastructure.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.bci.banco.ms.seguridad.sesion.user.application.UserFindUseCase;
import pe.bci.banco.ms.seguridad.sesion.user.domain.model.User;

/**
 * UserController.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/security/session/users")
public class UserController {

    /** userFindUseCase. */
    private final UserFindUseCase userFindUseCase;

    @GetMapping("/{email}")
    public User findUser(@PathVariable("email") final String email){
        return userFindUseCase.findByEmail(email);
    }

}
