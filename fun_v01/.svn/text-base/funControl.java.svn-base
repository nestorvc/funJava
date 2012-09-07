package fun_v01;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public abstract class funControl implements KeyListener{
    
    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    private boolean keyW;
    private boolean keyA;
    private boolean keyS;
    private boolean keyD;
    private boolean keyIzquierda;
    private boolean keyDerecha;
    private boolean keyArriba;
    private boolean keyAbajo;
    private boolean keyEspacio;
    private boolean keyEnter;
    private boolean key8;
    private boolean key4;
    private boolean key6;
    private boolean key2;
    private boolean keyCtrl;
    private boolean keyAlt;
    private boolean keyShift;
    private boolean keyESC;
    private boolean keyX; 
    private boolean keyC;  
    private funSprite jugador;
    private boolean pausaOn;
    
    
    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
     * El constructor de funControl
     * @param jugador El jugador que va a controlar
     */
    public funControl(funSprite jugador) {
        setKeyW(false);
        setKeyA(false);
        setKeyS(false);
        setKeyD(false);
        setKeyIzquierda(false);
        setKeyDerecha(false);
        setKeyArriba(false);
        setKeyAbajo(false);
        setKeyEspacio(false);
        setKeyEnter(false);
        setKey8(false);
        setKey4(false);
        setKey6(false);
        setKey2(false);
        setKeyCtrl(false);
        setKeyAlt(false);
        setKeyShift(false);
        setKeyESC(false);
        setKeyX(false);
        setKeyC(false); 
        setJugador(jugador);
        setPausaOn(false);
    }
    
    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * Actualiza los estados de los objetos
     * Acá se actualiza si las teclas están siendo presionadas o no en los diferentes métodos
     */
    public void actualizar(){
        getJugador().setVelocidadX(0);
        getJugador().setVelocidadY(0);
        moverDerecha();
        moverIzquierda();
        moverArriba();
        moverAbajo();
        moverSaltar();
        presionarPausa();
    }
    
    /**
     * Revisa si se está presionando la tecla establecida
     * Solo se le pueden enviar funKeys validos
     * @param tecla El funKey establecido
     * @return Si se está presionando o no
     */
    public boolean estaPresionando(funKeys tecla){
        
        boolean resp = false;        
        
        switch(tecla){
            case W: resp = isKeyW(); break;
            case A: resp = isKeyA(); break;
            case S: resp = isKeyS(); break;
            case D: resp = isKeyD(); break;
            case IZQUIERDA: resp = isKeyIzquierda(); break;
            case DERECHA: resp = isKeyDerecha(); break;
            case ARRIBA: resp = isKeyArriba(); break;
            case ABAJO: resp = isKeyAbajo(); break;
            case ESPACIO: resp = isKeyEspacio(); break;
            case ENTER: resp = isKeyEnter(); break;
            case K8: resp = isKey8(); break;
            case K4: resp = isKey4(); break;
            case K6: resp = isKey6(); break;
            case K2: resp = isKey2(); break;
            case CTRL: resp = isKeyCtrl(); break;
            case ALT: resp = isKeyAlt(); break;
            case SHIFT: resp = isKeyShift(); break;
            case ESC: resp = isKeyESC(); break;
            case X: resp = isKeyX(); break;
            case C: resp = isKeyC(); break;
        }
        return resp;
    }
    
    /**
     * Revisa si no se está tocando alguna tecla
     * @return Si se está tocando o no
     */
    public boolean estaQuieto(){

        if(!isKeyW() &&
           !isKeyA() &&
           !isKeyS() &&
           !isKeyD() &&
           !isKeyIzquierda() &&
           !isKeyDerecha() &&
           !isKeyArriba() &&
           !isKeyAbajo() &&
           !isKeyEspacio() &&
           !isKeyEnter() &&
           !isKey8() &&
           !isKey4() &&
           !isKey6() &&
           !isKey2() &&
           !isKeyCtrl() &&
           !isKeyAlt() &&
           !isKeyShift() &&
           !isKeyESC() &&
           !isKeyX() &&
           !isKeyC()) return true;
        return false;
    }
    
    /**
     * Mueve el personaje para la derecha
     * @return Si el personaje logró moverse o no
     */
    public abstract boolean moverDerecha();
    
    /**
     * Mueve el personaje para la izquierda
     * @return Si el personaje logró moverse o no
     */
    public abstract boolean moverIzquierda();
    
    /**
     * Mueve el personaje para abajo
     * @return Si el personaje logró moverse o no
     */
    public abstract boolean moverAbajo();
    
    /**
     * Mueve el personaje para arriba
     * @return Si el personaje logró moverse o no
     */
    public abstract boolean moverArriba();
    
    /**
     * Hace que el personaje salte.
     * @return Si el personaje logró moverse o no
     */
    public abstract boolean moverSaltar();
    
    /**
     * Activa la pausa
     */
    public  void presionarPausa(){
        //TODO
    }
    
    @Override
    public abstract void keyTyped(KeyEvent ke);

    @Override
    public abstract void keyPressed(KeyEvent ke);
    
    @Override
    public abstract void keyReleased(KeyEvent ke);

    
    
    //******************************GETS-&-SETS******************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
     * @return the keyW
     */
    public boolean isKeyW() {
        return keyW;
    }

    /**
     * @param keyW the keyW to set
     */
    public void setKeyW(boolean keyW) {
        this.keyW = keyW;
    }

    /**
     * @return the keyA
     */
    public boolean isKeyA() {
        return keyA;
    }

    /**
     * @param keyA the keyA to set
     */
    public void setKeyA(boolean keyA) {
        this.keyA = keyA;
    }

    /**
     * @return the keyS
     */
    public boolean isKeyS() {
        return keyS;
    }

    /**
     * @param keyS the keyS to set
     */
    public void setKeyS(boolean keyS) {
        this.keyS = keyS;
    }

    /**
     * @return the keyD
     */
    public boolean isKeyD() {
        return keyD;
    }

    /**
     * @param keyD the keyD to set
     */
    public void setKeyD(boolean keyD) {
        this.keyD = keyD;
    }

    /**
     * @return the keyIzquierda
     */
    public boolean isKeyIzquierda() {
        return keyIzquierda;
    }

    /**
     * @param keyIzquierda the keyIzquierda to set
     */
    public void setKeyIzquierda(boolean keyIzquierda) {
        this.keyIzquierda = keyIzquierda;
    }

    /**
     * @return the keyDerecha
     */
    public boolean isKeyDerecha() {
        return keyDerecha;
    }

    /**
     * @param keyDerecha the keyDerecha to set
     */
    public void setKeyDerecha(boolean keyDerecha) {
        this.keyDerecha = keyDerecha;
    }

    /**
     * @return the keyArriba
     */
    public boolean isKeyArriba() {
        return keyArriba;
    }

    /**
     * @param keyArriba the keyArriba to set
     */
    public void setKeyArriba(boolean keyArriba) {
        this.keyArriba = keyArriba;
    }

    /**
     * @return the keyAbajo
     */
    public boolean isKeyAbajo() {
        return keyAbajo;
    }

    /**
     * @param keyAbajo the keyAbajo to set
     */
    public void setKeyAbajo(boolean keyAbajo) {
        this.keyAbajo = keyAbajo;
    }

    /**
     * @return the keyEspacio
     */
    public boolean isKeyEspacio() {
        return keyEspacio;
    }

    /**
     * @param keyEspacio the keyEspacio to set
     */
    public void setKeyEspacio(boolean keyEspacio) {
        this.keyEspacio = keyEspacio;
    }

    /**
     * @return the keyEnter
     */
    public boolean isKeyEnter() {
        return keyEnter;
    }

    /**
     * @param keyEnter the keyEnter to set
     */
    public void setKeyEnter(boolean keyEnter) {
        this.keyEnter = keyEnter;
    }

    /**
     * @return the key8
     */
    public boolean isKey8() {
        return key8;
    }

    /**
     * @param key8 the key8 to set
     */
    public void setKey8(boolean key8) {
        this.key8 = key8;
    }

    /**
     * @return the key4
     */
    public boolean isKey4() {
        return key4;
    }

    /**
     * @param key4 the key4 to set
     */
    public void setKey4(boolean key4) {
        this.key4 = key4;
    }

    /**
     * @return the key6
     */
    public boolean isKey6() {
        return key6;
    }

    /**
     * @param key6 the key6 to set
     */
    public void setKey6(boolean key6) {
        this.key6 = key6;
    }

    /**
     * @return the key2
     */
    public boolean isKey2() {
        return key2;
    }

    /**
     * @param key2 the key2 to set
     */
    public void setKey2(boolean key2) {
        this.key2 = key2;
    }

    /**
     * @return the keyCtrl
     */
    public boolean isKeyCtrl() {
        return keyCtrl;
    }

    /**
     * @param keyCtrl the keyCtrl to set
     */
    public void setKeyCtrl(boolean keyCtrl) {
        this.keyCtrl = keyCtrl;
    }

    /**
     * @return the keyAlt
     */
    public boolean isKeyAlt() {
        return keyAlt;
    }

    /**
     * @param keyAlt the keyAlt to set
     */
    public void setKeyAlt(boolean keyAlt) {
        this.keyAlt = keyAlt;
    }

    /**
     * @return the keyShift
     */
    public boolean isKeyShift() {
        return keyShift;
    }

    /**
     * @param keyShift the keyShift to set
     */
    public void setKeyShift(boolean keyShift) {
        this.keyShift = keyShift;
    }

    /**
     * @return the ESC
     */
    public boolean isKeyESC() {
        return keyESC;
    }

    /**
     * @param ESC the ESC to set
     */
    public void setKeyESC(boolean keyESC) {
        this.keyESC = keyESC;
    }

    /**
     * @return the X
     */
    public boolean isKeyX() {
        return keyX;
    }

    /**
     * @param X the X to set
     */
    public void setKeyX(boolean keyX) {
        this.keyX = keyX;
    }

    /**
     * @return the C
     */
    public boolean isKeyC() {
        return keyC;
    }

    /**
     * @param C the C to set
     */
    public void setKeyC(boolean keyC) {
        this.keyC = keyC;
    }

    /**
     * @return the jugador
     */
    public funSprite getJugador() {
        return jugador;
    }

    /**
     * @param jugador the jugador to set
     */
    public void setJugador(funSprite jugador) {
        this.jugador = jugador;
    }

    /**
     * @return the pausaOn
     */
    public boolean isPausaOn() {
        return pausaOn;
    }

    /**
     * @param pausaOn the pausaOn to set
     */
    public void setPausaOn(boolean pausaOn) {
        this.pausaOn = pausaOn;
    }

 
    
    
}
