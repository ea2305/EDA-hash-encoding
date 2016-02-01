package structs.simple_list;

import struct.*;
import java.util.*;
 /*
*   Lista generica, fase de pruebas para clases
*   que implementen de Comparable
*   @author Elihu Alejandro Cruz Albores
*   @version 1.5
*/
package estructuras;

public class ListaSimple<T extends Comparable<T>> implements Comparable<ListaSimple<T>>{

    // Referencia  a el node raiz o la cabeza de la lista.
    private Node <T> head;
    private int listCount;
    private char ABC;

    // constructor
    // Se asigna la cabeza a un nodo nulo y el contador a 0
    public ListaSimple() {
        head = new Node<T>(null);
        listCount = 0;
        this.ABC = ' ';
    }

    public void setABC(char ABC){
      this.ABC = ABC;
    }

    public char getABC(){
      return this.ABC;
    }

    // Agrega el nodo al final de la lista.
    public void add(T data){

        Node<T> Temp = new Node<T>(data);

        Node<T> Current = head;
        // Se tiene que posicionar en la cabeza para poder recorrer la lista y llegar al fin

        while (Current.getNext() != null) {
            Current = Current.getNext();
        }
        // Asignamos el nuevo nodo como "next"
        Temp.setPrev(Current);
        Current.setNext(Temp);
        listCount++;// incrementamos el contador de nodos
    }

    // Regresa el nodo en la posición indicada por index
    public Node<T> get(int index){
        if (index <= 0)
            return null;

        Node<T> Current = head.getNext();

        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return null;
             Current = Current.getNext();
        }
        return Current;
    }

    // remueve el elemento en la posición indicada
    public boolean remove(int index){
        //
        if (index < 1 || index > size())
            return false;

        Node<T> Current = head;

        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return false;
             Current = Current.getNext();
        }
        Current.setNext(Current.getNext().getNext());
        if(index != 1)
          Current.setPrev(Current.getPrev().getPrev());

        listCount--; // disminuimos el contador de nodos
        return true;
    }

    // agrega el elemento en la posición indicada
    public boolean addPos(int index, T data){
        //
        if (index < 1 )
            return false;
        if (index > size()){
            add(data);
            return true;
        }

        Node<T> Current = head;

        int a = index+1;

        for (int i = 1; i < index; i++) {
             Current = Current.getNext();
        }

        Node<T> Temp = new Node<T>(data,Current.getNext(),Current);
        Current.setNext(Temp);
        listCount++; // aumenta  el contador de nodos
        return true;
    }

    // agrega el elemento en la posición indicada
    //Ordenacion de menor a mayor para clases genericas con
    //Implentacion de Comparable
    public boolean addOrdenado(T data){

        Node<T> Current = head;
        int a=1;

        while(Current.getNext()!=null &&
                              data.compareTo(Current.getNext().getData()) > 0) {
             Current = Current.getNext();
            a++;
        }
        return addPos(a,data);
    }

    // returns the number of elements in this list.
    public int size(){return listCount;}

    public String toString() {
        Node<T> Current = head.getNext();
        String output = "";
        while (Current != null) {
            output += "[" + Current.getData().toString() + "]";
            Current =  Current.getNext();
        }
        return output;
    }

    public int compareTo(ListaSimple<T> o){
      if(this.ABC >= o.getABC())
        if(this.ABC == o.getABC())
          return 0;
        else
          return 1;
      else
        return -1;
    }
}
