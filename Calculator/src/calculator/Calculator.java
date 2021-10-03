/*
 * TPO Exercice 1
 * Elouan Barois Loïc Bernard
 * Septembre 2021
 */
package calculator;

import java.util.Scanner;

/**
 *
 * @author Elou
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Please enter the operator:\n1) add\n2) substract\n3) multiply\n4) divide\n5) modulo");
        int operator;
        int operande1;
        int operande2;
        int res=0;
        Scanner sc = new Scanner(System.in);
        operator=sc.nextInt();
        if (operator>5 || operator<1){
            System.out.println("ERREUR");
            System.exit(0);
        }
        System.out.println("\n Entrer le première valeur :");
        operande1=sc.nextInt(); // On demande a sc de donner la première valeur
        System.out.println("\n Entrer le dexième valeur :");
        operande2=sc.nextInt(); // On demande a sc de donner la deuxième valeur
        
        if (operator==1) {
            res=operande1+operande2;
        }
        if (operator==2) {
            res=operande1-operande2;
        }
        if (operator==3) {
            res=operande1*operande2;
        }
        if (operator==4) {
            res=operande1/operande2;
        }
        if (operator==5) {
            res=operande1%operande2;
        }
        System.out.println("le résultat est : "+ res);
    }
    
}
