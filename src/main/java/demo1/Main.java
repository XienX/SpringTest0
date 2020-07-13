package demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application_demo1.xml");
        UserService userService = context.getBean(UserService.class);// 获取Bean
        User user = userService.login("bob@example.com", "password");// 正常调用
        System.out.println(user.getName());
    }
}
