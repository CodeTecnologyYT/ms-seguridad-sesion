/*
 * @(#)Error.java
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
package pe.bci.banco.ms.seguridad.sesion.shared.exceptions;

import java.io.Serializable;

/**
 * Error.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
public interface Error extends Serializable {

    /**
     * Obtiene el prefix
     *
     * @return {@link String}
     */
    String getPrefix();

    /**
     * Obtiene el code
     *
     * @return {@link String}
     */
    String getCode();

    /**
     * Obtiene el Message
     *
     * @return {@link String}
     */
    String getMessage();

    /**
     * Obtiene el StandardLogCode
     *
     * @return {@link String}
     */
    String getStandardLogCode();

    /**
     * Obtiene el StandLogMessage
     *
     * @return {@link String}
     */
    String getStandardLogMessage();

}