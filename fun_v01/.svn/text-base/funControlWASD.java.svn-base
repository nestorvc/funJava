/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fun_v01;

import java.awt.event.KeyEvent;

/**
 *
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class funControlWASD extends funControl{

    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * El constructor de funControlWASD
     * @param jugador El jugador que va a controlar
     */
    public funControlWASD(funSprite jugador) {
        super(jugador);
    }    
    
    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_W: setKeyW(true); break;
            case KeyEvent.VK_A: setKeyA(true); break;
            case KeyEvent.VK_S: setKeyS(true); break;
            case KeyEvent.VK_D: setKeyD(true); break;            
            case KeyEvent.VK_SPACE: setKeyEspacio(true); break;
            case KeyEvent.VK_ENTER: setKeyEnter(true); break;            
            case KeyEvent.VK_ALT: setKeyAlt(true); break;
            case KeyEvent.VK_SHIFT: setKeyShift(true); break;
            case KeyEvent.VK_ESCAPE: setKeyESC(true); break;
        }
        actualizar();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_W: setKeyW(false); break;
            case KeyEvent.VK_A: setKeyA(false); break;
            case KeyEvent.VK_S: setKeyS(false); break;
            case KeyEvent.VK_D: setKeyD(false); break;
            case KeyEvent.VK_SPACE: setKeyEspacio(false); break;
            case KeyEvent.VK_ENTER: setKeyEnter(false); break;            
            case KeyEvent.VK_ALT: setKeyAlt(false); break;
            case KeyEvent.VK_SHIFT: setKeyShift(false); break;
            case KeyEvent.VK_ESCAPE: setKeyESC(false); break;
        }
        actualizar();
    }

    @Override
    public boolean moverDerecha() {
        if(isKeyD()) {    
            if(isKeyShift()) getJugador().setVelocidadX(30); 
            else getJugador().setVelocidadX(10);           
            getJugador().setFacing(funFacing.DERECHA);
            return true;
        }
        return false;
    }

    @Override
    public boolean moverIzquierda() {
        if(isKeyA()) {
            if(isKeyShift()) getJugador().setVelocidadX(-30); 
            else getJugador().setVelocidadX(-10); 
            getJugador().setFacing(funFacing.IZQUIERDA);
            return true;
        }
        return false;
    }

    @Override
    public boolean moverAbajo() {
        if(isKeyS()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean moverArriba() {
        if(isKeyW() && getJugador().getEstaTocando() == funColisiones.PISO) {
            getJugador().setPosY(getJugador().getPosY() - 2);
            getJugador().setVelocidadY(50);
            return true;
        }
        return false;
    }

    @Override
    public boolean moverSaltar() {
        if(isKeyEspacio()) {
            return true;
        }
        return false;
    }
 
}
