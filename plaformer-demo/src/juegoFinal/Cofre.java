package juegoFinal;

import fun_v01.funSprite;

/**
 * La clase que crea y maneja el cofre del juego
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class Cofre extends funSprite{

    public Cofre(int ancho, int alto, int posX, int posY, String imagenURL, int anchoMask, int altoMask) {
        super(ancho, alto, posX, posY, imagenURL, anchoMask, altoMask);
    }    
    
    @Override
    public void crear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void ejecutor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
