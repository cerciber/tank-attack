package tankattack.clases;

// Librerias
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* Clase GameLoop que permite:
    - Visualizar graficos a la ventana
    - Reponder a eventos del mouse y el teclado
    - Actualizar infomracion cada periodo de tiempo
*/
public class GameLoop extends JPanel implements Runnable{
    
    /* Variables globales */
    int pausaDeTiempo = 50;   // Peridodo de pausa del gameloop en milisegundos
    
    /* Objetos involucrados */
    MenuPrincipal menuPrincipal = new MenuPrincipal(this); // crear objeto Menu Principal
    
    JFrame frame;
    
    public GameLoop(JFrame frame){
        
        this.frame = frame;
        
    }
    
    /* Metodo para Visualizar graficos a la ventana 
       - Este metodo viene de la clase padre JPanel
    */
    @Override
    public void paint(Graphics g){
        
        /* Obtener obejeto grafico del Panel */
        super.paint(g);  // Asignar objeto que se pintará
        Graphics2D g2 = (Graphics2D) g; //Crear objeto Graphics2D para acceder a mas propiedades de los graficos
        
        // Pintar fondo blanco de acuerdo al tamaño de la ventana
        g2.setColor (Color.white);
        g2.fillRect(0, 0, this.getWidth(), this.getWidth());
        
        // Pintar menu Principal
        menuPrincipal.paint(g2);
        
    }
    
    /* Metodo para gestionar acciones del mouse y el teclado */
    public void eventos(){
        
        /* Detectar acciones del teclado en la ventana */
        this.addKeyListener(new KeyListener() {

            /* Detectar cuando se tipea una letra */
            @Override
            public void keyTyped(KeyEvent ke) {}

            /* Detectar cuando se presiona una letra */
            @Override
            public void keyPressed(KeyEvent ke) {}

            /* Detectar cuando se suelta una letra */
            @Override
            public void keyReleased(KeyEvent ke) {}
           
        });

        /* Detectar movimiento del mouse en la ventana */
        this.addMouseMotionListener(new MouseMotionListener() {

            /* Detectar movimiento del mouse arrastrado */
            @Override
            public void mouseDragged(MouseEvent me) {}

            /* Detectar movimiento del mouse sin presionar */
            @Override
            public void mouseMoved(MouseEvent me) {}

        });
        
        /* Detectar acciones del mouse en la ventana */
        this.addMouseListener(new MouseListener() {

            /* Detectar click del mouse */
            @Override
            public void mouseClicked(MouseEvent me) {}

            /* Detectar cuando se presiona una tecla del mouse */
            @Override
            public void mousePressed(MouseEvent me) {}

            /* Detectar cuando se suelta una tecla del mouse */
            @Override
            public void mouseReleased(MouseEvent me) {}

            /* Detectar cuando el mouse entra en la ventana */
            @Override
            public void mouseEntered(MouseEvent me) {}

            /* Detectar cuando el mouse sale de la ventana */
            @Override
            public void mouseExited(MouseEvent me) {}
            
        });
        
    } 
    
    // Metodo para actualizar información del juego
    public void actualizar(){
    
    }

    // Metodo para pausar el hilo por un periodo de tiempo determinado
    public void Esperar() {
    
        try{Thread.sleep(pausaDeTiempo);}
        catch(InterruptedException ex){}
    }
    
    /* Metodo para ejecutar los metodos anteriores indefinidamente
       - Este metodo viene de la clase implemetada Runnable
    */
    @Override
    public void run() {
        
        eventos();  // Llamar metodo eventos
        
        /* Repetir llamado de eventos indefinidamente */
        while(true){
            
            actualizar();  // Llamar metodo actualizar
            repaint();  // Llamar metodo paint
            Esperar();  // Llamar metodo esperar
            
        }
        
    }
    
}
