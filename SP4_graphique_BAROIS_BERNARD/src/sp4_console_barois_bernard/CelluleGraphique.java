
package sp4_console_barois_bernard;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class CelluleGraphique extends JButton {
    Cellule celluleAssociee ;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png")) ;
    ImageIcon img_jetonJaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png")) ;
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png")) ;
    ImageIcon img_jetonRouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png")) ;
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png")) ;
    
    
    
    public CelluleGraphique (Cellule uneCellule) {
        celluleAssociee = uneCellule ;
    }
    
    @Override
    
    public void paintComponent (Graphics G){
        super.paintComponent(G) ;
        System.out.println(celluleAssociee.trouNoir);
        if (celluleAssociee.presenceTrouNoir() == true ){
            setIcon(img_trouNoir) ;
        }
        else if (celluleAssociee.presenceDesintegrateur() == true ){
                setIcon(img_desint) ;
        }
        else {
            String couleur_jeton = celluleAssociee.lireCouleurDuJeton() ;
            switch (couleur_jeton) {
                case "vide":
                    setIcon(img_vide) ;
                    break;
                case "Rouge":
                    setIcon(img_jetonRouge) ;
                    break;
                case "Jaune":
                   setIcon(img_jetonJaune) ;
                    break ;
            }
        }
      }
    
    
    
    
    
    
    
    
}
