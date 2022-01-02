
package lights.out;


public class Grille {
    Cellule[] [] CellulesJeu = new Cellule [5][5] ; // création d'une grille 5x5
    
    public Grille (){
        for (int i=0;i<5;i++){ // boucle parcourant les 5 lignes
            for (int j=0;j<5;j++){ // boucle parcourant les 5 colonnes
                CellulesJeu[i][j]=new Cellule(); // on crée une cellule jeu ayant pour coordonnées le numero de ligne et de colonne (i,j)
            }
        }
    }
    
    
    public void afficherGrilleSurConsole(){ // affiche la grille en console
        for (int i=4;i>=0;i--){ // boucle parcourant les 5 lignes
            for (int j=0;j<5;j++){ // boucle parcourant les 5 colonnes
                if (CellulesJeu[i][j].Couleur=="Foncé"){ // si la couleur associée à la celluleJeu est Foncé, on lui associe une couleur en console
                    System.out.print("\033[35m O  ");
                }else{ // si la couleur associée à la celluleJeu est Clair, on lui associe une autre couleur en console
                    System.out.print("\033[37m O  ");
                }
            }
            System.out.println(""); // crée un espace
        }
    }
    
    public void ClicJoueur(int numLigne,int numColonne){ // méthode permettant de cliquer sur une cellule en rentrant des coordonnées des lignes/colonnes
       CellulesJeu[numLigne][numColonne].ChangerDeCouleur(); // la case cliquée change de couleur
       // pour le code suivant, on change la couleur des cases autours de celle cliquée en fonction 
       // de la position de celle-ci si elle est positionnée aux extrémités ou pas
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
    
    public boolean etreGagnantePourJoueur(){ // méthode permettant de vérifier si un joueur a gagné
       boolean res=true;
        for (int i=0;i<5;i++){ // boucle parcourant les 5 lignes du tableau
            for (int j=0;j<5;j++){ // boucle parcourant les 5 colonnes du tableau
                if (CellulesJeu[i][j].Couleur=="Clair"){ // Si toutes les cases sont Clair, alors la variable res retourne false
                    res=false;
                    break;
                }
            }
            if(res==false){ // on sort donc de la boucle
                break;
            }
        }
        return res; // on retourne la valeur de res
    }
    
}
