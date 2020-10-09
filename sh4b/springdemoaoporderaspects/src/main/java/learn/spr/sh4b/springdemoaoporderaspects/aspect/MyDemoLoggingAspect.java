package learn.spr.sh4b.springdemoaoporderaspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("learn.spr.sh4b.springdemoaoporderaspects.aspect.Pointcuts.daoPackageNoGetterSetter()")
    public void beforeAnyInPackage() {
        System.out.println("\n======>>> Executing @Before advice on any method in package");
    }
}
