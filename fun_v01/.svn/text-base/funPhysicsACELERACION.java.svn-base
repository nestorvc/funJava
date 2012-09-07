package fun_v01;

import java.awt.Point;

/**
 * Éste método realiza una fórmula física de aceleración.
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class funPhysicsACELERACION extends funPhysics{

    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//    
    
    public funPhysicsACELERACION(funObject objeto, double originalY, double velocidadY, double originalX, double velocidadX) {
        super(objeto, originalY, velocidadY, originalX, velocidadX);
    }
    
    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//
    
    @Override
    public Point formula() {
        setAceleracionX(getVelocidadX() / getTiempo());
        setAceleracionX(getVelocidadY() / getTiempo());
                
        Point coordenada = new Point();
        coordenada.x = (int) getAceleracionX();
        coordenada.y = (int) getAceleracionY();
        return coordenada;
    }
    
}
