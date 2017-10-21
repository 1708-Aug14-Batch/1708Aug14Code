package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {

	//Advice - the block of code that runs based on the point cut definition
	//(pointcut) where this method can occur
	
	@Before("execution(* aspect.beans.Student.e*(..))")
	public void logBefore() {
		
		System.out.println("Don't make me do things");
		
	}
	
	@Pointcut("execution(* beans.*.* (..)")
	public void everywhere() {}
	
//	@After("everywhere()")
//	public void done() {
//		System.out.println("Hi I am done");
//	}
	
//	@Around("everywhere()")
	public void count(ProceedingJoinPoint pjp) {
		System.out.println("1..2..3..");
		
		try {
			pjp.proceed();
		}
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(pjp.getSignature());
		System.out.println("4..5..6");
	}
	
	
	
	
}
