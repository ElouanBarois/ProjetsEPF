/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_barois._bernard;

/**
 *
 * @author Elou
 */
public class Cellule {
    
    Jeton jetonCourant;
    
    public Cellule(){
        jetonCourant=null;
    
    }
    public boolean affecterJeton(Jeton unJeton){
        if (jetonCourant==null) {
            jetonCourant=unJeton;
            return true;
        }else{
            return false;
        }
    }
    public String lireCouleurDuJeton(){
        if (jetonCourant==null) {
            return "vide";
        }else{
            return jetonCourant.Couleur;  
        }
    }
    }
    

