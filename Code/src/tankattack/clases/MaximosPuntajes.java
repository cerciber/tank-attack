package tankattack.clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JTextArea;

public class MaximosPuntajes {
    
    /* Objeto contenedor */
    MenuPrincipal menuPrincipal;
    /* Cambiar pantalla */
    boolean cambiarPantalla = false;
    
    
    /* Subobjetos */
    Objeto titulo = new Objeto(800/2-500/2, 20, 500, 100, 
            "/tankattack/imagenes/menuPrinicipal/TituloMaximosPuntajes.png");
    Objeto placa = new Objeto(150, 150, 500, 400, 
            "/tankattack/imagenes/configuracion/placa.jpg");
    Objeto volver = new Objeto(0, 600-80, 100, 50, 
            "/tankattack/imagenes/configuracion/img7.png");
    
    String[] Nombres = new String[50];
    int[] puntajes = new int[50];
    
    Font fuente = new Font("Helvetica",Font.BOLD,34);
    
    public MaximosPuntajes(MenuPrincipal m){
        
        menuPrincipal = m;
        leerdatos();
        ordenar(puntajes);
        
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        menuPrincipal.pantallaDePresentacion.fondo.paint(g);  // Pintar fondo
        titulo.paint(g);  // Pintar titulo
        volver.paint(g);  // Pintar boton volver
        placa.paint(g);
        
        g.setFont(fuente);
        g.setColor(Color.black);
        for (int i = 0, j = 200; i < 10; i++, j+=35) {

            if(Nombres[i] == null) {
                
                g.drawString("Vacio", 200, j);
                
            } else {
                
                g.drawString(Nombres[i], 200, j);
                
            }
            
            g.drawString(puntajes[i]+"", 500, j);

        }
        
    }
    
    public int[] ordenar(int[] x) {
        
        return insert_campo(x, x.length, 1);
        
    }

    public int[] insert_campo(int[] x, int n, int i) {
        if (i == n) {
            return x;
        }
        x = insert_pos_correct(x, n, i);
       
        return insert_campo(x, n, i + 1);
    }

    public int[] insert_pos_correct(int[] x, int n, int j) {
        
        int t;
        String t2;
        
        if (j == 0) {
            return x;
        } else if (j >= 1 && x[j] <= x[j - 1]) {
            return x;
        }
        
        t = x[j - 1];
        x[j - 1] = x[j];
        x[j] = t;
        
        t2 = Nombres[j - 1];
        Nombres[j - 1] = Nombres[j];
        Nombres[j] = t2;

        
        return insert_pos_correct(x, n, j - 1);
    }
    
    public int[] leerdatos(){
        
        File f = new File("src/documentos/Puntaje.txt");
        
        try {
            
            String texto;
            FileReader lector = new FileReader(f);
            BufferedReader contenido = new BufferedReader(lector);

            for (int i = 0; (texto = contenido.readLine()) != null && i < 25; i++) {
                
                Nombres[i] = texto.substring(texto.indexOf("US") + 2, texto.indexOf("$"));
                puntajes[i] = Integer.parseInt(texto.substring(texto.indexOf("PA") + 2, texto.indexOf("US"))); 
                
            }
            
           contenido.close();
           
        }
        catch (Exception e) {
            System.out.println("Error al leer");
        }
        return puntajes;
    }
   
    public void eventos(MouseEvent me){
        
        if(volver.click(me)){
           
            menuPrincipal.cambiarPantalla = 0;          
            
        }  
        
    }
    
    public void eventos(KeyEvent ke){
        
    }
    
    public void actualizar(){
        
    }
    
}
