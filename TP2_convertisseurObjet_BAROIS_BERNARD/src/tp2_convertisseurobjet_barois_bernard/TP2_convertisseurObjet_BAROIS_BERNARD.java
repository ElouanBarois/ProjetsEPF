/*
 * TP1 Exercice 1
 * Elouan Barois Loïc Bernard
 * Octobre 2021
 */
package tp2_convertisseurobjet_barois_bernard;

import java.util.Scanner;

/**
 *
 * @author Elou
 */
public class TP2_convertisseurObjet_BAROIS_BERNARD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n;
        n= sc.nextInt();
        
        
        Convertisseur unConvertisseur =new Convertisseur();
        double res = unConvertisseur.CelciusVersKelvin(n);
        System.out.println(n+" degrés Celcius donne "+res+" degrés Kelvin");
        double res2 = unConvertisseur.KelvinVersCelcius(res);
        System.out.println(res+" degrés Kelvin donne "+res2+" degrés Celcius");
        
        Convertisseur deuxConvertisseur =new Convertisseur();
        res = deuxConvertisseur.KelvinVersFarenheit(n);
        System.out.println(n+" degrés Kelvin donne "+res+" degrés Farenheit");
        res2 = deuxConvertisseur.FarenheitVersCelcius(res);
        System.out.println(res+" degrés Farenheit donne "+res2+" degrés Celcius");
        
        System.out.println(unConvertisseur) ;
        System.out.println(deuxConvertisseur) ;
        
    }
    
}
