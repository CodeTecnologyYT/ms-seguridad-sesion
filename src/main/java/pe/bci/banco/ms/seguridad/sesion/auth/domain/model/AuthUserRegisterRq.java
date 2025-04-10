/*
 * @(#)AuthUserRegisterRq.java
 *
 * Copyright (c) BCI (Chile). All rights reserved.
 *
 * All rights to this product are owned by BCI and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by BCI.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package pe.bci.banco.ms.seguridad.sesion.auth.domain.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.bci.banco.ms.seguridad.sesion.shared.validations.EmailValid;

/**
 * AuthUserRegisterRq.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserRegisterRq {

    /** name. */
    @NotBlank(message = "Nombre no puede ser vacio")
    private String name;
    /** email. */
    @NotBlank(message = "Correo no puede ser vacio")
    @EmailValid(message = "Email no tiene el formato Correcto")
    private String email;
    /** password. */
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d{2})[a-zA-Z\\d]{2,}$",
        message = "La contraseña no tiene el formato correcto")
    @Size(min = 4, max = 100,
        message = "La contrasena como minimo tiene que tener 4 caracteres y como maximo 100 caracteres")
    @NotNull(message = "Contrasena no puede ser vacio")
    private String password;
    /** phones. */
    @Valid
    @NotEmpty(message = "Celulares no puede ser vacio")
    private List<PhoneRegister> phones;

    /**
     * PhoneRegister.
     *
     * @author Bryan Rosas.
     * @version 1.0.0, 10-04-2025
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PhoneRegister {

        /** number. */
        @Pattern(regexp = "^\\d{7,9}$", message = "El numero no tiene el formato correcto")
        @Size(min = 7, max = 10, message = "El numero debe tener 7 o mas digitos")
        @NotBlank(message = "Numero no puede ser vacio")
        private String number;
        /** citycode. */
        @NotBlank(message = " Codigo de ciudad no puede ser vacio")
        private String citycode;
        /** countrycode. */
        @NotBlank(message = "Codigo de pais no puede ser vacio")
        private String countrycode;

    }

}
