/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_manip_barois_bernard;

/**
 *
 * @author Elou
 */
public class TP2_manip_BAROIS_BERNARD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tartiflette assiette1 = new Tartiflette(500) ;
        Tartiflette assiette2 = new Tartiflette(600) ;
        Tartiflette assiette3 = assiette2 ; 
        // TODO code application logic here
        System.out.println("nb de calories de Assiette 2 : " + assiette2.nbCalories) ;
        System.out.println("nb de calories de Assiette 3 : " +assiette3.nbCalories) ;
        assiette3.nbCalories+=50;
        System.out.println("nb de calories de Assiette 3 : " +assiette3.nbCalories) ;
        
        Tartiflette assiette4 = assiette1 ;  
        assiette1 = assiette2 ;  
        assiette2 = assiette4 ; 
        
        /* Répondez alors à la question suivante : une référence objet qui annonce référencer un type d’objet
        peut-elle en référencer un autre qui n’a aucun rapport ? 
        Oui, car l'objet en soi n'est pas la référence */

    }
    
}
