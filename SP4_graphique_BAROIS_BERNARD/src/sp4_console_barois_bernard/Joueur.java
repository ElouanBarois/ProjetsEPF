
package sp4_console_barois_bernard;


public class Joueur {
    String nom;
    String Couleur;
    Jeton listeJetons []= new Jeton [21]; 
    int nombreJetonsRestants;
    int nombreDesintegrateurs ;
    
    public Joueur(String Unnom){
        nom=Unnom;
    }
    
    public void affecterCouleur(String UneCouleur){
        Couleur=UneCouleur;
    }
    
    public boolean ajouterJeton(Jeton UnJeton){
        if (nombreJetonsRestants!=21){
            listeJetons[nombreJetonsRestants]=UnJeton;
            return true;
        }else{
            return false;
        }
    }
   
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs++ ;
    }
    
    public boolean utiliserDesintegrateur(){
        if (nombreDesintegrateurs!=0){
            nombreDesintegrateurs-- ;
            return true ;
        }
        else {
            return false ;
        }
    } 
    
}
        