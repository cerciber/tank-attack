package tankattack.clases;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public final class Tablero {
    
    /* Objeto contenedor */
    VS2Player escenario;
    
    /* variables globales */
    int x = 50;
    int y = 90;
    int w = 700;
    int h = 500;
    
    /* Objetos involucrados */
    Base base1; 
    Base base2; 
    Bandera bandera1; 
    Bandera bandera2;
    Tanque tanque1;
    Tanque tanque2;
    Muro[][] muros;
    
    public Tablero(VS2Player e){
        
        escenario = e;
        base1 = new Base(this, x + 50, y + 50); 
        base2 = new Base(this, x + 600, y + 400); 
        bandera1 = new Bandera(this, x + 60, y + 60); 
        bandera2 = new Bandera(this,  x + 610, y + 410);
        tanque1 = new Tanque(this, 1);
        tanque2 = new Tanque(this, 2);
        muros = new Muro[14][10];
        asignarMuros(muros);
        
    }
    
    public void paint(Graphics2D g){
        
        // Pintar fondo blanco
        g.setColor(Color.WHITE);
        g.fillRect(x, y, w, h);
        
        /* Pintar matriz roja  */
        g.setColor(Color.RED);
        for(int i = x; i <= x + w; i += 50){
            g.drawLine(i, y, i, y + h);
        }
        for(int i = y; i <= y + h; i += 50){
            g.drawLine(x, i, x + w, i);
        }
                
        /* pintar muros */
        for(int i = 0; i <= 13; i++){
            for(int j = 0; j <= 9; j++){

                muros[i][j].paint(g);
                
            }
        }
        
        base1.paint(g);
        base2.paint(g);
        tanque1.paint(g);
        tanque2.paint(g);
        bandera1.paint(g);
        bandera2.paint(g);

    }
    
    public void eventos(MouseEvent me){
        
        /* eventos muros */
        for(int i = 0; i <= 13; i++){
            for(int j = 0; j <= 9; j++){

                muros[i][j].eventos(me);
                
            }
        }
        
        base1.eventos(me);
        base2.eventos(me);
        tanque1.eventos(me);
        tanque2.eventos(me);
        bandera1.eventos(me);
        bandera2.eventos(me);
        
    }
    
    public void eventos(KeyEvent ke){
    
        /* eventos muros */
        for(int i = 0; i <= 13; i++){
            for(int j = 0; j <= 9; j++){

                muros[i][j].eventos(ke);
                
            }
        }
        
        base1.eventos(ke);
        base2.eventos(ke);
        tanque1.eventos(ke);
        tanque2.eventos(ke);
        bandera1.eventos(ke);
        bandera2.eventos(ke);
        
    }
    
    public void actualizar(){
    
        /* actualizacion muros */
        for(int i = 0; i <= 13; i++){
            for(int j = 0; j <= 9; j++){

                muros[i][j].actualizar();
                
            }
        }
        
        base1.actualizar();
        base2.actualizar();
        tanque1.actualizar();
        tanque2.actualizar();
        bandera1.actualizar();
        bandera2.actualizar();
        
    }
    
    public void asignarMuros(Muro[][] muros){
        
        for(int i = 0, px = x; i <= 13; i++, px += 50){
            for(int j = 0, py = y; j <= 9; j++, py +=50){

                if(i == 1 && j == 1){
                    muros[i][j] = new Muro(this, px, py, 6);
                } else if (i == 12 && j == 8){
                    muros[i][j] = new Muro(this, px, py, 6);
                }else{
                    muros[i][j] = new Muro(this, px, py, (int) (Math.random()*(1-7)+7));
                }
            }
        }
        
    }
    
}
