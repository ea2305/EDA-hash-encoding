package colisiones;
import colisiones.*;
import struct.*;


public class Encadenamiento{
    
    ListaSimple<ListaSimple<Integer>> List;
    boolean state;
    
    //Constructor por defecto
    public Encadenamiento(){
        List = new ListaSimple<ListaSimple<Integer>>();
        state = false;    
    }

    /**
     *Agrega informacion a la lista simple
     *@param data : Integer, con datos proximos a insertar
     */    
    public void insert(Integer data,int posicion){
        
        if(posicion > List.size()){//Redimencion
            ListaSimple<Integer> aux;
            for (int i = List.size(); i < posicion ; i++){
                aux = new ListaSimple<Integer>();
                List.add(aux);
            }
        }

        
        ListaSimple<Integer> Current = new ListaSimple<>();
        
        //Buscamos el elemento en la lista.
        Current = List.get(posicion).getData();//Agregamos a variable temporal
        
        Current.add(data);//insertamos elemento en la lista        
        
    }
    
    public int search(Integer data, int posicion){
        
        if(posicion > List.size())
            return -1;
        
        ListaSimple<Integer> current = new ListaSimple<>();
        
        //Busqueda directa con metodo get()
        current = List.get(posicion).getData();
        
        for(int i = 1; i <= current.size() ; i++){
            
            //Inspeccionamso cada nodo prguntando por el dato
            if(current.get(i).getData() == data){
                return i;
            }
        }
        
        return -1;
    }
    
    public void currentNode(){
        List.get(1);
    }
    
    /**
     *Inicializa la lista simple para qu econtenga los datos de las colisiones futuras
     *@param size : int con el numero de elementos que permitira el arreglo
     */
    public void startList(int size){ 
        
        ListaSimple<Integer> aux;
        
        for (int i = 0; i < size ; i++){
                aux = new ListaSimple<Integer>();
                //aux.add(i);//agregamos un dato para ejemplo
                //aux.add(i * 2);//agregamos un dato para ejemplo
                List.add(aux);
                //System.out.println(List.get(i + 1).getData().get(1).getData());
        }
        
    }
    
    /**
     *Imprime los datos contenidos en la lista simple 
     */
    public void printList(){
        
        for(int i = 1; i <= List.size(); i++){
            
            ListaSimple<Integer> current;//Buffer
            current = List.get(i).getData();
            System.out.print ("Fila " + i + " : ");
            
            for(int j = 1; j <= current.size(); j++){
                
                //Imprimir los datos en la lista integer
                System.out.print("\t" + current.get(j).getData());
                
            }
            System.out.println();
            
        }
               
    }
}