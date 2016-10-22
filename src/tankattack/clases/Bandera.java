package tankattack.clases;

import java.awt.Color;
import java.awt.Graphics2D;

public class Bandera {

    /* Objeto contenedor */
    Tablero tablero;
    
    int x; // Posicion en x
    int y; // Posicion en y
    int w = 30;
    int h = 30;
    
    /*
    Poseedor actual de la bandera
        1: base aliada 
        2: tanque aliado 
        3: base enemiga 
        4: tanque enemigo  
    */
    int poseedor;
    
    public Bandera(Tablero t, int x, int y){
        
        tablero = t;
        this.x = x;
        this.y = y;
        
    }
    
    public void paint(Graphics2D g2){
        
        // Bandera
        g2.setColor (Color.red);
        g2.fillRect (x, y, w, h / 2);
        
        // Mastil
        g2.setColor (Color.black);
        g2.fillRect (x, y, 5, h);
    
    }
    
    public void eventos(){}
    
    public void actualizar(){}
    
}
