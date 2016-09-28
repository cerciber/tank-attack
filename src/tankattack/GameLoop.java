package tankattack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GameLoop extends JPanel implements Runnable{
    
    int pausaDeTiempo = 1;   
    MenuPrincipal menuPrincipal = new MenuPrincipal(); 
    
    int x = 0,y = 0;
    boolean dirX = true, dirY = true;
    
    // Metodo para pintar elementos en pantalla
    @Override
    public void paint(Graphics g){
        
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g.setColor (Color.BLACK);
        g.fillRect (0, 0, 800, 600);
        g.setColor (Color.yellow);
        g.fillOval (x, y, 200, 200);
    }
    
    // Metodo para gestionar acciones del mouse y el teclado
    public void eventos(){
        
        
        
    } 
    
    // Metodo para actualizarlos datos del juego
    public void actualizar(){
        
        if(x < 0){dirX = true;}
        if(y < 0){dirY = true;}
        if(x > 600){dirX = false;}
        if(y > 400){dirY = false;}
        if(dirX){x++;}else{x--;}
        if(dirY){y++;}else{y--;}
        
        
    }

    // Metodo para pausar el hilo por un lapso de tiempo determinado
    public void Esperar() {
    
        try{Thread.sleep(pausaDeTiempo);}
        catch(InterruptedException ex){}
    }
    
    // Metodo para ejecutar los metodos anteriores indefinidamente
    @Override
    public void run() {
        
        eventos();
        
        while(true){
            
            actualizar();
            repaint();
            Esperar();
            
        }
        
    }
    
}
