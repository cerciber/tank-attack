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
    int highscore1 = 0;
    int highscore2 = 0;
    String Jugador1 = "Jugador 1";
    String Jugador2 = "Jugador 2";
   
    /* Fuente texto */
    Font fuente = new Font ("Helvetica", Font.BOLD, 16);
    
    public Marcador(VS2Player e){
        //Ingreso nombre de los jugadores
        Jugador1 = JOptionPane.showInputDialog(null,"Nombre primer jugador");
        if(Jugador1 == null || "".equals(Jugador1)){
            Jugador1 = "Jugador 1";
        }
        Jugador2 = JOptionPane.showInputDialog(null,"Nombre segundo jugador");
        if(Jugador2 == null || "".equals(Jugador2)){
            Jugador2 = "Jugador 2";
        }
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
        g.drawString(Jugador1, x + 30, y + g.getFontMetrics().getAscent() + 20);
        g.drawString (Jugador2, x + w - 20 - g.getFontMetrics()
                .stringWidth(Jugador2), y + g.getFontMetrics().getAscent() + 20);
        g.drawString("Puntos:      "+Puntaje1+"      Highscore:      "+highscore1, x + 30, y + g.getFontMetrics().getAscent() + 40);
        g.drawString ("Puntos:      "+Puntaje2+"      Highscore:      "+highscore2, x + w - 20 - g.getFontMetrics()
                .stringWidth("Puntos:      "+Puntaje2+"      Highscore:      "+highscore2), y + g.getFontMetrics().getAscent() + 40);
         
    }
    
    
    public void eventos(MouseEvent me){
        
    }
    
    public void eventos(KeyEvent ke){
    
    }
    
    public void actualizar(){
        
    
    }
    
}
