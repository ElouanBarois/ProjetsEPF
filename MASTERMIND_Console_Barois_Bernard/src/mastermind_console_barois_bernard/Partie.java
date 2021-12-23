/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_console_barois_bernard;

/**
 *
 * @author Elou
 */
import java.util.Random;
import java.util.Scanner;

public class Partie {
    //Attributs:
    Grille grilleJeu;
    String[] Code;
    String[] Code2;
    String [] Couleurs={"Rouge","Jaune","Vert","Bleu","Orange","Violet"};
    int ligneActuelle;
    
    public void initialiserPartie(){
        grilleJeu= new Grille (); //crée une grille
        Code= new String[4];
        Random rand = new Random();
        int max=6;
        for (int i=0; i<4;i++){
            int random = rand.nextInt(max);
            Code[i]=Couleurs[random];
        }
        Code2=new String[] {"Rouge","Rouge","Bleu","Bleu"};
        
    }
    public void DebuterPartie(){
        for (int j=0;j<14;j++){
            ligneActuelle=j;
            for (int i=0;i<4;i++){
                Scanner sc = new Scanner(System.in) ;
                System.out.println("Quel couleur voulez-vous tenter: 1="+"\033[31mO "+"\033[37m2="+"\033[33mO "+"\033[37m3="+"\033[32mO "+"\033[37m4="+"\033[34mO "+"\033[37m5="+"\033[36mO "+"\033[37m6="+"\033[35mO "+"\033[37m." );
                int Choix = sc.nextInt();
                grilleJeu.LignesJeu[j].CellulesLigne[i].AjouterBoule(Choix);
            }
            String[] A=grilleJeu.AfficherGrilleSurConsole(Code2, ligneActuelle);
            if(grilleJeu.EtreGagnantePourJoueur(Code2, A)==true){
                System.out.println("GAGNÉ!");
                break;
            } 
        }
        System.out.println("fin de partie!");
        
    }
}
