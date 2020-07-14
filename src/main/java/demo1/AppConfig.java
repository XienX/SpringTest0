package demo1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;

import java.time.ZoneId;

@Configuration
@ComponentScan
@PropertySource("demo1.properties") // 表示读取classpath的demo1.properties
public class AppConfig { //使用Annotation配置

    @Value("${app.zone:Z}") //读取key为app.zone的value，但如果key不存在，就使用默认值Z
    String zoneId;

    @Bean("shanghai")
    ZoneId createZoneOfShanghai() {
        return ZoneId.of(zoneId);
    }


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