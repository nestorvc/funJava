package fun_v01;

import java.awt.Point;

/**
 * Ésta clase maneja las físicas de los funObjects
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public /*abstract*/ class funPhysics {
    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    private funObject objeto;
    private double nuevaY;
    private double originalY;
    private double velocidadY;
    private double nuevaX;
    private double originalX;
    private double velocidadX;
    private double tiempo;
    private double aceleracionX;
    private double aceleracionY;
    final double INCREMENTO_TIEMPO = 0.25;
    final double UN_MEDIO = 0.5;
    final double GRAVEDAD =  -9.81;

    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//

    public funPhysics(funObject objeto, double originalY, double velocidadY, double originalX, double velocidadX) {
        this.objeto = objeto;
        this.originalY = originalY;
        this.velocidadY = velocidadY;
        this.originalX = originalX;
        this.velocidadX = velocidadX;
    }

    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//
    
    public /*abstract*/ Point formula(){
        setTiempo(getTiempo() + INCREMENTO_TIEMPO);
        setNuevaX(getVelocidadX() * getTiempo());
        setNuevaY(getOriginalY() + getVelocidadY() * getTiempo() + UN_MEDIO * GRAVEDAD * getTiempo() * getTiempo());
        setNuevaX(getNuevaX() + getOriginalX());
        setNuevaY(getOriginalY() - getNuevaY());
        setNuevaY(getNuevaY() + getOriginalY());

        Point coordenada = new Point();
        coordenada.x = (int) getNuevaX();
        coordenada.y = (int) getNuevaY();
        return coordenada;
    }
    
    public void incrementoTiempo(){
        setTiempo(getTiempo() + INCREMENTO_TIEMPO);
    }
    
    public void resetearConDatosActuales(double originalY, double velocidadY, double originalX, double velocidadX){
        this.originalY = originalY;
        this.velocidadY = velocidadY;
        this.originalX = originalX;
        this.velocidadX = velocidadX;
        setTiempo(0);
    }
    
    public void aplicarFisica(){
        //incrementoTiempo();
        if(getObjeto().getEstaTocando() == funColisiones.PISO) {
            resetearConDatosActuales(getObjeto().getPosY(), getObjeto().getVelocidadY(), getObjeto().getPosX(), getObjeto().getVelocidadX());
            Point coord = formula();   
            getObjeto().setPosX(coord.x);
        }  else {
            Point coord = formula();
            getObjeto().setPosY(coord.y);   
            getObjeto().setPosX(coord.x);
        }        
    }
    
    //******************************GETS-&-SETS******************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
     * @return the nuevaY
     */
    public double getNuevaY() {
        return nuevaY;
    }

    /**
     * @param nuevaY the nuevaY to set
     */
    public void setNuevaY(double nuevaY) {
        this.nuevaY = nuevaY;
    }

    /**
     * @return the originalY
     */
    public double getOriginalY() {
        return originalY;
    }

    /**
     * @param originalY the originalY to set
     */
    public void setOriginalY(double originalY) {
        this.originalY = originalY;
    }

    /**
     * @return the velocidadY
     */
    public double getVelocidadY() {
        return velocidadY;
    }

    /**
     * @param velocidadY the velocidadY to set
     */
    public void setVelocidadY(double velocidadY) {
        this.velocidadY = velocidadY;
    }

    /**
     * @return the nuevaX
     */
    public double getNuevaX() {
        return nuevaX;
    }

    /**
     * @param nuevaX the nuevaX to set
     */
    public void setNuevaX(double nuevaX) {
        this.nuevaX = nuevaX;
    }

    /**
     * @return the originalX
     */
    public double getOriginalX() {
        return originalX;
    }

    /**
     * @param originalX the originalX to set
     */
    public void setOriginalX(double originalX) {
        this.originalX = originalX;
    }

    /**
     * @return the velocidadX
     */
    public double getVelocidadX() {
        return velocidadX;
    }

    /**
     * @param velocidadX the velocidadX to set
     */
    public void setVelocidadX(double velocidadX) {
        this.velocidadX = velocidadX;
    }

    /**
     * @return the tiempo
     */
    public double getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the objeto
     */
    public funObject getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(funObject objeto) {
        this.objeto = objeto;
    }

    /**
     * @return the aceleracionX
     */
    public double getAceleracionX() {
        return aceleracionX;
    }

    /**
     * @param aceleracionX the aceleracionX to set
     */
    public void setAceleracionX(double aceleracionX) {
        this.aceleracionX = aceleracionX;
    }

    /**
     * @return the aceleracionY
     */
    public double getAceleracionY() {
        return aceleracionY;
    }

    /**
     * @param aceleracionY the aceleracionY to set
     */
    public void setAceleracionY(double aceleracionY) {
        this.aceleracionY = aceleracionY;
    }

}
