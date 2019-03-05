package fr.iocean.dta.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Level;
import fr.iocean.dta.exception.EmployeeNotFoundException;
import fr.iocean.dta.main.App;

@Aspect
@Component
public class AopConfiguration {

	private static final ch.qos.logback.classic.Logger loggerParent = (ch.qos.logback.classic.Logger) LoggerFactory
			.getLogger("AopConfiguration");

//	tp 20
	@Before("execution(* fr.iocean.dta.service.EmployeService.*(..))")
	public void afficheNomMethode(org.aspectj.lang.JoinPoint jp) {
		loggerParent.info("JE SUIS UNE INFO : logger parent");
		loggerParent.setLevel(Level.WARN);
		loggerParent.warn("Nom de la methode : " + jp.getSignature().getName(), App.class.getSimpleName());

	}

//	tp 21
	@AfterThrowing(pointcut = "execution(* *(..) throws fr.iocean.dta.exception.EmployeeNotFoundException)", throwing = "ex")
	public void logAfterThrowing(EmployeeNotFoundException ex) throws Throwable {

		final ch.qos.logback.classic.Logger loggerenfant = (ch.qos.logback.classic.Logger) LoggerFactory
				.getLogger("AopConfiguration.child");
		loggerenfant.info("JE SUIS UNE INFO :  logger enfant");
		loggerenfant.setLevel(Level.ERROR);
		loggerenfant.error(ex.getMessage());

	}

//	@Around("execution(* fr.iocean.dta.service.*.*(..))")
//	public Object afficherMessageBeforeAllFunction(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("AVANT CHAQUE METHODE : " + joinPoint.getSignature().getName());
//		Object returnVal = null;
//		returnVal = joinPoint.proceed();
//		System.out.println("Apres CHAQUE METHODE " + joinPoint.getSignature().getName());
//		return returnVal;
//	}

}
