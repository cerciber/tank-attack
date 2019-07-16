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
    static int highscore1 = 0;
    static int highscore2 = 0;
    String Jugador1 = "Jugador 1";
    String Jugador2 = "Jugador 2";
   
    /* Fuente texto */
    Font fuente = new Font ("Helvetica", Font.BOLD, 16);
    
    Objeto marco = new Objeto(x, y , w, h, 
            "/tankattack/imagenes/muro/Marcador.png");
    
    public Marcador(VS2Player e){
        //Ingreso nombre de los jugadores
        
        JOptionPane j = new JOptionPane()
                ;
        Jugador1 = j.showInputDialog(null,"Nombre primer jugador","Jugador 1",JOptionPane.QUESTION_MESSAGE);
        if(Jugador1 == null || "".equals(Jugador1)){
            Jugador1 = "Jugador 1";
        }
        Jugador2 = j.showInputDialog(null,"Nombre segundo jugador","Jugador 2",JOptionPane.QUESTION_MESSAGE);
        if(Jugador2 == null || "".equals(Jugador2)){
            Jugador2 = "Jugador 2";
        }
        
        escenario = e;
        escenario.menuPrincipal.pantallaDePresentacion.gameLoop.sonidoDeFondo.stop();
        escenario.tablero.audioBatalla.play();
        
    }
    
    public void paint(Graphics2D g){
        
        // pintar marco
        marco.paint(g);
        g.setFont(fuente);
        g.setColor(Color.white);
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
