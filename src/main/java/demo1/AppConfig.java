package demo1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;

import java.time.ZoneId;

@Configuration
@ComponentScan
public class AppConfig { //使用Annotation配置

    // 创建一个Bean:
    @Bean("z") //指定别名两种方式
    @Primary //指定为主要Bean
    ZoneId createZoneId() {
        return ZoneId.of("Z");
    }

    @Bean
    @Qualifier("utc8")
    ZoneId createZoneOfUTC8() {
        return ZoneId.of("UTC+08:00");
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