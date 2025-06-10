package com.saugat.jobapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.saugat.jobapp.service.JobService.getJob(..) ) && args(jobId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int jobId) throws Throwable {
        if(jobId < 0){
            LOGGER.info("JobId is negative. "+ jobId +"\nUpdating value.......\n");
            jobId = -jobId;
            LOGGER.info("New value is: "+jobId);
        }

        Object obj = jp.proceed(new Object[]{jobId});
        return obj;
    }

}
