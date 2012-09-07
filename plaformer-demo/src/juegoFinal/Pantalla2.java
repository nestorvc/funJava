package juegoFinal;

import fun_v01.*;


/**
 * La clase que crea y maneja la pantalla 2
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class Pantalla2 extends funScreen {

    //*******************************ATRIBUTOS*******************************//
    //***********************************************************************//
    //***********************************************************************//
    private Player1 jugador1;
    private Player2 jugador2;
    private Escenario escenario;
    private Fondo fondo;
    private Estrellas2 estrellas;
    private int puntaje;
    private Texto texto;
    private funTile puerta;
    private Vida vida;
    private int vidas;

    //******************************MÈTODOS FUN******************************//
    //***********************************************************************//
    //***********************************************************************//
    @Override
    public void crear() {
        setPuntaje(0);
        setVidas(3);
        setEscenario(new Escenario("assets/mapa2.csv"));
        setJugador1(new Player1(16 * 2, 16 * 2, 36, 40, "assets/player1.png", 16, 16));
        setJugador2(new Player2(16 * 3, 18 * 3, 0, 40, "assets/player2.png", 16, 18));
        setFondo(new Fondo(800, 600, 0, 0, "assets/fondo1.png", 600, 400));
        setEstrellas(new Estrellas2());
        setTexto(new Texto());
        setVida(new Vida(32 * 2, 16 * 2, 10, 5, "assets/vidas.png", 32, 16));       
        
        addKeyListener(new funControlWASD(getJugador1()));
        addKeyListener(new funControlFLECHAS(getJugador2()));

        add(getTexto());
        agregarObjeto(getVida());
        agregarObjeto(getJugador1());
        agregarObjeto(getJugador2());
        agregarGrupo(getEstrellas());
        agregarTilemap(getEscenario());
        agregarObjeto(getFondo());
        
        controlPuntaje();
        controlVidas();

        for (funTile tile : getEscenario().getTiles()) {
            if (tile.getId() == 12) setPuerta(tile);
        }
    }

    @Override
    public void ejecutor() {
        controlPuntaje();
        controlVidas();
        controlAnimaciones();
        controlColisiones();
        controlRespawn();
    }

    //*******************************UTILERIAS*******************************//
    //***********************************************************************//
    //***********************************************************************//
    
    /**
     * Controla y actualiza los puntajes
     */
    public void controlPuntaje() {
        getTexto().setText("ESTRELLAS: " + getPuntaje());
    }

    public void controlVidas() {
        switch (getVidas()) {
            case 3:
                vida.correrAnimacion("idle");
                break;
            case 2:
                vida.correrAnimacion("2vidas");
                break;
            case 1:
                vida.correrAnimacion("1vidas");
                break;
            case 0:
                getPadre().ejecutarPantalla(getPadre().getPantallas().get(5));
                break;
        }
    }

    /**
     * Controla y actualiza las animaciones
     */
    public void controlAnimaciones() {
        getJugador1().correrAnimacion("caminar");
        if (((funControlWASD) getKeyListeners()[0]).estaQuieto()) {
            getJugador1().correrAnimacion("idle");
        }

        getJugador2().correrAnimacion("caminar");
        if (((funControlFLECHAS) getKeyListeners()[1]).estaQuieto()) {
            getJugador2().correrAnimacion("idle");
        }
    }

    /**
     * Controla y actualiza las colisiones
     */
    public void controlColisiones() {
        if (funLaws.getFunLaws().existeColisionEntre(getPuerta(), getJugador2())) {
            ((Pantalla3)getPadre().getPantallas().get(2)).setPuntaje(getPuntaje());
            ((Pantalla3)getPadre().getPantallas().get(2)).setVidas(getVidas());
            getPadre().ejecutarPantalla(getPadre().getPantallas().get(2));
        }

        funLaws.getFunLaws().existeColisionEntre(getJugador1(), getEscenario());
        funLaws.getFunLaws().existeColisionEntre(getJugador2(), getEscenario());

        if (getEstrellas().matarObjetoGrupoSiExisteColisionContra(getJugador1())) {
            setPuntaje(getPuntaje() + 1);
        }
        if (getEstrellas().matarObjetoGrupoSiExisteColisionContra(getJugador2())) {
            setPuntaje(getPuntaje() + 1);
        }
    }

    /**
     * Controla y actualiza los respawns de los spirtes cuando mueren
     */
    public void controlRespawn() {
        if (fueraDeLimites(getJugador1())) {
            getJugador1().respawn();
        }
        if (fueraDeLimites(getJugador2())) {
            setVidas(getVidas()-1);
            getJugador2().respawn();            
        }

    }

    //******************************GETS-&-SETS******************************//
    //***********************************************************************//
    //***********************************************************************//
    /**
     * @return the jugador1
     */
    public Player1 getJugador1() {
        return jugador1;
    }

    /**
     * @param jugador1 the jugador1 to set
     */
    public void setJugador1(Player1 jugador1) {
        this.jugador1 = jugador1;
    }

    /**
     * @return the jugador2
     */
    public Player2 getJugador2() {
        return jugador2;
    }

    /**
     * @param jugador2 the jugador2 to set
     */
    public void setJugador2(Player2 jugador2) {
        this.jugador2 = jugador2;
    }

    /**
     * @return the escenario
     */
    public Escenario getEscenario() {
        return escenario;
    }

    /**
     * @param escenario the escenario to set
     */
    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }

    /**
     * @return the fondo
     */
    public Fondo getFondo() {
        return fondo;
    }

    /**
     * @param fondo the fondo to set
     */
    public void setFondo(Fondo fondo) {
        this.fondo = fondo;
    }

    /**
     * @return the estrellas
     */
    public Estrellas2 getEstrellas() {
        return estrellas;
    }

    /**
     * @param estrellas the estrellas to set
     */
    public void setEstrellas(Estrellas2 estrellas) {
        this.estrellas = estrellas;
    }

    /**
     * @return the puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return the texto
     */
    public Texto getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(Texto texto) {
        this.texto = texto;
    }

    /**
     * @return the puerta
     */
    public funTile getPuerta() {
        return puerta;
    }

    /**
     * @param puerta the puerta to set
     */
    public void setPuerta(funTile puerta) {
        this.puerta = puerta;
    }

    /**
     * @return the vida
     */
    public Vida getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(Vida vida) {
        this.vida = vida;
    }

    /**
     * @return the vidas
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * @param vidas the vidas to set
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
}