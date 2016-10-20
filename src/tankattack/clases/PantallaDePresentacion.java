package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PantallaDePresentacion {
    
    /* Objeto contenedor */
    GameLoop gameLoop;
    
    /* Objetos involucrados */
    MenuPrincipal menuPrincipal = new MenuPrincipal(this);
    Muro muro = new Muro(100, 100, "agua");
    
    /* Cambiar pantalla */
    boolean cambiarPantalla = false;
    
    /* Subobjetos */
    Objeto fondo = new Objeto(0, 0, 800, 600, 
            "/tankattack/imagenes/pantallaDePresentacion/Fondo.jpg");
    Objeto titulo = new Objeto(800/2-500/2, 20, 500, 100, 
            "/tankattack/imagenes/pantallaDePresentacion/Titulo.png");
    Objeto enter = new Objeto(800/2-150/2, 600/2-50/2, 150, 50, 
            "/tankattack/imagenes/pantallaDePresentacion/Enter.png");
    
    /* Metodo constructor */
    public PantallaDePresentacion(GameLoop gameLoop){
        
        /* Asignar clase padre */
        this.gameLoop = gameLoop;
        
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        if(cambiarPantalla){
            
            menuPrincipal.paint(g);  // Pintar menu principal
            
        } else {
            
            fondo.paint(g);  // Pintar fondo
            titulo.paint(g);  // Pintar titulo
            enter.paint(g);  // Pintar Enter
            
        }
        muro.paint(g);

    }
    
    public void eventos(MouseEvent me){
        
        if(cambiarPantalla){
            
            menuPrincipal.eventos(me);
            
        } else if(enter.click(me)){

            cambiarPantalla = true;
            
        }
        
    }
    
    public void eventos(KeyEvent ke){
        
        if(cambiarPantalla){
            
            menuPrincipal.eventos(ke);
            
        } else if(enter.enter(ke)){

            cambiarPantalla = true;
            
        }   

    }
    
    public void actualizar(){
        
        if(cambiarPantalla){
            
            menuPrincipal.actualizar();
            
        } 
        
    }
    
}
