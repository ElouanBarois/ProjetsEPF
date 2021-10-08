/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_bieres_bernard_barois;

/**
 *
 * @author Elou
 */
public class BouteilleBiere {
    String Nom;
    double degreAlcool;
    String brasserie;
    boolean ouverte;
    
    public void lireEtiquette() {
        System.out.println("Bouteille de " + Nom +" (" + degreAlcool + " degres) \nBrasserie : " + brasserie ) ;

    }
    public BouteilleBiere(String unNom, double unDegre, String uneBrasserie,boolean uneOuverte) {
        Nom = unNom;
        degreAlcool = unDegre;
        brasserie = uneBrasserie;
        ouverte = false;
    }
    public void Decapsuler() {
        if (ouverte==false){
            ouverte=true;
        }
        else {
            System.out.println("erreur : biere déjà ouverte");
            ouverte=false;
        }
    }
}

