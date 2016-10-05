
package tankattack.clases;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Tanque /*extends GameLoop*/ {
    GameLoop gameLoop;
    int x;
    int y;
   ImageIcon Tank = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/menuprinicipal/Fondo.jpg"));
    public Tanque(GameLoop gameLoop) {
        
       this.gameLoop = gameLoop;
    }

    public void paint(Graphics2D g) {
        g.drawImage(Tank, CoordX(), CoordY(), gameLoop);
//       this.x=xi;
//       this.y=yi;
//       ImageIcon Tank = new ImageIcon("tankattack/imagenes/tanque/TankUP.png");
//       g.drawImage(Tanquesito.getImage(), xi, yi, GameLoop.paint);
      
    }
    
    public int CoordX(){
        return this.x;
    }
    public int CoordY(){
        return this.y;
    }
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