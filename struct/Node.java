//Nodo Generico
//Implementacion y retornos de datos correctos
package struct;

public class Node <T>{

    //Referencia al siguiente elemento
    //o a NULL si es el ultimo
    Node<T> next;
    T data;
    int ID;

    // Node constructor
    public Node(T dataValue) {
        this.next = null;
        this.data = dataValue;
        this.ID = 0;
    }

    // Constructor que incluye el siguiente nodo
    public Node(T dataValue, Node<T> nextValue){

        this.next = nextValue;
        this.data = dataValue;
        this.ID = 0;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public int getID(){
        return this.ID;
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
