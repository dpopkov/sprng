package learn.spr.sh4b.springdemoaoporderaspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Pointcuts {
    @Pointcut("execution(* learn.spr.sh4b.springdemoaoporderaspects.dao.*.*(..))")
    public void daoPackage() {}

    @Pointcut("execution(* learn.spr.sh4b.springdemoaoporderaspects.dao.*.get*())")
    public void getter() {}

    @Pointcut("execution(void learn.spr.sh4b.springdemoaoporderaspects.dao.*.set*(*))")
    public void setter() {}

    @Pointcut("daoPackage() && !(getter() || setter())")
    public void daoPackageNoGetterSetter() {}
}
