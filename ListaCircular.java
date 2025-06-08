import java.util.ArrayList;

public class ListaCircular {
    ArrayList<Integer> listaCircularAL = new ArrayList<>();
    ArrayList<Integer> numerosPrimosCircular = new ArrayList<>();

    Nodo cabeza;
    Nodo cola;

    public class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public boolean esVacia() {
        return cabeza == null;
    }

    public void agregarNodo(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (esVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;

            cola.siguiente = cabeza;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza;

            cola = nuevoNodo;
        }

        listaCircularAL.add(dato);

        if (esPrimo(dato)) {
            numerosPrimosCircular.add(dato);
        }
    }

    public void ordenarArrayList() {
        for (int i = 0; i < listaCircularAL.size() - 1; i++) {
            for (int j = 0; j < listaCircularAL.size() - 1 - i; j++) {
                if (listaCircularAL.get(j) > listaCircularAL.get(j + 1)) {
                    int temporal = listaCircularAL.get(j);
                    listaCircularAL.set(j, listaCircularAL.get(j + 1));
                    listaCircularAL.set(j + 1, temporal);
                }
            }
        }
        System.out.println("ArrayList Circular Ordenado: " + listaCircularAL);
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

    public void listaPrimosCircular() {
        System.out.println("Numeros Primos que colocaste en la lista Circular: " + numerosPrimosCircular);
    }

    public void mostrarLista() {
        if (esVacia()) {
            System.out.println("La lista circular está vacía.");
            return;
        }

        Nodo actual = cabeza;
        System.out.println("Contenido de la lista circular:");
        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(regresa a la cabeza)");
    }
}
