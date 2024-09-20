package com.example.aop_demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
//if you only have pointcuts then @Aspect is optional
//only required if you add advices in this class: @Before, @After etc
@Component
public class LuvAopExpressions {

    @Pointcut("execution(* com.example.aop_demo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* com.example.aop_demo.dao.*.get*(..))")
    public void forGetterMethods() {
    }

    @Pointcut("execution(* com.example.aop_demo.dao.*.set*(..))")
    public void forSetterMethods() {
    }

    @Pointcut("forDaoPackage() && !(forGetterMethods() || forGetterMethods())")
    public void forDaoPackageNoGetterSetter() {
    }

}
