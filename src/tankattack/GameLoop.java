package tankattack;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GameLoop extends JPanel implements Runnable{
    
    int pausaDeTiempo = 1000;   
    MenuPrincipal menuPrincipal = new MenuPrincipal(); 
    
    // Metodo para pintar elementos en pantalla
    @Override
    public void paint(Graphics g){
        
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        
    }
    
    // Metodo para gestionar acciones del mouse y el teclado
    public void eventos(){
        
        
        
    } 
    
    // Metodo para actualizarlos datos del juego
    public void actualizar(){
        
        
        
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
