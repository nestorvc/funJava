package juegoFinal;

import fun_v01.funGroup;

/**
 * Las estrellas del nivel 3
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class Estrellas3 extends funGroup{
    
    @Override
    public void crear() {
        
        agregarObjeto(new Estrella(16*2, 16*2, 0,510, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 40,510, "assets/star.png", 16, 16));
        
        agregarObjeto(new Estrella(16*2, 16*2, 190,380, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 230,380, "assets/star.png", 16, 16));
        
        agregarObjeto(new Estrella(16*2, 16*2, 340,380, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 380,380, "assets/star.png", 16, 16));

        agregarObjeto(new Estrella(16*2, 16*2, 515,440, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 450,510, "assets/star.png", 16, 16));
                
        agregarObjeto(new Estrella(16*2, 16*2, 720,0, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 720,40, "assets/star.png", 16, 16));
        agregarObjeto(new Estrella(16*2, 16*2, 720,80, "assets/star.png", 16, 16));
        




    }

    @Override
    public void ejecutor() {
    }
    
}
