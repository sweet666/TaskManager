package by.safronenko.repositories.userRepositories;


import by.safronenko.entities.userEntities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
