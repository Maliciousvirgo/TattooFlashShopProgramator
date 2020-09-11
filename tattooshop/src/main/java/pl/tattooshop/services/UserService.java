package pl.tattooshop.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.tattooshop.models.User;

public interface UserService extends UserDetailsService{
    void save(User user);

    boolean isUniqueLogin(String login);
    boolean isUniqueEmail(String email);
}
