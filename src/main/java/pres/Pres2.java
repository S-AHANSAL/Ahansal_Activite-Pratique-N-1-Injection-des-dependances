package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception{
        //  l'injection des dépendances
        //  b. Par instanciation dynamique


        // Ouverture du fichier de configuration pour la lecture
        Scanner scanner = new Scanner(new File("config.txt"));
        // Lecture du nom de la classe du DAO à partir du fichier de configuration
        String daoClassName = scanner.nextLine();
        // Chargement dynamique de la classe du DAO à partir de son nom
        Class cDao = Class.forName(daoClassName);
        // Création d'une instance du DAO en utilisant le constructeur par défaut
        IDao dao=(IDao) cDao.getConstructor().newInstance();


        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();


        Method method = cMetier.getMethod("setDao", IDao.class);
        //metier.setDao(dao); //statique
        method.invoke(metier,dao);
        System.out.println("Resultat est "+metier.calcul());
    }
}
