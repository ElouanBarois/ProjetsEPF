/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_barois._bernard;

/**
 *
 * @author Elou
 */
public class Grille {

    Cellule[] [] CellulesJeu = new Cellule [6][7] ;
    int i = 0;
    public Grille (){
        CellulesJeu=null;
    }

    public boolean ajouterJetonDansColonne(Jeton jeton , int numColonne){
            if (CellulesJeu[5][numColonne-1]!=null){
                return false ;
            }
            else {
                while (CellulesJeu[i][numColonne-1]!=null ){ 
                    i++ ;
                }
                CellulesJeu[i][numColonne-1].jetonCourant=jeton ;
                return true ; 
            }
    }
    public boolean etreRemplie() {
        boolean rep=false;
        for(int i=0;i<7;i++){
            if (CellulesJeu[5][i]!=null){
                rep=true;
            }
        }
        if (rep==false){
            return true;
        }else{
            return false;
        }
    }
    public void viderGrille(){
        CellulesJeu=null;
    }
    public void afficherGrilleSurConsole(){
        System.out.println(CellulesJeu);
    }
    public boolean celluleOccupee(int ligne, int colonne){
        if (CellulesJeu[ligne-1][colonne-1]!=null){
            return true;
        }else{
            return false;
        }
    }
    public String lireCouleurDuJeton(int ligne, int colonne){
        return CellulesJeu[ligne-1][colonne-1].jetonCourant.Couleur;  
    }
    public boolean etreGagnantePourJoueur(Joueur joueur){
        int val=0;
        int j;
        int i;
        for(j=0;j<6;j++){
            if (val==1){
                break;
            }
            for(i=0;i<4;i++){
                if (CellulesJeu[j][i].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[j][i+1].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[j][i+2].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[j][i+3].jetonCourant.Couleur==joueur.Couleur){
                    val=1;
                    break;
                }
            }
        }
        for(j=0;j<3;j++){
            if (val==1){
                break;
            }
            for(i=0;i<7;i++){

                if (CellulesJeu[j][i].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[j+1][i].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[j+2][i].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[j+3][i].jetonCourant.Couleur==joueur.Couleur){
                    val=1;
                    break;
                }
            }
        }

        for(j=0;j<3;j++){
            if (val==1){
                break;
            }
            for(i=0;i<4;i++){
                if (CellulesJeu[j][i].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[j+1][i+1].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[j+2][i+2].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[j+3][i+3].jetonCourant.Couleur==joueur.Couleur){
                    val=1;
                    break;
                }
            }
        }

        for(j=0;j<3;j++){
            if (val==1){
                break;
            }
            for(i=6;i<3;i--){
                if (CellulesJeu[j][i].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[j+1][i-1].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[j+2][i-2].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[j+3][i-3].jetonCourant.Couleur==joueur.Couleur){
                    val=1;
                    break;
                }
            }
        }
        if (val==1){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean colonneRemplie(int numColonne){

            if (CellulesJeu[5][numColonne-1]!=null){
                return true;
            }else{
                return false;
            }
            
    }
}
    
