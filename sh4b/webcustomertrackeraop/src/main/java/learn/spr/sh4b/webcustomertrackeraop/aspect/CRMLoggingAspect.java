package learn.spr.sh4b.webcustomertrackeraop.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@SuppressWarnings({"EmptyMethod", "unused"})
@Aspect
@Component
public class CRMLoggingAspect {

    private final Logger log = LogManager.getLogger();

    @Pointcut("execution(* learn.spr.sh4b.webcustomertrackeraop.controller.*.*(..))")
    private void controllerPackage() {}

    @Pointcut("execution(* learn.spr.sh4b.webcustomertrackeraop.service.*.*(..))")
    private void servicePackage() {}

    @Pointcut("execution(* learn.spr.sh4b.webcustomertrackeraop.dao.*.*(..))")
    private void daoPackage() {}

    @Pointcut("controllerPackage() || servicePackage() || daoPackage()")
    private void appFlow() {}

    @Before("appFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        log.info("=====>> in @Before: calling method {}", method);

        Object[] arguments = joinPoint.getArgs();
        for (int i = 0; i < arguments.length; i++) {
            log.info("=====>> argument #{}: {}", i, arguments[i]);
        }
    }

    @AfterReturning(
            pointcut = "appFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint joinPoint, Object theResult) {
        String method = joinPoint.getSignature().toShortString();
        log.info("=====>> in @AfterReturning: calling method {}", method);
        log.info("=====>> result: {}", theResult);
    }
}
