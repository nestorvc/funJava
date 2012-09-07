package fun_v01;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Ésta clase crea los tiles que componen el tilemap del juego.
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class funTile extends funObject {

    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
    private int id;
    private BufferedImage imagen;
    private int margenColision;
    private Rectangle rectColisionArriba;
    private Rectangle rectColisionAbajo;
    private Rectangle rectColisionIzquierda;
    private Rectangle rectColisionDerecha;

    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//
    /**
     * El constructor de funTile.
     * @param ancho Ancho del objeto.
     * @param alto Alto del objeto.
     * @param posX Posición en coordenada X del objeto.
     * @param posY Posición en coordenada Y del objeto.
     */
    public funTile(int ancho, int alto, int posX, int posY) {
        super(ancho, alto, posX, posY);
        setId(-1);
        setImagen(null);  
        setRectColisionArriba(new Rectangle());
        setRectColisionAbajo(new Rectangle());
        setRectColisionIzquierda(new Rectangle());
        setRectColisionDerecha(new Rectangle());
        setMargenColision(10);
        crear();
    }

    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//
    @Override
    public void crear() {               
    }

    @Override
    public void ejecutor() {
    }

    @Override
    public void actualizar() {

    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(getImagen(), 0, 0, getAncho(), getAlto(), null);
        pintarRectLados(g2d);

        if (isDebug()) {
            Rectangle2D rect = new Rectangle2D.Double(0, 0, getHitbox().getWidth(), getHitbox().getHeight());
            g2d.setStroke(new BasicStroke(2));

            if (isTieneColisiones()) {                  
                g2d.setColor(Color.red);
            } else {
                g2d.setColor(Color.blue);
            }
            g2d.draw(rect);
            
        }
    }
    
    /**
     * Pinta los rectangulos laterales que se usan para detectar colisiones laterales
     * @param g2d El Graphics del objeto
     */
    public void pintarRectLados(Graphics2D g2d) {
        
        Rectangle2D rectArriba = new Rectangle2D.Double(0+getMargenColision(), 0, getHitbox().getWidth()-(getMargenColision()*2), 2);
        Rectangle2D rectAbajo = new Rectangle2D.Double(0+getMargenColision(), getHitbox().getHeight()-4, getHitbox().getWidth()-(getMargenColision()*2), 2);
        Rectangle2D rectIzquierda = new Rectangle2D.Double(0, 0+getMargenColision(), 2, getHitbox().getHeight()-getMargenColision()*2);
        Rectangle2D rectDerecha = new Rectangle2D.Double(getHitbox().getWidth()-4, 0+getMargenColision(), 2, getHitbox().getHeight()-getMargenColision()*2);

        getRectColisionArriba().setBounds((int)getHitbox().getX()+(int)rectArriba.getX(), (int)getHitbox().getY()+(int)rectArriba.getY(), (int)rectArriba.getWidth(), (int)rectArriba.getHeight());
        getRectColisionAbajo().setBounds((int)getHitbox().getX()+(int)rectAbajo.getX(), (int)getHitbox().getY()+(int)rectAbajo.getY(), (int)rectAbajo.getWidth(), (int)rectAbajo.getHeight());
        getRectColisionIzquierda().setBounds((int)getHitbox().getX()+(int)rectIzquierda.getX(), (int)getHitbox().getY()+(int)rectIzquierda.getY(), (int)rectIzquierda.getWidth(), (int)rectIzquierda.getHeight());
        getRectColisionDerecha().setBounds((int)getHitbox().getX()+(int)rectDerecha.getX(), (int)getHitbox().getY()+(int)rectDerecha.getY(), (int)rectDerecha.getWidth(), (int)rectDerecha.getHeight());

        if (isDebug() && isTieneColisiones())
        {
            g2d.setColor(Color.green);                
            g2d.fill(rectArriba);
            g2d.draw(rectArriba);    
            g2d.fill(rectAbajo);
            g2d.draw(rectAbajo);  
            g2d.fill(rectIzquierda);
            g2d.draw(rectIzquierda);  
            g2d.fill(rectDerecha);
            g2d.draw(rectDerecha);
        }
    }

    //******************************GETS-&-SETS******************************//
    //***********************************************************************//
    //***********************************************************************//
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the imagen
     */
    public BufferedImage getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the rectColisionArriba
     */
    public Rectangle getRectColisionArriba() {
        return rectColisionArriba;
    }

    /**
     * @param rectColisionArriba the rectColisionArriba to set
     */
    public void setRectColisionArriba(Rectangle rectColisionArriba) {
        this.rectColisionArriba = rectColisionArriba;
    }

    /**
     * @return the rectColisionAbajo
     */
    public Rectangle getRectColisionAbajo() {
        return rectColisionAbajo;
    }

    /**
     * @param rectColisionAbajo the rectColisionAbajo to set
     */
    public void setRectColisionAbajo(Rectangle rectColisionAbajo) {
        this.rectColisionAbajo = rectColisionAbajo;
    }

    /**
     * @return the rectColisionIzquierda
     */
    public Rectangle getRectColisionIzquierda() {
        return rectColisionIzquierda;
    }

    /**
     * @param rectColisionIzquierda the rectColisionIzquierda to set
     */
    public void setRectColisionIzquierda(Rectangle rectColisionIzquierda) {
        this.rectColisionIzquierda = rectColisionIzquierda;
    }

    /**
     * @return the rectColisionDerecha
     */
    public Rectangle getRectColisionDerecha() {
        return rectColisionDerecha;
    }

    /**
     * @param rectColisionDerecha the rectColisionDerecha to set
     */
    public void setRectColisionDerecha(Rectangle rectColisionDerecha) {
        this.rectColisionDerecha = rectColisionDerecha;
    }

    /**
     * @return the margenColision
     */
    public int getMargenColision() {
        return margenColision;
    }

    /**
     * @param margenColision the margenColision to set
     */
    public void setMargenColision(int margenColision) {
        this.margenColision = margenColision;
    }
}
