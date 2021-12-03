
package lights.out;


import java.util.Random;
import java.util.Scanner;
public class Partie {
    Scanner sc = new Scanner(System.in) ;
    Grille grilleJeu;
    String[] tab={"Blanc","Violet"};
    
    public void debuterPartie(){
        grilleJeu= new Grille ();
        Random rand = new Random();
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                int Coul=rand.nextInt(2);
                grilleJeu.CellulesJeu[i][j].Couleur=tab[Coul];
            }
        }
        boolean test1=false;
        while (test1==false){
            grilleJeu.afficherGrilleSurConsole();
            System.out.println("Quelle case voulez-vous taper?");
            System.out.print("Tapez la ligne:");
            int ligne_choisie = sc.nextInt()-1;
            System.out.print("Tapez la colonne:");
            int colonne_choisie = sc.nextInt()-1;
            grilleJeu.ClicJoueur(ligne_choisie,colonne_choisie);
            if (grilleJeu.etreGagnantePourJoueur()){
                test1=true;
            }
            
        }
        System.out.print("Vous avez gagné!");
        
    }
    
    
}
