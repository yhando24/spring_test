package fr.iocean.dta.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

import org.springframework.context.support.AbstractApplicationContext;

import ch.qos.logback.classic.Level;



/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan(basePackages="fr.iocean.dta")
@EnableAspectJAutoProxy
public class App 
{
	private static final Logger logger  = LoggerFactory.getLogger(App.class);

	
	
	
    public static void main( String[] args )
    {
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    
    	  logger.info("Example log from {}", App.class.getSimpleName());
    }
}
