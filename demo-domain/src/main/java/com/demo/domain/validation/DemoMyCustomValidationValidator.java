package com.demo.domain.validation;

import org.springframework.context.i18n.LocaleContextHolder;
import com.demo.domain.dao.RechnerDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
@AllArgsConstructor
public class DemoMyCustomValidationValidator implements ConstraintValidator<DemoMyCustomValidation, RechnerDto> {

    private final MessageSource messageSource;

    @Override
    public void initialize(DemoMyCustomValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RechnerDto rechnerDto, ConstraintValidatorContext constraintValidatorContext) {
        if (rechnerDto.getA().equals("Eicher")) {
            Locale locale = LocaleContextHolder.getLocale();
            String msg = messageSource.getMessage("my.custom.validation.error.message", new Object[]{}, locale);
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(msg)
                    .addNode("a")
                    .addConstraintViolation();
            return false;
        } else {
            return true;
        }

    }
}