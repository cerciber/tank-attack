package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Configuracion {
    
    /* Objeto contenedor */
    MenuPrincipal menuPrincipal;
    
    /* Subobjetos */
    Objeto titulo = new Objeto(800/2-500/2, 20, 500, 100, 
            "/tankattack/imagenes/configuracion/img1.png");
    Objeto textoNDisparos = new Objeto(800/2-350, 600/2-50/2-100, 350, 50, 
            "/tankattack/imagenes/configuracion/img2.png");
    Objeto textoNBanderas = new Objeto(800/2-350, 600/2-50/2, 350, 50, 
            "/tankattack/imagenes/configuracion/img3.png");
    Objeto textoTiempoDePartida = new Objeto(800/2-350, 600/2-50/2+100, 350, 50, 
            "/tankattack/imagenes/configuracion/img4.png");
    
    public Configuracion(MenuPrincipal m){
        
        menuPrincipal = m;
        
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        menuPrincipal.pantallaDePresentacion.fondo.paint(g);  // Pintar fondo
        titulo.paint(g);  // Pintar titulo
        textoNDisparos.paint(g);  // Pintar numero de disparos
        textoNBanderas.paint(g);  // Pintar numero de banderas
        textoTiempoDePartida.paint(g);  // Pintar Tiempo De Partida
        
    }
    
    public void eventos(MouseEvent me){
        
    }
    
    public void actualizar(){
        
    }
    
}
