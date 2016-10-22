package tankattack.clases;

import java.awt.Color;
import java.awt.Graphics2D;

public class Escenario {

    /* Objeto contenedor */
    MenuPrincipal menuPrincipal;
    
    /* Objetos involucrados */
    Tablero tablero = new Tablero(this);
    Marcador marcador = new Marcador(this);
    
    public Escenario(MenuPrincipal m){
        
        menuPrincipal = m;
        
    }
    
    public void paint(Graphics2D g){
    
        menuPrincipal.pantallaDePresentacion.fondo.paint(g);  // Pintar fondo
        marcador.paint(g);  // Pintar marcador
        tablero.paint(g);  // Pintar tablero
    
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
