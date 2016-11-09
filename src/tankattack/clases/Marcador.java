package tankattack.clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class Marcador {
    
    /* Objeto contenedor */
    VS2Player escenario;
    
    /* variables globales */
    int x = 10;
    int y = 10;
    int w = 800 - 20;
    int h = 100 - 20;
    int Puntaje1 = 0;
    int Puntaje2 = 0;
    String J1;
    String J2;
   
    /* Fuente texto */
    Font fuente = new Font ("Helvetica", Font.BOLD, 12);
    
    public Marcador(VS2Player e){
        J1=JOptionPane.showInputDialog(null,"Nombre primer jugador");
        J2=JOptionPane.showInputDialog(null,"Nombre segundo jugador");
        escenario = e;
        
    }
    
    public void paint(Graphics2D g){
        
        // pintar marco
        g.setColor(Color.BLACK);
        g.fillRect(x, y, w, h);
        g.setColor(Color.GRAY);
        g.fillRect(x + 10, y + 10, w - 20, h - 20);
        g.setColor(Color.white);
        g.setFont(fuente);
        g.drawString(J1+": "+Puntaje1, x + 30, y + g.getFontMetrics().getAscent() + 30);
        
        g.drawString (J2+": "+Puntaje2, x + w - 30 - g.getFontMetrics()
                .stringWidth(J2), y + g.getFontMetrics().getAscent() + 30);
         
    }
    
    
    public void eventos(MouseEvent me){
        
    }
    
    public void eventos(KeyEvent ke){
    
    }
    
    public void actualizar(){
    
    
    }
    
}
