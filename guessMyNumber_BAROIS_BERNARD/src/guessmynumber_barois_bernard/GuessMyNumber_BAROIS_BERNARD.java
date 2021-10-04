/*
 * TP1 Exercice 1
 * Elouan Barois Loïc Bernard
 * Octobre 2021
 */
package guessmynumber_barois_bernard;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Elou
 */
public class GuessMyNumber_BAROIS_BERNARD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here\
        Random generateurAleat = new Random();
        /**  on affiche 5 nb aléatoires à l'écran
            for (int i=0;i<5;i++) {
                int n = generateurAleat.nextInt(100);   
                System.out.println(n);
            }
        */
        int ChoixJoueur=0;
        int n = generateurAleat.nextInt(100);
        System.out.println("Saisissez une valeur entre 0 et 100");
        Scanner sc = new Scanner(System.in);
        ChoixJoueur = sc.nextInt();
        while (ChoixJoueur!=n) {
            if (ChoixJoueur>n) {
                System.out.println("Trop grand");
                System.out.println("Saisissez une valeur entre 0 et 100");
                ChoixJoueur = sc.nextInt();
            }
            if (ChoixJoueur<n) {
                System.out.println("Trop petit");
                System.out.println("Saisissez une valeur entre 0 et 100");
                ChoixJoueur = sc.nextInt();
            }
        if (ChoixJoueur==n) {
            System.out.println("Gagné");
        }

        }
    }
        

    
    
    
