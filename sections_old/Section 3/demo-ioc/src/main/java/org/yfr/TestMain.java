package org.yfr;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
//        final Controller controller = new Controller();
//        System.out.println(controller.printName());

        final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println("bean : " + beanName);
        }

        final Controller controller = applicationContext.getBean("controller", Controller.class);
        System.out.println(controller.printName());
    }
}
