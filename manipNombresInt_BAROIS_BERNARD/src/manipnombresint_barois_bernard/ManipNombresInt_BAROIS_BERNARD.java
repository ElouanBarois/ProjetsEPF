/*
 * TP1 Exercice 1
 * Elouan Barois Loïc Bernard
 * Octobre 2021
 */
package manipnombresint_barois_bernard;

import java.util.Scanner;

/**
 *
 * @author Elou
 */
public class ManipNombresInt_BAROIS_BERNARD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int var1 =0;
    int var2 =0;
    Scanner sc = new Scanner(System.in);
    System.out.println("Entrez 2 entiers: ");
    var1 = sc.nextInt();
    var2 = sc.nextInt();
    System.out.println(var1+" "+var2);
    System.out.println("somme ="+(var1+var2));
    System.out.println("diff ="+(var1-var2));
    System.out.println("produit ="+var1*var2);
    System.out.println("quotient entier ="+var1/var2+" et reste de la division euclidienne ="+var1%var2);

    
    }
}