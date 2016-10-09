package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class MenuPrincipal {
    
    /* Objeto contenedor */
    PantallaDePresentacion pantallaDePresentacion;
    
    /* Objetos involucrados */
    Configuracion configuracion = new Configuracion(this);
    
    /* Cambiar pantalla */
    boolean cambiarPantalla = false;
    
    /* Subobjetos */
    Objeto textoVS2Player = new Objeto(800/2-300/2, 300-50/2-50, 300, 50, 
            "/tankattack/imagenes/menuPrinicipal/VS2Player.png");
    Objeto textoConfiguracion = new Objeto(800/2-300/2, 300-50/2+50, 300, 50, 
            "/tankattack/imagenes/menuPrinicipal/Configuracion.png");
    
    public MenuPrincipal(PantallaDePresentacion p){
        
        pantallaDePresentacion = p;
        
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        if(cambiarPantalla){
            
            configuracion.paint(g);
            
        } else {
            
            pantallaDePresentacion.fondo.paint(g);  // Pintar fondo
            pantallaDePresentacion.titulo.paint(g);  // Pintar titulo
            textoVS2Player.paint(g);  // Pintar texto VS 2 Player
            textoConfiguracion.paint(g);  // Pintar texto Configuracion
            
        }
        
    }
    
    public void eventos(MouseEvent me){
        
        if(cambiarPantalla){
            
            configuracion.eventos(me);
            
        } else if(textoConfiguracion.click(me)){

            cambiarPantalla = true;
            
        }
        
    }
    
    public void eventos(KeyEvent ke){
        
    }
    
    public void actualizar(){
        
        if(cambiarPantalla){
            
            configuracion.actualizar();
            
        }
        
    }
    
}
