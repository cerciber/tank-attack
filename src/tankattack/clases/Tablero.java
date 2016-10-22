package tankattack.clases;

import java.awt.Color;
import java.awt.Graphics2D;

public final class Tablero {
    
    /* Objeto contenedor */
    Escenario escenario;
    
    int x = 50;
    int y = 90;
    int w = 700;
    int h = 500;
    
    /* Objetos involucrados */
    Base base1 = new Base(this, x + 50, y + 50); 
    Base base2 = new Base(this, x + 600, y + 400); 
    Bandera bandera1 = new Bandera(this, x + 60, y + 60); 
    Bandera bandera2 = new Bandera(this,  x + 610, y + 410);
    
    Muro[][] muro = new Muro[14][10];
    
    public Tablero(Escenario e){
        
        escenario = e;
        asignarMuros();
        
    }
    
    public void paint(Graphics2D g){
        
        g.setColor(Color.WHITE);
        g.fillRect(x, y, w, h);
        g.setColor(Color.RED);
        
        for(int i = x; i <= x + w; i += 50){
            
            g.drawLine(i, y, i, y + h);
            
        }
        
        for(int i = y; i <= y + h; i += 50){
            
            g.drawLine(x, i, x + w, i);
            
        }
        
                
        for(int i = 0, px = x; i <= 13; i++, px += 50){
            for(int j = 0, py = y; j <= 9; j++, py +=50){

                muro[i][j].paint(g);
                
            }
        }
        
        base1.paint(g);
        base2.paint(g);
        bandera1.paint(g);
        bandera2.paint(g);
        //muro.paint(g);


    }
    
    public void asignarMuros(){
        
        for(int i = 0, px = x; i <= 13; i++, px += 50){
            for(int j = 0, py = y; j <= 9; j++, py +=50){

                muro[i][j] = new Muro(this, px, py, (int) (Math.random()*(1-6)+6));
                
            }
        }
        
    }
}
