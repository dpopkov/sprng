package learn.spr.sh4b.annotationsdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
        boolean theSame = theCoach == alphaCoach;
        System.out.println("Pointing to the same object: " + theSame);
        System.out.println("theCoach  : " + theCoach);
        System.out.println("alphaCoach: " + alphaCoach);
        context.close();
    }
}
