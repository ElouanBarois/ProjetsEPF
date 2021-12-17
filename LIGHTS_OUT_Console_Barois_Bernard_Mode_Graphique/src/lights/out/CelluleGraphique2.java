
package lights.out;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class CelluleGraphique2 extends JButton{
    int x;
    int y;
    Cellule celluleAssociee ;
    ImageIcon caseClair2 = new javax.swing.ImageIcon(getClass().getResource("/Images/caseClair2.drawio.png")) ;
    ImageIcon caseFoncee2 = new javax.swing.ImageIcon(getClass().getResource("/images/caseFoncee2.drawio.png")) ;
    
    
    public CelluleGraphique2 (Cellule uneCellule, int a , int b){
        celluleAssociee = uneCellule ;
        x=a ;
        y=b;

    }   

public void paintComponent (Graphics G){
        super.paintComponent(G) ;
        if (celluleAssociee.Couleur=="Clair"){
            setIcon(caseClair2) ;
        }
        else {
            setIcon(caseFoncee2) ;
        }
        
        
        
        
}

    
    
    
    
    
    
    
    
    
}
