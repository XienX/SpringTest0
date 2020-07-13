package demo1;

import org.springframework.stereotype.Component;

@Component
public class NameValidator implements Validator {
    public void validate(String email, String password, String name) {
        //System.out.println("NameValidator");
        if (name == null || name.isEmpty() || name.length() > 20) {
            throw new IllegalArgumentException("invalid name: " + name);
        }
    }
}
