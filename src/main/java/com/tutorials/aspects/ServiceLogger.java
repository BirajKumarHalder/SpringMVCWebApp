package com.tutorials.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ServiceLogger {

	private static final Logger LOGGER = Logger.getLogger(ServiceLogger.class);

	@Around("log()")
	public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {
		Object object = joinPoint.proceed();
		return object;
	}

	@Pointcut(value = "execution(* com.tutorial.services.*(..))")
	private void log() {
	}

	@Before("log()")
	public void beforeAdvice() {
		LOGGER.info("beforeAdvice");
	}

	@After("log()")
	public void afterAdvice() {
		LOGGER.info("Student profile has been setup.");
	}

	@AfterReturning(pointcut = "log()", returning = "retVal")
	public void afterReturningAdvice(Object retVal) {
		LOGGER.info("Returning:" + retVal.toString());
	}

	@AfterThrowing(pointcut = "log()", throwing = "ex")
	public void AfterThrowingAdvice(IllegalArgumentException ex) {
		LOGGER.info("There has been an exception: " + ex.toString());
	}

}
