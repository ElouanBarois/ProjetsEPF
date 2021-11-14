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
        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                CellulesJeu[i][j]=new Cellule();
            }
        }
    }

    public boolean ajouterJetonDansColonne(Jeton jeton , int numColonne){
            int j=0;
            if (CellulesJeu[5][numColonne].jetonCourant!=null){
                return false ;
            }
            else {
                while (celluleOccupee(j,numColonne)){ 
                    j++ ;
                }
                CellulesJeu[j][numColonne].affecterJeton(jeton) ;
                return true ; 
            }
    }
    
    public boolean etreRemplie() {
        boolean rep=false;
        for(int i=0;i<7;i++){
            if (CellulesJeu[5][i].jetonCourant!=null){
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
        for (int i=5;i>=0;i--){
            for (int j=0;j<7;j++){
                if (celluleOccupee(i, j)==true){
                    if (lireCouleurDuJeton(i, j)=="Rouge"){
                        System.out.print("\033[31m O  ");
                    }else{
                        System.out.print("\033[33m O  ");
                    }
                }else{
                    System.out.print("\033[37m O  ");
                }
            }
            System.out.println("");
        }
        
    }
    
    
    public boolean celluleOccupee(int ligne, int colonne){
        if (CellulesJeu[ligne][colonne].jetonCourant!=null){
            return true;
        }else{
            return false;
        }
    }
    
    public String lireCouleurDuJeton(int ligne, int colonne){
        return CellulesJeu[ligne][colonne].jetonCourant.Couleur;  
    }
    
    public boolean etreGagnantePourJoueur(Joueur joueur){
        int val=0;
        int i;
        int j;
        for(i=0;i<6;i++){  //Pour toutes les lignes
            if (val==1){
                break;
            }
            for(j=0;j<4;j++){  //On teste si 4 jetons de suite sur 1 ligne
                if (celluleOccupee(i, j)&&celluleOccupee(i, j+1)&&celluleOccupee(i, j+2)&&celluleOccupee(i, j+3)==true){
                    if (CellulesJeu[i][j].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i][j+1].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i][j+2].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i][j+3].jetonCourant.Couleur==joueur.Couleur){
                        val=1;
                        break;
                    }
                }
            }
        }
        for(i=0;i<3;i++){
            if (val==1){
                break;
            }
            for(j=0;j<7;j++){
                if (celluleOccupee(i, j)&&celluleOccupee(i+1, j)&&celluleOccupee(i+2, j)&&celluleOccupee(i+3, j)==true){
                    if (CellulesJeu[i][j].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i+1][j].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i+2][j].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i+3][j].jetonCourant.Couleur==joueur.Couleur){
                        val=1;
                        break;
                    }
                }
            }
        }

        for(i=0;i<3;i++){
            if (val==1){
                break;
            }
            for(j=0;j<4;j++){
                if (celluleOccupee(i, j)&&celluleOccupee(i+1, j+1)&&celluleOccupee(i+2, j+2)&&celluleOccupee(i+3, j+3)==true){
                    if (CellulesJeu[i][j].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i+1][j+1].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i+2][j+2].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i+3][j+3].jetonCourant.Couleur==joueur.Couleur){
                        val=1;
                        break;
                    }
                }
            }
        }

        for(i=0;i<3;i++){
            if (val==1){
                break;
            }
            for(j=6;j<3;j--){
                if (celluleOccupee(i, j)&&celluleOccupee(i+1, j-1)&&celluleOccupee(i+2, j-2)&&celluleOccupee(i+3, j-3)==true){
                    if (CellulesJeu[i][j].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i+1][j-1].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i+2][j-2].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i+3][j-3].jetonCourant.Couleur==joueur.Couleur){
                        val=1;
                        break;
                    }
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

            if (CellulesJeu[5][numColonne].jetonCourant!=null){
                return true;
            }else{
                return false;
            }
            
    }
}
    
