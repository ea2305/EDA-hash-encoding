/**
*@author Flyzx
*@version 0.2
*/
package transformacionClaves;
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
  /**
  *@param Integer: dato, int: numero de elementos
  *@return Integer : valor resultante de la conversion
  */
  public Integer cuadradoHash(Integer dato, int N){
    CuadradoHash ch = new CuadradoHash(N);
    return ch.transformElement(dato);
  }
  /**
  *@param Integer: dato, int: numero de elementos
  *@return Integer : valor resultante de la conversion
  */
  public Integer plegamientoHash(Integer dato, int N){
    PlegamientoHash ph = new PlegamientoHash(N);
    return ph.transformElement(dato);
  }
  /**
  *@param Integer: dato, int: numero de elementos
  *@return Integer : valor resultante de la conversion
  */
  public Integer truncamientoHash(Integer dato, int N){
    TruncamientoHash th = new TruncamientoHash(N);
    return th.transformElement(dato);
  }
  /**
  *@param Integer: dato, int: numero de elementos
  *@return String : resultados de la conversion
  */
  public String testHash(Integer dato, int N){
    final String salto = "\n";
    final String tab = "\t";
    return(
      "ModularHash" + salto +
      tab + dato + " : " + this.modularHash(dato, N) + salto +
      "CuadradoHash" + salto +
      tab + dato + " : " + this.cuadradoHash(dato, N) + salto +
      "PlegamientoHash" + salto +
      tab + dato + " : " + this.plegamientoHash(dato, N) + salto +
      "TruncamientoHash" + salto +
      tab + dato + " : " + this.truncamientoHash(dato, N) + salto
    );
  }

}
