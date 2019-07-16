package tankattack.clases;

// Librerias
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/* Clase principal en la cual se crea la ventana y se añade el Gameloop*/
public class TankAttack {

    // Metodo que inicia el programa
    public static void main(String[] args) {

        /* Crear objeto ventana */
        JFrame frame = new JFrame();
        
        /* Asignar propiedades de ventana */
        frame.setTitle("Tank Attack");  // Estblecer titulo
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);    //  Finalizar programa al cerrar la ventana
        frame.setSize(808,630); // Establecer altra y ancho
        frame.setResizable(false);  // Desactivar redimecionamiento de la ventana
        frame.setLocationRelativeTo(null);  // Ubicar en el centro de la pantalla al inicarse
        
        /* Crear objeto GameLoop */ 
        Runnable gameloop = new GameLoop(frame);
        
        /* Crear un hilo para ejecutar el objeto GameLoop */
        new Thread(gameloop).start();
        
        // Añadir Gameloop a la ventana como Panel
        frame.add((JPanel)gameloop);
        
        frame.setVisible(true);  // Mostrar ventana en la pantalla
        
    }
    
}
