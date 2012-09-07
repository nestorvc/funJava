package juegoFinal;

import fun_v01.*;

/**
 * La clase que crea y maneja la pantalla de Game Over
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class PantallaGameOver extends funScreen{

    private Fondo fondo;

    @Override
    public void crear() {
        fondo = new Fondo(800, 600, 0, 0, "assets/gameover.png", 800, 600);   
        
        agregarObjeto(fondo);
    }

    @Override
    public void ejecutor() {
        
    }
    
}
