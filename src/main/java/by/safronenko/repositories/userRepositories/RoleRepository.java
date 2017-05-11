package by.safronenko.repositories.userRepositories;

import by.safronenko.entities.userEntities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
