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
    //Attributs:
    Cellule[] [] CellulesJeu = new Cellule [6][7] ;
    int i = 0;
    
    //Constructeurs: 
    public Grille (){
        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                CellulesJeu[i][j]=new Cellule();
            }
        }
    }

    //Méthodes:
    public boolean ajouterJetonDansColonne(Jeton jeton , int numColonne){ //teste si la colonne est pleine, si non, on rajoute un jeton à la première cellule sans jeton de cette colonne
            int j=0;
            if (CellulesJeu[5][numColonne].jetonCourant!=null){
                return false ;
            }
            else {
                while (celluleOccupee(j,numColonne)){ //tant que la cellule est occupée on ne fait rien
                    j++ ;
                }
                CellulesJeu[j][numColonne].affecterJeton(jeton) ; //On rajoute le jeton à la première cellule sans jeton
                return true ; 
            }
    }
    
    public boolean etreRemplie() {  //Renvoie true si la grille est pleine
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
    public void viderGrille(){ //vide les jetons de la grille
        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                CellulesJeu[i][j].jetonCourant=null;
            }
        }
    }
    
    
    public void afficherGrilleSurConsole(){  //On affiche la grille sur la console
        for (int i=5;i>=0;i--){
            for (int j=0;j<7;j++){
                if (celluleOccupee(i, j)==true){  //Si il y a un jeton dans la cellule
                    if (lireCouleurDuJeton(i, j)=="Rouge"){ //Si le jeton est rouge
                        System.out.print("\033[31m O  ");  //Print un O rouge
                    }else{
                        System.out.print("\033[33m O  ");   //Sinon print un O Jaune
                    }
                } else if(CellulesJeu[i][j].presenceDesintegrateur()==true){ //Sinon si on a un desintégrateur
                    if(CellulesJeu[i][j].presenceTrouNoir()==true){   //Si on a un trou noir
                        System.out.print("\033[35m O  ");  //On print un O violet (trou noir) qui cache le désintégrateur
                    }else{
                        System.out.print("\033[32m X  ");  //On print un X vert (désintégrateur "toxique")
                    }
                } else if(CellulesJeu[i][j].presenceTrouNoir()==true){
                    System.out.print("\033[35m O  "); //On print un O violet (trou noir) pour le reste des trous noirs
                
                    
                }else{
                    System.out.print("\033[37m O  ");  //On print de O blancs pour le reste des cellules
                }
            }
            System.out.println(""); //Permet d'aligner bien les cellules
        }
        
    }
    
    
    public boolean celluleOccupee(int ligne, int colonne){  //Teste si une cellule est occupée
        if (CellulesJeu[ligne][colonne].jetonCourant!=null){
            return true;
        }else{
            return false;
        }
    }
    
    public String lireCouleurDuJeton(int ligne, int colonne){  //renvoie la couleur du Jeton dans la cellule
        return CellulesJeu[ligne][colonne].jetonCourant.Couleur;  
    }
    
    public boolean etreGagnantePourJoueur(Joueur joueur){  //Teste si la grille est gagnante pour un Joueur donné
        int val=0;
        int i;
        int j;
        for(i=0;i<6;i++){  //Pour toutes les lignes
            if (val==1){  //Si une combinaison a été concluante on peut break, car la grill est déjà gagnante
                break;
            }
            for(j=0;j<4;j++){  //On teste si on a 4 jetons de suite sur 1a ligne
                if (celluleOccupee(i, j)&&celluleOccupee(i, j+1)&&celluleOccupee(i, j+2)&&celluleOccupee(i, j+3)==true){  //On doit d'abord tester que toutes les cellules sont bien occupées sinon on a une erreur car on essaye de comparer un null
                    if (CellulesJeu[i][j].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i][j+1].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i][j+2].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i][j+3].jetonCourant.Couleur==joueur.Couleur){
                        val=1; //C'est un test pour éviter de continuer à tester de combinaisons gagnantes si une a déjà été trouvée
                        break;
                    }
                }
            }
        }
        
        //On teste si on a 4 jetons de suite sur 1a colonne
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
        
        //On teste si on a 4 jetons de suite sur 1a diagonale ascendante
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
        
        //On teste si on a 4 jetons de suite sur 1a diagonale descendante
        for(i=0;i<3;i++){
            if (val==1){
                break;
            }
            for(j=6;j>2;j--){ //Il faut faire attention à décroitre les colonne plutot qu'augmenter
                if (celluleOccupee(i, j)&&celluleOccupee(i+1, j-1)&&celluleOccupee(i+2, j-2)&&celluleOccupee(i+3, j-3)==true){
                    if (CellulesJeu[i][j].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i+1][j-1].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i+2][j-2].jetonCourant.Couleur==joueur.Couleur && CellulesJeu[i+3][j-3].jetonCourant.Couleur==joueur.Couleur){
                        val=1;
                        break;
                    }
                }
            }
        }
        if (val==1){ //Si grille gagnante
            return true;
        }
        else{ //sinon
            return false;
        }
    }
    
    
    
    public boolean colonneRemplie(int numColonne){ //Teste si la dernière cellule de la colonne a un jeton(donc si la colonne est remplie)

            if (CellulesJeu[5][numColonne].jetonCourant!=null){
                return true;
            }else{
                return false;
            }
            
    }
    public boolean placerTrouNoir(int numLigne,int numColonne){ //Si on n'a pas de trou noir, on en place un dans la cellule
        if (CellulesJeu[numLigne][numColonne].presenceTrouNoir()){
            return false;
        }else{
            CellulesJeu[numLigne][numColonne].placerTrouNoir();
            return true;
        }
    }
    public boolean placerDesintegrateur(int numLigne, int numColonne){ //Si on n'a pas de désintégrateur, on en place un dans la cellule
        if (CellulesJeu[numLigne][numColonne].presenceDesintegrateur()){
                return false;
            }else{
                CellulesJeu[numLigne][numColonne].placerDesintegrateur();
                return true;
            }
    }
    public boolean supprimerJeton(int numLigne, int numColonne){ //Si la cellule est occupée, on reset la valeur du jeton
        if (celluleOccupee(numLigne,numColonne)== true){
            CellulesJeu[numLigne][numColonne].jetonCourant = null ;
            return true ;
        }
        else {
            return false ;
        }
    }
    public Jeton recupererJeton(int numLigne , int numColonne){ //supprime le jeton d'une cellule, et le renvoie
        Jeton Jeton_recupere=CellulesJeu[numLigne][numColonne].jetonCourant; //On sauvegarde la valeur de ce jeton dans un nouvel objet
        CellulesJeu[numLigne][numColonne].jetonCourant = null ;
        return Jeton_recupere ;
    }
    
    public void tasserGrille(int numColonne){ //Parcourt les cellules de la colonne (du bas vers le haut), dés qu'une est vide, fait descendre les jetons au dessus
        for (int i=0;i<6;i++){
            if (celluleOccupee(i,numColonne)==false){
                for( int j=i;j<5;j++){ //j est initialisé à i, comme ça on ne traite pas les cellules sous la cellule vide
                    CellulesJeu[j][numColonne].jetonCourant=CellulesJeu[j+1][numColonne].jetonCourant;
                }
                CellulesJeu[5][numColonne].jetonCourant=null; //la dernière cellule est reset car elle se vide
                break;
            }
        }
    }
    
}
    
