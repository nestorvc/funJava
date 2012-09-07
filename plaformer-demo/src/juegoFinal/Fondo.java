package juegoFinal;

import fun_v01.funSprite;

/**
 * La clase que crea y maneja los fondos del juego
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class Fondo extends funSprite{

    public Fondo(int ancho, int alto, int posX, int posY, String imagenURL, int anchoMask, int altoMask) {
        super(ancho, alto, posX, posY, imagenURL, anchoMask, altoMask);
        setSeMueve(false);
    }
    
    @Override
    public void crear() {
    }

    @Override
    public void ejecutor() {
       
    }
    
}
