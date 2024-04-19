package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringAnnotations {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext("dao","metier","ext");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Resultat est "+metier.calcul());
    }
}