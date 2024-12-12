package com.gio.curso.springboot.app.aop.springbootaop.aop;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Component
@Aspect
public class GreetingServicePintcuts {


    @Pointcut("execution(* com.gio.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
     public void greetingFooLoggerPointCut(){}

     @Pointcut("execution(* com.gio.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
     public void greetingLoggerPointCut(){}


}
