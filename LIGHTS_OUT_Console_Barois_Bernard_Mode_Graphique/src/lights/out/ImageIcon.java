
package lights.out;
import java.awt.Graphics;
import javax.swing.JLabel;


public class ImageIcon extends JLabel{
    
    
javax.swing.ImageIcon lightsOut = new javax.swing.ImageIcon(getClass().getResource("/Images/ImageLightsOut.png")) ;

public ImageIcon (){
    
}

public void paintComponent (Graphics G){
        super.paintComponent(G) ;
        setIcon(lightsOut) ;
        
        
        
        
}





}