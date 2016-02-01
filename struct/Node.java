//Nodo Generico
//Implementacion y retornos de datos correctos
package estructuras;

public class Node <T>{

    //Referencia al siguiente elemento
    //o a NULL si es el ultimo
    Node<T> next;
    T data;

    // Node constructor
    public Node(T dataValue) {
        this.next = null;
        this.data = dataValue;
    }

    // Constructor que incluye el siguiente nodo
    public Node(T dataValue, Node<T> nextValue){

        this.next = nextValue;
        this.data = dataValue;

    }

    public T getData() {
        return this.data;
    }

    public void setData(T dataValue) {
        this.data = dataValue;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> nextValue) {
        this.next = nextValue;
    }
}
