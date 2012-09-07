package juegoFinal;

import fun_v01.funSprite;

/**
 * La clase que crea y maneja al jugador 1
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class Player1 extends funSprite{

    public Player1(int ancho, int alto, int posX, int posY, String imagenURL, int anchoMask, int altoMask) {
        super(ancho, alto, posX, posY, imagenURL, anchoMask, altoMask);
        crear();
    }

    @Override
    public void crear() {
        agregarAnimacion("caminar", "0,1");
    }

    @Override
    public void ejecutor() {

    }
    
}
