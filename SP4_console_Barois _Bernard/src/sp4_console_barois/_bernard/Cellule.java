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
    
    //Attributs:
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
    
    //Constructeurs: (avec les valeurs des attributs par défaut)
    public Cellule(){
        jetonCourant=null;
        trouNoir=false;
        desintegrateur=false;
    
    }
    
    //Méthodes:
    
    public boolean affecterJeton(Jeton unJeton){  //On affecte à jetonCourant(le jeton dans la cellule) la valeur d'un jeton
        if (jetonCourant==null) {
            jetonCourant=unJeton;
            return true;
        }else{
            return false;
        }
    }
    public String lireCouleurDuJeton(){  //Renvoie la couleur du Jeton situé dans la cellule
        if (jetonCourant==null) {
            return "vide";
        }else{
            return jetonCourant.Couleur;  
        }
    }
    public boolean supprimerJeton(){    //Reset la valeur du jeton dans la cellule à null
        if (jetonCourant==null) {
            return false ;
        }
        else {
            jetonCourant=null ;
            return true ;
        }
    }
    public boolean placerTrouNoir(){    //Affecte true à l'attribut trouNoir (on place un trou noir dans cette cellule)
        if (presenceTrouNoir()==false){
            trouNoir=true;
            return true;
        }else{ return false;
        
        }
    }
    public boolean presenceTrouNoir(){  //Teste si un trou noir est présent dans la cellule
        if (trouNoir==true){
            return true ;
        }
        else {
            return false ;
        }
    }
    public boolean activerTrouNoir(){  //Si il y a un trou noir, active le trou noir, reset la valeur de jetonCourant et enlève le trou noir
        if (presenceTrouNoir()==true){
            jetonCourant = null ;
            trouNoir=false ;
            return true ;
        }
        else {
            return false ;
        }

    }
    public boolean presenceDesintegrateur(){  //Teste si un desintégrateur est présent dans la cellule
        if (desintegrateur==false){
            return false ;
        }
        else {
            return true ;
        }
    }
    public boolean placerDesintegrateur(){ //Si il n'y a pas de desintégrateur dans la cellule, en rajoute un
        if (presenceDesintegrateur()==false){
            desintegrateur=true ;
            return true ;
        }
        else {
            return false ;
        }
    }
    public boolean recupererDesintegrateur(){   //Si un désintégrateur est présent, on l'enlève de la cellule
        if (presenceDesintegrateur()==true){
            desintegrateur = false ;
            return true ;
        }
        else {
            return false ;
        }
    }
    public Jeton recupererJeton(){  //Renvoie le jeton présent dans la cellule
        return jetonCourant ;
    }
    }
    

