package fun_v01;

import java.awt.event.KeyEvent;

/**
 *
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class funControlFLECHAS extends funControl{
    
    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * El constructor de funControlFLECHAS
     * @param jugador El jugador que va a controlar
     */
    public funControlFLECHAS(funSprite jugador) {
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
            case KeyEvent.VK_LEFT: setKeyIzquierda(true); break;
            case KeyEvent.VK_RIGHT: setKeyDerecha(true); break;
            case KeyEvent.VK_UP: setKeyArriba(true); break;
            case KeyEvent.VK_DOWN: setKeyAbajo(true); break;     
            case KeyEvent.VK_SPACE: setKeyEspacio(true); break;
            case KeyEvent.VK_ENTER: setKeyEnter(true); break;            
            case KeyEvent.VK_CONTROL: setKeyCtrl(true); break;
            case KeyEvent.VK_ALT: setKeyAlt(true); break;
            case KeyEvent.VK_ESCAPE: setKeyESC(true); break;           
        }
        actualizar();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_LEFT: setKeyIzquierda(false); break;
            case KeyEvent.VK_RIGHT: setKeyDerecha(false); break;
            case KeyEvent.VK_UP: setKeyArriba(false); break;
            case KeyEvent.VK_DOWN: setKeyAbajo(false); break;
            case KeyEvent.VK_SPACE: setKeyEspacio(false); break;
            case KeyEvent.VK_ENTER: setKeyEnter(false); break;
            case KeyEvent.VK_CONTROL: setKeyCtrl(false); break;
            case KeyEvent.VK_ALT: setKeyAlt(false); break;
            case KeyEvent.VK_ESCAPE: setKeyESC(false); break;
        }
        actualizar();
    }

    @Override
    public boolean moverDerecha() {
        if(isKeyDerecha()) {    
            if(isKeyCtrl()) getJugador().setVelocidadX(30); 
            else getJugador().setVelocidadX(10);           
            getJugador().setFacing(funFacing.DERECHA);
            return true;
        }
        return false;
    }

    @Override
    public boolean moverIzquierda() {
        if(isKeyIzquierda()) {
            if(isKeyCtrl()) getJugador().setVelocidadX(-30); 
            else getJugador().setVelocidadX(-10); 
            getJugador().setFacing(funFacing.IZQUIERDA);
            return true;
        }
        return false;
    }

    @Override
    public boolean moverAbajo() {
        if(isKeyAbajo()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean moverArriba() {
        if(isKeyArriba() && getJugador().getEstaTocando() == funColisiones.PISO) {
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
