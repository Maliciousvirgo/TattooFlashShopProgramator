package pl.tattooshop.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.tattooshop.validators.annotations.UniqueEmail;
import pl.tattooshop.validators.annotations.UniqueUsername;
import pl.tattooshop.services.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserService userService;

    public void initialize(UniqueUsername constraint) {
    }

    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userService == null || (email != null && userService.isUniqueEmail(email));
    }

}