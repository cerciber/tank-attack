
package tankattack.clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class MenuPrincipal  {
    
    // Clase padre
    GameLoop gameLoop;
    
    // Propiedades de fondo
    int ancho = 800;
    int alto = 600;    
    
    // Propiedades texto
    String familia = "Calibri";
    int tipoDeLetra = Font.BOLD;
    
    // Propiedades de titulo
    int tituloX = 165;
    int tituloY = 185;
    int tituloTamano = 80;
    
    // Propiedades de Entrar
    int entrarX = 220;
    int entrarY = 300;
    int entrarTamano = 60;
    
    // Imagen de fondo
    Image fondo = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/menuprinicipal/Fondo.jpg"))
            .getImage();
    
    /* Metodo constructor */
    public MenuPrincipal(GameLoop gameLoop){
        
        /* Asignar clase padre */
        this.gameLoop = gameLoop;
        
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        // Pintar fondo
        g.drawImage (fondo, 0, 0, ancho, alto, null);
        
        // Pintar titulo
        g.setColor(Color.WHITE);
        g.setFont(new Font(familia, tipoDeLetra, tituloTamano));
        g.drawString("TANK ATTACK", tituloX, tituloY);
        
        // Pintar Entrar
        g.setColor(Color.WHITE);
        g.setFont(new Font(familia, tipoDeLetra, entrarTamano));
        g.drawString("Presiona Enter", entrarX, entrarY);
        
    }
    
}
