
package lights.out;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class CelluleGraphique extends JButton{
    int x;
    int y;
    Cellule celluleAssociee ;
    ImageIcon caseClair = new javax.swing.ImageIcon(getClass().getResource("/Images/caseClair.drawio.png")) ;
    ImageIcon caseFoncee = new javax.swing.ImageIcon(getClass().getResource("/images/caseFoncee.drawio.png")) ;
    
public CelluleGraphique (Cellule uneCellule, int a, int b){
    celluleAssociee = uneCellule ;
    x=a ;
    y=b;

}

public void paintComponent (Graphics G){
        super.paintComponent(G) ;
        if (celluleAssociee.Couleur=="Clair"){
            setIcon(caseClair) ;
        }
        else {
            setIcon(caseFoncee) ;
        }
        
        
        
        
}


}