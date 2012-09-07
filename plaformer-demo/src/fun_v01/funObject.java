package fun_v01;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

/**
 * Esta clase define los objetos 'accionables' de fun.
 * Se separa de funSprite ya que acá pueden entrar otro tipo de objetos que 
 * no necesariamente se usen visualmente en el juego.
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public abstract class funObject extends funBasic {

    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
    private int alto;
    private int ancho;
    private int posX;
    private int posY;
    private Rectangle hitbox;
    private double aceleracionX;
    private double aceleracionY;
    private double arrastre;
    private double maxVelocidadX;
    private double velocidadX;
    private double maxVelocidadY;
    private double velocidadY;
    private double masa;
    private int salud;
    private boolean seMueve;
    private boolean tieneColisiones;
    private funColisiones estaTocando;  
    private funPhysics fisica;

    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//
    /**
     * El constructor de funObject.
     * Adicionalmente a los parámetros que se piden, establece varios otros
     * parámetros por default. 
     * Se establece un Hitbox de proporciones identicas al objeto, esta es la caja 
     * de colisión del objeto.
     * Se establece una aceleraciónX y aceleraciónY de 3.0
     * Se establece un arrastre de 6.0
     * Se establece una velocidadX y velocidadY de 6.0 y 1.0
     * Se establece una maxVelocidadX y maxVelocidadY de 20.0
     * Se establece una masa virtual de 6.0
     * Se establece una salud de 10.
     * Se establece que el objeto se puede mover.
     * Se establece que el objeto provoca colisiones en todos sus lados.
     * Se establece que el objeto en éste momento no está colisionando con nadie.
     * Se establece que está en estado habilitado.
     * @param ancho Ancho del objeto.
     * @param alto Alto del objeto.
     * @param ancho Ancho del objeto.
     * @param alto Alto del objeto.
     * @param posX Posición en coordenada X del objeto.
     * @param posY Posición en coordenada Y del objeto.
     */
    public funObject(int ancho, int alto, int posX, int posY) {
        super();
        this.alto = alto;
        this.ancho = ancho;
        this.posX = posX;
        this.posY = posY;
        setBounds(posX, posY, ancho, alto);
        setHitbox(new Rectangle(posX - 1, posY - 1, ancho + 2, alto + 2));
        setAceleracionX(15.0);
        setAceleracionY(15.0);
        setArrastre(6.0);
        setMaxVelocidadX(30.0);
        setVelocidadX(0.0);
        setMaxVelocidadY(30.0);
        setVelocidadY(0.0);
        setMasa(6.0);
        setSalud(10);
        setSeMueve(true);
        setTieneColisiones(true);
        setEstaTocando(funColisiones.NINGUNA);     
        setFisica(new funPhysics(this, posY, velocidadY, posX, velocidadX));
    }

    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//
    /**
     * Elimina al objeto del funScreen en el cual esté y cancela todos sus estados.
     */
    public boolean matar() {
        setAceleracionX(0);
        setAceleracionY(0);
        setArrastre(0);
        setMaxVelocidadX(0);
        setVelocidadX(0);
        setMaxVelocidadY(0);
        setVelocidadY(0);
        setMasa(0);
        setSalud(0);
        setVisible(false);
        setSeMueve(false);
        setTieneColisiones(false);
        return getMadre().eliminarObjeto(this);
    }

    /**
     * Daña al objeto quitándole 1 punto de vida.
     * Si el objeto llega a <= 0 de vida, se muere.
     */
    public void danar() {
        setSalud(getSalud() - 1);
        if (getSalud() <= 0) {
            matar();
        }
    }    

    /**
     * Éste es el método que separa a éste objeto de otro cuando hay una colisión.
     * Éste método se llama automaticamente en funLaws.revisarColisionesEntre().
     * @param otroObjeto El objeto del cual se va a separar.
     * @return Si se sepaó o no
     */
    public boolean separar(funObject otroObjeto) {

        //Código ajeno pero bueno
        int lapTop, lapBot, lapLeft, lapRight, small, scootX = 0, scootY = 0;

        try {
            lapTop = (otroObjeto.getPosY() + otroObjeto.getAlto()) - getPosY();
            lapBot = (getPosY() + getAlto()) - otroObjeto.getPosY();
            lapLeft = (otroObjeto.getPosX() + otroObjeto.getAncho()) - getPosX();
            lapRight = (getPosX() + getAncho()) - otroObjeto.getPosX();

            small = 999999999;

            //TODO
            if (isTieneColisiones()) {
                if (lapTop < small) {
                    small = lapTop;
                    scootX = 0;
                    scootY = lapTop;
                }
                if (lapBot < small) {
                    small = lapBot;
                    scootX = 0;
                    scootY = lapBot * -1;
                }
                if (lapLeft < small) {
                    small = lapLeft;
                    scootX = lapLeft;
                    scootY = 0;
                }
                if (lapRight < small) {
                    small = lapRight;
                    scootX = lapRight * -1;
                    scootY = 0;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NOTIFICACION: " + e);
            return false;
        }

        setVelocidadY(0);
        setPosX(getPosX() + scootX);
        setPosY(getPosY() + scootY);
        return true;
    }

    /**
     * Éste método revisa si hay una colision en algún lado del objeto
     * @param superficieX La colisión en el lado del objeto
     * @return Si hay colisión o no
     */
    public boolean hayContactoEn(funColisiones superficieX) {
        //TODO
        return true;
    }

    @Override
    public abstract void crear();

    @Override
    public abstract void ejecutor();

    @Override
    public void actualizar() {
    }

    @Override
    public void paint(Graphics g) {
        //TODO
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
        setBounds(getPosX(), getPosY(), getAncho(), alto);
        getHitbox().setBounds(getPosX() - 1, getPosY() - 1, getAncho() + 2, alto + 2);
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
        setBounds(getPosX(), getPosY(), ancho, getAlto());
        getHitbox().setBounds(getPosX() - 1, getPosY() - 1, ancho + 2, getAlto() + 2);
    }

    /**
     * @return the posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(int posX) {
        if (isSeMueve()) {
            this.posX = posX;
            setBounds(posX, getPosY(), getAncho(), getAlto());
            getHitbox().setBounds(posX - 1, getPosY() - 1, getAncho() + 2, getAlto() + 2);
        }
    }

    /**
     * @return the posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(int posY) {
        if (isSeMueve()) {
            this.posY = posY;
            setBounds(getPosX(), posY, getAncho(), getAlto());
            getHitbox().setBounds(getPosX() - 1, posY - 1, getAncho() + 2, getAlto() + 2);
        }
    }

    /**
     * @return the hitbox
     */
    public Rectangle getHitbox() {
        return hitbox;
    }

    /**
     * @param hitbox the hitbox to set
     */
    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
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
     * @return the arrastre
     */
    public double getArrastre() {
        return arrastre;
    }

    /**
     * @param arrastre the arrastre to set
     */
    public void setArrastre(double arrastre) {
        this.arrastre = arrastre;
    }

    /**
     * @return the masa
     */
    public double getMasa() {
        return masa;
    }

    /**
     * @param masa the masa to set
     */
    public void setMasa(double masa) {
        this.masa = masa;
    }

    /**
     * @return the maxVelocidadX
     */
    public double getMaxVelocidadX() {
        return maxVelocidadX;
    }

    /**
     * @param maxVelocidadX the maxVelocidadX to set
     */
    public void setMaxVelocidadX(double maxVelocidadX) {
        this.maxVelocidadX = maxVelocidadX;
    }

    /**
     * @return the salud
     */
    public int getSalud() {
        return salud;
    }

    /**
     * @param salud the salud to set
     */
    public void setSalud(int salud) {
        this.salud = salud;
    }

    /**
     * @return the seMueve
     */
    public boolean isSeMueve() {
        return seMueve;
    }

    /**
     * @param seMueve the seMueve to set
     */
    public void setSeMueve(boolean seMueve) {
        this.seMueve = seMueve;
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
     * @return the tieneColisiones
     */
    public boolean isTieneColisiones() {
        return tieneColisiones;
    }

    /**
     * @param tieneColisiones the tieneColisiones to set
     */
    public void setTieneColisiones(boolean tieneColisiones) {
        this.tieneColisiones = tieneColisiones;
    }

    /**
     * @return the estaTocando
     */
    public funColisiones getEstaTocando() {
        return estaTocando;
    }

    /**
     * @param estaTocando the estaTocando to set
     */
    public void setEstaTocando(funColisiones colision) {
        this.estaTocando = colision;
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

    /**
     * @return the maxVelocidadY
     */
    public double getMaxVelocidadY() {
        return maxVelocidadY;
    }

    /**
     * @param maxVelocidadY the maxVelocidadY to set
     */
    public void setMaxVelocidadY(double maxVelocidadY) {
        this.maxVelocidadY = maxVelocidadY;
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
     * @return the fisica
     */
    public funPhysics getFisica() {
        return fisica;
    }

    /**
     * @param fisica the fisica to set
     */
    public void setFisica(funPhysics fisica) {
        this.fisica = fisica;
    }
}
