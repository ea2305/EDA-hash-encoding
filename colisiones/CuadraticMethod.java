public class CuadraticMethod{
    
    Integer myArray[];
    
    public CuadraticMethod(){
        myArray = new Integer[2];
    }
    
    public CuadraticMethod(int size){
        myArray = new Integer[size];
    }
    
    public void insert(Integer data,int posicion){
        
        if(myArray[posicion] == null){
            myArray[posicion] = data;
        }else{
            
        }
        
    }
    
}