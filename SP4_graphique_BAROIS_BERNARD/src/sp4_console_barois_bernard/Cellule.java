
package sp4_console_barois_bernard;


public class Cellule {
    
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
    public Cellule(){
        jetonCourant=null;
        trouNoir=false;
        desintegrateur=false;
    
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
    public boolean supprimerJeton(){
        if (jetonCourant==null) {
            return false ;
        }
        else {
            jetonCourant=null ;
            return true ;
        }
    }
    public boolean placerTrouNoir(){
        if (presenceTrouNoir()==false){
            trouNoir=true;
            return true;
        }else{ return false;
        
        }
    }
    public boolean presenceTrouNoir(){
        if (trouNoir==true){
            return true ;
        }
        else {
            return false ;
        }
    }
    public boolean activerTrouNoir(){
        if (presenceTrouNoir()==true){
            jetonCourant = null ;
            trouNoir=false ;
            return true ;
        }
        else {
            return false ;
        }

    }
    public boolean presenceDesintegrateur(){
        if (desintegrateur==false){
            return false ;
        }
        else {
            return true ;
        }
    }
    public boolean placerDesintegrateur(){
        if (presenceDesintegrateur()==false){
            desintegrateur=true ;
            return true ;
        }
        else {
            return false ;
        }
    }
    public boolean recupererDesintegrateur(){
        if (presenceDesintegrateur()==true){
            desintegrateur = false ;
            return true ;
        }
        else {
            return false ;
        }
    }
    public Jeton recupererJeton(){
        return jetonCourant ;
    }

    String lireCouleurDuDjeton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

