package juegoFinal;

import fun_v01.funGroup;

/**
 * Las estrellas del nivel 2
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class Estrellas2 extends funGroup{
    
    @Override
    public void crear() {
        
        agregarObjeto(new Estrella(16*2, 16*2, 170,220, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 210,220, "assets/star.png", 16, 16));
        
        agregarObjeto(new Estrella(16*2, 16*2, 290,380, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 330,380, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 370,380, "assets/star.png", 16, 16));
        
        agregarObjeto(new Estrella(16*2, 16*2, 450,320, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 490,320, "assets/star.png", 16, 16));
        
        agregarObjeto(new Estrella(16*2, 16*2, 490,0, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 490,40, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 490,80, "assets/star.png", 16, 16));
        
        agregarObjeto(new Estrella(16*2, 16*2, 720,0, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 720,40, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 720,80, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 720,120, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 720,160, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 720,200, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 720,240, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 720,280, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 720,320, "assets/star.png", 16, 16));
        




    }

    @Override
    public void ejecutor() {
    }
    
}
