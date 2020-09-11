package pl.tattooshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tattooshop.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
    User findByEmail(String name);
}
