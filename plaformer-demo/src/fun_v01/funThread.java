package fun_v01;

import javax.swing.JOptionPane;

/**
 * Ésta clase define el Thread principal (y de momento único) que loopea el funGame
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class funThread implements Runnable{
    
    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
      
    private funGame padre;
    private Thread runner;
        
    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * El constructor de funThread.
     * @param padre El funGame que controla.
     */
    public funThread(funGame padre) {
        setPadre(padre);
        setRunner(new Thread(this));
        getRunner().start();
    }
    
    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * La función principal de éste thread es correr el método actualizar()
     * de su padre, que a la vez llama a todos los de los otros objetos.
     */
    @Override
    public void run() {
        while(true){
        getPadre().actualizar();
        
            try {
            Thread.currentThread().sleep(getPadre().getFps());
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "NOTIFICACION: Error con el framerate del juego: "+ e);
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NOTIFICACION: " + e);
            }
        }
    }
    
    //******************************GETS-&-SETS******************************//
    //***********************************************************************//
    //***********************************************************************//
 
    /**
     * @return the padre
     */
    public funGame getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(funGame padre) {
        this.padre = padre;
    }

    /**
     * @return the runner
     */
    public Thread getRunner() {
        return runner;
    }

    /**
     * @param runner the runner to set
     */
    public void setRunner(Thread runner) {
        this.runner = runner;
    }
}
