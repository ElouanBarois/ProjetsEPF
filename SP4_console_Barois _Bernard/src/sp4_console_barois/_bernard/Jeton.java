/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_barois._bernard;

/**
 *
 * @author Elou
 */
public class Jeton {
    //Attributs:
    String Couleur;  //On a un seul attribut pour la classe Jeton (sa couleur)
    
    //Constructeurs: 
    public Jeton(String UneCouleur){   //Constructeur qui permet de créer un objet de classe Jeton, en rentrant sa couleur en argument
        Couleur=UneCouleur;
    }
    
    public String lireCouleur(){  //Méthode qui permet de renvoyer la couleur du jeton
        return Couleur;
    }
    
}
