/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fun_v01;

import java.io.*;
import java.util.ArrayList;

/**
 * Esta clase sirve para hacer los archivos guardados de los avances del juego creado
 * Básicamente lo que hace es guardar todo el objeto funGame que contiene al resto de objetos
 * para que pueda ser recuperado exactamente cuando se quiera.
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class funGuardar {

    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    private ArrayList<String> juegosGuardados;

    //******************************CONSTRUCTOR******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * El constructor de funGuardar
     */
    public funGuardar(){
        setJuegosGuardados(new ArrayList());
    }
    
    /**
     * Verufica que el nombre del archivo buscado exista
     * @param nombreArchivo El nombre del archivo
     * @return Si existe o no
     */
    public boolean verificarNombre(String nombreArchivo) {
        for (int i = 0; i < juegosGuardados.size(); i++) {
            String x = juegosGuardados.get(i);
            int y = i;
            if (x.equals(nombreArchivo)) {
                return true;
            }
        }
        return false;
    }
    
    //*****************************OTROS MÈTODOS*****************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * Muestra los archivos guardados que existen en la 'memoria'
     */
    public void mostrarArchivos(){
        String lista = null;
        for (int i = 0; i < juegosGuardados.size(); i++) {
       String x =    juegosGuardados.get(i);
      lista = lista +("\n") + x;
            
        }
        System.out.println(lista);
    }

    /**
     * Guarda un archivo
     * @param nombreArchivo Nombre del archivo
     * @param objeto El archivo u objeto que va a guardar
     * @return Si lo guardó o no
     */
    public boolean guardarEnArchivo(String nombreArchivo, Object objeto) {
        /*
         * 1 - conectese 2 - procese 3 - cierre
         */
        try {
            // conectese...
            FileOutputStream fos = new FileOutputStream(nombreArchivo);
            ObjectOutputStream flujoSalida = new ObjectOutputStream(fos);
            //procese
            flujoSalida.writeObject(objeto);
            //cierre
            flujoSalida.close();
            if(!verificarNombre(nombreArchivo))
            getJuegosGuardados().add(nombreArchivo);
            else{
                getJuegosGuardados().remove(nombreArchivo);
                getJuegosGuardados().add(nombreArchivo);
            }

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Carga un archivo guardado
     * @param nombreArchivo El nombre del archivo
     * @return El archivo
     */
    public Object cargarArchivo(String nombreArchivo) {
        Object objeto = null;
        try {
            // conectese...
            FileInputStream fos = new FileInputStream(nombreArchivo);
            ObjectInputStream flujoEntrada = new ObjectInputStream(fos);
            //procese
            objeto = flujoEntrada.readObject();
            //cierre
            flujoEntrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objeto;

    }
    
    //******************************GETS-&-SETS******************************//
    //***********************************************************************//
    //***********************************************************************//

    /**
     * @return the juegosGuardados
     */
    public ArrayList<String> getJuegosGuardados() {
        return juegosGuardados;
    }

    /**
     * @param juegosGuardados the juegosGuardados to set
     */
    public void setJuegosGuardados(ArrayList<String> juegosGuardados) {
        this.juegosGuardados = juegosGuardados;
    }
}
