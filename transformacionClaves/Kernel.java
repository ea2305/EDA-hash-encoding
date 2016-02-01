/**
*@author Flyzx
*@version 0.1
*/
package transformacionClaves;

import transformacionClaves.*;
/**
*Clase Kernel con funciones necesarias
*/
public class Kernel{
    
    
    /**
     *@param element : Integer valor a transformar
     *@param N : int, numero de elementos del conjunto de element
     *@return Integer : valor resultante de la conversion 
     */
    public Integer modularHash(Integer element,int N){
        
       ModularHash modHash = new ModularHash(N);       
       return  modHash.transformElement(element);
       
        
    }
  
}
