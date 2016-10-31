
package tankattack.clases;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
    
    static int BordeSuperior=0;
    static int BordeInferior=520;
    static int BordeIzquierdo=0;
    static int BordeDerecho=750;
    int SPEEDX;
    int SPEEDY;
    int SPEEDFINAL = 10;
    boolean pressed=true;
    boolean pressed1=true;
    boolean pressed2=true;
    boolean pressed3=true;
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
    int auxy;
    int auxx;
    public void update(){
        //aux=choice();
//        if(y>Tanque.BordeInferior||y<Tanque.BordeSuperior||x>Tanque.BordeDerecho||x<Tanque.BordeIzquierdo) {
//          
//        
//         if(y>Tanque.BordeInferior){
//            SPEEDY=0;
//            
//        }
//         else if(y<Tanque.BordeSuperior){
//           SPEEDY=0;
//           
//        }
//        else if(x>Tanque.BordeDerecho){
//           
//           SPEEDX=0;
//        }
//        else if(x<Tanque.BordeIzquierdo){
//            
//            SPEEDX=0;
//        } 
            
            y+= SPEEDY;
            x+=SPEEDX;
          
    }
  public final void choice(){
        if(Orientacion==1){SPEEDX=0;SPEEDY=-SPEEDFINAL;}
        if(Orientacion==2){SPEEDX=0;SPEEDY=SPEEDFINAL;}
        if(Orientacion==3){SPEEDX=-SPEEDFINAL;SPEEDY=0;}
        if(Orientacion==4){SPEEDX=SPEEDFINAL;SPEEDY=0;}
        
    }
    public void eventos(KeyEvent ke){
        
        int pasos = 10;
        
        if(jugador == 1){
            
            switch(ke.getKeyCode()) {
                case  KeyEvent.VK_UP:
                    if(y>BordeSuperior){
                            //y=y-pasos;
                            
                            pressed2=true;
                            
                            Dibujo=TankUP;
                            Orientacion=1;
                            choice();
                    }

                break;
                case  KeyEvent.VK_DOWN:
                    if(y<BordeInferior){
                            //y=y+pasos;
                            
                            pressed2=true;
                            
                            Dibujo=TankDOWN;
                            Orientacion=2;
                            choice();
                    
                    }

                break;
                case  KeyEvent.VK_LEFT:
                    if(x>BordeIzquierdo){
                            //x=x-pasos;
                            
                            pressed2=true;
                            
                            Dibujo=TankLEFT;    
                            Orientacion=3;
                            choice();
                    }

                break;
                case  KeyEvent.VK_RIGHT:
                    if(x<BordeDerecho){
                            //x=x+pasos;
                            
                            pressed2=true;
                            
                            Dibujo=TankRIGHT;
                            Orientacion=4;
                            choice();
                    }

                break;
            }
           // switch(ke.getKeyCode()) {
                    if( ke.getKeyCode()==KeyEvent.VK_NUMPAD0&&pressed){
                    balas.add(new Bala(this, x, y, Orientacion));               
               // break;
                    pressed=false;
                    
                    }
            //}   
            System.out.println("x="+x);
            System.out.println("y="+y);
        } else {
            
            switch(ke.getKeyCode()) {
                case  KeyEvent.VK_W:
                    if(y>BordeSuperior){
                            //y=y-pasos;
                            pressed3=true;
                            Dibujo=TankUP;
                            Orientacion=1;
                            choice();
                    }

                break;
                case  KeyEvent.VK_S:
                    if(y<BordeInferior){
                            //y=y+pasos;
                            pressed3=true;
                            Dibujo=TankDOWN;
                            Orientacion=2;
                            choice();
                    }

                break;
                case  KeyEvent.VK_A:
                    if(x>BordeIzquierdo){
                            //x=x-pasos;
                            pressed3=true;
                            Dibujo=TankLEFT;    
                            Orientacion=3;
                            choice();
                    }

                break;
                case  KeyEvent.VK_D:
                    if(x<BordeDerecho){
                            //x=x+pasos;
                            pressed3=true;
                            Dibujo=TankRIGHT;
                            Orientacion=4;
                            choice();
                    }

                break;
            }
            if( ke.getKeyCode()==KeyEvent.VK_G&&pressed1){
                    balas.add(new Bala(this, x, y, Orientacion));               
               // break;
                    pressed1=false;
                    
                    }
            
        }
        
    }
    
    public void released(KeyEvent ke){
        int key = ke.getKeyCode();

      
      if(key == KeyEvent.VK_NUMPAD0){
          pressed = true;}
      if(key == KeyEvent.VK_G){
          pressed1 = true;}
      
      switch(ke.getKeyCode()) {
                case  KeyEvent.VK_UP:
                    pressed2=false;    
                break;
                case  KeyEvent.VK_DOWN:
                    pressed2=false; 
                break;
                case  KeyEvent.VK_LEFT:
                    pressed2=false; 
                break;
                case  KeyEvent.VK_RIGHT:
                    pressed2=false; 
                break;
                case  KeyEvent.VK_W:
                    pressed3=false;                    
                break;
                case  KeyEvent.VK_S:
                    pressed3=false;                  
                break;
                case  KeyEvent.VK_A:
                    pressed3=false; 
                break;
                case  KeyEvent.VK_D:
                    pressed3=false; 
                break;
                //default: pressed2=true;
      }
        
       
    }
    
    public void actualizar(){
       
            if(pressed2||pressed3){update();
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