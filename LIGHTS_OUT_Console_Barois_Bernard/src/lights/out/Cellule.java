
package lights.out;


public class Cellule {
    String Couleur; 
    
    public Cellule(){
        Couleur="Clair"; // une cellule prend la couleur Clair
    }
    
    public void ChangerDeCouleur(){ // méthode permettant de changer de couleur
        if (Couleur=="Foncé"){ // si la case est Foncé on la change en clair
            Couleur="Clair";
        }else{ // si la case est Clair on la change en Foncé
            Couleur="Foncé";
        }
    }
}
