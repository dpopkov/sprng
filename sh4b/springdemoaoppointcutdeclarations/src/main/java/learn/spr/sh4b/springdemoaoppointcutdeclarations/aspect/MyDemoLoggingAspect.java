package learn.spr.sh4b.springdemoaoppointcutdeclarations.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* learn.spr.sh4b.springdemoaoppointcutdeclarations.dao.*.*(..))")
    private void daoPackage() {}

    @Before("daoPackage()")
    public void beforeAnyInPackage() {
        System.out.println("\n======>>> Executing @Before advice on any method in package");
    }

    @Before("daoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n======>>> Performing API analytics");
    }
}
