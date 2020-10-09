package learn.spr.sh4b.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // This is where we add all of our related advices for logging

    @Before("execution(* add*(learn.spr.sh4b.springdemoaop.Account, ..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>> Executing @Before advice on method");
    }
}
