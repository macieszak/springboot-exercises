package com.example.aop_demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


    @Pointcut("execution(* com.example.aop_demo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.example.aop_demo.dao.*.get*(..))")
    private void forGetterMethods() {}

    @Pointcut("execution(* com.example.aop_demo.dao.*.set*(..))")
    private void forSetterMethods() {}

    @Pointcut("forDaoPackage() && !(forGetterMethods() || forGetterMethods())")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackage()")
    public void  performApiAnalytics() {
        System.out.println("\n=======> Performing API analytics");
    }

}
