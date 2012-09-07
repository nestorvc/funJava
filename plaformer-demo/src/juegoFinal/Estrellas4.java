package juegoFinal;

import fun_v01.funGroup;

/**
 * Las estrellas del nivel 4
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class Estrellas4 extends funGroup{
    
    @Override
    public void crear() {
        
        agregarObjeto(new Estrella(16*2, 16*2, 160,160, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 220,190, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 280,220, "assets/star.png", 16, 16));
        
        agregarObjeto(new Estrella(16*2, 16*2, 590,190, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 630,190, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 670,190, "assets/star.png", 16, 16));
        
        agregarObjeto(new Estrella(16*2, 16*2, 310,0, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 350,0, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 390,0, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 430,0, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 470,0, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 510,0, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 550,0, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 590,0, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 630,0, "assets/star.png", 16, 16));



    }

    @Override
    public void ejecutor() {
    }
    
}
