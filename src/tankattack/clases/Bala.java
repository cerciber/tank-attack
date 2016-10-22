package tankattack.clases;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Bala {
    
    /* Objeto contenedor */
    Tanque tank;
    
    Image Bala;
    
    int x;
    int y;
    int direccion;
    int SPEEDX;
    int SPEEDY;
    int SPEEDFINAL = 10;
    boolean visible;
    
    public Bala(Tanque tank, int x, int y, int direcc) {
        
        Bala = new ImageIcon(this.getClass()
                .getResource("/tankattack/imagenes/tanque/bala.png")).getImage();
        
        this.tank = tank;
        visible = true;
        this.x = x;
        this.y = y;
        this.direccion = direcc;
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
        //if(y>Tanque.BordeInferior||y<Tanque.BordeSuperior||x>Tanque.BordeDerecho||x<Tanque.BordeIzquierdo) visible = false;
    }
  public final void choice(){
        if(direccion==1){SPEEDX=0;SPEEDY=-SPEEDFINAL;}
        if(direccion==2){SPEEDX=0;SPEEDY=SPEEDFINAL;}
        if(direccion==3){SPEEDX=-SPEEDFINAL;SPEEDY=0;}
        if(direccion==4){SPEEDX=SPEEDFINAL;SPEEDY=0;}
        if(direccion==0){this.visible=false;}
    }
    
  public int getdir(){
      return direccion;
  }
    
}
    

