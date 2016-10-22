
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
    
    public void eventos(KeyEvent ke){
        
        int pasos = 10;
        
        if(jugador == 1){
            
            switch(ke.getKeyCode()) {
                case  KeyEvent.VK_UP:
                    if(y>BordeSuperior){
                            y=y-pasos;
                            Dibujo=TankUP;
                            Orientacion=1;}

                break;
                case  KeyEvent.VK_DOWN:
                    if(y<BordeInferior){
                            y=y+pasos;
                            Dibujo=TankDOWN;
                            Orientacion=2;}

                break;
                case  KeyEvent.VK_LEFT:
                    if(x>BordeIzquierdo){
                            x=x-pasos;
                            Dibujo=TankLEFT;    
                            Orientacion=3;}

                break;
                case  KeyEvent.VK_RIGHT:
                    if(x<BordeDerecho){
                            x=x+pasos;
                            Dibujo=TankRIGHT;
                            Orientacion=4;}

                break;
                case KeyEvent.VK_NUMPAD0:
                    balas.add(new Bala(this, x, y, Orientacion));               
                break;
                    
            }   
            
        } else {
            
            switch(ke.getKeyCode()) {
                case  KeyEvent.VK_W:
                    if(y>BordeSuperior){
                            y=y-pasos;
                            Dibujo=TankUP;
                            Orientacion=1;}

                break;
                case  KeyEvent.VK_S:
                    if(y<BordeInferior){
                            y=y+pasos;
                            Dibujo=TankDOWN;
                            Orientacion=2;}

                break;
                case  KeyEvent.VK_A:
                    if(x>BordeIzquierdo){
                            x=x-pasos;
                            Dibujo=TankLEFT;    
                            Orientacion=3;}

                break;
                case  KeyEvent.VK_D:
                    if(x<BordeDerecho){
                            x=x+pasos;
                            Dibujo=TankRIGHT;
                            Orientacion=4;}

                break;
                case KeyEvent.VK_G:
                    balas.add(new Bala(this, x, y, Orientacion));               
                break;
            }   
            
        }
        
            
            
    }
    
    public void actualizar(){
      
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
