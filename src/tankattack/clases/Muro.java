package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Muro {
    
    /* Objeto contenedor */
    Tablero tablero;
    
    // tipo de muero
    // 1 : "ladrillo"
    // 2 : "piedra"
    // 3 : "acero"
    // 4 : "agua"
    // 5 : "hollo"
    // 6 : "suelo"
    int tipo;
    
    int resistencia;    // Resistencia a las balas
    boolean traspasableBalas;   // limitacion de balas
    boolean traspasableTanque;  // limitacion de tanque
    boolean estado;  // estado de la prensa (abierto/carrado)
    int ancho = 50;
    int alto = 50;
    
     /* Subobjetos */
    Objeto muro;
    
    public Muro(Tablero t, int x, int y, int tipo){
        
        tablero = t;
        
        String nombre = null;
        
        switch(tipo){
            case 1:
                nombre = "ladrillo";
                break;
            case 2:
                nombre = "piedra";
                break;
            case 3:
                nombre = "acero";
                break;
            case 4:
                nombre = "agua";
                break;
            case 5:
                nombre = "hollo";
                break;
            case 6:
                nombre = "suelo";
                break;
        }
        
        muro = new Objeto(x, y, ancho, alto, 
            "/tankattack/imagenes/muro/" + nombre + ".png");
        
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        muro.paint(g);

    }
    
    public void eventos(MouseEvent me){
        
    }
    
    public void eventos(KeyEvent ke){
    
    }
    
    public void actualizar(){
    
    }
    
}
