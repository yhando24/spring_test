package fr.iocean.dta.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import fr.iocean.dta.exception.EmployeeNotFoundException;

@Aspect
@Component
public class AopConfiguration {
	
////	tp 20
//	@Before("execution(* fr.iocean.dta.service.EmployeService.*(..))")
//	public void afficheNomMethode(org.aspectj.lang.JoinPoint jp) {
//		System.out.println("Nom de la methode : " + jp.getSignature().getName());
//	}
//	
////	tp 21
//	@AfterThrowing(pointcut = "execution(* *(..) throws fr.iocean.dta.exception.EmployeeNotFoundException)", throwing = "ex")
//	 public void logAfterThrowing(EmployeeNotFoundException ex) throws Throwable  {
//		System.out.println(ex.getMessage());
//	}
	
	@Around("execution(* fr.iocean.dta.service.*.*(..))")
	public void afficherMessageBeforeAllFunction(ProceedingJoinPoint joinPoint) {
	
		System.out.println("AVANT CHAQUE METHODE : " +	joinPoint.getSignature().getName());
	
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			System.out.println("jai une erreur : " +e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("Apres CHAQUE METHODE " + joinPoint.getSignature().getName() );
		
	}
}
