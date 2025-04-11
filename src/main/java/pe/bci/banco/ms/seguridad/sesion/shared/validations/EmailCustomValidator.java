/*
 * @(#)EmailCustomValidator.java
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
package pe.bci.banco.ms.seguridad.sesion.shared.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * EmailCustomValidator.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Component
public class EmailCustomValidator implements ConstraintValidator<EmailValid, String> {

    /** emailRegex. */
    @Value("${ms.seguridad.sesion.regex.email}")
    private String emailRegex;
    /** pattern. */
    private Pattern pattern;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(EmailValid constraintAnnotation) {
        pattern = Pattern.compile(emailRegex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && pattern.matcher(value).matches();
    }

}
