package demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Validators {
    //注入List
    @Autowired
    List<Validator> validators;

    public void validate(String email, String password, String name) {
        for (Validator validator : this.validators) {
            validator.validate(email, password, name);
        }
    }
}
