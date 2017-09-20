package com.ex.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//Aspect - unit of modularity for crosscutting concerns
@Component
@Aspect
public class Logging {
	
	Long currentTime = System.currentTimeMillis();
	Long newTime = System.currentTimeMillis();

	//Advice - the block of code that runs based on the pointcut definition
	@Before("execution(* com.ex.beans.Students.e* (..))")
	public void logBefore() {
		System.out.println("Before doing things");
	}
	
	@Pointcut("execution(* com.ex.beans.*.* (..))")
	public void everywhere() {
		//System.out.println("everywhere");
	}
	
	@After("everywhere()")
	public void something() {
		System.out.println("hi I am done");
	}
	
	@Around("everywhere()")
	public void proceed(ProceedingJoinPoint pjb) {
		System.out.println("1....2....3....");
		try {
			pjb.proceed();
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println(pjb.getSignature());
		System.out.println("....4....5....6");
	}
	
	@Around("everywhere()")
	public void taketime(ProceedingJoinPoint pjb) {
		currentTime = System.currentTimeMillis();
		try {
			pjb.proceed();
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		newTime = System.currentTimeMillis();
		System.out.println(newTime - currentTime);
	}
	
}
