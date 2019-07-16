package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Muro {
    
    /* Objeto contenedor */
    Tablero tablero;
    
    // tipo de muro
    // 1 : "ladrillo"
    // 2 : "piedra"
    // 3 : "acero"
    // 4 : "suelo"
    // 5 : "agua"
    // 6 : "hollo"
    
    int tipo;
    
    int resistencia;    // Resistencia a las balas
    int impactos = 0;
    int ancho = 50;
    int alto = 50;
     int x;
     int y;
    String Nombre;
    
    /* Subobjetos */
    Objeto muro;
    Objeto[] roto = {null,null,null,null};
    
    public Muro(Tablero t, int x, int y, int tipo){
        
        tablero = t;
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        String nombre = null;
        
        switch(tipo){
            case 1:
                nombre = "ladrillo";
                resistencia = 5;
                break;
            case 2:
                nombre = "piedra";
                resistencia = 10;
                break;
            case 3:
                nombre = "acero";
                resistencia = 20;
                break;
            case 4:
                nombre = "suelo";
                break;
            case 5:
                nombre = "agua";
                break;
            case 6:
                nombre = "hoyo";
                break; 
        }
        
        try{
            muro = new Objeto(x, y, ancho, alto, 
            "/tankattack/imagenes/muro/" + nombre + ".png");
        }catch(NullPointerException e){
            muro = new Objeto(x, y, ancho, alto, 
            "/tankattack/imagenes/muro/" + nombre + ".gif");
        }
        
        roto[0] = new Objeto(x, y, ancho, alto, 
            "/tankattack/imagenes/muro/roto1.png");
        roto[1] = new Objeto(x, y, ancho, alto, 
            "/tankattack/imagenes/muro/roto2.png");
        roto[2] = new Objeto(x, y, ancho, alto, 
            "/tankattack/imagenes/muro/roto3.png");
        roto[3] = new Objeto(x, y, ancho, alto, 
            "/tankattack/imagenes/muro/roto4.png");
        
        this.Nombre = nombre;
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        muro.paint(g);
        if(impactos > resistencia){
            muro = new Objeto(x, y, ancho, alto, 
                "/tankattack/imagenes/muro/suelo.png");
            Nombre = "suelo";
            impactos = 0;
            resistencia = 0;
            tablero.audioMuroRoto.play();
        } else if(impactos > resistencia * 80 / 100){
            roto[3].paint(g);
        }else if(impactos > resistencia * 60 / 100){
            roto[2].paint(g);
        }else if(impactos > resistencia * 40 / 100){
            roto[1].paint(g);
        }else if(impactos > resistencia * 20 / 100){
            roto[0].paint(g);
        }

    }
    
    public int getx(){
        return x;
    }
    public  int gety(){
        return y;
    }
    public  String getname(){
        return Nombre;
    }
    
    public void eventos(MouseEvent me){
        
    }
    
    public void eventos(KeyEvent ke){
    
    }
    
    public void actualizar(){
    
    }
    
}
