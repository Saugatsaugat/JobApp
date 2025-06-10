package com.saugat.jobapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, class-type * method_name, args
    @Before("execution(* com.saugat.jobapp.service.JobService.getAllJobs(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called: " + jp.getSignature().getName());
    }

    @After("execution(* com.saugat.jobapp.service.JobService.getAllJobs(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed: " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.saugat.jobapp.service.JobService.getAllJobs(..))")
    public void logMethodReturning(JoinPoint jp){
        LOGGER.info("Method Executed Successfully: " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.saugat.jobapp.service.JobService.getAllJobs(..))")
    public void logMethodThrowing(JoinPoint jp){

        LOGGER.info("Some issues in this Method: " + jp.getSignature().getName());
    }


}
