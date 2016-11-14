package tankattack.clases;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Tanque {

    /* Objeto contenedor */
    Tablero tablero;

    /* Objetos involucrados */
    ArrayList balas;

    /* variables globales */
    int y;
    int x;

    /* Orientacion del tanque */
    // 1 = arriba
    // 2 = abajo
    // 3 = izquierda
    // 4 = derecha
    int Orientacion = 2;

    static int BordeSuperior = 85;
    static int BordeInferior = 600;
    static int BordeIzquierdo = 45;
    static int BordeDerecho = 755;
    int SPEEDX;
    int SPEEDY;
    int SPEEDFINAL = 10;
    int REVERSE = 10;
    static int Puntaje1 = 0;
    static int Puntaje2 = 0;
    boolean pressed = false;
    boolean pressed1 = false;
    boolean pressed2 = false;

    //Disparos necesarios para destruir el tanque
    int DIFICULTAD = 5;

    //Nivel de daño del tanque
    int dañoT1 = 0;
    int dañoT2 = 0;
    //Rectangulo que cubre el tanques
    Rectangle rectanglePlayer;

    //Imagen del tanque hacia arriba
    Image TankUP = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankUP.png")).getImage();
    //Imagen del tanque hacia abajo
    Image TankDOWN = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankDOWN.png")).getImage();
    //Imagen del tanque hacia la izquierda
    Image TankLEFT = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankLEFT.png")).getImage();
    //Imagen del tanque hacia la derecha
    Image TankRIGHT = new ImageIcon(this
            .getClass()
            .getResource("/tankattack/imagenes/tanque/TankRIGHT.png")).getImage();

    Image Dibujo = TankDOWN;

    int jugador;

    public Tanque(Tablero t, int x, int y, int j) {

        balas = new ArrayList();
        tablero = t;
        this.x = x;
        this.y = y;
        jugador = j;

    }

    public void paint(Graphics2D g) {

        g.drawImage(Dibujo, x, y, 50, 50, null);
        // Pintar Array de balas a demanda
        for (int i = 0; i < balas.size(); i++) {
            Bala b = (Bala) balas.get(i);
            //dependiendo del punto al que mire el tanque dibuja la bala en la punta del cañon
            if (b.getdir() == 1) {
                g.drawImage(b.getImage(), b.getX() + 16, b.getY() - 15, 20, 20, null);
            }
            if (b.getdir() == 2) {
                g.drawImage(b.getImage(), b.getX() + 16, b.getY() + 45, 20, 20, null);
            }
            if (b.getdir() == 3) {
                g.drawImage(b.getImage(), b.getX() - 15, b.getY() + 15, 20, 20, null);
            }
            if (b.getdir() == 4) {
                g.drawImage(b.getImage(), b.getX() + 45, b.getY() + 10, 20, 20, null);
            }
        }

    }

    public void eventos(MouseEvent me) {

    }

    public void mov() {
        y += SPEEDY;
        x += SPEEDX;
    }

    public void reverse() {
        switch (Orientacion) {
            case 1:
                abajo();
                break;
            case 2:
                arriba();
                break;
            case 3:
                derecha();
                break;
            case 4:
                izquierda();
                break;
        }
    }

    public void update() {

        rectanglePlayer = getBounds(Orientacion);
        System.out.print("x="+x);
        System.out.println("    y="+y);
        boolean retroceder = true;
        for (int i = 0; i <= 13; i++) {
            for (int j = 0; j <= 9; j++) {
                //Comparar el obstaculo en frente y detenerse
                if (rectanglePlayer.intersects(Tablero.muros[i][j].getx(), Tablero.muros[i][j].gety(), 50, 50)
                        && (Tablero.muros[i][j].getname().equals("acero")
                        || Tablero.muros[i][j].getname().equals("agua")
                        || Tablero.muros[i][j].getname().equals("ladrillo")
                        || Tablero.muros[i][j].getname().equals("piedra"))) {
                    if (retroceder) {
                        retroceder = false;
                        reverse();
                    }
                }
            }
        }

        //Limitacion con los bordes del escenario
        if (rectanglePlayer.intersectsLine(45, 85, 45, 600) || rectanglePlayer.intersectsLine(45, 85, 755, 85)
                || rectanglePlayer.intersectsLine(755, 85, 755, 600) || rectanglePlayer.intersectsLine(45, 600, 755, 600)) {
            reverse();

        }
        mov();
        tomarBandera();
    }

    public void destruido(int player) {
        //Destruccion de los tanques y reinicio en la base
        if (player == 1 && Bala.impactoT1 == DIFICULTAD) {
            Tablero.tanque1.x = tablero.base1.x;
            Tablero.tanque1.y = tablero.base1.y;
            Bala.impactoT1 = 0;
            System.out.println("Tanque 1" + Bala.impactoT1);
            tablero.bandera2.poseedor = 3;

        } else if (player == 2 && Bala.impactoT2 == DIFICULTAD) {
            Tablero.tanque2.x = tablero.base2.x;
            Tablero.tanque2.y = tablero.base2.y;
            Bala.impactoT2 = 0;
            System.out.println("Tanque 1" + Bala.impactoT2);
            tablero.bandera1.poseedor = 3;

        }
    }

    public void tomarBandera() {

        if (jugador == 1) {

            // Tomar bandera aliada
            if (tablero.bandera1.x + tablero.bandera1.w / 2 >= x
                    && tablero.bandera1.x + tablero.bandera1.w / 2 <= x + 50
                    && tablero.bandera1.y + tablero.bandera1.h / 2 >= y
                    && tablero.bandera1.y + tablero.bandera1.h / 2 <= y + 50) {

                tablero.bandera1.x = tablero.base1.x;
                tablero.bandera1.y = tablero.base1.y;
                tablero.bandera1.poseedor = 1;

            }

            // Tomar bandera enemiga
            if (tablero.bandera2.x + tablero.bandera2.w / 2 >= x
                    && tablero.bandera2.x + tablero.bandera2.w / 2 <= x + 50
                    && tablero.bandera2.y + tablero.bandera2.h / 2 >= y
                    && tablero.bandera2.y + tablero.bandera2.h / 2 <= y + 50) {

                tablero.bandera2.poseedor = 4;

            }

            // Llevar bandera enemiga
            if (tablero.bandera2.poseedor == 4) {

                tablero.bandera2.x = x;
                tablero.bandera2.y = y;

            }

            // Ganar bandera
            if (tablero.bandera2.x + tablero.bandera2.w / 2 >= tablero.base1.x
                    && tablero.bandera2.x + tablero.bandera2.w / 2 <= tablero.base1.x + 50
                    && tablero.bandera2.y + tablero.bandera2.h / 2 >= tablero.base1.y
                    && tablero.bandera2.y + tablero.bandera2.h / 2 <= tablero.base1.y + 50) {

                tablero.bandera2.x = tablero.base2.x;
                tablero.bandera2.y = tablero.base2.y;
                tablero.bandera2.poseedor = 3;
                Puntaje1++;
            }

        } else {

            // Tomar bandera aliada
            if (tablero.bandera2.x + tablero.bandera2.w / 2 >= x
                    && tablero.bandera2.x + tablero.bandera2.w / 2 <= x + 50
                    && tablero.bandera2.y + tablero.bandera2.h / 2 >= y
                    && tablero.bandera2.y + tablero.bandera2.h / 2 <= y + 50) {

                tablero.bandera2.x = tablero.base2.x;
                tablero.bandera2.y = tablero.base2.y;
                tablero.bandera2.poseedor = 1;

            }

            // Tomar bandera enemiga
            if (tablero.bandera1.x + tablero.bandera1.w / 2 >= x
                    && tablero.bandera1.x + tablero.bandera1.w / 2 <= x + 50
                    && tablero.bandera1.y + tablero.bandera1.h / 2 >= y
                    && tablero.bandera1.y + tablero.bandera1.h / 2 <= y + 50) {

                tablero.bandera1.poseedor = 4;

            }

            // Llevar bandera enemiga
            if (tablero.bandera1.poseedor == 4) {

                tablero.bandera1.x = x;
                tablero.bandera1.y = y;

            }

            // Ganar bandera
            if (tablero.bandera1.x + tablero.bandera1.w / 2 >= tablero.base2.x
                    && tablero.bandera1.x + tablero.bandera1.w / 2 <= tablero.base2.x + 50
                    && tablero.bandera1.y + tablero.bandera1.h / 2 >= tablero.base2.y
                    && tablero.bandera1.y + tablero.bandera1.h / 2 <= tablero.base2.y + 50) {

                tablero.bandera1.x = tablero.base1.x;
                tablero.bandera1.y = tablero.base1.y;
                tablero.bandera1.poseedor = 3;
                Puntaje2++;
            }

        }

    }

    public Rectangle getBounds(int i) {
        switch (i) {
            case 1:
                return new Rectangle(x, y - 10, 50, 60);

            case 2:
                return new Rectangle(x, y, 50, 60);

            case 3:
                return new Rectangle(x - 10, y, 60, 50);

            case 4:
                return new Rectangle(x, y, 60, 50);

            default:
                return new Rectangle(x, y, 50, 50);
        }

    }

    public void derecha() {
        x += REVERSE;
    }

    public void izquierda() {
        x += -REVERSE;
    }

    public void abajo() {
        y += REVERSE;
    }

    public void arriba() {
        y += -REVERSE;
    }

    public void moveUP() {
        SPEEDX = 0;
        SPEEDY = -SPEEDFINAL;
    }

    public void moveDOWN() {
        SPEEDX = 0;
        SPEEDY = SPEEDFINAL;
    }

    public void moveLEFT() {
        SPEEDX = -SPEEDFINAL;
        SPEEDY = 0;
    }

    public void moveRIGHT() {
        SPEEDX = SPEEDFINAL;
        SPEEDY = 0;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public void eventos(KeyEvent ke) {

        if (jugador == 1) {

            switch (ke.getKeyCode()) {
                case KeyEvent.VK_UP:
                    pressed1 = true;
                    Dibujo = TankUP;
                    Orientacion = 1;
                    moveUP();

                    break;
                case KeyEvent.VK_DOWN:
                    pressed1 = true;
                    Dibujo = TankDOWN;
                    Orientacion = 2;
                    moveDOWN();

                    break;
                case KeyEvent.VK_LEFT:

                    pressed1 = true;
                    Dibujo = TankLEFT;
                    Orientacion = 3;
                    moveLEFT();

                    break;
                case KeyEvent.VK_RIGHT:
                    pressed1 = true;
                    Dibujo = TankRIGHT;
                    Orientacion = 4;
                    moveRIGHT();

                    break;
            }

            if (ke.getKeyCode() == KeyEvent.VK_NUMPAD0 && pressed) {
                balas.add(new Bala(this, x, y, Orientacion));
                pressed = false;
            }

        } else {

            switch (ke.getKeyCode()) {
                case KeyEvent.VK_W:
                    if (y > BordeSuperior) {
                    }
                    pressed2 = true;
                    Dibujo = TankUP;
                    Orientacion = 1;
                    moveUP();

                    break;
                case KeyEvent.VK_S:
                    if (y < BordeInferior) {
                    }
                    pressed2 = true;
                    Dibujo = TankDOWN;
                    Orientacion = 2;
                    moveDOWN();

                    break;
                case KeyEvent.VK_A:
                    if (x > BordeIzquierdo) {
                    }
                    pressed2 = true;
                    Dibujo = TankLEFT;
                    Orientacion = 3;
                    moveLEFT();

                    break;
                case KeyEvent.VK_D:
                    if (x < BordeDerecho) {
                    }
                    pressed2 = true;
                    Dibujo = TankRIGHT;
                    Orientacion = 4;
                    moveRIGHT();

                    break;
            }
            if (ke.getKeyCode() == KeyEvent.VK_G && pressed) {
                balas.add(new Bala(this, x, y, Orientacion));
                pressed = false;
            }

        }

    }

    public void released(KeyEvent ke) {
        int key = ke.getKeyCode();

        if (key == KeyEvent.VK_NUMPAD0) {
            pressed = true;
        }
        if (key == KeyEvent.VK_G) {
            pressed = true;
        }

        switch (ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                pressed1 = false;
                break;
            case KeyEvent.VK_DOWN:
                pressed1 = false;
                break;
            case KeyEvent.VK_LEFT:
                pressed1 = false;
                break;
            case KeyEvent.VK_RIGHT:
                pressed1 = false;
                break;
            case KeyEvent.VK_W:
                pressed2 = false;
                break;
            case KeyEvent.VK_S:
                pressed2 = false;
                break;
            case KeyEvent.VK_A:
                pressed2 = false;
                break;
            case KeyEvent.VK_D:
                pressed2 = false;
                break;
            //default: pressed2=true;
        }
    }

    public void PresionBoton() {
        if (pressed1) {
            update();
        } else if (pressed2) {
            update();
        }
    }

    public void actualizacionBalas() {
        for (int j = 0; j < balas.size(); j++) {
            Bala b = (Bala) balas.get(j);
            if (b.isVisible()) {
                b.update();
            } else {
                balas.remove(j);
            }
        }
    }

    public void actualizar() {
        destruido(jugador);
        PresionBoton();
        actualizacionBalas();

    }

}
