package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class PantallaDePresentacion {
    
    /* Objeto contenedor */
    GameLoop gameLoop;
    
    /* Objetos involucrados */
    MenuPrincipal menuPrincipal = new MenuPrincipal(this);
    
    /* Cambiar pantalla */
    boolean cambiarPantalla = false;
    
    // Propiedades de fondo
    Image fondo = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/pantallaDePresentacion/Fondo.jpg"))
            .getImage();
    
    // Propiedades de titulo
    int tituloX;
    int tituloY = 20;
    int tituloW = 500;
    int tituloH = 100;
    Image titulo = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/pantallaDePresentacion/Titulo.png"))
            .getImage();
    
    // Propiedades de Entrar
    int enterX;
    int enterY;
    int enterW = 150;
    int enterH = 50;
    Image enter = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/pantallaDePresentacion/Enter.png"))
            .getImage();
    
    /* Metodo constructor */
    public PantallaDePresentacion(GameLoop gameLoop){
        
        /* Asignar clase padre */
        this.gameLoop = gameLoop;
        
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        if(!cambiarPantalla){
            
            // Pintar fondo
            g.drawImage (fondo, 0, 0, gameLoop.getWidth(), gameLoop.getHeight(), null);

            // Pintar titulo
            g.drawImage (titulo, tituloX, tituloY, tituloW, tituloH, null);

            // Pintar Enter
            g.drawImage (enter, enterX, enterY, enterW, enterH, null);
            
        } else {
            
            // Pintar menu principal
            menuPrincipal.paint(g);
            
        }

    }
    
    /* Eventos */
    public void eventos(MouseEvent me){
        
        if(!cambiarPantalla){
            
            // Entrar al menu principal
            if(me.getX() >= enterX 
                    && me.getX() <= enterX + enterW
                    && me.getY() >= enterY 
                    && me.getY() <= enterY + enterH) {

                cambiarPantalla = true;

            }
            
        } else {
            
            menuPrincipal.eventos(me);
            
        }
        
    }
    
    public void eventos(KeyEvent ke){
        
        // Entrar al menu principal
        if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
            
            cambiarPantalla = true;
            
        }        

    }
    
    public void actualizar(){
        
        // Centrar titulo en x
        tituloX = gameLoop.getWidth() / 2 - tituloW / 2;
        
        // Centrar Enter en x
        enterX = gameLoop.getWidth() / 2 - enterW / 2;
        
        // Centrar Enter en y
        enterY = gameLoop.getHeight() / 2 - enterH / 2;
        
        // Actualizar menu principal
        menuPrincipal.actualizar();
        
    }
    
}
