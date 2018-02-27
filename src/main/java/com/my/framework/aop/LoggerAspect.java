package com.my.framework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	protected Logger log = LoggerFactory.getLogger(getClass());
	static String name = "";
	static String type = "";
	
	@Around("execution(* com..*.*Controller.*(..)) or execution(* com..*.*Service.*(..)) or execution(* com..*.*Dao.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		type = joinPoint.getSignature().getDeclaringTypeName();
		
		if (type.indexOf("Controller") > -1) {
			name = "Controller \t: ";
		} else if (type.indexOf("Service") > -1) {
			name = "Service \t: ";
		} else if (type.indexOf("Dao") > -1) {
			name = "Dao \t: ";
		}
		
		log.debug(name + type + "." + joinPoint.getSignature().getName() + "()");
		
		return joinPoint.proceed();
	}
}
