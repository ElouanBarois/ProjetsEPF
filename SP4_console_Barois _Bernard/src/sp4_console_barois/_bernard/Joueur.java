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
    String nom;
    String Couleur;
    Jeton ListeJeton []= new Jeton [21]; 
    int nombreJetonsRestants;
    
    public Joueur(String Unnom){
        nom=Unnom;
    }
    
    public void affecterCouleur(String UneCouleur){
        Couleur=UneCouleur;
    }
    
    public void ajouterJeton(Jeton UnJeton){
        ListeJeton[nombreJetonsRestants]=UnJeton;
    }
    
}
