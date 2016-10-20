package tankattack.clases;

import java.awt.Color;
import java.awt.Graphics2D;

public class Escenario {

    /* Objeto contenedor */
    MenuPrincipal menuPrincipal;
    
    public Escenario(MenuPrincipal m){
        
        menuPrincipal = m;
        
    }
    
    public void paint(Graphics2D g){
    
        menuPrincipal.pantallaDePresentacion.fondo.paint(g);  // Pintar fondo
        
        // pintar marco
        g.setColor(Color.BLACK);
        g.fillRect(10, 10, 800 - 20, 100 - 20);
        
        // pintar tablero
        g.setColor(Color.BLACK);
        g.fillRect(10, 10, 800 - 20, 100 - 20);
    
    }
    
//    ArrayList <Bala> ArrayBalas= new ArrayList <> ();
//    
//    public void add (Bala b){
//        ArrayBalas.add(b);
//    }
//    
//     public void undo(){
//        ArrayBalas.remove(ArrayBalas.size() - 1);
//        
//    }
     
    
}
