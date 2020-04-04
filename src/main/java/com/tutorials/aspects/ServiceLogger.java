package com.tutorials.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;

@Aspect
public class ServiceLogger {

	private static final Logger LOGGER = Logger.getLogger(ServiceLogger.class);

	@Around("logService()")
	public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {
		CodeSignature signature = (CodeSignature) joinPoint.getSignature();
		String className = signature.getDeclaringType().getSimpleName();
		String methodName = signature.getName();
		String[] paramNames = signature.getParameterNames();
		Object[] paramValues = joinPoint.getArgs();
		StringBuilder builder = new StringBuilder("Executing: Class " + className + "; Method " + methodName + ";");
		if (paramNames.length > 0) {
			int i = 0;
			builder.append(" Params [");
			for (String name : paramNames) {
				builder.append("(" + name + ":" + paramValues[i] + ")");
			}
			builder.append("];");
		}
		LOGGER.debug(builder.toString());
		Object object = joinPoint.proceed();
		LOGGER.debug(object.toString());
		return object;
	}

	@Pointcut("execution(* com.tutorials.services.*.*(..))")
	private void logService() {
	}

}
