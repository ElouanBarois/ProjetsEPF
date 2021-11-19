/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_barois._bernard;

/**
 *
 * @author Elou
 */
public class Joueur {
    //Attributs:
    String nom;
    String Couleur;
    Jeton listeJetons []= new Jeton [21]; 
    int nombreJetonsRestants;
    int nombreDesintegrateurs;
    
    //Constructeurs: 
    public Joueur(String Unnom){
        nom=Unnom;
    }
    
    public void affecterCouleur(String UneCouleur){
        Couleur=UneCouleur;
    }
    
    //Méthodes:
    public boolean ajouterJeton(Jeton UnJeton){ //Si le nombre de jetons du joueur est <25, rajoute un jeton dans sa liste de jetons
        if (nombreJetonsRestants!=21){
            listeJetons[nombreJetonsRestants]=UnJeton;
            return true;
        }else{
            return false;
        }
    }
    public void obtenirDesintegrateur(){ //rajoute un désintégrateur au joueur
        nombreDesintegrateurs++ ;
    }

    public boolean utiliserDesintegrateur(){ //Si un desintégrateur est disponible, on enleve 1 au total de desintégrateurs dispo pour le joueur
        if (nombreDesintegrateurs!=0){
            nombreDesintegrateurs-- ;
            return true ;
        }
        else {
            return false ;
        }
    }
    
}
