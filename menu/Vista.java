package menu;

import menu.*;//Importamos la funcionalidad del menu
import transformacionClaves.*;
import colisiones.*; 
import java.util.Scanner;

public class Vista{
    
    int metodoHash;
    
    //Constructor por defecto
    public Vista(){
        this.metodoHash = -1;
    }

    /**
     *Inicializa los metodos de prueba.
     */    
    public void start(){
        
        if(this.metodoHash == -1)//Verificamos que el metodo ha sido cargado
            seleccionMetodo();
            
         menuPrincipal();//Menu para pruebas de metodos.
    }
    
    
    /**
     *Llamada al menu principal
     */
    private void menuPrincipal(){
        Scanner read = new Scanner(System.in);
        int option = 0;
        
        //Instancia de menu principal
        String [] elements = {"Prueba Lineal","Arreglos Anidados","Doble Direccion Hash","Encadenamiento","Cambiar metodo hash","Salir =>"};
        Menu myMenu = new Menu("\tMETODO DE SOLUCION DE COLISIONES A COMPROBAR", elements);
       
        while(option != -1){
            
            myMenu.printAll();//Imprimimos menu y demas
            System.out.print("Seleccione una opcion::");
            System.out.println();
            
            try{
                option = read.nextInt();
                option = pruebaColision(option);
                
            }catch(Exception e){
                read = new Scanner(System.in);
                System.out.println("Error de lectura =X ingrese numeros");
            }   
        }        
    }
    
    
    /**
     *Selecto de flujo 
     */
    private int pruebaColision(int option){
        switch(option){
            case 1:
                System.out.println("test 1");
                test_pruebaLineal();
                return option;
            case 2:
                System.out.println("test 2");
                test_pruebaArreglosAnidados();
                return option;
            case 3:
                System.out.println("test 3");
                test_pruebaDobleDireccionHash();
                return option;
            case 4:
                System.out.println("test 4");
                test_pruebaEncadenamiento();
                return option;
            case 5:
                seleccionMetodo();
                return option;                
                
            default:
                return -1;
        }
    }
    
    private void seleccionMetodo(){
        
        //Instancia de menu principal
        String [] elements = {"Modulo","Cuadrado","Truncamiento","Plegamiento"};
        Menu myMenu = new Menu("\tSELECCIONE UN METODO DE TRANSFORMACION DE CLAVES", elements);

        myMenu.printAll();
        
        Scanner read = new Scanner(System.in);
        int option = 0;
         
        System.out.print("Seleccione un metodo::");
        System.out.println();
       
        while(option == 0){
            try{
                option = read.nextInt();
                option = metodoSelect(option);
                
            }catch(Exception e){
                read = new Scanner(System.in);
                option = 0;
                System.out.println("Error de lectura =X ingrese numeros");
            }   
        }
        System.out.println("EL METODO SE HA CARGADO = OK");
    }
    
    /**
     *Selecciona el metodo por el usuario
     *@param option :  int, con valor de seleccion
     *@return value : value, seleccion valida o invalida
     */
    private int metodoSelect(int option){
        if(option > 0 && option < 5){
            this.metodoHash = option;
            return option;
        }else{
            System.out.println(" => SE HA ESTABLECIDO CONVERSION 'MODULO' POR DEFECTO");
            return 1;
        }
                
    }
    
    public void test_pruebaLineal(){}
    
    public void test_pruebaArreglosAnidados(){}
    
    public void test_pruebaDobleDireccionHash(){}
    
    public void test_pruebaEncadenamiento(){
        //Elementos de prueba
        Integer testArray [] = {25,43,56,35,54,13,80,104};
        Kernel kernel = new Kernel();
        
        Menu myMenu = new Menu("PRUEBA ENCADENAMIENTO", null);
        
        Encadenamiento A = new Encadenamiento();
        
        A.startList(testArray.length);//Generamos Tamaño de lista
        
        for(Integer e : testArray){
            A.insert(e,kernel.transformSelection(e,10,this.metodoHash));
        }   

        A.insert(787,3);
        
        A.printList();//Visuallizar arreglo
        
        int aux =  A.search(115,12);
        if(aux > 0){
            System.out.println("Elemento encontrado en la posicion : " + aux);
        }else{
            System.out.println("dato no encontrado");
        }
    }    
}