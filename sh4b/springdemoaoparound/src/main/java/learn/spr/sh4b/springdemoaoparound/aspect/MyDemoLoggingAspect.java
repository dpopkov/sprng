package learn.spr.sh4b.springdemoaoparound.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class MyDemoLoggingAspect {
    private static final Logger log = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    @Pointcut("execution(* learn.spr.sh4b.springdemoaoparound.service.TrafficFortuneService.getFortune(..))")
    private void executionOfGetFortune() {}

    @Around("executionOfGetFortune()")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        log.info("\n======>>> Executing @Around on method " + method);
        long begin = System.currentTimeMillis();

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            log.warning(e.getMessage());
            // rethrow the exception
            throw e;
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        log.info("======>>> Duration = " + duration / 1000 + " seconds");
        return result;
    }
}
