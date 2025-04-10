/*
 * @(#)SecuritySessionError.java
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

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * SecuritySessionError.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Getter
@AllArgsConstructor
public enum SecuritySessionError implements Error{

    /** DEFAULT. */
    DEFAULT("99", "Error Generico"),
    /** ERROR_NOT_FOUND_USER. */
    ERROR_NOT_FOUND_USER("420", "No se encontro el usuario"),
    /** ERROR_EXIST_USER. */
    ERROR_EXIST_USER("420", "El correo ya registrado");

    /** code. */
    private final String code;
    /** message. */
    private final String message;

    // -------------------------------------------------------------------
    // -- Métodos Sobrescritos -------------------------------------------
    // -------------------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public String getCode() {
        return this.getPrefix() + this.code;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return this.message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPrefix() {
        return "BFFBENE";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStandardLogCode() {
        return this.code;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStandardLogMessage() {
        return this.message;
    }

    // -------------------------------------------------------------------
    // -- Métodos Públicos -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Obtiene enum de Error segun parametro.
     *
     * @param code {@link String}
     * @return {@link SecuritySessionError}
     */
    public static SecuritySessionError getErrorByCode(final String code) {
        for (final SecuritySessionError error : SecuritySessionError.values()) {
            if (error.getCode().equalsIgnoreCase(code)) {
                return error;
            }
        }
        return DEFAULT;
    }

}