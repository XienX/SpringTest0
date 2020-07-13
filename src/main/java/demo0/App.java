package demo0;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application_demo0.xml");
        Student student = context.getBean(Student.class);

        System.out.println(student.getName()+"准备做作业了");
        student.doHomeWork();

        context.close();

    }
}
