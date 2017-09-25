package com.ex.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//unit of modularity for cross-cutting concerns
@Component
@Aspect
public class Logging {

	//block of code that runs based on pointcut definition
	//Advice: before,after,around,after throwing,after returning
//	@Before("execution(* com.ex.beans.Students.e* (..))")
//	public void logBefore() {
//		System.out.println("before action");
//	}
	
	@Pointcut("execution(* com.ex.beans.*.* (..))")
	public void everywhere() {
		
	}
	
//	@After("everywhere()")
//	public void logAfter() {
//		System.out.println("after action");
//	}
//	
//	@Around("everywhere()")
//	public void count(ProceedingJoinPoint pjp) {
//		System.out.println("1..2..3..4"); 
//		try {
//			pjp.proceed();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		System.out.println(pjp.getSignature());
//		System.out.println("..5..6..7");
//	}
	
	@Around("everywhere()")
	public void logTime(ProceedingJoinPoint pjp) {
		long time = (long) pjp.getArgs()[0];
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Took " + time + " milliseconds");
	}
}
