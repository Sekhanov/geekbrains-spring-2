package com.skhanov.geekbrainsspring;





import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * AspectConfig
 */
@Aspect
@Configuration
public class AspectConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // @Before("execution(* com.skhanov.geekbrainsspring.controller.*.*(..))")
    @Before("execution(* com.skhanov.geekbrainsspring.persist.service.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("Вызов до метода {}", joinPoint);
    }


    @AfterReturning("@annotation(com.skhanov.geekbrainsspring.aspect.LogAfterExMethod)")   
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("Вызов после метода с аннотацией {}", joinPoint);
    }
    
}