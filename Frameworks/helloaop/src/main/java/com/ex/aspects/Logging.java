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
public class Logging {
	
	
	//Advice - the block of code that runs based on the pointcut definition
	@Before("execution(* com.ex.beans.Students.e* (..))")
	public void logBefore(){
		System.out.println("Before doing things");
	}
	/*
	 * pointcut - defines the rules for the places the advice an be applied
	 * joinpoints - the methods where the rules apply and the advice is actually applied
	 */
	
	@Pointcut("execution(* com.ex.beans.*.* (..))")
	public void everywhere(){}
	
	
	@After("everywhere()")
	public void done(){
		System.out.println("hi i am done");
	}
	
	@Around("everywhere()")
	public void count(ProceedingJoinPoint pjp){
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
	
	//Logging example
	@Around("everywhere()")
	public void timer(ProceedingJoinPoint pjp){
		long currTime = System.currentTimeMillis();
		try{
			pjp.proceed();
		}
		catch(Throwable e){
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() - currTime);
	}
	
	
	// Steven's take on the logging 
	@Around("everywhere()")
	public void timer2(ProceedingJoinPoint pjp){
		long time = (Long) pjp.getArgs()[0];
		try{
			pjp.proceed();
		}
		catch(Throwable e){
			e.printStackTrace();
		}
		System.out.println("took " + time + " ms");
		
	}
	
	
	
}
