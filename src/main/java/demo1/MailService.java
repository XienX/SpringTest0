package demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MailService {

    @Autowired(required = false) //可选注入，虽然IDE不推荐写在字段上，但只有这样才起作用
    private ZoneId zoneId = ZoneId.systemDefault();

    /*public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }*/

    public String getTime() {
        return ZonedDateTime.now(zoneId).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    public void sendLoginMail(User user) {
        System.err.println(String.format("Hi, %s! You are logged in at %s", user.getName(), getTime()));
    }

    public void sendRegistrationMail(User user) {
        System.err.println(String.format("Welcome, %s!", user.getName()));
    }
}
