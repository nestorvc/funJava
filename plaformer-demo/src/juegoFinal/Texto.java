package juegoFinal;

import javax.swing.JLabel;

/**
 * Clase auxiliar creada para el uso de texto
 * @author Marvin Gonzalez, Kevin Gutierrez, Néstor Villalobos
 */
public class Texto extends JLabel{

    public Texto() {
        setFont(new java.awt.Font("Lucida Grande", 1, 13));
        setForeground(new java.awt.Color(255, 255, 255));
        setBounds(90, 10, 400, 20);
    }
}
