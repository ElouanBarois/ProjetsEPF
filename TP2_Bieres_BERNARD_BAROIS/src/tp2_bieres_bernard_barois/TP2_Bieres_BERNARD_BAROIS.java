/*
 * TP1 Exercice 1
 * Elouan Barois Loïc Bernard
 * Octobre 2021
 */
package tp2_bieres_bernard_barois;

/**
 *
 * @author Elou
 */
public class TP2_Bieres_BERNARD_BAROIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BouteilleBiere uneBiere = new BouteilleBiere("Cuvée des trolls",7.0,"Dubuisson",false) ;
        uneBiere.lireEtiquette();
        
        BouteilleBiere deuxBiere = new BouteilleBiere("Leffe",6.6,"Abbaye de Leffe",false) ;
        deuxBiere.lireEtiquette();
        
        BouteilleBiere troisBiere = new BouteilleBiere("Chienpanzé",9.0,"LaJungle",false) ;
        troisBiere.lireEtiquette();
        
        BouteilleBiere quatreBiere = new BouteilleBiere("Lit de Mort",75.0,"Youssoupha",false) ;
        quatreBiere.lireEtiquette();
        
        BouteilleBiere cinqBiere = new BouteilleBiere("En Bas La",0.1,"Deguem Pro",false) ;
        quatreBiere.lireEtiquette();
        

        
        
    }
    
}
