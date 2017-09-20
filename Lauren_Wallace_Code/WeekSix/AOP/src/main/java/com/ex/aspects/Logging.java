package com.ex.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//Aspect - unit of modularity for cross-cutting concerns
@Component
@Aspect
public class Logging {
	
	//Advice - the block of code that runs based on the point out defines
	//There are 5 types of Advice:
	//@Before,@After, @Around, @AfterThrowing, @AfterReturning
	//Around needs to be told when to perform
	//AfterThrowing & AfterReturning deal with when exceptions occur
	//AfterThrowing
	/*@Before("execution(* com.ex.beans.Students.e* (..))")
	public void logBefore() {
		System.out.println("Before doing things");
	}*/
	
	/*
	 * pointcut - join point queries where advice executes
	 * join point - well defined points in the program flow
	 */
	
	//must specify the class to look for aka Students or * classes
	@Pointcut("execution(* com.ex.beans.*.* (..))")
	public void everywhere() {
		System.out.println("We are everywhere!");
	}
	
	//("") is the pointcut
	/*@After("everywhere()")
	public void done() {
		System.out.println("Hi I am done");
	}*/
	
	@Around("everywhere()") 
	public void count(ProceedingJoinPoint pjp){
		System.out.println("1...2...3...");
		try {
		pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("4...5...6...");
	}
	
	@Around("everywhere()")
	public void timer(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		
		try {
			pjp.proceed();
		} catch(Throwable e) {
			e.printStackTrace();
		}
		long elapsedTime = System.currentTimeMillis();
		System.out.println("Method execution took " + (elapsedTime - start) + " milliseconds!");
	}
}
