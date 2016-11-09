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
    String Jugador1;
    String Jugador2;
   
    /* Fuente texto */
    Font fuente = new Font ("Helvetica", Font.BOLD, 12);
    
    public Marcador(VS2Player e){
        //Ingreso nombre de los jugadores
        Jugador1=JOptionPane.showInputDialog(null,"Nombre primer jugador");
        Jugador2=JOptionPane.showInputDialog(null,"Nombre segundo jugador");
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
        g.drawString(Jugador1+":      "+Puntaje1, x + 30, y + g.getFontMetrics().getAscent() + 30);
        g.drawString (Jugador2+":     "+Puntaje2, x + w - 30 - g.getFontMetrics()
                .stringWidth(Jugador2), y + g.getFontMetrics().getAscent() + 30);
         
    }
    
    
    public void eventos(MouseEvent me){
        
    }
    
    public void eventos(KeyEvent ke){
    
    }
    
    public void puntos(){
        //Actualizacion puntaje
        Puntaje1 = Tanque.Puntaje1;
        Puntaje2 = Tanque.Puntaje2;
    }
    
    public void actualizar(){
        puntos();
    
    }
    
}
