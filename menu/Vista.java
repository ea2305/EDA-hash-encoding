package menu;

import menu.*;//Importamos la funcionalidad del menu
import transformacionClaves.*;
import colisiones.*; 
import java.util.Scanner;
import search.*;

public class Vista{
    
    int metodoHash;
    Integer testArray [] = {25,43,56,35,54,13,80,104};
    
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
        String [] elements = {"Prueba Lineal","Arreglos Anidados","Doble Direccion Hash","Encadenamiento","Prueba cuadratica","Cambiar metodo hash","Salir =>"};
        Menu myMenu = new Menu("\tMETODO DE SOLUCION DE COLISIONES A COMPROBAR", elements);
       
        while(option != -1){
            
            myMenu.printAll();//Imprimimos menu y demas
            System.out.print("Seleccione una opcion::");
            System.out.println();
            
            try{
                option = read.nextInt();
                option = pruebaColision(option);
                
            }catch(java.util.InputMismatchException e){
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
                System.out.println("test 5");
                test_pruebaCuadratica();
                return option;
            case 6:
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
                
            }catch(java.util.InputMismatchException e){
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
    
    public void test_pruebaLineal(){
        Integer testArray [] = {25,43,56,35,54,13,80,104};
        Kernel kernel=new Kernel();
        Menu myMenu =new Menu("Prueba Reasignacion -- Prueba Lineal",null);
        RPruebaLineal A = new RPruebaLineal(10);
        int nInsert=0;
        for(int i=0;i<testArray.length ;i++) {
            System.out.println(kernel.transformSelection(testArray[i],10,this.metodoHash)-1);
            A.insert(kernel.transformSelection(testArray[i],10,this.metodoHash)-1,testArray[i]); 
            nInsert+=A.nInsert;   
        }

        Integer newtestArray[] =A.getData();

        System.out.println("Original");
        for (Integer e : testArray) {
            System.out.println(e);
        }   

        System.out.println("Datos hash");
        for (int i=0;i<newtestArray.length ;i++ ) {
            System.out.println(i +"--["+newtestArray[i]+"]");
        }

        System.out.println("\nEl numero de iteraciones para insertar en el arreglo es : " + nInsert);

        System.out.println("Buscando el numeor 13");
        int a=A.search((kernel.transformSelection(13,10,this.metodoHash))-1,13);
        int nSearch=A.nSearch;
        System.out.println("El numero de iteraciones para buscar el numero 13 es de : " + nSearch);
        

        
    }
    
    public void test_pruebaArreglosAnidados(){
        Kernel kernel = new Kernel();
        Integer testArray [] = {25,43,56,35,54,13,80,104};
        Anidado a = new Anidado(testArray.length+5);
        for(Integer i : testArray){
            System.out.println("posicion a insertar"+kernel.transformSelection(i, testArray.length, this.metodoHash));
            a.insertar(i, kernel.transformSelection(i, testArray.length, this.metodoHash));
        }

        a.printArray();

        System.out.println("BUSCAR ELEMENTO 25 EN EL ARREGLO DE DATOS");
        int nSearch=a.nSearch;
        System.out.println("El numero de iteraciones para buscar el numero 25 es de : " + nSearch);  
        System.out.println("posicion a buscar   "+ kernel.transformSelection(25,testArray.length,this.metodoHash));
        printSearchResult(a.buscar(25, kernel.transformSelection(25,testArray.length,this.metodoHash)));
        System.out.println("BUSCAR ELEMENTO 7 EN EL ARREGLO DE DATOS");
        nSearch=a.nSearch;
        printSearchResult(a.buscar(7, kernel.transformSelection(7,testArray.length,this.metodoHash)));
        System.out.println("El numero de iteraciones para buscar el numero 7 es de : " + nSearch);  

    }
    
    public void test_pruebaDobleDireccionHash(){



        Integer testArray [] = {2554,4323,5635,3512,5784,1323,8034,1042};
        Menu myMenu =new Menu("Prueba Doble Direccion Hash",null);

        TwoWay A = new TwoWay(10,this.metodoHash);
        int nInsert=0;

        for(int i=0;i<testArray.length ;i++){
            A.insert(testArray[i]); 
            nInsert+=A.nInsert;   
        }

        Integer newtestArray[]=A.getData();

        System.out.println("Visualizacion del arreglo ordenado");
        for (int i=0;i<newtestArray.length ;i++ ) {
            System.out.println("["+i+"] -- " + newtestArray[i]);
        }

        System.out.println("\nEl numero de iteraciones para insertar datos fue de : " + nInsert);
        
        System.out.println("\nBuscando el numero 4323\n");
        Kernel kernel=new Kernel();
        int a=A.search((kernel.transformSelection(4323,10,this.metodoHash)),4323);
        int nSearch=A.nSearch;
        System.out.println("El numero de iteraciones para buscar el numero 4323 es de : " + nSearch);

        System.out.println("\nBuscando el numero 1042\n");

        int b=A.search((kernel.transformSelection(1042,10,this.metodoHash)),1042);
        nSearch=A.nSearch;
        System.out.println("El numero de iteraciones para buscar el numero 1042 es de : " + nSearch);

    }
    
    public void test_pruebaEncadenamiento(){
        //Elementos de prueba
        Kernel kernel = new Kernel();
        int busqueda = 7;
        
        Menu myMenu = new Menu("PRUEBA ENCADENAMIENTO", null);
        myMenu.printTitle();
        Encadenamiento A = new Encadenamiento();
        
        A.startList(testArray.length);//Generamos Tamano de lista
        int nSearch=0;
        for(Integer e : testArray){
            A.insert(e,kernel.transformSelection(e,testArray.length,this.metodoHash));
        }   

        A.insert(787,3);
        
        A.printList();//Visuallizar arreglo
        
        System.out.println();
        
        System.out.println("Busqueda de dato  [104]");
        printSearchResult(A.search(104,kernel.transformSelection(104,testArray.length,this.metodoHash)));//test search
        nSearch=A.nSearch;
        System.out.println("El numero de iteraciones para encontrar el numero 104 es : " + nSearch);
        System.out.println("Busqueda de dato  [7]");
        printSearchResult(A.search(7,kernel.transformSelection(7,testArray.length,this.metodoHash)));//test search
        nSearch=A.nSearch;
        System.out.println("El numero de iteraciones para encontrar el numero 104 es : " + nSearch);


    }
    
    public void test_pruebaCuadratica(){//Tamanos fijos, 
         //Elementos de prueba
        
        Kernel kernel = new Kernel();
        
        Menu myMenu = new Menu("PRUEBA CUADRATICA", null);
        myMenu.printTitle();
        CuadraticMethod A = new CuadraticMethod();
        
        A.start(testArray.length * 2);
       
        for(Integer e : testArray){
            A.insert(e,kernel.transformSelection(e,testArray.length,this.metodoHash));
        }   
        
        A.printArray();
        int nSearch=0;
        System.out.println("Busqueda de dato  [104]");
        printSearchResult(A.search(104,kernel.transformSelection(104,testArray.length,this.metodoHash)));//test search
        nSearch=A.nSearch;
        System.out.println("El numero de iteraciones para encontrar el numero 104 es : "+ nSearch);
        System.out.println("Busqueda de dato  [7]");
        printSearchResult(A.search(7,kernel.transformSelection(7,testArray.length,this.metodoHash)));//test search
        nSearch=A.nSearch;
        System.out.println("El numero de iteraciones para buscar el numero 7 es : " + nSearch);
    }
    
    public void printSearchResult(int aux){
        if(aux >= 0){
            System.out.println("\tElemento encontrado en la posicion : " + aux);
        }else{
            System.out.println("\tDato no encontrado :(");
        }
    }
    

}