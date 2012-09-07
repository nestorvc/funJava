package fun_v01;

import java.awt.Point;

/**
 * Éste método realiza una fórmula física parabólica.
 * Generalmente se usa para movimiento de proyectiles o saltos.
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class funPhysicsPARABOLA extends funPhysics{

    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    public funPhysicsPARABOLA(funObject objeto, double originalY, double velocidadY, double originalX, double velocidadX) {
        super(objeto, originalY, velocidadY, originalX, velocidadX);
    }
    
    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//
    
    @Override
    public Point formula() {
        primeraFormula();
        segundaFormula();
        posicionarObjeto();

        Point coordenada = new Point();
        coordenada.x = (int) getNuevaX();
        coordenada.y = (int) getNuevaY();
        return coordenada;
    }
    
    /**
     * Realiza la primera fórmula para averiguar el movimiento parabólico
     */
    public void primeraFormula(){
        setNuevaX(getVelocidadX() * getTiempo());
    }
    
    /**
     * Realiza la segunda fórmula para averiguar el movimiento parabólico
     */
    public void segundaFormula(){        
        setNuevaY(getOriginalY() + getVelocidadY() * getTiempo() + UN_MEDIO * GRAVEDAD * getTiempo() * getTiempo());
    }
    
    /**
     * Define las nuevas posiciones X,Y del objeto según las fórmulas aplicadas
     */
    public void posicionarObjeto(){
        setNuevaX(getNuevaX() + getOriginalX());
        setNuevaY(getOriginalY() - getNuevaY());
        setNuevaY(getNuevaY() + getOriginalY());
    }
    
}
