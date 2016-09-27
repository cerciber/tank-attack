/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankattack;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author cesar
 */
public class GameLoop extends JPanel implements Runnable{
    
    int pausaDeTiempo = 1000;
    MenuPrincipal menuPrincipal = new MenuPrincipal(); 
    
    @Override
    public void paint(Graphics g){
        
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        
    }
    
    public void eventos(){
        
        
        
    } 
    
    public void actualizar(){
        
        
        
    }

    public void Esperar() {
    
        try{Thread.sleep(pausaDeTiempo);}
        catch(InterruptedException ex){}
    }
    
    @Override
    public void run() {
        
        eventos();
        
        while(true){
            
            System.out.println("FSDFSD");
            actualizar();
            repaint();
            Esperar();
            
        }
        
    }
    
}
