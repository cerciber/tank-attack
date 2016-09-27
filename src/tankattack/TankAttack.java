package tankattack;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class TankAttack {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        
        frame.setTitle("Tank Attack");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        Runnable gameloop = new GameLoop();
        new Thread(gameloop).start();
        frame.add((JPanel)gameloop);
        
    }
    
}
