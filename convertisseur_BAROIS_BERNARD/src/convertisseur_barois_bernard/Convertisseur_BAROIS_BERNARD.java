/*
 * TP1 Exercice 1
 * Elouan Barois Loïc Bernard
 * Octobre 2021
 */
package convertisseur_barois_bernard;

import java.util.Scanner;

/**
 *
 * @author Elou
 */
public class Convertisseur_BAROIS_BERNARD {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            float var1=0;
            int choix=0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Bonjour, saisissez une valeur :");
            var1 = sc.nextFloat();
            System.out.println("Saisissez la conversion que vous souhaitez effectuer :\n1) De Celcius vers Kelvin\n2) De Kelvin vers Celcius\n3) De Farenheit Vers Celcius\n4) De Celcius Vers Farenheit\n5) De Farenheit Vers Kelvin\n6) De Kelvin Vers Farenheit");
            choix = sc.nextInt();
            /**
             * On a ici les étapes précédentes:
                System.out.println("la valeur en Kelvin est: "+ (var1+273.15) +"K");
            
                System.out.println(CelciusVersKelvin (15));
                System.out.println(KelvinVersCelcius (15));
                System.out.println(FarenheitVersCelcius (15));
                System.out.println(CelciusVersFarenheit (15));
                System.out.println(FarenheitVersKelvin (15));
                System.out.println(KelvinVersFarenheit (15));
            */
            if (choix==1) {
                System.out.println(var1 +" degrés Celcius est égal à "+CelciusVersKelvin (var1)+" degrés Kelvin");
            }
            if (choix==2) {
                System.out.println(var1 +" degrés Kelvin est égal à "+KelvinVersCelcius (var1)+" degrés Celcius");
            }
            if (choix==3) {
                System.out.println(var1 +" degrés Farenheit est égal à "+FarenheitVersCelcius (var1)+" degrés Celcius");
            }
            if (choix==4) {
                System.out.println(var1 +" degrés Celcius est égal à "+CelciusVersFarenheit (var1)+" degrés Farenheit");
            }
            if (choix==5) {
                System.out.println(var1 +" degrés Farenheit est égal à "+FarenheitVersKelvin (var1)+" degrés Kelvin");
            }
            if (choix==6) {
                System.out.println(var1 +" degrés Kelvin est égal à "+KelvinVersFarenheit (var1)+" degrés Farenheit");
            }
            
            
            
            
            
    }
    public static double CelciusVersKelvin ( double tempCelcius) {
        // à completer
        double tempKelvin = 0;
        tempKelvin = tempCelcius+(273.15) ;
        return (tempKelvin);
    }
    public static double KelvinVersCelcius ( double tempKelvin) {
        // à completer
        double tempCelcius = 0;
        tempCelcius = (tempKelvin-(273.15)) ;
        return (tempCelcius);
    }
    public static double FarenheitVersCelcius ( double tempFarenheit) {
        // à completer
        double tempCelcius = 0;
        tempCelcius = (tempFarenheit-(32))*(5./9.) ;
        return (tempCelcius);
    }
    public static double CelciusVersFarenheit ( double tempCelcius) {
        // à completer
        double tempFarenheit = 0;
        tempFarenheit = (tempCelcius*(9./5.))+(32) ;
        return (tempFarenheit);
    }
    public static double KelvinVersFarenheit ( double tempKelvin) {
        // à completer
        double tempFarenheit = 0;
        tempFarenheit = (tempKelvin-(273.15)*(9./5.))+(32) ;
        return (tempFarenheit);
    }
    public static double FarenheitVersKelvin ( double tempFarenheit) {
        // à completer
        double tempKelvin = 0;
        tempKelvin = ((tempFarenheit-32)*(5./9.))+(273.15) ;
        return (tempKelvin);
    }
    
} 
