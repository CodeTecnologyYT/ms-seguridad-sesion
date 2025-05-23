/*
 * @(#)IAuthUserRegisterUseCase.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.application;

import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRq;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRs;

/**
 * IAuthUserRegisterUseCase.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
public interface IAuthUserRegisterUseCase {

    /**
     * Register UserRs.
     *
     * @param userRegisterRequest {@link AuthUserRegisterRq}
     * @return {@link AuthUserRegisterRs}
     */
    AuthUserRegisterRs register(final AuthUserRegisterRq userRegisterRequest);

}
