package juegoFinal;

import fun_v01.funGame;

/**
 * La clase prinicipal que crea y maneja el juego
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class Game extends funGame{

    public Game(int alto, int ancho) {
        super(alto, ancho);        
        setPuntaje(0);
        
        Pantalla1 p1 = new Pantalla1();
        Pantalla2 p2 = new Pantalla2();
        Pantalla3 p3 = new Pantalla3();
        Pantalla4 p4 = new Pantalla4();
        PantallaTitulo pT = new PantallaTitulo();
        PantallaGameOver pG = new PantallaGameOver();
                
        agregarPantalla(p1);
        agregarPantalla(p2);
        agregarPantalla(p3);
        agregarPantalla(p4);
        agregarPantalla(pT);
        agregarPantalla(pG);
    }   
}
