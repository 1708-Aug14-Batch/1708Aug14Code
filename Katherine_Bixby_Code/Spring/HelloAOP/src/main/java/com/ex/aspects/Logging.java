package com.ex.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Aspect - unit of modularity for crosscutting concerns
@Component
@Aspect
public final class Logging {

	//Advice - the block of code that runs based on the pointcut defin...
//	@Before("execution(* com.ex.beans.Students.e* (..))")
//	public void logBefore() {
//		System.out.println("Before doing things");
//	}
	
	@Pointcut("execution(* com.ex.beans.*.* (..))")
	public void everywhere() {
	}
	
//	@After("everywhere()")
//	public void done() {
//		System.out.println("hi i am done");
//	}
	
	@Around("everywhere()")
	public void count(ProceedingJoinPoint pjp) {
		System.out.println("1...2...3...");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pjp.getSignature());
		System.out.println("...4...5");
	}
	
}
