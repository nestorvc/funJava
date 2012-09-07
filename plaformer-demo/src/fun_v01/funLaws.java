package fun_v01;

import java.util.HashMap;

/**
 * Ésta clase define las "leyes naturales" omnipresentes siempre en el juego.
 * Es un Singleton.
 * @author Néstor Villalobos
 */
public class funLaws {

    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    private static funLaws INSTANCIA = null;
    private funControl CONTROLES;
    
    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
     * El constructor de funLaws
     */
    private funLaws() {
        CONTROLES = null;
    }
    
    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
     * Verificador para crear la instancia Singleton una sóla vez
     */
    private static void crearInstancia() {
        if (INSTANCIA == null) { 
            INSTANCIA = new funLaws();
        }
    } 

    /**
     * Ésta es la forma pública de llamar a esta clase.
     * @return El Singleton funLaws
     */
    public static funLaws getFunLaws() {
        crearInstancia();
        return INSTANCIA;
    }
    
    /**
     * Éste método revisa si dos objetos se están tocando en éste momento.
     * Para hacer ésta revisión se usan los Hitbox de los respectivos objetos.
     * Si sí se están tocando, los separa según sus condiciones de colisiones.
     * Generalmente éste método siempre será llamado desde algún ejecutor().
     * @param objeto1 El objeto principal.
     * @param objeto2 El objeto que el principal toca.
     * @return Si lo está tocando o no.
     */
    public boolean existeColisionEntre(funObject objeto1, funObject objeto2){  
        boolean resp = false;  
        
        if(objeto2.isTieneColisiones()){                        
            if(objeto1.getHitbox().intersects(objeto2.getHitbox()))
            {
                resp = objeto1.separar(objeto2);         
            }
        }  
        return resp;
    }

    /**
     * Éste método revisa si un objeto está en contacto con los objetos colisionables de un tilemap.
     * Para hacer ésta revisión se usan los Hitbox de los respectivos objetos.
     * Si sí se están tocando, los separa según sus condiciones de colisiones.
     * Generalmente éste método siempre será llamado desde algún ejecutor().
     * @param objeto1 El objeto principal.
     * @param tilemap1 El tilemap que contiene a los objetos colisionables que el principal toca.
     * @return Si está tocando o no con los objetos colisionables 
     */
    public boolean existeColisionEntre(funObject objeto1, funTilemap tilemap1){        
        boolean resp = false;
        boolean tocaPiso = false;
        objeto1.setEstaTocando(funColisiones.NINGUNA);        
        
        for (int i = 0; i < tilemap1.getTiles().size(); i++) {
            funTile tileActual = tilemap1.getTiles().get(i);
            if(tileActual.isTieneColisiones()){                        
                if(objeto1.getHitbox().intersects(tileActual.getHitbox()))       
                {                        
                    if(objeto1.getHitbox().intersects(tileActual.getRectColisionArriba())) objeto1.setEstaTocando(funColisiones.PISO);                     
                    resp = objeto1.separar(tileActual);
                }               
            }
        }            
        return resp;
    }
    
    /**
     * Éste método revisa si un objeto está en contacto con los objetos colisionables de un funGroup.
     * Para hacer ésta revisión se usan los Hitbox de los respectivos objetos.
     * Si sí se están tocando, los separa según sus condiciones de colisiones.
     * Generalmente éste método siempre será llamado desde algún ejecutor().
     * @param objeto1 El objeto principal.
     * @param grupo1 El grupo que contiene a los objetos colisionables que el principal toca.
     * @return Un HashMap formato <objetoQueToca, boolean> 
     */
    public HashMap existeColisionEntre(funObject objeto1, funGroup grupo1){        
        HashMap resp = new HashMap();   
        
        for (int i = 0; i < grupo1.getObjetos().size(); i++) {
            funObject objetoActual = grupo1.getObjetos().get(i);
            if(objetoActual.isTieneColisiones()){   
                if(objeto1.getHitbox().intersects(objetoActual.getHitbox()))
                {
                    resp.put(objetoActual, true);
                    return resp;        
                }                
            }
        }            
        return resp;
    }

    /**
     * @return the CONTROLES
     */
    public funControl getCONTROLES() {
        return CONTROLES;
    }

    /**
     * @param CONTROLES the CONTROLES to set
     */
    public void setCONTROLES(funControl CONTROLES) {
        this.CONTROLES = CONTROLES;
    }
    
}