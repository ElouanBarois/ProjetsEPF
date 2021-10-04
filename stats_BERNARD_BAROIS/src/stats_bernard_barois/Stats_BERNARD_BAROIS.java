/*
 * TP1 Exercice 1
 * Elouan Barois Loïc Bernard
 * Octobre 2021
 */
package stats_bernard_barois;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Elou
 */
public class Stats_BERNARD_BAROIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float m=0;
        Random generateurAleat = new Random();

        // TODO code application logic here
        int Tab []= new int [6];
        System.out.println("Saisissez un nombre entier m");
        Scanner sc = new Scanner(System.in);
        m = sc.nextFloat();
        for (double i=0; i<m; i++) {
            int n = generateurAleat.nextInt(6);
            Tab[n]+=1;  
        }
        for (int i=0;i<Tab.length;i++) {
            System.out.print((Tab[i]/m)*100+" ; ");
        }
    }
    
}
