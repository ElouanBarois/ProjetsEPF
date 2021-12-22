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
    Ligne [] LignesJeu = new Ligne [14] ;
    
    
    //Constructeurs: 
    public Grille (){
            for (int j=0;j<14;j++){
                LignesJeu[j]=new Ligne();
            }
    }
    
    public String[] AfficherGrilleSurConsole(String[] Code,int ligneActuelle ){
        String [] B = new String [4];
        for (int j=0;j<14;j++){
            String [] A =LignesJeu[j].AfficherLigneSurConsole(Code);
            if (j==ligneActuelle){
                B = A;
            }
        }
        return B;
    }
    
    public boolean EtreGagnantePourJoueur(String[] Code,String[] CouleursLigne){
        int compt=0;
        for (int j=0;j<4;j++){
            if (CouleursLigne[j]==Code[j]){
                compt++;
            }
        }
        if (compt==4){
            return true;
        }
        else{
            return false;
        }
    }
}
