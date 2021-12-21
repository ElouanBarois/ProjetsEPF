/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_console_barois_bernard;

/**
 *
 * @author Elou
 */
public class Ligne {
    //Attributs
    Cellule[] CellulesLigne= new Cellule [4];
    String [] Code=new String[4];
    String [] CouleursLigne=new String [4];
    
    //Constructeur
    public Ligne (){
        for (int i=0;i<4;i++){
                CellulesLigne[i]=new Cellule();
        }
    }
    
    
    
    public void AfficherLigneSurConsole(String[] Code){
       
        for (int i=0;i<4;i++){
            CouleursLigne[i]=CellulesLigne[i].Couleur;
            if (CellulesLigne[i].Couleur=="vide"){
                System.out.print("\033[37m O  ");
            }
            if (CellulesLigne[i].Couleur=="Rouge"){
                System.out.print("\033[31m O  ");
            }
            if (CellulesLigne[i].Couleur=="Jaune"){
                System.out.print("\033[33m O  ");
            }
            if (CellulesLigne[i].Couleur=="Violet"){
                System.out.print("\035[30m O  ");
            }
            if (CellulesLigne[i].Couleur=="Vert"){
                System.out.print("\033[32m O  ");
            }
            if (CellulesLigne[i].Couleur=="Bleu"){
                System.out.print("\033[34m O  ");
            }
            if (CellulesLigne[i].Couleur=="Orange"){
                System.out.print("\033[48:2:255:165:0m%s\033[m O  ");
            }
        }
        for (int j=0;j<4;j++){
            if(CouleursLigne[j]==Code[j]){ //Si bon endroit bonne couleur
                System.out.print("\033[31m .");
            }
            else if(CouleursLigne[j]==Code[0]||CouleursLigne[j]==Code[1]||CouleursLigne[j]==Code[2]||CouleursLigne[j]==Code[3]){
                System.out.print("\033[33m .");
            }
            else{
                System.out.print("\033[37m .");
            }
        }
        
            
        System.out.print("\n");
        
    }
    
    

    
}
