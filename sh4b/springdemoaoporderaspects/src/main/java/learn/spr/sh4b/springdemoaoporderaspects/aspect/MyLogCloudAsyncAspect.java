package learn.spr.sh4b.springdemoaoporderaspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLogCloudAsyncAspect {

    @Before("learn.spr.sh4b.springdemoaoporderaspects.aspect.Pointcuts.daoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n======>>> Logging to Cloud in async fashion");
    }
}
