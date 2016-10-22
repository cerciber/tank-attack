/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankattack.clases;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author cesar
 */
public class Base {
    
    /* Objeto contenedor */
    Tablero tablero;
    
    int x; // Posicion en x
    int y; // Posicion en y
    int w = 50;
    int h = 50;
    
    public Base(Tablero t, int x, int y){
        
        tablero = t;
        this.x = x;
        this.y = y;
        
    }
    
    public void paint(Graphics2D g2){
        
        g2.setColor (Color.blue);
        g2.fillRect (x, y, w, h);
    
    }
    
    public void eventos(){}
    
    public void actualizar(){}
    
}

    
