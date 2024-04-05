package com.codestates.burgerqueenspring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(void *(..))")
    void allMethod(){}

    @Pointcut("execution(int *(..))")
    void returnMethod(){}

    @Before("allMethod() || returnMethod()")
    public void before(JoinPoint joinPoint) {
        log.info("⭐️ 메서드 호출 ⭐");

        Signature signature = joinPoint.getSignature();
        log.info("============= 메서드명 = {} =============", signature.getName());

        Object[] args = joinPoint.getArgs();
        if (args.length == 0) {
            log.info("[파라미터] = 없음");
        } else {
            for (int i = 0; i < args.length; i++) {
                log.info("[파라미터 타입] = {}, [파리미터 값] = {}",
                        args[i].getClass().getSimpleName(), args[i]);
            }
        }
    }

    @AfterReturning(pointcut = "returnMethod()", returning = "returnValue")
    public void after(JoinPoint joinPoint, Object returnValue) {
        log.info("⭐ 메서드 호출 후 ⭐");

        Signature signature = joinPoint.getSignature();
        log.info("============= 메서드명 = {} =============", signature.getName());
        log.info("[반환 값] = {}", returnValue);
    }
}
