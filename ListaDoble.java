public class ListaDoble {
    Nodo cabeza, cola;

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
    }

    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("");
    }
}
