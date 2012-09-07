package juegoFinal;


/**
 * El probador
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class Probador {

    public static void main(String[] args) {

        Game g = new Game(800, 600);        
        g.ejecutarPantalla(g.getPantallas().get(0));        
        //g.setDebug(true);
    }
}
