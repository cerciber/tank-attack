package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PantallaDePresentacion {
    
    /* Objeto contenedor */
    GameLoop gameLoop;
    
    /* Objetos involucrados */
    MenuPrincipal menuPrincipal;
    
    /* Cambiar pantalla */
    int cambiarPantalla = 0;
    
    /* Subobjetos */
    Objeto fondo = new Objeto(0, 0, 800, 600, 
            "/tankattack/imagenes/pantallaDePresentacion/Fondo.jpg");
    Objeto titulo = new Objeto(800/2-500/2, 20, 500, 100, 
            "/tankattack/imagenes/pantallaDePresentacion/Titulo.png");
    Objeto enter = new Objeto(800/2-150/2, 600/2-50/2, 150, 50, 
            "/tankattack/imagenes/pantallaDePresentacion/Enter.png");
    
    /* Metodo constructor */
    public PantallaDePresentacion(GameLoop gameLoop){
        
        this.gameLoop = gameLoop;
        
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        switch(cambiarPantalla){
            case 0:
                fondo.paint(g);  // Pintar fondo
                titulo.paint(g);  // Pintar titulo
                enter.paint(g);  // Pintar Enter
                break;
            case 1:
                menuPrincipal.paint(g);  // Pintar menu principal
                break;
        }

    }
    
    public void eventos(MouseEvent me){
        
        switch(cambiarPantalla){
            case 0:
                if(enter.click(me)) {
                    menuPrincipal = new MenuPrincipal(this);
                    cambiarPantalla = 1;
                }
                break;
            case 1:
                menuPrincipal.eventos(me);
                break;
        }
        
    }
    
    public void eventos(KeyEvent ke){
        
        switch(cambiarPantalla){
            case 0:
                if(enter.enter(ke)) {
                    menuPrincipal = new MenuPrincipal(this);
                    cambiarPantalla = 1;
                }
                break;
            case 1:
                menuPrincipal.eventos(ke);
                break;
        }

    }
    
    public void actualizar(){
        
        switch(cambiarPantalla){
            case 1:
                menuPrincipal.actualizar();
                break;
        }
        
    }
    
}
