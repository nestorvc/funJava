package juegoFinal;

import fun_v01.*;


/**
 * La clase que crea y maneja la pantalla del título
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class PantallaTitulo extends funScreen {

    private Fondo fondo;
    private Fondo titulo;
    private Texto texto;
    private int puntaje;

    @Override
    public void crear() {
        setFondo(new Fondo(800, 600, 0, 0, "assets/fondo1.png", 600, 400));   
        setTitulo(new Fondo(640, 480, 60, 40, "assets/titulo.png", 320, 240));  
        setTexto(new Texto());
        setPuntaje(0);        
                
        agregarObjeto(getTitulo());
        add(getTexto());
        agregarObjeto(getFondo());
        pintarTopAdelante(getTitulo());
        
        getTexto().setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        getTexto().setBounds(300, 500, 500, 50);
        
        actualizarPuntaje();
    }

    @Override
    public void ejecutor() {
        actualizarPuntaje();
    }
    
    public void actualizarPuntaje() {
        getTexto().setText("PUNTAJE FINAL: " + getPuntaje());
    }

    /**
     * @return the fondo
     */
    public Fondo getFondo() {
        return fondo;
    }

    /**
     * @param fondo the fondo to set
     */
    public void setFondo(Fondo fondo) {
        this.fondo = fondo;
    }

    /**
     * @return the titulo
     */
    public Fondo getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(Fondo titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the texto
     */
    public Texto getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(Texto texto) {
        this.texto = texto;
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
}
