package tankattack.clases;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public final class Tablero {

    /* Objeto contenedor */
    VS2Player escenario;

    /* variables globales */
    int x = 50;
    int y = 90;
    int w = 700;
    int h = 500;

    /* Objetos involucrados */
    Base base1;
    Base base2;
    Bandera bandera1;
    Bandera bandera2;
    Tanque tanque1;
    Tanque tanque2;
    static Muro[][] muros;

    public Tablero(VS2Player e) {

        escenario = e;
        base1 = new Base(this, x + 50, y + 50, "rojo");
        base2 = new Base(this, x + 600, y + 400, "azul");
        bandera1 = new Bandera(this, x + 50, y + 50, "rojo");
        bandera2 = new Bandera(this, x + 600, y + 400, "azul");
        tanque1 = new Tanque(this, base1.x, base1.y, 1);
        tanque2 = new Tanque(this, base2.x, base2.y, 2);
        muros = new Muro[14][10];
        asignarMuros(muros);

    }

    public void paint(Graphics2D g) {

        /* pintar muros */
        for (int i = 0; i <= 13; i++) {
            for (int j = 0; j <= 9; j++) {

                muros[i][j].paint(g);

            }
        }

        base1.paint(g);
        base2.paint(g);
        tanque1.paint(g);
        tanque2.paint(g);
        bandera1.paint(g);
        bandera2.paint(g);

    }

    public void eventos(MouseEvent me) {

        /* eventos muros */
        for (int i = 0; i <= 13; i++) {
            for (int j = 0; j <= 9; j++) {

                muros[i][j].eventos(me);

            }
        }

        base1.eventos(me);
        base2.eventos(me);
        tanque1.eventos(me);
        tanque2.eventos(me);
        bandera1.eventos(me);
        bandera2.eventos(me);

    }

    public void eventos(KeyEvent ke) {

        /* eventos muros */
        for (int i = 0; i <= 13; i++) {
            for (int j = 0; j <= 9; j++) {

                muros[i][j].eventos(ke);

            }
        }

        base1.eventos(ke);
        base2.eventos(ke);
        tanque1.eventos(ke);
        tanque2.eventos(ke);
        bandera1.eventos(ke);
        bandera2.eventos(ke);

    }

    public void released(KeyEvent ke) {
        tanque1.released(ke);
        tanque2.released(ke);
    }

    public void actualizar() {

        /* actualizacion muros */
        for (int i = 0; i <= 13; i++) {
            for (int j = 0; j <= 9; j++) {

                muros[i][j].actualizar();

            }
        }

        base1.actualizar();
        base2.actualizar();
        tanque1.actualizar();
        tanque2.actualizar();
        bandera1.actualizar();
        bandera2.actualizar();

    }

    public void asignarMuros(Muro[][] muros) {

        for (int i = 0, px = x; i <= 13; i++, px += 50) {
            for (int j = 0, py = y; j <= 9; j++, py += 50) {

                if (i == 1 && j == 1) {
                    
                    muros[i][j] = new Muro(this, px, py, 4);
                    
                } else if (i == 12 && j == 8) {
                    
                    muros[i][j] = new Muro(this, px, py, 4);
                    
                } else if(i > 0 && j > 0 && i < 13 && j < 9){
                    
                    int valor = 1;
                    
                    if((valor == 5 || valor == 6)
                            || (muros[i - 1][j - 1].tipo == 6 || muros[i - 1][j - 1].tipo == 5)
                            || (muros[i - 1][j].tipo == 6 || muros[i - 1][j].tipo == 5)
                            || (muros[i - 1][j + 1].tipo == 6 || muros[i - 1][j + 1].tipo == 5)
                            || (muros[i][j - 1].tipo == 6 || muros[i][j - 1].tipo == 5)){
                        
                        valor = (int) (Math.random() * (1 - 5) + 5);
                        
                    } else {
                        valor = (int) (Math.random() * (1 - 7) + 7);
                    }
                    
                    muros[i][j] = new Muro(this, px, py, valor);
                    
                } else{
                    
                    muros[i][j] = new Muro(this, px, py, (int) (Math.random() * (1 - 7) + 7));
                    
                }

            }
        }

    }

}
