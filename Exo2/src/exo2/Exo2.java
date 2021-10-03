/*
 * TPO Exercice 1
 * Elouan Barois Loic Bernard
 * Septembre 2021
 */
package exo2;

import java.util.Scanner;

/**
 *
 * @author Elou
 */
public class Exo2 {


        public static void main(String[] args) {
            
            //Declaration des variables
            int nb; // nombre dentiers a additionner
            int result; // resultat
            int ind; //indice
            nb=5;
            //nb=5;
            Scanner sc = new Scanner(System.in);
            System.out.println("\n Entrer le nombre :");
            nb=sc.nextInt(); // On demande a sc de donner le prochain entier
            result=0;
            
            // Addition des nb premiers entiers
            ind=1;
            while (ind <= nb) {
            result=result+ind;
            ++ind;
            }
            
            
            // Affichage du resultat
            System.out.println();
            System.out.println("La somme des "+ nb + "entiers est: "+result);
        }
    }
    

