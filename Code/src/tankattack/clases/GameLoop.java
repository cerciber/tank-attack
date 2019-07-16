package tankattack.clases;

// Librerias
import java.applet.AudioClip;
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
    - Actualizar informacion cada periodo de tiempo
*/
public class GameLoop extends JPanel implements Runnable{
    
    /* Objeto contenedor */
    protected JFrame frame;
     
    /* Objetos involucrados */
    PantallaDePresentacion pantallaDePresentacion;
       
    /* Variables globales */
    int pausaDeTiempo = 50;   // Peridodo de pausa del gameloop en milisegundos
    
    AudioClip sonidoDeFondo = java.applet.Applet.newAudioClip(getClass().getResource("/tankattack/audios/CancionDeFondo.wav"));
    AudioClip golpe = java.applet.Applet.newAudioClip(getClass().getResource("/tankattack/audios/golpe.wav"));
    
    /* Metodo constructor */
    public GameLoop(JFrame frame){
       
       this.frame = frame;
       pantallaDePresentacion = new PantallaDePresentacion(this); // crear objeto Menu Principal
        
    }
    
    /* Metodo para Visualizar graficos a la ventana 
       - Este metodo viene de la clase padre JPanel
    */
    @Override
    public void paint(Graphics g){
        
        /* Obtener obejeto grafico del Panel */
        super.paint(g);  // Asignar objeto que se pintará
        Graphics2D g2 = (Graphics2D) g; //Crear objeto Graphics2D para acceder a mas propiedades de los graficos
        
        pantallaDePresentacion.paint(g2); // Pintar menu Principal
        
    }
    
    /* Metodo para gestionar acciones del mouse y el teclado */
    public void eventos(){
        
        /* Detectar acciones del teclado en la ventana */
        frame.addKeyListener(new KeyListener() {

            /* Detectar cuando se tipea una letra */
            @Override
            public void keyTyped(KeyEvent ke) {}

            /* Detectar cuando se presiona una letra */
            @Override
            public void keyPressed(KeyEvent ke) {
                
                pantallaDePresentacion.eventos(ke);
              
            }

            /* Detectar cuando se suelta una letra */
            @Override
            public void keyReleased(KeyEvent ke) {
                pantallaDePresentacion.released(ke);
            }
               
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
            public void mouseClicked(MouseEvent me) {
            
                golpe.play();
                pantallaDePresentacion.eventos(me);
            
            }

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
   
    public void actualizar(){
      
        pantallaDePresentacion.actualizar();
   
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
        sonidoDeFondo.play();
       
        /* Repetir llamado de eventos indefinidamente */
        while(true){
            
            actualizar();  // Llamar metodo actualizar
            repaint();  // Llamar metodo paint
            Esperar();  // Llamar metodo esperar
            
        }
        
    }
    
}
