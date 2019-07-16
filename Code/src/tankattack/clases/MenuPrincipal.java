package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;

public class MenuPrincipal {
    
    /* Objeto contenedor */
    PantallaDePresentacion pantallaDePresentacion;
    
    /* Objetos involucrados */
    Configuracion configuracion = new Configuracion(this);
    VS2Player vs2Player;
    MaximosPuntajes maximosPuntajes;
    
    /* Cambiar pantalla */
    // 0 = Permanecer
    // 1 = Escenario
    // 2 = Configuracion
    // 3 = Maximos puntajes
    int cambiarPantalla = 0;
    
    /* Subobjetos */
    Objeto textoVS2Player = new Objeto(800/2-300/2, 300-50/2-100, 300, 50, 
            "/tankattack/imagenes/menuPrinicipal/VS2Player.png");
    Objeto textoConfiguracion = new Objeto(800/2-300/2, 300-50/2, 300, 50, 
            "/tankattack/imagenes/menuPrinicipal/Configuracion.png");
    Objeto textoMaxPuntajes = new Objeto(800/2-300/2, 300-50/2+100, 300, 50, 
            "/tankattack/imagenes/menuPrinicipal/MaximosPuntajes.png");
    Objeto volver = new Objeto(0, 600-80, 100, 50, 
            "/tankattack/imagenes/configuracion/img7.png");
    
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
                textoMaxPuntajes.paint(g);
                volver.paint(g);
                break;
            case 1:
                vs2Player.paint(g);
                break;
            case 2:
                configuracion.paint(g);
                break;
            case 3:
                maximosPuntajes.paint(g);
                break;
        }
        
    }
    
     
    public void eventos(MouseEvent me){
        
        switch(cambiarPantalla){
            case 0:
                if(textoVS2Player.click(me)){
                    configuracion = new Configuracion(this);
                    vs2Player = new VS2Player(this);
                    cambiarPantalla = 1;
                } else if(textoConfiguracion.click(me)){
                    configuracion = new Configuracion(this);
                    cambiarPantalla = 2;
                }else if(textoMaxPuntajes.click(me)){
            
                    maximosPuntajes = new MaximosPuntajes(this);
                    cambiarPantalla = 3;

                }  else if(volver.click(me)){
            
                    pantallaDePresentacion.cambiarPantalla = 0;
                    configuracion.guardarConfiguracion();
                }  
                break;
            case 1:
                vs2Player.eventos(me);
                break;
            case 2:
                configuracion.eventos(me);
                break;
            case 3:
                maximosPuntajes.eventos(me);
                break;
        }
        
    }
    
    public void eventos(KeyEvent ke){
        
        switch(cambiarPantalla){
            case 1:
                vs2Player.eventos(ke);
                break;
            case 2:
                configuracion.eventos(ke);
                break;
            case 3:
                maximosPuntajes.eventos(ke);
                break;
        }
        
    }
    
    public void released(KeyEvent ke){
        
        switch(cambiarPantalla){
            case 1:
                vs2Player.released(ke);
                break;
        }
        
    }
    
    public void actualizar(){
        
        switch(cambiarPantalla){
            case 1:
                vs2Player.actualizar();
                break;
            case 2:
                configuracion.actualizar();
                break;
            case 3:
                maximosPuntajes.actualizar();
                break;
        }
        
    }
    
}
