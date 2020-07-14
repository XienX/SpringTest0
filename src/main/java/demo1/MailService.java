package demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Component
public class MailService {

    @Autowired(required = false) //可选注入，虽然IDE不推荐写在字段上，但只有这样才起作用
    @Qualifier("shanghai") //有多个同类型的Bean，注入需指定名称，有@Primary时可不写
    private ZoneId zoneId = ZoneId.systemDefault();

    /*public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }*/

    @Value("classpath:/demo1/test.txt") //使用Resource
    private Resource resource;

    private String word;

    @PostConstruct //初始化
    public void init() {
        System.out.println("Init mail service with zoneId = " + this.zoneId);

        try {
            System.out.println(new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))
                    .lines().collect(Collectors.joining("\n")));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
