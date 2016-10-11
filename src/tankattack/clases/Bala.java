package tankattack.clases;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Bala {
    GameLoop gameLoop;
    Image Bala;
    protected int x,y,direccion,aux;
    private int SPEEDX;
    private int SPEEDY;
    private boolean visible;
    
    
    public Bala(GameLoop gameLoop, int x, int y,int direcc) {
             Bala = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/bala.png")).getImage();
            this.gameLoop = gameLoop;
            visible=true;
            this.x=x;
            this.y=y;
            this.direccion=direcc;
            choice();
        }
    
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
        //aux=choice();
        y+= SPEEDY;
        x+=SPEEDX;
        if(aux>Tanque.BordeInferior||aux>Tanque.BordeSuperior||aux>Tanque.BordeDerecho||aux>Tanque.BordeIzquierdo) visible = false;
    }
  public final void choice(){
        if(direccion==1){SPEEDX=0;SPEEDY=-5;}
        if(direccion==2){SPEEDX=0;SPEEDY=5;}
        if(direccion==3){SPEEDX=-5;SPEEDY=0;}
        if(direccion==4){SPEEDX=5;SPEEDY=0;}
        if(direccion==0){this.visible=false;}
    }
  
//  public void updateArriba(){
//      y -= SPEED;
//      if(y>Tanque.BordeInferior) visible = false;
//    }
//
//    public void updateAbajo(){
//       y += SPEED;
//       if(y>Tanque.BordeInferior) visible = false;
//    }
//    public  void updateDerecha(){
//        x -= SPEED;
//        if(y>Tanque.BordeInferior) visible = false;
//    }
//    
//    public void updateIzquierda(){
//        x += SPEED;
//        if(y>Tanque.BordeInferior) visible = false;
//    }
    
    
}
    

