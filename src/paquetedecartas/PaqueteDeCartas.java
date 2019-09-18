/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetedecartas;

import Beans.Carta;
import Beans.Jugador;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Proyectos
 */
public class PaqueteDeCartas {

    // Propiedades globales de la clase
    private Carta[] paquete; // arreglo de objetos "Carta"
    private static Jugador[] jugadores; //arreglo que contiene las propiedades de los jugadores
    private int cartaActual; // subíndice de la siguiente carta a repartir (0 hasta 51)
    private static final int NUMERO_DE_CARTAS = 52; // número constante de cartas
    static Dictionary valorDeCartas = new Hashtable();
    private static final Random NUMEROS_ALEATORIOS = new Random();

    // el constructor llena el paquete de cartas
    public PaqueteDeCartas() {

        String[] caras = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez",
            "Joker", "Quina", "Rey"};
        String[] palos = {"Corazones", "Diamantes", "Treboles", "Espadas"};

        paquete = new Carta[NUMERO_DE_CARTAS];
        cartaActual = 0;

        for (int cuenta = 0; cuenta < paquete.length; cuenta++) {

            paquete[cuenta] = new Carta(caras[cuenta % 13], palos[cuenta / 13]);
            //El cálculo con la operacion modular % siempre produce un valor del 0 al 12
            //El cálculo con la division normal / produce un valor del 0 al 3
        }
        asignarValorDeCartas();
    }

    public void barajar() {

        //Después de barajar la reparición debe empezar en la posición 0
        cartaActual = 0;

        //para cada carta selecciona otra carta aleatoria (0 al 51) y las intercambia
        for (int primera = 0; primera < paquete.length; primera++) {

            int segunda = NUMEROS_ALEATORIOS.nextInt(NUMERO_DE_CARTAS);

            // intercambia carta actual con la carta seleccionada al azar
            Carta temporal = paquete[primera];
            paquete[primera] = paquete[segunda];
            paquete[segunda] = temporal;

        }
    }

    public Carta repartirCarta() {
        if (cartaActual < paquete.length) {
            return paquete[cartaActual++]; // devuelve la carta actual en el arreglo
        } else {
            return null; //indicamos que ya se repartieron todas las cartas
        }
    }

    public final void asignarValorDeCartas() {

        valorDeCartas.put("Quina de Diamantes", 12);
        valorDeCartas.put("Dos de Treboles", 2);
        valorDeCartas.put("Cinco de Espadas", 5);
        valorDeCartas.put("Dos de Corazones", 2);
        valorDeCartas.put("Cuatro de Espadas", 4);
        valorDeCartas.put("Ocho de Corazones", 8);
        valorDeCartas.put("Rey de Diamantes", 13);
        valorDeCartas.put("Tres de Diamantes", 3);
        valorDeCartas.put("Seis de Espadas", 6);
        valorDeCartas.put("Ocho de Diamantes", 8);
        valorDeCartas.put("Cuatro de Corazones", 4);
        valorDeCartas.put("Ocho de Espadas", 8);
        valorDeCartas.put("Cuatro de Treboles", 4);
        valorDeCartas.put("Quina de Treboles", 12);
        valorDeCartas.put("Dos de Diamantes", 2);
        valorDeCartas.put("Cinco de Diamantes", 5);
        valorDeCartas.put("Nueve de Corazones", 9);
        valorDeCartas.put("Nueve de Diamantes", 9);
        valorDeCartas.put("Joker de Treboles", 11);
        valorDeCartas.put("Seis de Corazones", 6);
        valorDeCartas.put("As de Espadas", 1); //TODO: el valor puede ser 1 u 11
        valorDeCartas.put("Cuatro de Diamantes", 4);
        valorDeCartas.put("Ocho de Treboles", 8);
        valorDeCartas.put("Rey de Treboles", 13);
        valorDeCartas.put("Diez de Diamantes", 10);
        valorDeCartas.put("Siete de Espadas", 7);
        valorDeCartas.put("As de Treboles", 1);
        valorDeCartas.put("Joker de Diamantes", 11);
        valorDeCartas.put("Rey de Espadas", 13);
        valorDeCartas.put("Rey de Corazones", 13);
        valorDeCartas.put("Nueve de Treboles", 9);
        valorDeCartas.put("Seis de Treboles", 6);
        valorDeCartas.put("Siete de Corazones", 7);
        valorDeCartas.put("Tres de Corazones", 3);
        valorDeCartas.put("Tres de Espadas", 3);
        valorDeCartas.put("Diez de Espadas", 10);
        valorDeCartas.put("Quina de Corazones", 12);
        valorDeCartas.put("Seis de Diamantes", 6);
        valorDeCartas.put("Quina de Espadas", 12);
        valorDeCartas.put("Diez de Corazones", 10);
        valorDeCartas.put("Siete de Diamantes", 7);
        valorDeCartas.put("Diez de Treboles", 10);
        valorDeCartas.put("Cinco de Treboles", 5);
        valorDeCartas.put("Joker de Corazones", 11);
        valorDeCartas.put("Joker de Espadas", 11);
        valorDeCartas.put("As de Diamantes", 1);
        valorDeCartas.put("Siete de Treboles", 7);
        valorDeCartas.put("As de Corazones", 1);
        valorDeCartas.put("Cinco de Corazones", 5);
        valorDeCartas.put("Nueve de Espadas", 9);
        valorDeCartas.put("Dos de Espadas", 2);
        valorDeCartas.put("Tres de Treboles", 3);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PaqueteDeCartas miPaqueteDeCartas = new PaqueteDeCartas();
        miPaqueteDeCartas.barajar();

        System.out.println("=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=| ");
        System.out.println("|   Bienvenido al juego        = ");
        System.out.println("=     M A N O T A Z O          | ");
        System.out.println("|=|=|=|=|=|=|=|=|=|=|=|=|=|=|=|= ");

        Scanner lector = new Scanner(System.in);
        int numeroDeJugadores;
        int cartasDelJuego;
        int valorDeLaMano = 0;

        System.out.println("Ingrese número de jugadores: ");
        numeroDeJugadores = Integer.parseInt(lector.nextLine());
        System.out.println("Ingrese número de cartas: ");
        cartasDelJuego = Integer.parseInt(lector.nextLine());

        jugadores = new Jugador[numeroDeJugadores];

        if (numeroDeJugadores < 5 && cartasDelJuego <= NUMERO_DE_CARTAS) {
            for (int j = 0; j < numeroDeJugadores; j++) {
                Carta[] manoActual = new Carta[cartasDelJuego];

                Jugador jugadorActual = new Jugador();
                System.out.println("Escribe el nombre del jugador: ");
                jugadorActual.setNombre(lector.nextLine());

                for (int i = 0; i < manoActual.length; i++) {
                    manoActual[i] = miPaqueteDeCartas.repartirCarta();
                }

                jugadorActual.setManoDeCartas(manoActual);

//                for (Carta carta : manoActual) {
//                    valorDeLaMano = Integer.parseInt((String) valorDeCartas.get(carta.toString()));
//                }
                jugadores[j] = jugadorActual;
                System.out.println("El nombre del jugador es: " + jugadores[j].getNombre());
                System.out.println("Su mano tiene: " + Arrays.toString(jugadores[j].getManoDeCartas()));
                System.out.println("Su valor es: " + String.valueOf(valorDeLaMano));
            }
        } else {
            repartirRestantes(miPaqueteDeCartas);
            System.out.println("El número de jugadores debe ser menor a 5. ");
            System.out.println("El número de cartas debe ser menor a " + NUMERO_DE_CARTAS + ".");
            System.out.println("Fin de la ejecución. ");
            System.exit(0);
        }

    }

    private static void repartirRestantes(PaqueteDeCartas miPaqueteDeCartas) {
        //Cuidado de que no sean mayor a 4
        for (int i = 1; i <= 52; i++) {

            System.out.printf("%-25s", miPaqueteDeCartas.repartirCarta());

            if (i % 4 == 0) {
                System.out.println();
            }
        }
    }

}
