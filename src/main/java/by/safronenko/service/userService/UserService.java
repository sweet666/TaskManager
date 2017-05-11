package by.safronenko.service.userService;

import by.safronenko.entities.userEntities.User;


public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
