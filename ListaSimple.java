public class ListaSimple {
    Nodo cabeza; // Creo una referencia a la cabeza de la lista

    public class Nodo { // Creo el nodo el cual tiene 2 atributos int dato y Nodo siguiente el cual es
                        // igual a null
        int dato;
        Nodo siguiente;

        public Nodo(int dato) { // Lo que hice aqui fue crear el metodo constructor Nodo en el cual recibo el
                                // parameto int dato y defino que dato es igual a dato
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public void agregarNumeros(int dato) {
        Nodo nodo = new Nodo(dato); // Aqui es donde se van a crear los nuevos nodos

        nodo.siguiente = cabeza;
        cabeza = nodo;
        // Lo que hago aqui es que estoy diciendo que el nuevo nodo que cree apunte como
        // siguiente a cabeza, cuando pasa por primera vez cabeza = null, entonces es
        // como decir "nodo.siguiente = null;" el siguiente de mi nuevo nodo va a ser
        // null, ahora si agrego un segundo nodo ya cabeza no vale null sino que vale el
        // valor del nodo que cree en el paso anterior y digo que el nuevo nodo apunte a
        // mi nodo anteriormente creado
    }

    public void mostrarLista() {
        Nodo actual = cabeza;

        System.out.println("Contenido de la lista:");
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("Null");
    }
}