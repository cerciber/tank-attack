
package tankattack.clases;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;



public class Tanque /*extends GameLoop*/ {
    GameLoop gameLoop;
    int x=0;
    int y=0;
   Image Tank = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankUP.png")).getImage();
    public Tanque(GameLoop gameLoop) {
        
       this.gameLoop = gameLoop;
    }

    public void paint(Graphics2D g) {
        g.drawImage(Tank, x, y, null);
      
        
    }
    
//    public int CoordX(){
//        return this.x;
//    }
//    public int CoordY(){
//        return this.y;
//    }
    public void eventos(KeyEvent ke){
        
        switch(ke.getKeyCode()) {
            case  KeyEvent.VK_UP:
                x=x+10;
            break;
            case  KeyEvent.VK_DOWN:
                x=x-10;
            break;
            case  KeyEvent.VK_LEFT:
                y=y+10;
            break;
            case  KeyEvent.VK_RIGHT:
                y=y-10;
            break;
        }
            
        }
}