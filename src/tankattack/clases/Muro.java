package tankattack.clases;

import java.awt.Graphics2D;

public class Muro {
    
    // tipo de muero
    // 1 : "ladrillo"
    // 2 : "piedra"
    // 3 : "acero"
    // 4 : "agua"
    // 5 : "prensa"
    // 6 : "hollo"
    String tipo;
    
    int resistencia;    // Resistencia a las balas
    boolean traspasableBalas;   // limitacion de balas
    boolean traspasableTanque;  // limitacion de tanque
    boolean estado;  // estado de la prensa (abierto/carrado)
    int ancho = 100;
    int alto = 100;
    
     /* Subobjetos */
    Objeto muro;
    
    public Muro(int x, int y, String tipo){
        
        muro = new Objeto(x, y, ancho, alto, 
            "/tankattack/imagenes/muro/" + tipo + ".png");
        
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        muro.paint(g);

    }
    
}
