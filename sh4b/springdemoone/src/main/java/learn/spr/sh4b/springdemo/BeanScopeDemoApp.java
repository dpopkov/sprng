package learn.spr.sh4b.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "beanScope-applicationContext.xml");
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        boolean theSame = theCoach == alphaCoach;
        System.out.println("Pointing to the same object: " + theSame);
        System.out.println("theCoach   : " + theCoach);
        System.out.println("alphaCoach : " + alphaCoach);

        context.close();
    }
}
