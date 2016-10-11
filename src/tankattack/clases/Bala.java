package tankattack.clases;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Bala {
    GameLoop gameLoop;
    Image Bala;
    protected int x,y;
    private final int direccion;
    private int SPEEDX;
    private int SPEEDY;
    private final int SPEEDFINAL=10;
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
        if(y>Tanque.BordeInferior||y<Tanque.BordeSuperior||x>Tanque.BordeDerecho||x<Tanque.BordeIzquierdo) visible = false;
    }
  public final void choice(){
        if(direccion==1){SPEEDX=0;SPEEDY=-SPEEDFINAL;}//px=16;py=-15;}
        if(direccion==2){SPEEDX=0;SPEEDY=SPEEDFINAL;}//px=16;py=45;}
        if(direccion==3){SPEEDX=-SPEEDFINAL;SPEEDY=0;}//px=-15;py=15;}
        if(direccion==4){SPEEDX=SPEEDFINAL;SPEEDY=0;}//px=45;py=10;}
        if(direccion==0){this.visible=false;}
    }
    
  public int getdir(){
      return direccion;
  }
    
}
    

