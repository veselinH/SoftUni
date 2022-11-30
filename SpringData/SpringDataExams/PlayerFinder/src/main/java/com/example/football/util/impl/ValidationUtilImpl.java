package softuni.exam.util.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import softuni.exam.util.ValidationUtil;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidationUtilImpl implements ValidationUtil {

    private final Validator validator;

    @Autowired
    public ValidationUtilImpl() {
        this.validator = Validation
                .buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> boolean isValid(E entity) {

        return validator.validate(entity).isEmpty();
    }
}
