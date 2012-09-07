package fun_v01;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Éste objeto crea los spirtes del juego.
 * Ésta será una de las clses principales de fun, ya que los sprites son los 
 * objetos animados y casi siempre controlables por el jugador.
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public abstract class funSprite extends funObject{
    
    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
 
    private HashMap<String,ArrayList<Integer>> animaciones;
    private String aniActual;
    private funFacing facing;
    private String imagenURL;
    private BufferedImage imagen;
    private int anchoMask;
    private int altoMask;
    private int auxMask;
    private int cuadroActual;    
    private int fpsAux;
    private int posXrespawn;
    private int posYrespawn;

    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//
 
    /**
     * El constructor de funSprite.
     * Adicionalmente a los parámetros que se piden, establece varios otros
     * parámetros por default. 
     * Se establece que el sprite está viendo hacia la derecha.
     * Se establece que el sprite será visible.
     * @param ancho Ancho del objeto.
     * @param alto Alto del objeto.
     * @param posX Posición en coordenada X del objeto.
     * @param posY Posición en coordenada Y del objeto.
     * @param imagenURL La dirección en carpeta de donde se encuetra la imagen del sprite
     * De momento fun sólo acepta imágenes con todos los sprites en una sola
     * hilera tipo este: http://goo.gl/dnGrZ
     * Imagenes de sprite en matriz aún no está disponible: http://goo.gl/rlvfh
     * @param anchoMask El ancho de la máscara del sprite (el crop).
     * @param altoMask El alto de la máscara del sprite (el crop).
     */
    public funSprite(int ancho, int alto, int posX, int posY, String imagenURL, int anchoMask, int altoMask) {
        super(ancho, alto, posX, posY);
        setAnchoMask(anchoMask);
        setAltoMask(altoMask);
        setImagenURL(imagenURL);
        setAnimaciones(new HashMap<String, ArrayList<Integer>>());
        setFacing(funFacing.DERECHA);
        setImagen(null);    
        setVisible(true);        
        setAniActual(null);
        setCuadroActual(0);
        crearImagen();        
        setFpsAux(0);
        setPosXrespawn(posX);
        setPosYrespawn(posY);
    }    
        
    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//
  
    /**
     * Éste método agrega una animación al repertorio de animaciones posibles
     * de éste sprite. 
     * @param nombre El nombre de la animación
     * @param cuadrosQueUsa En texto, los cuadros que se usan de la imagen. Se 
     * debe seguir éste formato "#,#,#,#,..."
     * @return 
     */
    public boolean agregarAnimacion(String nombre, String cuadrosQueUsa) {
        if(getAnimaciones().containsKey(nombre)){
            JOptionPane.showMessageDialog(null, "NOTIFICACION: No se ha podido agregar la animación '"+ nombre + "' porque éste nombre ya existe.");
            return false;
        }   
        
        ArrayList<Integer> listaTemp = new ArrayList<Integer>();                
        StringTokenizer st = new StringTokenizer(cuadrosQueUsa,","); 
        while (st.hasMoreTokens())
        {
            try{
                int nTemp = Integer.parseInt(st.nextToken());
                nTemp = nTemp * getAnchoMask();
                listaTemp.add(nTemp);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NOTIFICACION: Los cuadros de la animación '"+ nombre + "' a agregar deben venir en formato '#,#,#,#,...' ");
                return false;
            }               
        }
        getAnimaciones().put(nombre, listaTemp);
        return true;
    }
    
    /**
     * Éste método elimina una animación del repertorio del sprite.
     * @param nombre Nombre de la animación a eliminar.
     * @return Si la eliminó o no.
     */
    public boolean eliminarAnimacion(String nombre) {
        if(!getAnimaciones().containsKey(nombre)){
            JOptionPane.showMessageDialog(null, "NOTIFICACION: No se ha podido eliminar la animación '"+ nombre + "' porque éste nombre no existe.");
            return false;
        }   
        
        getAnimaciones().remove(nombre);
        return true;
    }
    
    /**
     * Éste método corre la animación deseada del repertorio del sprite.
     * La animación corrido es declarada como la Animación Actual.
     * @param nombre Nombre de la animación a correr.
     * @return Si la corre o no.
     */
    public boolean correrAnimacion(String nombre) {
        if(!getAnimaciones().containsKey(nombre)){
            JOptionPane.showMessageDialog(null, "NOTIFICACION: No se ha podido correr la animación '"+ nombre + "' porque éste nombre no existe.");
            return false;
        }   
        
        setAniActual(nombre);
        return true;
    }
    
    /**
     * Convierte la imagen en la ruta URL en una imagen utilizable por fun.
     * Con ésta imagen se declara que existirá una animación por default llamada
     * "idle" que tendrá únicamente el primer cuadro de la imagen.
     * Éste animación se declara como la Animación Actual.
     */
    public void crearImagen() {        
        try {
        BufferedImage imgTemp = null;
        /*String path = getClass().getResource(".").getPath() + getImagenURL();   
        File f = new File(path);*/ //DEBUG
        File f = new File(getImagenURL());
        imgTemp = ImageIO.read(f);
        setImagen(imgTemp); 
        agregarAnimacion("idle", "0");
        setAniActual("idle");
        //repaint();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "NOTIFICACION: El Sprite '" + this + " (" + getImagenURL() +") no pudo ser cargado: " + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NOTIFICACION: " + e);
        }
        
    }
    
    /**
     * Éste método anima la Animación Actual.
     * Se ejecuta automáticamente desde actualizar().
     */
    public void animar(){
        int fps = getMadre().getPadre().getFps();
        int sumaCuadros = 1;
        if(getFpsAux() == fps/2){
            if(getAniActual() != null &&
           !getAnimaciones().isEmpty()){
                ArrayList<Integer> aTemp = getAnimaciones().get(getAniActual());
                sumaCuadros = aTemp.size();
                if(getCuadroActual() >= aTemp.size()) setCuadroActual(0);        
                int i = getCuadroActual();
                setAuxMask(aTemp.get(i));
                i++;
                setCuadroActual(i);
            }
            setFpsAux(0);
        }
        setFpsAux(getFpsAux() + sumaCuadros);
        
    }
    
    /**
     * Éste método detiene la Animación Actual.
     */
    public void detenerAnimacion() {
        setAniActual(null);
    } 
    
    /**
     * Éste método estampa, o pega visualmente, otro sprite a éste sprite.
     * Sirve en casos que queramos añadirle visualmente objetos a éste sprite, 
     * como por ejemplo espadas, trajes, etc.
     * @param sprite El objeto que se va a estampar a éste.
     * @param relX La posición en X de éste objeto relativo a éste.
     * @param relY La posición en Y de éste objeto relativo a éste.
     */
    public void estampa(funSprite sprite, int relX, int relY) {  
        sprite.setPosX(getPosX()+relX);
        sprite.setPosY(getPosY()+relY);
    }
    
    /**
     * Encuentra el centro de éste sprite.
     * @return El centro en X,Y de éste sprite.
     */
    public Point spriteCentro() {
        Point punto = new Point();
        punto.x = getAncho()/2;
        punto.y = getAlto()/2;
        return punto;
    }
    
    /**
     * Éste método reestablece al sprite desde su posición inicial
     * Prácticamente hace un reset del sprite
     */
    public void respawn() {
        setPosX(getPosXrespawn());
        setPosY(getPosYrespawn()); 
        getFisica().resetearConDatosActuales(getPosYrespawn(), getVelocidadY(), getPosXrespawn(), getVelocidadX());
    }
    
    @Override
    public abstract void crear();
    
    @Override
    public abstract void ejecutor();

    @Override
    public void actualizar() {
        //repaint();
        animar();  
        getFisica().aplicarFisica();     
    }
    
    @Override
    public void paint(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
        if(getFacing().equals(funFacing.IZQUIERDA))
            g2d.drawImage(getImagen(), 0, 0, getAncho(), getAlto(), getAnchoMask()+ getAuxMask(), 0, 0 + getAuxMask(), getAltoMask(), null);
        else if((getFacing().equals(funFacing.DERECHA)))
            g2d.drawImage(getImagen(), 0, 0, getAncho(), getAlto(), 0 + getAuxMask() , 0, getAnchoMask() + getAuxMask(), getAltoMask(), null);
        
        if(isDebug()){
            
            Rectangle2D rect = new Rectangle2D.Double(0, 0, getHitbox().getWidth(), getHitbox().getHeight());
            g2d.setStroke(new BasicStroke(2));
            
            if(isTieneColisiones()) g2d.setColor(Color.red);
            else g2d.setColor(Color.blue);
            
            g2d.draw(rect);
        }
               
    }
    
    //******************************GETS-&-SETS******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * @return the facing
     */
    public funFacing getFacing() {
        return facing;
    }

    /**
     * @param facing the facing to set
     */
    public void setFacing(funFacing facing) {
        this.facing = facing;
    }

    /**
     * @return the imagenURL
     */
    public String getImagenURL() {
        return imagenURL;
    }

    /**
     * @param imagenURL the imagenURL to set
     */
    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
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
     * @return the anchoMask
     */
    public int getAnchoMask() {
        return anchoMask;
    }

    /**
     * @param anchoMask the anchoMask to set
     */
    public void setAnchoMask(int anchoMask) {
        this.anchoMask = anchoMask;
    }

    /**
     * @return the altoMask
     */
    public int getAltoMask() {
        return altoMask;
    }

    /**
     * @param altoMask the altoMask to set
     */
    public void setAltoMask(int altoMask) {
        this.altoMask = altoMask;
    }

    /**
     * @return the auxMask
     */
    public int getAuxMask() {
        return auxMask;
    }

    /**
     * @param auxMask the auxMask to set
     */
    public void setAuxMask(int auxMask) {
        this.auxMask = auxMask;
    }

    /**
     * @return the aniActual
     */
    public String getAniActual() {
        return aniActual;
    }

    /**
     * @param aniActual the aniActual to set
     */
    public void setAniActual(String aniActual) {
        this.aniActual = aniActual;
    }

    /**
     * @return the animaciones
     */
    public HashMap<String,ArrayList<Integer>> getAnimaciones() {
        return animaciones;
    }

    /**
     * @param animaciones the animaciones to set
     */
    public void setAnimaciones(HashMap<String,ArrayList<Integer>> animaciones) {
        this.animaciones = animaciones;
    }

    /**
     * @return the cuadroActual
     */
    public int getCuadroActual() {
        return cuadroActual;
    }

    /**
     * @param cuadroActual the cuadroActual to set
     */
    public void setCuadroActual(int cuadroActual) {
        this.cuadroActual = cuadroActual;
    }

    /**
     * @return the fpsAux
     */
    public int getFpsAux() {
        return fpsAux;
    }

    /**
     * @param fpsAux the fpsAux to set
     */
    public void setFpsAux(int fpsAux) {
        this.fpsAux = fpsAux;
    }

    /**
     * @return the posXrespawn
     */
    public int getPosXrespawn() {
        return posXrespawn;
    }

    /**
     * @param posXrespawn the posXrespawn to set
     */
    public void setPosXrespawn(int posXrespawn) {
        this.posXrespawn = posXrespawn;
    }

    /**
     * @return the posYrespawn
     */
    public int getPosYrespawn() {
        return posYrespawn;
    }

    /**
     * @param posYrespawn the posYrespawn to set
     */
    public void setPosYrespawn(int posYrespawn) {
        this.posYrespawn = posYrespawn;
    }

}
