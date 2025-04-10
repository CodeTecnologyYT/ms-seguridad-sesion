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

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
   private String name;
   /** email. */
   private String email;
   /** password. */
   private String password;
   /** phones. */
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
       private String number;
       /** citycode. */
       private String citycode;
       /** countrycode. */
       private String countrycode;

   }

}
