import java.util.ArrayList;

public class ListaSimple {
    ArrayList<Integer> listaSimpleAL = new ArrayList<>();
    ArrayList<Integer> numerosPrimosSimple = new ArrayList<>();

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

        listaSimpleAL.add(dato);

        if (esPrimo(dato)) {
            numerosPrimosSimple.add(dato);
        }
    }

    public void ordenarArrayList() {
        // Repetimos el proceso tantas veces como elementos haya en la lista menos 1
        for (int i = 0; i < listaSimpleAL.size() - 1; i++) {

            // En cada pasada comparamos pares de elementos
            for (int j = 0; j < listaSimpleAL.size() - 1 - i; j++) {

                // Si el de la izquierda es mayor que el de la derecha, los intercambiamos
                if (listaSimpleAL.get(j) > listaSimpleAL.get(j + 1)) {
                    int temporal = listaSimpleAL.get(j);
                    listaSimpleAL.set(j, listaSimpleAL.get(j + 1));
                    listaSimpleAL.set(j + 1, temporal); // ponemos el mayor a la derecha
                }
            }
        }
        System.out.println("ArrayList Simple Ordenado: " + listaSimpleAL);
    }

    public static boolean esPrimo(int dato) { // Lo puse boolean para que la respuesta sea un true o un false
        if (dato <= 1) {
            return false;
        }

        for (int i = 2; i * i <= dato; i++) {
            if (dato % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void listaPrimosSimples() {
        System.out.println("Numeros Primos que colocaste en la lista Simple: " + numerosPrimosSimple);
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