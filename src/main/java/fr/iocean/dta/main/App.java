package fr.iocean.dta.main;

import org.springframework.context.annotation.*;

import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan(basePackages="fr.iocean.dta")
@EnableAspectJAutoProxy
public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    	System.out.println(" Hello world!");
    }
}
