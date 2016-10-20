package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class Configuracion {
    
    /* Objeto contenedor */
    MenuPrincipal menuPrincipal;
    
    /* Cambiar pantalla */
    boolean cambiarPantalla = false;
    
    /* Subobjetos */
    Objeto titulo = new Objeto(800/2-500/2, 20, 500, 100, 
            "/tankattack/imagenes/configuracion/img1.png");
    Objeto textoNDisparos = new Objeto(800/2-350, 600/2-50/2-100, 350, 50, 
            "/tankattack/imagenes/configuracion/img2.png");
    Objeto flechaNDisparosIzq = new Objeto(800/2+100, 600/2-50/2-100, 50, 50, 
            "/tankattack/imagenes/configuracion/img5.png");
    Objeto flechaNDisparosDer = new Objeto(800/2+200, 600/2-50/2-100, 50, 50, 
            "/tankattack/imagenes/configuracion/img6.png");
    Objeto textoNBanderas = new Objeto(800/2-350, 600/2-50/2, 350, 50, 
            "/tankattack/imagenes/configuracion/img3.png");
    Objeto flechaNBanderasIzq = new Objeto(800/2+100, 600/2-50/2, 50, 50, 
            "/tankattack/imagenes/configuracion/img5.png");
    Objeto flechaNBanderasDer = new Objeto(800/2+200, 600/2-50/2, 50, 50, 
            "/tankattack/imagenes/configuracion/img6.png");
    Objeto textoTiempoDePartida = new Objeto(800/2-350, 600/2-50/2+100, 350, 50, 
            "/tankattack/imagenes/configuracion/img4.png");
    Objeto flechaTiempoDePartidaIzq = new Objeto(800/2+100, 600/2-50/2+100, 50, 50, 
            "/tankattack/imagenes/configuracion/img5.png");
    Objeto flechaTiempoDePartidaDer = new Objeto(800/2+200, 600/2-50/2+100, 50, 50, 
            "/tankattack/imagenes/configuracion/img6.png");
    Objeto volver = new Objeto(0, 600-80, 100, 50, 
            "/tankattack/imagenes/configuracion/img7.png");
    
    public Configuracion(MenuPrincipal m){
        
        menuPrincipal = m;
        
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        menuPrincipal.pantallaDePresentacion.fondo.paint(g);  // Pintar fondo
        titulo.paint(g);  // Pintar titulo
        textoNDisparos.paint(g);  // Pintar texto de disparos
        flechaNDisparosIzq.paint(g);  // Pintar flecha izquierda disparos
        flechaNDisparosDer.paint(g);  // Pintar flecha derecha disparos
        textoNBanderas.paint(g);  // Pintar numero de banderas
        flechaNBanderasIzq.paint(g);  // Pintar flecha izquierda numero de banderas
        flechaNBanderasDer.paint(g);  // Pintar flecha derecha numero de banderas
        textoTiempoDePartida.paint(g);  // Pintar Tiempo De Partida
        flechaTiempoDePartidaIzq.paint(g);  // Pintar flecha izquierda Tiempo De Partida
        flechaTiempoDePartidaDer.paint(g);  // Pintar flecha derecha Tiempo De Partida
        volver.paint(g);  // Pintar boton volver
        
    }
    
    public void eventos(MouseEvent me){
        
        if(volver.click(me)){
            
            menuPrincipal.cambiarPantalla = 0;
            
        }  
        
    }
    
    public void actualizar(){
        
    }
    
}
