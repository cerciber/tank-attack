package tankattack.clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Marcador {
    
    /* Objeto contenedor */
    Escenario escenario;
    
    int x = 10;
    int y = 10;
    int w = 800 - 20;
    int h = 100 - 20;
    
    Font fuente = new Font ("Helvetica", Font.BOLD, 12);
    
    public Marcador(Escenario e){
        
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
        g.drawString("Jugador 1", x + 30, y + g.getFontMetrics().getAscent() + 30);
        g.drawString("Jugador 2", x + w - 30 - g.getFontMetrics()
                .stringWidth("Jugador 2"), y + g.getFontMetrics().getAscent() + 30);
         
    }
    
}
