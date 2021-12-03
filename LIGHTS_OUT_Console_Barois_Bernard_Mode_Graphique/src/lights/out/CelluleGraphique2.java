
package lights.out;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class CelluleGraphique2 extends JButton{
    Cellule celluleAssociee ;
    ImageIcon caseClair2 = new javax.swing.ImageIcon(getClass().getResource("/Images/caseClair2.drawio.png")) ;
    ImageIcon caseFoncee2 = new javax.swing.ImageIcon(getClass().getResource("/images/caseFoncee2.drawio.png")) ;
    
    
    public CelluleGraphique2 (Cellule uneCellule){
        celluleAssociee = uneCellule ;

    }   

public void paintComponent (Graphics A){
        super.paintComponent(A) ;
        Random rand = new Random();
        int Coul=rand.nextInt(2);
        if (Coul==1){
            setIcon(caseClair2) ;
        }
        else {
            setIcon(caseFoncee2) ;
        }
        
        
}

    
    
    
    
    
    
    
    
    
}
