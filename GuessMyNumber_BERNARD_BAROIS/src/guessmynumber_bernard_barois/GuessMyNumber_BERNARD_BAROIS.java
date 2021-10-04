/*
 * TP1 Exercice 1
 * Elouan Barois Loïc Bernard
 * Octobre 2021
 */
package guessmynumber_bernard_barois;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Elou
 */
public class GuessMyNumber_BERNARD_BAROIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here\
        Random generateurAleat = new Random();
        Scanner sc = new Scanner(System.in);

        /**  on affiche 5 nb aléatoires à l'écran
            for (int i=0;i<5;i++) {
                int n = generateurAleat.nextInt(100);   
                System.out.println(n);
            }
        */
        System.out.println("Bienvenue au \" Guess My Number \" \nQuel niveau de difficulté souhaitez-vous?\n1) facile\n2) normal\n3) Difficile") ;
        int Diff = sc.nextInt();
        int ChoixJoueur=0;
        int compteur=1;
        if (Diff==1) {
            System.out.println("Mode Facile activé: tentatives illimitées, nombre entre 0 et 50, aide améliorée");
            int n = generateurAleat.nextInt(50);
            System.out.println("Saisissez une valeur entre 0 et 50");
            ChoixJoueur = sc.nextInt();
            while (ChoixJoueur!=n) {
                if (ChoixJoueur>n) {
                    if (ChoixJoueur>(n+15)) {
                        System.out.println("Beaucoup Trop grand: (au moins 15 de différence)");
                        System.out.println("Saisissez une valeur entre 0 et 50");
                        ChoixJoueur = sc.nextInt();
                    } 
                    else {
                        System.out.println("Trop grand: (moins de 15 de différence)");
                        System.out.println("Saisissez une valeur entre 0 et 50");
                        ChoixJoueur = sc.nextInt();
                    }
                }
                if (ChoixJoueur<n) {
                    if (ChoixJoueur<(n-15)) {
                        System.out.println("Beaucoup Trop petit: (au moins 15 de différence)");
                        System.out.println("Saisissez une valeur entre 0 et 50");
                        ChoixJoueur = sc.nextInt();
                    } 
                    else {
                        System.out.println("Trop petit: (moins de 15 de différence)");
                        System.out.println("Saisissez une valeur entre 0 et 50");
                        ChoixJoueur = sc.nextInt();
                    }
                }
                compteur ++;
            }
            if (ChoixJoueur==n) {
                System.out.println("Gagné en "+(compteur+1)+" tentatives");

            }
        }
        if (Diff==2) {
            System.out.println("Mode Normal activé: tentatives limitées à 10, nombre entre 0 et 100");
            int n = generateurAleat.nextInt(100);
            System.out.println("Saisissez une valeur entre 0 et 100");
            ChoixJoueur = sc.nextInt();
            while (ChoixJoueur!=n & compteur<10) {
                if (ChoixJoueur>n) {
                        System.out.println("Trop grand: ");
                        System.out.println("Saisissez une valeur entre 0 et 100");
                        ChoixJoueur = sc.nextInt();
                    }
                
                if (ChoixJoueur<n) {
                        System.out.println("Trop petit:");
                        System.out.println("Saisissez une valeur entre 0 et 100");
                        ChoixJoueur = sc.nextInt();
                    }
                compteur ++;
                }
            if (compteur!=10) {
                if (ChoixJoueur==n) {
                    System.out.println("Gagné en "+(compteur+1)+" tentatives");

                }
            }
            else {
                System.out.println("Perdu "+(compteur)+" tentatives; tentatives terminées");
            }
        }
        if (Diff==3) {
            System.out.println("Mode Normal activé: tentatives limitées à 5, nombre entre 0 et 100");
            int n = generateurAleat.nextInt(100);
            System.out.println("Saisissez une valeur entre 0 et 100");
            ChoixJoueur = sc.nextInt();
            while (ChoixJoueur!=n & compteur<5) {
                if (ChoixJoueur>n) {
                        System.out.println("Trop grand: ");
                        System.out.println("Saisissez une valeur entre 0 et 100");
                        ChoixJoueur = sc.nextInt();
                    }
                
                if (ChoixJoueur<n) {
                        System.out.println("Trop petit:");
                        System.out.println("Saisissez une valeur entre 0 et 100");
                        ChoixJoueur = sc.nextInt();
                    }
                compteur ++;
                }
            if (compteur!=5) {
                if (ChoixJoueur==n) {
                    System.out.println("Gagné en "+(compteur+1)+" tentatives");

                }
            }
            else {
                System.out.println("Perdu "+(compteur)+" tentatives; tentatives terminées");
            }
        }
        }
        /*
            int n = generateurAleat.nextInt(100);
            System.out.println("Saisissez une valeur entre 0 et 100");
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
                compteur ++;
            }
            if (ChoixJoueur==n) {
                System.out.println("Gagné en "+(compteur+1)+" tentatives");

            }
        **/
        
        }