package demo1;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator implements Validator {
    public void validate(String email, String password, String name) {
        //System.out.println("PasswordValidato");
        if (!password.matches("^.{6,20}$")) {
            throw new IllegalArgumentException("invalid password");
        }
    }
}
