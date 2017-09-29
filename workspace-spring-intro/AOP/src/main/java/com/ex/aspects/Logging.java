package com.ex.aspects;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	
	@Before("execution(* com.ex.beans.*.* (..))")
	public void logBefore() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(System.currentTimeMillis() % 1000);
	}
	
	@Pointcut("execution(* com.ex.beans.*.* (..))")
	public void everywhere() {
		
	}
	
	@After("everywhere()")
	public void done() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(System.currentTimeMillis() % 1000);
	}
	
	@Around("everywhere()")
	public void count(ProceedingJoinPoint pjp) {
		System.out.println("1...2...3...");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("...4...5");
	}

}
