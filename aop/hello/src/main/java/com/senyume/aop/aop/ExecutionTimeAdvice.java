package com.senyume.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Jigish Patel
 */

@Component
@Aspect
public class ExecutionTimeAdvice {

	Logger logger = LoggerFactory.getLogger(ExecutionTimeAdvice.class);

	@Around("execution(* com.senyume.aop.service..*(..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {

		long startTime = System.nanoTime();
		Object retVal = pjp.proceed();
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);

		logger.info("Method " + pjp.getSignature() + " took " + duration + " ns (" + (duration/1000000.0) + " ms)");

		return retVal;
	}
}
