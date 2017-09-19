package com.ex.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
	
}
