package com.ex.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//unity of modularity for crosscutting concerns
@Component
@Aspect
public class Logging {
	
	//advice - block of code that runs based on the pointcut definition
	//@before
	//@after
	//@around
	//@afterthrowing
	//@afterreturning
	@Before("execution(* com.ex.beans.Students.* (..))*")
	public void logBefore() {
		System.out.println("before doing things");
	}
	//pointcut - defines the rules for the places the advice 
	//joinpoints - methods where the rules apply 
	
	@Pointcut("execution(* com.ex.beans.*.* (..))*")
	public void everywhere() {
		
	}
	
	@After("everywhere()")
	public void done() {
		System.out.println("done!");
	}
	
//	@Around("everywhere()")
//	public void count(ProceedingJoinPoint pjp) {
//		System.out.println("1,2,3...");
//		try {
//			pjp.proceed();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		System.out.println("...4,5");
//	}
	
	@Around("everywhere()")
	public void timer(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		try {
			pjp.proceed();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis()-start;
		System.out.println("how many millis?? " +end);
	}
	
	
}
