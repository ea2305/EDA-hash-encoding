package struct;

import struct.*;
import java.util.*;
 /*
*   Lista generica, fase de pruebas para clases
*   que implementen de Comparable
*   @author Elihu Alejandro Cruz Albores
*   @version 1.5
*/

public class ListaSimple<T extends Comparable<T>> implements Comparable<ListaSimple<T>>{

    // Referencia  a el node raiz o la cabeza de la lista.
    private Node <T> head;
    private int listCount;

    // constructor
    // Se asigna la cabeza a un nodo nulo y el contador a 0
    public ListaSimple() {
        head = new Node<T>(null);
        listCount = 0;
    }

    // Agrega el nodo al final de la lista.
    public void add(T data){

        //index
        int index = 1;
        
        Node<T> Temp = new Node<T>(data);

        Node<T> Current = head;
        // Se tiene que posicionar en la cabeza para poder recorrer la lista y llegar al fin

        while (Current.getNext() != null) {
            index++;
            Current = Current.getNext();
        }

        Temp.setID(index);
        Current.setNext(Temp);
        listCount++;// incrementamos el contador de nodos
    }

    // Regresa el nodo en la posicion indicada por index
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

    // remueve el elemento en la posicion indicada
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

        listCount--; // disminuimos el contador de nodos
        return true;
    }

    // agrega el elemento en la posicion indicada
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

        Node<T> Temp = new Node<T>(data,Current.getNext());
//        Temp.setID(); //implementacion de id no valida
        Current.setNext(Temp);
        listCount++; // aumenta  el contador de nodos
        return true;
    }

    // agrega el elemento en la posicion indicada
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
      if(get(1).getID() >= o.get(1).getID())
        if(get(1).getID() == o.get(1).getID())
          return 0;
        else
          return 1;
      else
        return -1;
    }
}
