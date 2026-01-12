package estructuras;

// Teniendo en cuenta esta estructura de datos de java: 

// class Nodo {
//     int dato;
//     Nodo siguiente;

//     Nodo(int dato) {
//         this.dato = dato;
//         this.siguiente = null;
//     }
// } 

// Implementa un método que recibe un Nodo y que dada una lista enlazada de números, 
// elimine todos los nodos que contengan un número par. 
// No importa que implementes el método que imprime la lista resultante por pantalla. 
// Solamente me interesa el método eliminarPares.

// Ejemplos de uso:

// Si tienes la lista 1 -> 2 -> 3 -> 4 -> 5, deberías eliminar los nodos 
// con los valores 2 y 4, resultando en la lista 1 -> 3 -> 5.

public class ListaEnlazada {

    // Definición de la clase Nodo
    static class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Método para eliminar nodos pares
    public static Nodo eliminarPares(Nodo inicio) {
        // Eliminar todos los nodos pares al principio de la lista
        while (inicio != null && inicio.dato % 2 == 0) {
            inicio = inicio.siguiente;
        }

        // Si la lista está vacía después de eliminar los nodos iniciales
        if (inicio == null) {
            return null;
        }

        // Recorrer la lista y eliminar nodos pares
        Nodo actual = inicio;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato % 2 == 0) {
                actual.siguiente = actual.siguiente.siguiente; // Eliminar el nodo par
            } else {
                actual = actual.siguiente; // Avanzar al siguiente nodo
            }
        }

        return inicio; // Devolver la nueva inicio de la lista
    }

    // Método para imprimir la lista
    public static void imprimirLista(Nodo inicio) {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Crear una lista enlazada: 1 -> 2 -> 3 -> 4 -> 5
        Nodo inicio = new Nodo(1);
        inicio.siguiente = new Nodo(2);
        inicio.siguiente.siguiente = new Nodo(3);
        inicio.siguiente.siguiente.siguiente = new Nodo(4);
        inicio.siguiente.siguiente.siguiente.siguiente = new Nodo(5);

        System.out.print("Lista original: ");
        imprimirLista(inicio);

        // Eliminar los nodos pares
        inicio = eliminarPares(inicio);

        System.out.print("Lista sin nodos pares: ");
        imprimirLista(inicio);
    }
}
