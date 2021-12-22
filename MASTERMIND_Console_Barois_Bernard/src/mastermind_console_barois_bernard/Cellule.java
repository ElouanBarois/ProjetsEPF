/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_console_barois_bernard;

/**
 *
 * @author Elou
 */
public class Cellule {
    //Attributs
    String Couleur;
    String [] TabCouleur={"Rouge","Jaune","Vert","Bleu","Orange","Violet"};
    
    public Cellule(){
    Couleur="vide";
    }
    
    public void AjouterBoule(int CouleurChoisie){
        Couleur=TabCouleur[CouleurChoisie-1];
    }
    
    
    
}
