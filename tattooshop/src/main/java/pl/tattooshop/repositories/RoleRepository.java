package pl.tattooshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tattooshop.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByType(Role.Types type);
}
