public class ListaCircular {
    Nodo cabeza;
    Nodo cola;

    public class Nodo {
        int numero;
        Nodo siguiente;

        public Nodo(int numero) {
            this.numero = numero;
            this.siguiente = null;
        }
    }

    public boolean esVacia() {
        return cabeza == null;
    }

    public void agregarNodo(int numero) {
        Nodo nuevoNodo = new Nodo(numero);

        if (esVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;

            cola.siguiente = cabeza;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza;

            cola = nuevoNodo;
        }
    }

    public void mostrarLista() {
        if (esVacia()) {
            System.out.println("La lista circular está vacía.");
            return;
        }

        Nodo actual = cabeza;
        System.out.println("Contenido de la lista circular:");
        do {
            System.out.print(actual.numero + " -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(regresa a la cabeza)");
    }
}
