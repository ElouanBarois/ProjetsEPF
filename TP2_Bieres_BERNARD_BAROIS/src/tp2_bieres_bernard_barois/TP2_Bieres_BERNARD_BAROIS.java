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
        BouteilleBiere uneBiere = new BouteilleBiere("Cuvée des trolls",7.0,"Dubuisson") ;
        uneBiere.lireEtiquette();
        
        BouteilleBiere deuxBiere = new BouteilleBiere("Leffe",6.6,"Abbaye de Leffe") ;
        deuxBiere.lireEtiquette();
        
        BouteilleBiere troisBiere = new BouteilleBiere("Chienpanzé",9.0,"LaJungle") ;
        troisBiere.lireEtiquette();
        
        BouteilleBiere quatreBiere = new BouteilleBiere("Lit de Mort",75.0,"Youssoupha") ;
        quatreBiere.lireEtiquette();
        
        BouteilleBiere cinqBiere = new BouteilleBiere("En Bas La",0.1,"Deguem Pro") ;
        cinqBiere.lireEtiquette();
        
        uneBiere.Decapsuler();

        /* System.out.println("La Biere "+ uneBiere.Nom+" est ouverte? "+ uneBiere.ouverte); */
        
        System.out.println(uneBiere) ; 
        
        troisBiere.Decapsuler();
        System.out.println(troisBiere) ; 
        
        cinqBiere.Decapsuler();
        System.out.println(cinqBiere) ;
    }
    
}
