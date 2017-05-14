package by.safronenko.utils;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentUser {

    public String getCurrentUser(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
