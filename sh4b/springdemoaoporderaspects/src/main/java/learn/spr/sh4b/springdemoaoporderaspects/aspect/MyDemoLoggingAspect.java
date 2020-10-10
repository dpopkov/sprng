package learn.spr.sh4b.springdemoaoporderaspects.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("learn.spr.sh4b.springdemoaoporderaspects.aspect.Pointcuts.daoPackageNoGetterSetter()")
    public void beforeAnyInPackage(JoinPoint joinPoint) {
        System.out.println("\n======>>> Executing @Before advice on any method in package");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + signature);

        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("argument " + i + ": " + args[i]);
        }
    }
}
