/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fun_v01;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Ésta clase agrupa a varios objetos de tipo funObject para manipularlos juntos
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public abstract class funGroup extends funBasic{
    
    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    private ArrayList<funObject> objetos;  
    
    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
     * El constructor de funGroup
     */
    public funGroup() {
        super();
        setObjetos(new ArrayList<funObject>());
        crear();
    }

    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
     * Agrega un objeto a la lista de este grupo
     * @param objeto El objeto a agregar
     * @return Si lo agregó o no
     */
    public boolean agregarObjeto(funObject objeto){
        return getObjetos().add(objeto);
    }
    
    /**
     * Elimina un objeta de la lista de este grupo
     * @param objeto El objeto a eliminar
     * @return Si lo eliminó o no
     */
    public boolean eliminarObjeto(funObject objeto){
        objeto.matar();
        return getObjetos().remove(objeto);
    }
    
    /**
     * Mata un objeto de este grupo si colisiona contra el objeto establecido
     * @param objeto1 El objeto establecido
     */
    public boolean matarObjetoGrupoSiExisteColisionContra(funObject objeto1) {
        boolean resp = false;
        HashMap h = funLaws.getFunLaws().existeColisionEntre(objeto1,this);        
        
        if(h.values().contains(true)){
            Object[] tempO = h.keySet().toArray();
            funObject objetoActual = (funObject)tempO[0];            
            eliminarObjeto(objetoActual);
            return true;
        }
        return resp;
    }
    
    @Override
    public abstract void crear();

    @Override
    public abstract void ejecutor();

    @Override
    public void actualizar() {
        for (funObject objeto : getObjetos()) {
            objeto.actualizar();
        }
    }

    @Override
    public void paint(Graphics g) {
        
    }
    
    //******************************GETS-&-SETS******************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
     * @return the objetos
     */
    public ArrayList<funObject> getObjetos() {
        return objetos;
    }

    /**
     * @param objetos the objetos to set
     */
    public void setObjetos(ArrayList<funObject> objetos) {
        this.objetos = objetos;
    }

}
