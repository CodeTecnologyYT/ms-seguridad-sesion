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

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@Schema(name = "User Request" , description = "Request para el registro de un usuario",
    example = """
        {
            "name": "Juan Rodriguez",
            "email": "juan@compan.org",
            "password": "Hunter21",
            "phones": [
                {
                    "number": "1234567",
                    "citycode": "1",
                    "countrycode": "57"
                }
            ]
        }
        """)
public class AuthUserRegisterRq {

    /** name. */
    @NotBlank(message = "Nombre no puede ser vacio")
    private String name;
    /** email. */
    @Schema(description = "Correo del usuario",example = "example@nisum.com", required = true)
    @NotBlank(message = "Correo no puede ser vacio")
    @EmailValid(message = "Email no tiene el formato Correcto")
    private String email;
    /** password. */
    @Schema(description = "Password del usuario",example = "Password123",required = true)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d{2})[a-zA-Z\\d]{2,}$",
        message = "La contraseña no tiene el formato correcto")
    @Size(min = 4, max = 100,
        message = "La contrasena como minimo tiene que tener 4 caracteres y como maximo 100 caracteres")
    @NotNull(message = "Contrasena no puede ser vacio")
    private String password;
    /** phones. */
    @Schema(description = "Telefonos del usuario")
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
    @Builder
    @Schema(name = "Phone Request")
    public static class PhoneRegister {

        /** number. */
        @Schema(description = "Numero de Telefono",example = "+511954206384",required = true)
        @Pattern(regexp = "^\\d{7,9}$", message = "El numero no tiene el formato correcto")
        @Size(min = 7, max = 10, message = "El numero debe tener 7 o mas digitos")
        @NotBlank(message = "Numero no puede ser vacio")
        private String number;
        /** citycode. */
        @Schema(description = "Codigo de Ciudad", example = "1",required = true)
        @NotBlank(message = " Codigo de ciudad no puede ser vacio")
        private String citycode;
        /** countrycode. */
        @Schema(description = "Codigo de Pais",example = "52",required = true)
        @NotBlank(message = "Codigo de pais no puede ser vacio")
        private String countrycode;

    }

}
