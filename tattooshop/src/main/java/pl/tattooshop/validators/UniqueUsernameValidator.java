package pl.tattooshop.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.tattooshop.validators.annotations.UniqueUsername;
import pl.tattooshop.services.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserService userService;

    public void initialize(UniqueUsername constraint) {
    }

    public boolean isValid(String login, ConstraintValidatorContext context) {
        //w RepositoryInitializer userService jeszcze nie ma dlatego userService == null.
        return userService == null || (login != null && userService.isUniqueLogin(login));
    }

}