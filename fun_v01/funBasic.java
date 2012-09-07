package fun_v01;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * Este es el Template genérico de los distintos objetos que usará fun
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public abstract class funBasic extends JComponent{
    
    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    private funScreen madre;    
    private boolean debug;

    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * El constructor de funBasic.
     * Adicionalmente a los parámetros que se piden, establece varios otros
     * Se establece por deafault que el objeto no está visible.
     */
    public funBasic() {

        setVisible(false);
        setDebug(false);
    }       
    
    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
     * Acá es donde se pondrá la lógica principal de iniciación del objeto
     * IMPORTANTE: Esto funciona como un Constructor propio de fun, por lo tanto
     * dentro de lo posible usar este para construir las propiedades del objeto
     * y no el constructor de la clase.
     */
    public abstract void crear();
    
    /**
     * Acá es donde se pondrá la lógica principal de verificación del objeto
     * Este método se esta corriendo N cantidad de veces por segundo, por lo tanto
     * acá se establecerían funciones como verificar colisiones, controles presionados,
     * etc.
     */
    public abstract void ejecutor();
    
    /**
     * Éste método actualizará N cantidad de veces por segundo las propiedades 
     * cambiantes del objeto. Generalmente este método no debería ser alterado
     * ni sobreescrito. Para eso está el ejecutor()
     */
    public abstract void actualizar ();
    
    /**
     * Éste método pinta los objetos dentro de la funScreen madre
     * @param g El Graphics del escenario al que pertenece, generalmente un funScreen
     */
    
    @Override
    public abstract void paint(Graphics g);
    
    //******************************GETS-&-SETS******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * @return the madre
     */
    public funScreen getMadre() {
        return madre;
    }

    /**
     * @param madre the madre to set
     */
    public void setMadre(funScreen madre) {
        this.madre = madre;
    }

    /**
     * @return the debug
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * @param debug the debug to set
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    
    
}
