package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class MenuPrincipal {
    
    /* Objeto contenedor */
    PantallaDePresentacion pantallaDePresentacion;
    
    /* Objetos involucrados */
    Configuracion configuracion = new Configuracion(this);
    Escenario escenario = new Escenario(this);
    
    /* Cambiar pantalla */
    // 0 = Permanecer
    // 1 = Escenario
    // 2 = Configuracion
    int cambiarPantalla = 0;
    
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
        
        switch(cambiarPantalla){
            case 0:
                pantallaDePresentacion.fondo.paint(g);  // Pintar fondo
                pantallaDePresentacion.titulo.paint(g);  // Pintar titulo
                textoVS2Player.paint(g);  // Pintar texto VS 2 Player
                textoConfiguracion.paint(g);  // Pintar texto Configuracion
                break;
            case 1:
                escenario.paint(g);
                break;
            case 2:
                configuracion.paint(g);
                break;
        }
        
    }
    
    public void eventos(MouseEvent me){
        
        switch(cambiarPantalla){
            case 0:
                if(textoVS2Player.click(me)){
                    cambiarPantalla = 1;
                } else if(textoConfiguracion.click(me)){
                    cambiarPantalla = 2;
                }
                break;
            case 1:
                //escenario.eventos(me);
                break;
            case 2:
                configuracion.eventos(me);
                break;
        }
        
    }
    
    public void eventos(KeyEvent ke){
        
    }
    
    public void actualizar(){
        
        switch(cambiarPantalla){
            case 1:
                //escenario.actualizar();
                break;
            case 2:
                configuracion.actualizar();
                break;
        }
        
    }
    
}
