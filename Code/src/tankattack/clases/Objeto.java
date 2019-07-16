package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Objeto {

    int x;    // posicion en x
    int y;    // posicion en y
    int w;    // ancho
    int h;    // alto
    Image i;  // imagen
    
    public Objeto(int x, int y, int w, int h, String d){
        
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.i = new ImageIcon(this.getClass().getResource(d)).getImage();
        
    }
    
    public void paint(Graphics2D g){
        
        g.drawImage (i, x, y, w, h, null);
        
    }
    
    public boolean click(MouseEvent me){
        
        return me.getX() >= x  && me.getX() <= x + w
                && me.getY() >= y && me.getY() <= y + h;
        
    }
    
    public boolean enter(KeyEvent ke){
        
        return ke.getKeyCode() == KeyEvent.VK_ENTER;
        
    }
    
}
