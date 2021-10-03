/*
 * TPO Exercice 1
 * Elouan Barois
 * Septembre 2021
 */
package exo1;

import java.util.Scanner;

/**
 *
 * @author Elou
 */
public class Exo11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Bonjour");
        System.out.println("Au revoir");
        
        String prenom;
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Bonjour, quel est votre prenom ?");
        prenom = sc.nextLine();
        System.out.println("Bonjour"+ prenom);
        
    }
    
}
