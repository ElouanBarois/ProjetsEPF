
package lights.out;


public class Grille {
    Cellule[] [] CellulesJeu = new Cellule [5][5] ;
    
    public Grille (){
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                CellulesJeu[i][j]=new Cellule();
            }
        }
    }
    
    
    public void afficherGrilleSurConsole(){
        for (int i=4;i>=0;i--){
            for (int j=0;j<5;j++){
                if (CellulesJeu[i][j].Couleur=="Violet"){
                    System.out.print("\033[35m O  ");
                }else{
                    System.out.print("\033[37m O  ");
                }
            }
            System.out.println("");
        }
    }
    
    public void ClicJoueur(int numLigne,int numColonne){
       CellulesJeu[numLigne][numColonne].ChangerDeCouleur();
       if (numLigne==0){
           if (numColonne==0){
               CellulesJeu[numLigne+1][numColonne].ChangerDeCouleur();
               CellulesJeu[numLigne][numColonne+1].ChangerDeCouleur();
           }else if(numColonne==4){
               CellulesJeu[numLigne+1][numColonne].ChangerDeCouleur();
               CellulesJeu[numLigne][numColonne-1].ChangerDeCouleur();
           }else{
               CellulesJeu[numLigne+1][numColonne].ChangerDeCouleur();
               CellulesJeu[numLigne][numColonne-1].ChangerDeCouleur();
               CellulesJeu[numLigne][numColonne+1].ChangerDeCouleur();
           }
       }
       else if (numLigne==4){
           if (numColonne==0){
               CellulesJeu[numLigne-1][numColonne].ChangerDeCouleur();
               CellulesJeu[numLigne][numColonne+1].ChangerDeCouleur();
           }else if(numColonne==4){
               CellulesJeu[numLigne-1][numColonne].ChangerDeCouleur();
               CellulesJeu[numLigne][numColonne-1].ChangerDeCouleur();
           }else{
               CellulesJeu[numLigne-1][numColonne].ChangerDeCouleur();
               CellulesJeu[numLigne][numColonne-1].ChangerDeCouleur();
               CellulesJeu[numLigne][numColonne+1].ChangerDeCouleur();
           }
       }
       else if (numColonne==0){
               CellulesJeu[numLigne+1][numColonne].ChangerDeCouleur();
               CellulesJeu[numLigne-1][numColonne].ChangerDeCouleur();
               CellulesJeu[numLigne][numColonne+1].ChangerDeCouleur();
       }
       else if (numColonne==4){
               CellulesJeu[numLigne+1][numColonne].ChangerDeCouleur();
               CellulesJeu[numLigne-1][numColonne].ChangerDeCouleur();
               CellulesJeu[numLigne][numColonne-1].ChangerDeCouleur();
       }else{
           CellulesJeu[numLigne+1][numColonne].ChangerDeCouleur();
           CellulesJeu[numLigne-1][numColonne].ChangerDeCouleur();
           CellulesJeu[numLigne][numColonne-1].ChangerDeCouleur();
           CellulesJeu[numLigne][numColonne+1].ChangerDeCouleur();
       }
    }
    
    public boolean etreGagnantePourJoueur(){
       boolean res=true;
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                if (CellulesJeu[i][j].Couleur=="Blanc"){
                    res=false;
                    break;
                }
            }
            if(res==false){
                break;
            }
        }
        return res;
    }
    
}
