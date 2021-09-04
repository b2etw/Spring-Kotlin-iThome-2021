package cc.jianminhuang.day3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AppMain {

    public static void main(String[] args) {
        System.out.println("Spring registered beans -> ");
        final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("./applicationContext.xml");
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);

        final ControllerA controllerA = applicationContext.getBean("controllerA", ControllerA.class);

        System.out.println("\n" + controllerA.sayHello());
    }
}
