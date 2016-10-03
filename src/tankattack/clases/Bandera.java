package tankattack.clases;

import java.awt.Color;
import java.awt.Graphics2D;

public class Bandera {

    int x = 225; // Posicion en x
    int y = 100; // Posicion en y
    
    /*
    Poseedor actual de la bandera
        1: base aliada 
        2: tanque aliado 
        3: base enemiga 
        4: tanque enemigo  
    */
    int poseedor;    
    
    public void paint(Graphics2D g2){
        
        // Bandera
        g2.setColor (Color.red);
        g2.fillRect (x, y, 20, 12);
        
        // Mastil
        g2.setColor (Color.black);
        g2.fillRect (x, y, 5, 20);
        
        // Marco
        g2.setColor (Color.decode("#D8D8D8"));
        g2.drawRect(x, y, 20, 20);
    
    }
    
    public void eventos(){}
    
    public void actualizar(){}
    
}
