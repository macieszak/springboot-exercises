package com.example.aop_demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //@Before("execution(public void addAccount())")
    //@Before("execution(public void com.example.aop_demo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void *addAccount())")
    //@Before("execution(public * *addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(* add*(com.example.aop_demo.Account))")
    //@Before("execution(* add*(com.example.aop_demo.Account, ..))")
    //@Before("execution(* add*(..))") //doesn't work with IntelliJ IDEA ULTIMATE
    //@Before("execution(* com.example.aop_demo..add*(..))")
    @Before("execution(* com.example.aop_demo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====> Executing @Before advice on addAccount()");
    }

}
