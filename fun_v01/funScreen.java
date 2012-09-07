package fun_v01;

import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Ésta clase define las pantallas que va a tener el juego.
 * Por ejemplo, los juegos generalmetne tiene una pantalla de Menu, una pantalla
 * de gameplay, una pantalla de Créditos, etc. todas con lógicas diferentes.
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public abstract class funScreen extends JPanel{
 
    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    private funGame padre;
    private ArrayList<funBasic> objetos;
    private boolean debug;
    private funTilemap tilemap;
    
    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//

    /*
     * El constructor de funScreen.
     * Se establece que la pantalla por default es invisible, este estado se cambia
     * automaticamente cuando es ejecutada desde un funGame.
     * Se establece que no estará visible el modo debug.
     * Después de que se inicializa la clase, se llama al 'constructor de fun': crear()
     */
    public funScreen() {
        setObjetos(new ArrayList<funBasic>());           
        setLayout(null);
        setVisible(false);
        setDebug(false);
        setFocusable(true);
        setTilemap(null);
        crear();
    }  
    
    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
    * Acá es donde se pondrá la lógica principal de iniciación de la pantalla
    * IMPORTANTE: Esto funciona como un Constructor propio de fun, por lo tanto
    * dentro de lo posible usar este para construir las propiedades de la pantalla
    * y no el constructor de la clase.
    */
    public abstract void crear();
    
    /**
     * Acá es donde se pondrá la lógica principal de verificación de  la pantalla
     * Este método se esta corriendo N cantidad de veces por segundo, por lo tanto
     * acá se establecerían funciones como verificar colisiones, controles presionados,
     * etc.
     */
    public abstract void ejecutor();

    /**
     * Éste método actualizará N cantidad de veces por segundo las propiedades 
     * cambiantes de la pantalla. Generalmente este método no debería ser alterado
     * ni sobreescrito. Para eso está el ejecutor(), que de paso, es llamado también
     * desde actualizar().
     */
    public void actualizar () {
        for (int i = 0; i < getObjetos().size(); i++) {
            getObjetos().get(i).actualizar();
        }
        if(getTilemap() != null){
            for (int i = 0; i < getTilemap().getTiles().size(); i++) {
                getTilemap().getTiles().get(i).actualizar();
            }
        }
        if(!isDebug()) repaint();
        ejecutor();
    }
     
    /**
     * Éste método agrega objetos funBasic a ésta pantalla.
     * @param objeto El objeto a agregar.
     * @return Si lo agregó o no.
     */
    public boolean agregarObjeto(funBasic objeto) {
        int index = getObjetos().indexOf(objeto);
        if (index == -1) {
            objeto.setMadre(this);
            getObjetos().add(objeto);            
            add(objeto);
            return true;
        }
        return false;
    }
    
    /**
     * Éste método agrega objetos funGroup a ésta pantalla.
     * @param objeto El objeto a agregar.
     * @return Si lo agregó o no.
     */
    public boolean agregarGrupo(funGroup grupo) {
        int index = getObjetos().indexOf(grupo);
        if (index == -1) {
            grupo.setMadre(this);
            getObjetos().add(grupo);            
            add(grupo);
            for (funBasic objetoActual : grupo.getObjetos()) {
                add(objetoActual);
                getObjetos().add(objetoActual);
                objetoActual.setMadre(this);
            }       
            return true;
        }
        return false;
    }
    
    /**
     * Éste método elimina objetos funBasic de ésta pantalla.
     * @param objeto El objeto a eliminar.
     * @return Si lo eliminó o no.
     */
    public boolean eliminarObjeto(funBasic objeto) {
        int index = getObjetos().indexOf(objeto);
        if (index != -1) {
            getObjetos().remove(objeto);
            remove(objeto);
            validate();
            repaint();
            return true;
        }
        return false;
    }
    
        /**
     * Éste método elimina objetos funBasic de ésta pantalla.
     * @param objeto El objeto a eliminar.
     * @return Si lo eliminó o no.
     */
    public boolean eliminarGrupo(funGroup grupo) {
        int index = getObjetos().indexOf(grupo);
        if (index != -1) {
            for (funBasic objetoActual : grupo.getObjetos()) {
                grupo.getObjetos().remove(objetoActual);
            }
            getObjetos().remove(grupo);
            remove(grupo);
            validate();
            repaint();
            return true;
        }
        return false;
    }
    
    /**
     * Éste método agrega todos los objetos funTile de un funTilemap a ésta pantalla.
     * @param tilemap El tilemap de donde se obtienen los funTile
     */
    public void agregarTilemap(funTilemap tilemap){ //TODO: RIESGO DE INCOPATIBILIDAD POR FRAGILIDAD
        setTilemap(tilemap);
        ArrayList<funTile> tilesTemp = getTilemap().getTiles();     
                
        int i = 0;
        int yInicial = 0;

        for (int xInicial = 0; xInicial < getTilemap().getAnchoMapa(); xInicial += getTilemap().getAnchoTile()) {
            int tileId = getTilemap().getTiles().get(i).getId();
            getTilemap().getTiles().get(i).setVisible(true);
            getTilemap().getTiles().get(i).setImagen(getTilemap().getTilesImgs().get(tileId));
            getTilemap().getTiles().get(i).setPosX(xInicial);
            getTilemap().getTiles().get(i).setPosY(yInicial);
            //getTilemap().getTiles().get(i).repaint();
            getTilemap().getTiles().get(i).setSeMueve(false);
            getObjetos().add(getTilemap().getTiles().get(i));
            add(getTilemap().getTiles().get(i));
            
            getTilemap().getTiles().get(i).setBounds(xInicial, yInicial, getTilemap().getAnchoTile(), getTilemap().getAltoTile());
            
            i++;
            
            
            if((xInicial + getTilemap().getAnchoTile()) >= getTilemap().getAnchoMapa()) {
                yInicial += getTilemap().getAltoTile();
                xInicial =- getTilemap().getAnchoTile();
            }
            
            if((yInicial + getTilemap().getAltoTile()) > getTilemap().getAltoMapa()) xInicial = getTilemap().getAnchoMapa()+1;
        } 
    }
    
    /**
     * Éste método elimina todos los objetos funTile del funTilemap de ésta pantalla.
     */
    public void eliminarTilemap() {
        if(getTilemap() != null){
            for (int i = 0; i < getTilemap().getTiles().size(); i++) {
                funTile tileActual = getTilemap().getTiles().get(i);
                remove(tileActual);
            }
            setTilemap(null);
        }
    }
    
    /**
     * Éste método revisa si el objeto consultado se salió de los límites de la pantalla
     * @param objeto El objeto consultado
     * @return Si se salió o no
     */
    public boolean fueraDeLimites(funObject objeto) {
        Rectangle r = getBounds();
        r.grow(100, 100);
        if(!r.contains(objeto.getHitbox())) return true;
        else return false;
    }
    
    
    //*****************************MÈTODOS MISC******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * Éste método pinta de primero el objeto deseado en ésta pantalla
     * @param objeto El objeto a sobreponer
     */
    public void pintarTopAdelante(funBasic objeto) {
        setComponentZOrder(objeto, 0);
    }
    
    /**
     * Éste método pinta de primero el tilemap deseado en ésta pantalla
     * @param tilemap El tilemap a sobreponer
     */
    public void pintarTopAdelante(funTilemap tilemap) {
        for (int i = 0; i < tilemap.getTiles().size(); i++) {
            funTile tileActual = tilemap.getTiles().get(i);
            pintarTopAdelante(tileActual);
        }
    }
    
    /**
     * Éste método pinta de último el objeto deseado en ésta pantalla
     * @param objeto El objeto a subponer
     */
    public void pintarTopAtras(funBasic objeto) {
        setComponentZOrder(objeto, getComponentCount()-1);
    }
    
    /**
     * Éste método pinta de último el tilemap deseado en ésta pantalla
     * @param objeto El tilemap a subponer
     */
    public void pintarTopAtras(funTilemap tilemap) {
        for (int i = 0; i < tilemap.getTiles().size(); i++) {
            funTile tileActual = tilemap.getTiles().get(i);
            pintarTopAtras(tileActual);
        }
    }
    
    /**
     * Éste método pinta en la posición Z el objeto deseado en ésta pantalla
     * @param objeto El objeto a sobreponer
     * @param index El índice de la posición Z relativa a los objetos totales de esta pantalla
     */
    public void pintarCustom(funBasic objeto, int index) {
        setComponentZOrder(objeto, index);
    }
    
    /**
     * Éste método pinta en la posición Z el tilemap deseado en ésta pantalla
     * @param tilemap El tilemap a sobreponer
     * @param index El índice de la posición Z relativa a los objetos totales de esta pantalla
     */
    public void pintarCustom(funTilemap tilemap, int index) {
        for (int i = 0; i < tilemap.getTiles().size(); i++) {
            funTile tileActual = tilemap.getTiles().get(i);
            pintarCustom(tileActual, index);
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
     * @return the objetos
     */
    public ArrayList<funBasic> getObjetos() {
        return objetos;
    }

    /**
     * @param objetos the objetos to set
     */
    public void setObjetos(ArrayList<funBasic> objetos) {
        this.objetos = objetos;
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
        for (int i = 0; i < getObjetos().size(); i++) {
            getObjetos().get(i).setDebug(debug);
        }
        if(getTilemap() != null){
            for (int i = 0; i < getTilemap().getTiles().size(); i++) {
                getTilemap().getTiles().get(i).setDebug(debug);
            }
        }
        this.debug = debug;
    }

    /**
     * @return the tilemap
     */
    public funTilemap getTilemap() {
        return tilemap;
    }

    /**
     * @param tilemap the tilemap to set
     */
    public void setTilemap(funTilemap tilemap) {
        this.tilemap = tilemap;
    }

}


