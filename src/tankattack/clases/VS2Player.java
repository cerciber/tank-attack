package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class VS2Player {

    /* Objeto contenedor */
    MenuPrincipal menuPrincipal;
    
    /* Objetos involucrados */
    Tablero tablero;
    Marcador marcador;
    
    public VS2Player(MenuPrincipal m){
        
        menuPrincipal = m;
        tablero = new Tablero(this);
        marcador = new Marcador(this);
        
    }
    
    public void paint(Graphics2D g){
    
        menuPrincipal.pantallaDePresentacion.fondo.paint(g);  // Pintar fondo
        marcador.paint(g);  // Pintar marcador
        tablero.paint(g);  // Pintar tablero
    
    }
    
    public void eventos(MouseEvent me){
        
        marcador.eventos(me);
        tablero.eventos(me);
        
    }
    
    public void eventos(KeyEvent ke){
        
        marcador.eventos(ke);
        tablero.eventos(ke);
        
    }
    
    public void actualizar(){
        
        marcador.actualizar();
        tablero.actualizar();
        
    }
    
}
