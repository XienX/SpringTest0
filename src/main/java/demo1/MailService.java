package demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MailService {

    @Autowired(required = false) //可选注入，虽然IDE不推荐写在字段上，但只有这样才起作用
    //@Qualifier("z") //有多个同类型的Bean，注入需指定名称，有@Primary时可不写名称
    private ZoneId zoneId = ZoneId.systemDefault();

    /*public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }*/

    @PostConstruct //初始化
    public void init() {
        System.out.println("Init mail service with zoneId = " + this.zoneId);
    }

    @PreDestroy //销毁
    public void shutdown() {
        System.out.println("Shutdown mail service");
    }

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
