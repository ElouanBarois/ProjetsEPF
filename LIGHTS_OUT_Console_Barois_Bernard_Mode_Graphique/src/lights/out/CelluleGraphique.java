
package lights.out;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class CelluleGraphique extends JButton{
    Cellule celluleAssociee ;
    ImageIcon caseClair = new javax.swing.ImageIcon(getClass().getResource("/Images/caseClair.drawio.png")) ;
    ImageIcon caseFoncee = new javax.swing.ImageIcon(getClass().getResource("/images/caseFoncee.drawio.png")) ;

public CelluleGraphique (Cellule uneCellule){
    celluleAssociee = uneCellule ;

}

public void paintComponent (Graphics G){
        super.paintComponent(G) ;
        Random rand = new Random();
        int Coul=rand.nextInt(2);
        if (Coul==1){
            setIcon(caseClair) ;
        }
        else {
            setIcon(caseFoncee) ;
        }
        
        
}


}