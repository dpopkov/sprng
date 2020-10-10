package learn.spr.sh4b.springdemoaopafterreturning.aspect;

import learn.spr.sh4b.springdemoaopafterreturning.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Pointcut("execution(* learn.spr.sh4b.springdemoaopafterreturning.dao.AccountDAO.findAccounts(..))")
    private void executionOfFindAccounts() {}

    @Before("executionOfFindAccounts()")
    public void beforeAnyInPackage(JoinPoint joinPoint) {
        System.out.println("\n======>>> Executing @Before advice on any method in package");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + signature);

        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("argument " + i + ": " + args[i]);
        }
    }

    @AfterReturning(
            pointcut="executionOfFindAccounts()",
            returning="resultList"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> resultList) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterReturning on method: " + method);
        System.out.println("======>>> result is: " + resultList);

        // Post-processing the data
        convertNamesToUpperCase(resultList);
        System.out.println("\n======>>> result is: " + resultList);
    }

    @AfterThrowing(
            pointcut = "executionOfFindAccounts()",
            throwing = "theException"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Exception theException) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterThrowing on method: " + method);
        System.out.println("======>>> the exception is: " + theException);
    }

    private void convertNamesToUpperCase(List<Account> accounts) {
        for (Account acc : accounts) {
            acc.setName(acc.getName().toUpperCase());
        }
    }
}
