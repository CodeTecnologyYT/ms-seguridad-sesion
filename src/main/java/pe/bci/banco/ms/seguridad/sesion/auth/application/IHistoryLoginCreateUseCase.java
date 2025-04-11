/*
 * @(#)IHistoryLoginCreateUseCase.java
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

import java.time.LocalDateTime;

/**
 * IHistoryLoginCreateUseCase.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 11-04-2025
 */
public interface IHistoryLoginCreateUseCase {

    /**
     * createHistoryLogin.
     *
     * @param username username {@link String}
     * @param ipAddress ipAddress {@link String}
     * @param loginTime loginTime {@link LocalDateTime}
     */
    void createHistoryLogin(final String username, final String ipAddress, final LocalDateTime loginTime);

}