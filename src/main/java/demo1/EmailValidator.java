package demo1;

import org.springframework.stereotype.Component;

@Component
public class EmailValidator implements Validator {
    public void validate(String email, String password, String name) {
        //System.out.println("EmailValidator");
        if (!email.matches("^[a-z0-9]+\\@[a-z0-9]+\\.[a-z]{2,10}$")) {
            throw new IllegalArgumentException("invalid email: " + email);
        }
    }
}
