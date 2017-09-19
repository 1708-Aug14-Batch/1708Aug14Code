package com.revature.andy.aspects;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

	//Advice - the block of code that runs based on the pointcut definition
	
	//@Before("execution(* com.revature.andy.beans.Student.e* (..))")
	public void logBefore() {
		//System.out.println("Log before doing things");
	}
	// pointcut - join point queries where advice executes
	// join point - well-defined points in the program flow
	
	@Pointcut("execution(* com.revature.andy.beans.*.* (..))")
	public void everywhere() {
		
	}

	//@After("everywhere()")
	public void done() {
		System.out.println("Done");
	}
	
	@Around("everywhere()")
	public void count(ProceedingJoinPoint pjp) {
		
		Date temp = new Date();
		
		Long start = temp.getTime();
		
		System.out.println(start);
		
		//System.out.println("around 1");
		//System.out.println(pjp.getSignature());
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("around 2");
		
		Date temp1 = new Date();
		
		Long end = temp1.getTime();
		
		System.out.println(end);
		
		System.out.println(end-start);
	}
	
}
