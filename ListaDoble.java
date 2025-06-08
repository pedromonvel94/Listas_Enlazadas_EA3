import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListaDoble {
    ArrayList<Integer> listaDobleAL = new ArrayList<>();
    ArrayList<Integer> numerosPrimosDoble = new ArrayList<>();
    ArrayList<Integer> numerosMenoresUsuario = new ArrayList<>();

    Nodo cabeza, cola;
    Nodo cabezaPrimos, colaPrimos;

    public class Nodo {
        int dato;
        Nodo siguiente, anterior;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = this.anterior = null;
        }
    }

    public void agregarNodo(int dato) {
        Nodo nuevoNodo = new Nodo(dato); // Instancio "Creo un objeto" haciendo uso del dato que viene de la clase nodo

        if (cabeza == null) { // Este if solo sucede para el PRIMER NODO
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }

        listaDobleAL.add(dato);

        if (esPrimo(dato)) {
            numerosPrimosDoble.add(dato);
        }
    }

    public void ordenarArrayList() {
        for (int i = 0; i < listaDobleAL.size() - 1; i++) {
            for (int j = 0; j < listaDobleAL.size() - 1 - i; j++) {
                if (listaDobleAL.get(j) > listaDobleAL.get(j + 1)) {
                    int temporal = listaDobleAL.get(j);
                    listaDobleAL.set(j, listaDobleAL.get(j + 1));
                    listaDobleAL.set(j + 1, temporal);
                }
            }
        }
        System.out.println("ArrayList Lista Doble Ordenados: " + listaDobleAL);
    }

    public static boolean esPrimo(int dato) {
        if (dato <= 1) {
            return false;
        }

        for (int i = 2; i * i < dato; i++) {
            if (dato % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void listaEnlazadaPrimosDoble() {
        cabezaPrimos = null;
        colaPrimos = null;

        for (int i = 0; i < numerosPrimosDoble.size(); i++) {
            Nodo nuevoNodoPrimo = new Nodo(numerosPrimosDoble.get(i));

            if (cabezaPrimos == null) {
                cabezaPrimos = nuevoNodoPrimo;
                colaPrimos = nuevoNodoPrimo;
            } else {
                colaPrimos.siguiente = nuevoNodoPrimo;
                nuevoNodoPrimo.anterior = colaPrimos;
                colaPrimos = nuevoNodoPrimo;
            }
        }
    }

    public void filtrarPrimosMenores(Scanner scan) {
        int numeroUsuario = scan.nextInt();

        for (int i = 0; i < numerosPrimosDoble.size(); i++) {
            if (numerosPrimosDoble.get(i) <= numeroUsuario) {
                numerosMenoresUsuario.add(numerosPrimosDoble.get(i));
            }
        }

        Collections.sort(numerosMenoresUsuario);

        System.out.println("Números primos menores o iguales a " + numeroUsuario + ": " + numerosMenoresUsuario);
    }

    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("Null");
    }

    public void mostrarPrimosDoble() {
        Nodo actualPrimos = cabezaPrimos;

        System.out.print("Numeros Primos que colocaste en ambas listas: [ ");
        while (actualPrimos != null) {
            System.out.print(actualPrimos.dato + " ");
            actualPrimos = actualPrimos.siguiente;
        }
        System.out.print("]");
        System.out.print("");
    }
}
