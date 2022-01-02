/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_console_barois_bernard;

/**
 *
 * @author Elou
 */
public class Grille {
    //Attributs:
    Ligne [] LignesJeu = new Ligne [14] ;
    
    
    //Constructeurs: 
    public Grille (){
            for (int j=0;j<14;j++){
                LignesJeu[j]=new Ligne();
            }
    }
    
    public String[] AfficherGrilleSurConsole(String[] Code,int ligneActuelle ){ //On prend en argument le code à trouver et la ligne sur laquelle le joueur joue
        String [] B = new String [4];
        for (int j=0;j<14;j++){ //Boucle pour les 14 lignes
            String [] A =LignesJeu[j].AfficherLigneSurConsole(Code); //On appelle l'affichage de chaque ligne
            if (j==ligneActuelle){ //On sauvegarde les couleurs tentées pour la lignes actuelle
                B = A;
            }
        }
        return B; //on retourne le tableau de couleurs de la ligne actuelle
    }
    
    public boolean EtreGagnantePourJoueur(String[] Code,String[] CouleursLigne){  //On prend 2 arguments qu'on va comparer
        int compt=0;
        for (int j=0;j<4;j++){ //On teste si chaque couleur correspond indice par indice
            if (CouleursLigne[j]==Code[j]){
                compt++;
            }
        }
        if (compt==4){ // si les 4 couleurs correspondent la grille est gagnante
            return true;
        }
        else{
            return false;
        }
    }
}
