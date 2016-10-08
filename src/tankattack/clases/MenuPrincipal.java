package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class MenuPrincipal  {
    
    // Clase padre
    GameLoop gameLoop;
    
    // Propiedades de fondo
    Image fondo = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/menuprinicipal/Fondo.jpg"))
            .getImage();
    
    // Propiedades de titulo
    int tituloX = 130;
    int tituloY = 20;
    int tituloW = 550;
    int tituloH = 100;
    Image titulo = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/menuprinicipal/Titulo.png"))
            .getImage();
    
    // Propiedades de Entrar
    int enterX = 325;
    int enterY = 300 - 25;
    int enterW = 150;
    int enterH = 50;
    boolean dibujar = true;
    Image enter = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/menuprinicipal/Enter.png"))
            .getImage();
    
    /* Metodo constructor */
    public MenuPrincipal(GameLoop gameLoop){
        
        /* Asignar clase padre */
        this.gameLoop = gameLoop;
        
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        // Pintar fondo
        g.drawImage (fondo, 0, 0, gameLoop.getWidth(), gameLoop.getHeight(), null);
        
        // Pintar titulo
        g.drawImage (titulo, tituloX, tituloY, tituloW, tituloH, null);
        
        // Pintar Enter
        if (dibujar) g.drawImage (enter, enterX, enterY, enterW, enterH, null);

    }
    
    /* Eventos */
    public void eventos(MouseEvent me){
        
        if(me.getX() >= enterX 
                && me.getX() <= enterX + enterW
                && me.getY() >= enterY 
                && me.getY() <= enterY + enterH) {
            
            dibujar = false;
            
        }
        
    }
    
    public void eventos(KeyEvent ke){
        

        if(ke.getKeyCode() == KeyEvent.VK_ENTER) dibujar = !dibujar;        
        

    }
    
}
