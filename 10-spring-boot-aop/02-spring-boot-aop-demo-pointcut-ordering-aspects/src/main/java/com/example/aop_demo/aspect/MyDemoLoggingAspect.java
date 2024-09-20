package com.example.aop_demo.aspect;

import com.example.aop_demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(
            pointcut = "execution(* com.example.aop_demo.dao.AccountDAOImpl.findAccounts(..)))",
            returning ="result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterReturning on method: " + method);

        System.out.println("\n=====> result is:  " + result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====> result is:  " + result);


    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
//        for (Account account : result) {
//            String upperName = account.getName().toUpperCase();
//            account.setName(upperName);
//        }
        result.forEach(account -> account.setName(account.getName().toUpperCase()));
    }

    @Before("com.example.aop_demo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        //JoinPoint has metadata about method call

        System.out.println("\n====> Executing @Before advice on addAccount()");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method:" + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("acccount name: " + account.getName());
                System.out.println("acccount level: " + account.getLevel());
            }
        }


    }


}
