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
    
    int pausaDeTiempo = 10;
    
    JFrame frame= new JFrame();
    MenuPrincipal menuPrincipal = new MenuPrincipal(); 
    
    public GameLoop(){
        
        frame.setTitle("Tank Attack");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(this);
        
    }
    
    @Override
    public void addNotify(){
        
        super.addNotify();
        new Thread(this);
        
    }
    
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
            
            actualizar();
            repaint();
            
            try{Thread.sleep(1000);}
            catch(InterruptedException ex){}
            
        }
        
    }
    
}
