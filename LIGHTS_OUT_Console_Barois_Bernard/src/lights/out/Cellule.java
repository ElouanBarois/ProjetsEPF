/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lights.out;

/**
 *
 * @author Elou
 */
public class Cellule {
    String Couleur;
    public Cellule(){
        Couleur="Blanc";
    }
    
    public void ChangerDeCouleur(){
        if (Couleur=="Violet"){
            Couleur="Blanc";
        }else{
            Couleur="Violet";
        }
    }
}
