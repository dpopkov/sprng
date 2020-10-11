package learn.spr.sh4b.springdemoaoparound.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* learn.spr.sh4b.springdemoaoparound.service.TrafficFortuneService.getFortune(..))")
    private void executionOfGetFortune() {}

    @Around("executionOfGetFortune()")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @Around on method " + method);
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("======>>> Duration = " + duration / 1000 + " seconds");
        return result;
    }
}
