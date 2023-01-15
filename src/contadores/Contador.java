/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contadores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Contador implements Runnable {

    private int contador;
    private String nombre;
    private int limite;

    public Contador(String nombre, int limite) {
        this.contador = 0;
        this.nombre = nombre;
        this.limite = limite;
    }

    @Override
    public void run() {
        while (contador <= limite) {
            System.out.println("Hilo " + nombre + ": " + contador);
            contador++;
        }
        System.out.println("Hilo " + nombre + " ya ha acabado");
    }

    public static void main(String[] args) {
        Contador c1 = new Contador("Contador 1", 40);
        Contador c2 = new Contador("Contador 2", 50);
        Contador c3 = new Contador("Contador 3", 60);
        Contador c4 = new Contador("Contador 4", 70);

        Thread r1 = new Thread(c1);
        Thread r2 = new Thread(c2);
        Thread r3 = new Thread(c3);
        Thread r4 = new Thread(c4);

        r1.start();
        r2.start();
        r3.start();
        r4.start();

        try {
            r1.join();
            r2.join();
            r3.join();
            r4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El programa a finalizado");
    }
}
