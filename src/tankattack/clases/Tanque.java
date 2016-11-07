
package tankattack.clases;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;

public class Tanque {
    
    /* Objeto contenedor */
    Tablero tablero;
    
    /* Objetos involucrados */
    ArrayList balas;
    
    /* variables globales */
    int y;
    int x;
    
    /* Orientacion del tanque */
    // 1 = arriba
    // 2 = abajo
    // 3 = izquierda
    // 4 = derecha
    int Orientacion = 2;
    
    static int BordeSuperior=90;
    static int BordeInferior=500;
    static int BordeIzquierdo=45;
    static int BordeDerecho=700;
    int SPEEDX;
    int SPEEDY;
    int SPEEDFINAL = 10;
    int REVERSE = 10;
    boolean pressed=false;
    boolean pressed1=false;
    boolean pressed2=false;
    boolean pressed3=true;
    
    //Muro[][] muros = new Muro[15][11];
    //Imagen del tanque hacia arriba
    Image TankUP = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankUP.png")).getImage();
    //Imagen del tanque hacia abajo
    
    Image TankDOWN = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankDOWN.png")).getImage();
    //Imagen del tanque hacia la izquierda
    Image TankLEFT = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankLEFT.png")).getImage();
    //Imagen del tanque hacia la derecha
    Image TankRIGHT = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankRIGHT.png")).getImage();
    
        
    Image Dibujo = TankDOWN;
    
    int jugador;
   
    public Tanque(Tablero t, int x, int y, int j) {
        
       balas = new ArrayList();
       tablero = t;
       this.x = x;
       this.y = y;
       jugador = j;
       
    }
    
    public void paint(Graphics2D g) {
        
        g.drawImage(Dibujo, x, y, 50, 50, null);
        //g.drawRect(rectanglePlayer, y, y, y);
        // Pintar Array de balas a demanda
        for(int i = 0; i < balas.size(); i++) {
            Bala b = (Bala) balas.get(i);
            //dependiendo del punto al que mire el tanque dibuja la bala en la punta del cañon
            if(b.getdir()==1)g.drawImage(b.getImage(), b.getX()+16, b.getY()-15,20,20, null);
            if(b.getdir()==2)g.drawImage(b.getImage(), b.getX()+16, b.getY()+45,20,20, null);
            if(b.getdir()==3)g.drawImage(b.getImage(), b.getX()-15, b.getY()+15,20,20, null);
            if(b.getdir()==4)g.drawImage(b.getImage(), b.getX()+45, b.getY()+10,20,20, null);
        }
        
    }
    
    public void eventos(MouseEvent me){
        
    }
    public void mov(){
        y+= SPEEDY;
        x+=SPEEDX;
    }
    public void stop(){
        SPEEDFINAL=0;
        System.out.println("stop");
    }
    int auxy;
    int auxx;
    boolean v;
    public void update(){
        
            Rectangle rectanglePlayer = getBounds(Orientacion);
            //mov();
            System.out.print("x="+x);
            System.out.println("    y="+y);
            for(int i = 0; i <= 13; i++){
                for(int j = 0; j <= 9; j++){
//                   
                       if (rectanglePlayer.intersects(Tablero.muros[i][j].getx(),Tablero.muros[i][j].gety(), 50, 50)&&Tablero.muros[i][j].getname().equals("agua")){
                            System.out.println("tocando "+Tablero.muros[i][j].getname());
                            //stop();
                            //v=false;
                            
                            switch(Orientacion){
                                case 1:
                                    System.out.println("Obstaculo arriba ");
                                   abajo();
                                   //y += REVERSE;
                                    //moveDOWN(REVERSE);
                                   //moveDOWN();
                                break;
                                case 2:
                                    System.out.println("Obstaculo abajo");
                                    arriba();
                                    //y += -REVERSE;
                                    //moveUP(REVERSE);
                                    //moveUP();
                                break;
                                case 3:
                                    System.out.println("Obstaculo a la izquierda");
                                   //x += REVERSE;//SPEEDFINAL;
                                  derecha();
                                    //moveRIGHT();
                                break;
                                case 4:
                                    System.out.println("Obstaculo a la derecha");
                                    //x += -REVERSE;//SPEEDFINAL;
                                    izquierda();
                                   // moveLEFT();
                                break;
                            }
                            
                            //break;
                            //System.out.println("no leido");
                        }
                       
                       else{v=true;}
                }
                
            }
            if(v){
                 
            } //else{break;}
            mov();
    }
    
    public Rectangle getBounds(int i) {
        switch (i){
            case 1:
                return new Rectangle(x, y-10, 50, 60);
            
            case 2:
                return new Rectangle(x, y, 50, 60);
                
            case 3:
                return new Rectangle(x-10, y, 60, 50);
                
            case 4:
                return new Rectangle(x, y, 60, 50);
            
                    
            default: return new Rectangle(x, y, 50, 50);
        }
        
    }
    
    public void derecha(){
        x += REVERSE;
    }
     public void izquierda(){
        x += -REVERSE;
    }
      public void abajo(){
        y += REVERSE;
    }
       public void arriba(){
        y += -REVERSE;
    }
    
    public void moveUP() {
            SPEEDX = 0;
            SPEEDY = -SPEEDFINAL;
    }

    public void moveDOWN() {
            SPEEDX = 0;
            SPEEDY = SPEEDFINAL;
    }

    public void moveLEFT() {
            SPEEDX = -SPEEDFINAL;
            SPEEDY = 0;
    }

    public void moveRIGHT() {
            SPEEDX = SPEEDFINAL;
            SPEEDY = 0;
    }
    
    
    public void eventos(KeyEvent ke){
        
        if(jugador == 1){
     
            switch(ke.getKeyCode()) {
                case  KeyEvent.VK_UP:
                    if(y>BordeSuperior){
                             //y=y-pasos;
                    }      
                            pressed1=true;
                            
                            Dibujo=TankUP;
                            Orientacion=1;
                           moveUP();
                    

                break;
                case  KeyEvent.VK_DOWN:
                    if(y<BordeInferior){
                            //y=y+pasos;
                    }      
                            pressed1=true;
                            
                            Dibujo=TankDOWN;
                            Orientacion=2;
                            moveDOWN();
                    
                break;
                case  KeyEvent.VK_LEFT:
                    if(x>BordeIzquierdo){
                            //x=x-pasos;
                    }        
                            pressed1=true;
                            
                            Dibujo=TankLEFT;    
                            Orientacion=3;
                           moveLEFT();
                    

                break;
                case  KeyEvent.VK_RIGHT:
                    if(x<BordeDerecho){
                            //x=x+pasos;
                    }
                            pressed1=true;
                            
                            Dibujo=TankRIGHT;
                            Orientacion=4;
                           moveRIGHT();
                    

                break;
            }
           // switch(ke.getKeyCode()) {
                    if( ke.getKeyCode()==KeyEvent.VK_NUMPAD0&&pressed){
                    balas.add(new Bala(this, x, y, Orientacion));               
               // break;
                    pressed=false;
                    
                    }
            //}   
            
        } else {
            
            switch(ke.getKeyCode()) {
                case  KeyEvent.VK_W:
                    if(y>BordeSuperior){}
                            //y=y-pasos;
                            pressed2=true;
                            Dibujo=TankUP;
                            Orientacion=1;
                             moveUP();
                    

                break;
                case  KeyEvent.VK_S:
                    if(y<BordeInferior){}
                            //y=y+pasos;
                            pressed2=true;
                            Dibujo=TankDOWN;
                            Orientacion=2;
                            moveDOWN();
                    

                break;
                case  KeyEvent.VK_A:
                    if(x>BordeIzquierdo){}
                            //x=x-pasos;
                            pressed2=true;
                            Dibujo=TankLEFT;    
                            Orientacion=3;
                            moveLEFT();
                    

                break;
                case  KeyEvent.VK_D:
                    if(x<BordeDerecho){}
                            //x=x+pasos;}
                            pressed2=true;
                            Dibujo=TankRIGHT;
                            Orientacion=4;
                            moveRIGHT();
                    

                break;
            }
            if( ke.getKeyCode()==KeyEvent.VK_G&&pressed){
                    balas.add(new Bala(this, x, y, Orientacion));               
               // break;
                    pressed=false;
                    
                    }
            
        }
        
    }
    
    public void released(KeyEvent ke){
        int key = ke.getKeyCode();

      
      if(key == KeyEvent.VK_NUMPAD0){
          pressed = true;}
      if(key == KeyEvent.VK_G){
          pressed = true;}
      
      switch(ke.getKeyCode()) {
                case  KeyEvent.VK_UP:
                    pressed1=false;    
                break;
                case  KeyEvent.VK_DOWN:
                    pressed1=false; 
                break;
                case  KeyEvent.VK_LEFT:
                    pressed1=false; 
                break;
                case  KeyEvent.VK_RIGHT:
                    pressed1=false; 
                break;     
                case  KeyEvent.VK_W:
                    pressed2=false;                    
                break;
                case  KeyEvent.VK_S:
                    pressed2=false;                  
                break;
                case  KeyEvent.VK_A:
                    pressed2=false; 
                break;
                case  KeyEvent.VK_D:
                    pressed2=false; 
                break;
                //default: pressed2=true;
      }
        
       
    }
    
    public void actualizar(){
            //v=true;
            if(pressed1){update();
        }   
            else if(pressed2){update();
        }
        
        for(int j = 0; j < balas.size(); j++){
            Bala b = (Bala) balas.get(j);
            if(b.isVisible()){
                b.update();
            }
            else
                balas.remove(j);
        }
    }
    
}