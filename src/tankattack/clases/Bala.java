package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Bala  {
    GameLoop gameLoop;
    ArrayList <Image> ArrayBalas= new ArrayList <> ();
    
    Image Bala = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/bala.png")).getImage();

    public Bala(GameLoop gameLoop) {
            this.gameLoop = gameLoop;
        }
    
    Image Dibujo2;
    int y;
    public void paint(Graphics2D g){
    
        if(press){g.drawImage(Bala, GameLoop.z,y, 20,20,null);
    }}
  
   
    static boolean press=false;
    public void eventos(KeyEvent ke){
        int Orientacion=Tanque.Sentido();
        if(ke.getKeyCode()==KeyEvent.VK_NUMPAD0){
            ArrayBalas.add(Bala);
            System.out.println("Cantidad Array "+ArrayBalas.size());
            System.out.println("Orientacion "+Orientacion);
            //this.proyectiles();
            press=true;
            //Dibujo2=ArrayBalas.get(y);
                       
            
//             switch(Orientacion){
//                    case 1 :
//                       Dibujo2=BulletUP;
//                        System.out.println("Orientacion ");
////                        x=Tanque.x;
////                        y=Tanque.y;
//                    break; 
//                    case 2:
//                        Dibujo2=BulletDOWN;
//                    break; 
//                    case 3:
//                        Dibujo2=BulletLEFT;
//                       
//                    break; 
//                    case 4:
//                        Dibujo2=BulletRIGHT;
//                    break; 
//             }
        }
    }
}
