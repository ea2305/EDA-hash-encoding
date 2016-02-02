package colisiones;

public class CuadraticMethod{
    
    Integer myArray[];
    
    public CuadraticMethod(){
        myArray = new Integer[2];
    }
    
    public void start(int size){
        Integer [] temp = new Integer[size];
        this.myArray = temp; 
    }
    
    public void printArray(){
        int index = 0;
        for(Integer e : myArray)
            System.out.println("[" + (index++) +"] : " + e);
    }
    
    public Integer insert(Integer data,int posicion){
        
        int count = 0;
        if(posicion < 0 || posicion >= this.myArray.length){
            System.out.println("El elemento excede el tamaño del arreglo");
            return -1;
        }
        
        if(myArray[posicion] == null){
            
            myArray[posicion] = data;
            return posicion;
            
        }else{  
            int i = 1;
            int newPosition = posicion + (int)Math.pow(i,2);
            
            while(count < this.myArray.length){
                
                if(myArray[newPosition] == null){
                    myArray[newPosition] = data;
                    return newPosition;
                }       
                
                i++;
                count++;
                newPosition = posicion + (int)Math.pow(i,2);
                if(newPosition >= myArray.length){
                    i = 0;
                    posicion = 0;
                    newPosition = posicion + (int)Math.pow(i,2);
                }
            }
        }
        
        System.out.println(" Elemento" + data  + " No pudo ser insertado, intente con otro metodo ");
        return -1;
    }
    
    public Integer search(Integer data,int posicion){
        
        int count = 0;
        if(posicion < 0 || posicion >= this.myArray.length)
            return -1;
        
        if(myArray[posicion] == data){
            
            return posicion;
            
        }else{  
            int i = 1;
            int newPosition = posicion + (int)Math.pow(i,2);
            
            while(count < this.myArray.length){
                
                if(myArray[newPosition] == data){
                   
                    return newPosition;
                }       
                
                i++;
                count++;
                newPosition = posicion + (int)Math.pow(i,2);
                if(newPosition >= myArray.length){
                    i = 0;
                    posicion = 0;
                    newPosition = posicion + (int)Math.pow(i,2);
                }
            }
        }
        return -1;
    }
}