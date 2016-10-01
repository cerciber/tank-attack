
package tankattack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class MenuPrincipal  {
    
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
    
    
    public void paint(Graphics2D g){
        
        // Pintar fondo
        g.setColor (Color.BLACK);
        g.fillRect(0, 0, ancho, alto);
        
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
