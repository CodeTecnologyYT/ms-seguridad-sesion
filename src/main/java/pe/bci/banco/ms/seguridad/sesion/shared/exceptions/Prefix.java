/*
 * @(#)Prefix.java
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
 * Prefix.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Getter
@AllArgsConstructor
public enum Prefix {

    /** BMC. */
    BMC("BFF de Manager Customer");

    /** BMC. */
    private final String description;
}