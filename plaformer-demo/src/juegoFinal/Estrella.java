package juegoFinal;

import fun_v01.*;

/**
 * La clase que crea y maneja las estrellas del juego
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class Estrella extends funSprite{

    public Estrella(int ancho, int alto, int posX, int posY, String imagenURL, int anchoMask, int altoMask) {
        super(ancho, alto, posX, posY, imagenURL, anchoMask, altoMask);
        crear();
    }
    
    
    @Override
    public void crear() {
        setSeMueve(false);
    }

    @Override
    public void ejecutor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
