package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class MenuPrincipal {
    
    /* Objeto contenedor */
    PantallaDePresentacion pantallaDePresentacion;
    
    /* Objetos involucrados */
    Configuracion configuracion = new Configuracion(this);
    
    /* Cambiar pantalla */
    boolean cambiarPantalla = false;
    
    // Propiedades de titulo
    int tituloX;
    int tituloY = 20;
    int tituloW = 500;
    int tituloH = 100;
    
    // Propiedades de item1
    int item1X;
    int item1Y = 300 - 50 / 2 - 50;
    int item1W = 300;
    int item1H = 50;
    Image item1 = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/menuPrinicipal/VS2Player.png"))
            .getImage();
    
    // Propiedades de item2
    int item2X;
    int item2Y = 300 - 50 / 2 + 50;
    int item2W = 300;
    int item2H = 60;
    Image item2 = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/menuPrinicipal/Configuracion.png"))
            .getImage();
    
    public MenuPrincipal(PantallaDePresentacion p){
        
        pantallaDePresentacion = p;
        
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        if(!cambiarPantalla){
            
            // Pintar fondo
            g.drawImage (pantallaDePresentacion.fondo, 0, 0, 
                    pantallaDePresentacion.gameLoop.getWidth(), 
                    pantallaDePresentacion.gameLoop.getHeight(), null);

            // Pintar titulo
            g.drawImage (pantallaDePresentacion.titulo, tituloX, tituloY, tituloW, tituloH, null);

            // Pintar item1
            g.drawImage (item1, 
                    pantallaDePresentacion.gameLoop.getWidth() / 2 - item1W / 2, 
                    item1Y, item1W, item1H, null);

            // Pintar item2
            g.drawImage (item2, 
                    pantallaDePresentacion.gameLoop.getWidth() / 2 - item2W / 2, 
                    item2Y, item2W, item2H, null);
            
        } else {
            
            // Pintar menu principal
            configuracion.paint(g);
            
        }
        
    }
    
    /* Eventos */
    public void eventos(MouseEvent me){
        
        // Entrar a la configuracion
        if(me.getX() >= item2X 
                && me.getX() <= item2X + item2W
                && me.getY() >= item2Y 
                && me.getY() <= item2Y + item2H) {
            
            cambiarPantalla = true;
            
        }
        
    }
    
    public void actualizar(){
        
        // Centrar titulo en x
        tituloX = pantallaDePresentacion.gameLoop.getWidth() / 2 - tituloW / 2;
        
        // Centrar Item1 en x
        item1X = pantallaDePresentacion.gameLoop.getWidth() / 2 - item1W / 2;
        
        // Centrar Item2 en x
        item2X = pantallaDePresentacion.gameLoop.getWidth() / 2 - item2W / 2;
        
    }
    
}
