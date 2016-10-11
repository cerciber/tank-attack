package tankattack.clases;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Bala {
    GameLoop gameLoop;
    Image Bala;
    protected int x,y;
    private final int SPEED = 5;
    private boolean visible;
    //ArrayList <Bala> ArrayBalas= new ArrayList <> ();  
    
    public Bala(GameLoop gameLoop, int x, int y) {
             Bala = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/bala.png")).getImage();
            this.gameLoop = gameLoop;
            visible=true;
            this.x=x;
            this.y=y;
            
        }//gameLoop.repaint();
    
    public int getX(){
      return x;
    }

    public int getY(){
      return y;
    }

    public Image getImage(){
      return Bala;
    }
    
    public boolean isVisible(){
      return visible;
  }

  public void setVisible(boolean visible){
      this.visible = visible;
  }

  public void update(){
      y += SPEED;
      if(y>210) visible = false;
    }

    Image Dibujo2;

    public void paint(Graphics2D g){
        //if(Tanque.Orientacion==4){
             //Graphics2D g2d = (Graphics2D)g;
            System.out.println("Bala impresa= "+Tanque.n);
            
            if(Tanque.Press){
                x+=moverabajo();
                y+=moverabajo();
             
                for (int j=0;j<Tanque.i;j++){
                    g.drawImage(Bala, x,y, 20,20,null);}
            }
            
       // }
//        if(Tanque.Orientacion==2){
//            
//           y+=moverabajo();
//            if(Tanque.Press)g.drawImage(Bala, x,y, 20,20,null);
//        }
        
        
    }
    
    public int moverabajo(){
        //System.out.println("Aumentar 10 x");    
        int v=5;
        
        return v;
         
    }
    public final void aumentarx(){
      
    }
    
    public int mostrarx(){
        return x;
    }
    public int mostrary(){
        return y;
    }
            
    //static boolean press=false;
    public void eventos(KeyEvent ke){
//      int Orientacion=Tanque.Sentido();
//            if(ke.getKeyCode()==KeyEvent.VK_NUMPAD0){
//            //press=true; 
//           
//            System.out.println("Orientacion "+Orientacion);
//            //this.proyectiles();
           
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
             }
        }
    //}

