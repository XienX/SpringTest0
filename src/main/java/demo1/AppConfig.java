package demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;

import static java.lang.Thread.sleep;

@Configuration
@ComponentScan
public class AppConfig { //使用Annotation配置

    // 创建一个Bean:
    @Bean
    ZoneId createZoneId() {
        return ZoneId.of("Z");
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = userService.login("bob@example.com", "password");
        System.out.println(user.getName());

        userService.register("xxiien99@gmail.com", "0000000", "Xien");
        User user1 = userService.login("xxiien99@gmail.com", "0000000");

        context.close(); //只有ConfigurableApplicationContext有close方法，只有显示调用close才会调用@PreDestroy
    }
}