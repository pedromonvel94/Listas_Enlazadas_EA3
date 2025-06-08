import java.util.Scanner;

public class Montoya_Juan_Pedro_EA3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ListaSimple listaSimple = new ListaSimple();
        ListaCircular listaCircular = new ListaCircular();
        ListaDoble listaDoble = new ListaDoble();

        System.out.println("Que tipo de lista deseas manejar (Simple/Circular/Ambas)");
        String tipoLista = scan.nextLine();

        boolean tipoListaValida = true;

        while (tipoListaValida) {
            if (tipoLista.equalsIgnoreCase("simple")) {

                usarSimple(scan, listaSimple, listaDoble);

                listaSimple.mostrarLista();
                listaSimple.ordenarArrayList();
                listaSimple.listaPrimosSimples();

                tipoListaValida = false;

            } else if (tipoLista.equalsIgnoreCase("circular")) {

                usarCircular(scan, listaCircular, listaDoble);

                listaCircular.mostrarLista();
                listaCircular.ordenarArrayList();
                listaCircular.listaPrimosCircular();

                tipoListaValida = false;

            } else if (tipoLista.equalsIgnoreCase("ambas")) {

                System.out.println("Crea tu lista simple");
                usarSimple(scan, listaSimple, listaDoble);
                listaSimple.mostrarLista();

                System.out.println("Crea tu lista circular");
                usarCircular(scan, listaCircular, listaDoble);
                listaCircular.mostrarLista();

                listaSimple.ordenarArrayList();
                listaCircular.ordenarArrayList();

                listaSimple.listaPrimosSimples();
                listaCircular.listaPrimosCircular();

                tipoListaValida = false;
            } else {
                System.out.println("Tipo de lista no válido.");
            }
        }

        boolean respuestaCorrecta = true;

        while (respuestaCorrecta) {
            System.out.println("Deseas imprimir la lista doble que es la union de la simple y la circular? (Y/N)");
            String respuestaUsuario = scan.nextLine();

            if (respuestaUsuario.equalsIgnoreCase("y")) {

                listaDoble.mostrar();
                listaDoble.ordenarArrayList();
                listaDoble.listaEnlazadaPrimosDoble();
                listaDoble.mostrarPrimosDoble();

                respuestaCorrecta = false;
            } else if (respuestaUsuario.equalsIgnoreCase("n")) {

                listaDoble.listaEnlazadaPrimosDoble();
                listaDoble.mostrarPrimosDoble();

                respuestaCorrecta = false;
            } else {
                System.out.println("Coloca una respuesta valida.");
            }
        }

        System.out.println("Ahora hagamos magia, elige un numero ");
        listaDoble.filtrarPrimosMenores(scan);

        scan.close();
    }

    public static void usarSimple(Scanner scan, ListaSimple listaSimple, ListaDoble listaDoble) {
        boolean nuevoNodo = true;

        while (nuevoNodo) {
            System.out.println("Deseas agregar un nuevo nodo? (Y/N)");
            String respuestaUsuario = scan.nextLine();

            if (respuestaUsuario.equalsIgnoreCase("y")) {
                System.out.println("Escribe un numero para el dato");
                int nuevoDato = scan.nextInt();
                scan.nextLine();
                listaSimple.agregarNumeros(nuevoDato);
                listaDoble.agregarNodo(nuevoDato);
            } else if (respuestaUsuario.equalsIgnoreCase("n")) {
                nuevoNodo = false;
            } else {
                System.out.println("Coloca una respuesta correcta");
            }
        }
    }

    public static void usarCircular(Scanner scan, ListaCircular listaCircular, ListaDoble listaDoble) {
        boolean nuevoNodo = true;

        while (nuevoNodo) {
            System.out.println("Deseas agregar un nuevo nodo? (Y/N)");
            String respuestaUsuario = scan.nextLine();

            if (respuestaUsuario.equalsIgnoreCase("y")) {
                System.out.println("Escribe un numero para el dato");
                int nuevoDato = scan.nextInt();
                scan.nextLine();
                listaCircular.agregarNodo(nuevoDato);
                listaDoble.agregarNodo(nuevoDato);
            } else if (respuestaUsuario.equalsIgnoreCase("n")) {
                nuevoNodo = false;
            } else {
                System.out.println("Coloca una respuesta correcta");
            }
        }
    }
}