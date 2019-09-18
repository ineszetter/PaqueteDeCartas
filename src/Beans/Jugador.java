/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Proyectos
 */
public class Jugador {

    private String nombre;
    private Carta[] manoDeCartas;

    public Jugador(String nombreJugador, Carta[] cartas) {
        nombre = nombreJugador;
        manoDeCartas = cartas;
    }

    public Jugador() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public Carta[] getManoDeCartas() {
        return manoDeCartas;
    }

    public void setManoDeCartas(Carta[] nuevaMano) {
        manoDeCartas = nuevaMano;
    }

}
