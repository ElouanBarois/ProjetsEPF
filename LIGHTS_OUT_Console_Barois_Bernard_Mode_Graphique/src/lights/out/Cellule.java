
package lights.out;


public class Cellule {
    String Couleur;
    public Cellule(){
        Couleur="Clair";
    }
    
    public void ChangerDeCouleur(){
        if (Couleur=="Foncé"){
            Couleur="Clair";
        }else{
            Couleur="Foncé";
        }
    }
}
