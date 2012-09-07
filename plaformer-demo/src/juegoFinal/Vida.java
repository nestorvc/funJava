package juegoFinal;

import fun_v01.*;

/**
 * La clase que crea y maneja las vidas del jugador
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class Vida extends funSprite{

    public Vida(int ancho, int alto, int posX, int posY, String imagenURL, int anchoMask, int altoMask) {
        super(ancho, alto, posX, posY, imagenURL, anchoMask, altoMask);
        crear();
    }    
    
    @Override
    public void crear() {
        setSeMueve(false);
        setTieneColisiones(false);        
        agregarAnimacion("2vidas", "1");
        agregarAnimacion("1vidas", "2");
    }

    @Override
    public void ejecutor() {
    }
    
}
