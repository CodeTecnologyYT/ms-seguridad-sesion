/*
 * @(#)SimpleException.java
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

import lombok.Getter;

/**
 * SimpleException.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Getter
public class SimpleException extends RuntimeException{

    private static final long serialVersionUID = 1905122041950251207L;
    private final int status;
    private final String code;
    private final Error errorEnum;
    private final String source;

    public SimpleException(final Error enumError) {
        this(enumError, (Throwable) null);
    }

    public SimpleException(final Error enumError, final Throwable cause) {
        this(enumError, 500, cause);
    }

    public SimpleException(final Error enumError, final int httpStatus) {
        this(enumError, httpStatus, (Throwable) null);
    }

    public SimpleException(final Error enumError, final int httpStatus, final Throwable cause) {
        super(enumError.getMessage(), cause);
        this.source = SimpleException.class.getName();
        this.errorEnum = enumError;
        this.status = httpStatus;
        this.code = enumError.getCode();
    }

    private SimpleException(final String code, final String message, final int httpStatus, final Throwable cause) {
        super(message, cause);
        this.source = SimpleException.class.getName();
        this.errorEnum = SecuritySessionError.DEFAULT;
        this.code = code;
        this.status = httpStatus;
    }

}
