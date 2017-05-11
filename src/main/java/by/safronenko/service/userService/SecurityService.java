package by.safronenko.service.userService;


public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
