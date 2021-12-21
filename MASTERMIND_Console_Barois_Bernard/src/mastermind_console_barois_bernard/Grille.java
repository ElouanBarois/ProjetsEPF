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
    
    public void AfficherGrilleSurConsole(String[] Code){
        for (int j=0;j<14;j++){
            LignesJeu[j].AfficherLigneSurConsole(Code);
            
        }
    }
}
