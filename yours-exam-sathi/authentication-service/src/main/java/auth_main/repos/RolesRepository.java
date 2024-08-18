package auth_main.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import auth_main.models.Role;
import auth_main.models.enums.RoleName;

public interface RolesRepository  extends JpaRepository<Role, Long>{
    Optional<Role> findByName(RoleName roleName);
}
