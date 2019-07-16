package tankattack.clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Configuracion {
    
    /* Objeto contenedor */
    MenuPrincipal menuPrincipal;
    
    /* Cambiar pantalla */
    boolean cambiarPantalla = false;
    
    int resistencia;
    int banderas;
    /* Subobjetos */
    Objeto titulo = new Objeto(800/2-500/2, 20, 500, 100, 
            "/tankattack/imagenes/configuracion/img1.png");
    Objeto textoNDisparos = new Objeto(800/2-350, 600/2-50/2-100, 350, 50, 
            "/tankattack/imagenes/configuracion/img2.png");
    Objeto flechaNDisparosIzq = new Objeto(800/2+100, 600/2-50/2-100, 50, 50, 
            "/tankattack/imagenes/configuracion/img5.png");
    Objeto flechaNDisparosDer = new Objeto(800/2+200, 600/2-50/2-100, 50, 50, 
            "/tankattack/imagenes/configuracion/img6.png");
    Objeto textoNBanderas = new Objeto(800/2-350, 600/2-50/2, 350, 50, 
            "/tankattack/imagenes/configuracion/img3.png");
    Objeto flechaNBanderasIzq = new Objeto(800/2+100, 600/2-50/2, 50, 50, 
            "/tankattack/imagenes/configuracion/img5.png");
    Objeto flechaNBanderasDer = new Objeto(800/2+200, 600/2-50/2, 50, 50, 
            "/tankattack/imagenes/configuracion/img6.png");
    Objeto volver = new Objeto(0, 600-80, 100, 50, 
            "/tankattack/imagenes/configuracion/img7.png");
    Font fuente = new Font("Helvetica",Font.BOLD,34);
    public Configuracion(MenuPrincipal m){
        
        menuPrincipal = m;
        leerConfiguracion();
        
    }
    public void guardarConfiguracion(){
        File f = new File("src/documentos/Archivo.txt");
        try {

            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write("R" + resistencia + "S" + "B" + banderas + "T");
            //bw.append();
            bw.close();

        } catch (IOException e) {
            //System.out.println("Error E/S: " + e);
        }
    }
    public void leerConfiguracion(){
        File f = new File("src/documentos/Archivo.txt");
        try {
            String texto;
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            texto = br.readLine();
            resistencia = Integer.parseInt(texto.substring(texto.indexOf("R") + 1, texto.indexOf("S")));
            banderas = Integer.parseInt(texto.substring(texto.indexOf("B") + 1, texto.indexOf("T")));
            br.close();
            System.out.println("res " + resistencia + "   band " + banderas);
        } catch (Exception ex) {

        }
    }
    
    /* Pintar en pantalla */
    public void paint(Graphics2D g){
        
        menuPrincipal.pantallaDePresentacion.fondo.paint(g);  // Pintar fondo
        titulo.paint(g);  // Pintar titulo
        textoNDisparos.paint(g);  // Pintar texto de disparos
        flechaNDisparosIzq.paint(g);  // Pintar flecha izquierda disparos
        flechaNDisparosDer.paint(g);  // Pintar flecha derecha disparos
        textoNBanderas.paint(g);  // Pintar numero de banderas
        flechaNBanderasIzq.paint(g);  // Pintar flecha izquierda numero de banderas
        flechaNBanderasDer.paint(g);  // Pintar flecha derecha numero de banderas
        volver.paint(g);  // Pintar boton volver
        g.setFont(fuente);
        g.setColor(Color.black);
        g.drawString(resistencia+"", 555, 210);
        g.drawString(banderas+"", 555, 310);
        
    }
    
    public void eventos(MouseEvent me){
        
        if(volver.click(me)){
            
            menuPrincipal.cambiarPantalla = 0;
            guardarConfiguracion();
        }  
        if (flechaNDisparosIzq.click(me) && resistencia >= 4) {
            resistencia -= 2;
        }
        if (flechaNDisparosDer.click(me)) {
            resistencia += 2;
        }
        if (flechaNBanderasIzq.click(me) && banderas >= 2) {
            banderas -= 1;
        }
        if (flechaNBanderasDer.click(me)) {
            banderas += 1;
        } 
        
    }
    
    public void eventos(KeyEvent ke){
        
    }
    
    public void actualizar(){
        
    }
    
}
