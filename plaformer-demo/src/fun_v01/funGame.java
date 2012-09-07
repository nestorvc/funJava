package fun_v01;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Esta es la clase principal que engloba a todos los demás elementos.
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class funGame extends JFrame implements Serializable{

    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    private int alto;
    private int ancho;
    private int fps;
    private boolean mostrarPuntaje;
    private int puntaje;
    private funLaws leyes;
    private ArrayList<funScreen> pantallas;
    private funThread runner;
    private boolean debug;
    private funScreen pantActual;

    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
     * El constructor de funGame
     * Adicionalmente a los parámetros que se piden, establece varios otros
     * parámetros por default. 
     * Se establece un framerate de 10 fps.
     * Se establece que el puntaje (si existiera) no se muestre.
     * Se establece un puntaje de 0.
     * @param ancho El ancho del juego.
     * @param alto El alto del juego.
     */
    public funGame(int ancho, int alto) {
        this.alto = alto;
        this.ancho = ancho;
        setMostrarPuntaje(false);
        setPuntaje(0);
        setLeyes(funLaws.getFunLaws());
        setPantallas(new ArrayList());
        getContentPane().setLayout(null);
        setBounds(0, 0, ancho, alto);
        establecerFramerate(60);
        setRunner(new funThread(this));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDebug(false);
        setResizable(false);
        setPantActual(null);
        show();
    }    
    
    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
     * Éste método llama el método actualizar de todos sus hijos.
     */
    public void actualizar(){
        try {
            getPantActual().actualizar();
        } catch (Exception e) {
        }
    }
    
    /**
     * Establece el framerate general del juego.
     * Basicamente lo que hace es establecer el .sleep genérico del Thread en estado
     * loop infinito que controla el juego.
     * @param cuadrosXsec Cantidad de cuadros por segundo que se quiere.
     */
    public void establecerFramerate(int cuadrosXsec){
        int sec = 1000;
        int framerate = sec / cuadrosXsec;
        setFps(framerate);
    }
    
    /**
     * Agrega una nueva funScreen al funGame.
     * @param pantalla La funScreen a agregar.
     * @return Si la pantalla se agregó o no.
     */
    public boolean agregarPantalla(funScreen pantalla) {
        int index = getPantallas().indexOf(pantalla);
        if (index == -1) {
            
            pantalla.setBounds(0, 0, getAncho(), getAlto());
            getContentPane().add(pantalla);            
            
            //Establece valores funScreen especificos
            pantalla.setPadre(this);
            getPantallas().add(pantalla);
            return true;
        }
        return false;
    }
    
    /**
     * Ejecuta la funScreen deseada. 
     * Realmente lo que hace es hacer visible la pantalla deseada y ocultar
     * todas las demás
     * Solo se puede correr una pantalla a la vez.
     * @param pantalla funScreen a ejecutar.
     * @return Si la pantalla se pudo ejecutar o no.
     */
    public boolean ejecutarPantalla(funScreen pantalla) {
        
        //Primero se resetean todas las funScreen como invisibles
        for (int i = 0; i < getPantallas().size(); i++) {
            getPantallas().get(i).setVisible(false); 
            //TODO Hay que ver si es necesario destruir las otras pantallas mientras
            //para mayor rendimiento.
        }
        
        //Luego se pone la funScreen establecida como visible
        int index = getPantallas().indexOf(pantalla);
        if (index != -1) {
            getPantallas().get(index).setVisible(true);
            getPantallas().get(index).requestFocus();
            setPantActual(getPantallas().get(index));
            return true;
        }
        return false;
    }
    
    /**
     * Elimina un funScreen de la lista de pantallas de éste funGame.
     * @param pantalla funScreen a eliminar.
     * @return Si la pantalla se eliminó o no.
     */
    public boolean eliminarPantalla(funScreen pantalla) {
        int index = getPantallas().indexOf(pantalla);
        if (index != -1) {
            getPantallas().remove(pantalla);
            return true;
        }
        return false;
    }
    
    
    //******************************GETS-&-SETS******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the fps
     */
    public int getFps() {
        return fps;
    }

    /**
     * @param fps the fps to set
     */
    public void setFps(int fps) {
        this.fps = fps;
    }

    /**
     * @return the mostrarPuntaje
     */
    public boolean isMostrarPuntaje() {
        return mostrarPuntaje;
    }

    /**
     * @param mostrarPuntaje the mostrarPuntaje to set
     */
    public void setMostrarPuntaje(boolean mostrarPuntaje) {
        this.mostrarPuntaje = mostrarPuntaje;
    }

    /**
     * @return the puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return the leyes
     */
    public funLaws getLeyes() {
        return leyes;
    }

    /**
     * @param leyes the leyes to set
     */
    public void setLeyes(funLaws leyes) {
        this.leyes = leyes;
    }

    /**
     * @return the pantallas
     */
    public ArrayList<funScreen> getPantallas() {
        return pantallas;
    }

    /**
     * @param pantallas the pantallas to set
     */
    public void setPantallas(ArrayList<funScreen> pantallas) {
        this.pantallas = pantallas;
    }

    /**
     * @return the runner
     */
    public funThread getRunner() {
        return runner;
    }

    /**
     * @param runner the runner to set
     */
    public void setRunner(funThread runner) {
        this.runner = runner;
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
        for (int i = 0; i < getPantallas().size(); i++) {
            getPantallas().get(i).setDebug(debug);
        }
        this.debug = debug;
    }

    /**
     * @return the pantActual
     */
    public funScreen getPantActual() {
        return pantActual;
    }

    /**
     * @param pantActual the pantActual to set
     */
    public void setPantActual(funScreen pantActual) {
        this.pantActual = pantActual;
    }
    
}
