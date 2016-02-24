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
    Integer hash = modHash.transformElement(element);
    while(hash > N) hash -= N;
    return hash;
  }
  /**
  *@param Integer: dato, int: numero de elementos
  *@return Integer : valor resultante de la conversion
  */
  public Integer cuadradoHash(Integer dato, int N){
    CuadradoHash ch = new CuadradoHash(N);
    Integer hash = ch.transformElement(dato);
    while(hash > N) hash -= N;
    return hash;
  }
  /**
  *@param Integer: dato, int: numero de elementos
  *@return Integer : valor resultante de la conversion
  */
  public Integer plegamientoHash(Integer dato, int N){
    PlegamientoHash ph = new PlegamientoHash(N);
    Integer hash = ph.transformElement(dato);
    while(hash > N) hash -= N;
    return hash;
  }
  /**
  *@param Integer: dato, int: numero de elementos
  *@return Integer : valor resultante de la conversion
  */
  public Integer truncamientoHash(Integer dato, int N){
    TruncamientoHash th = new TruncamientoHash(N);
    Integer hash = th.transformElement(dato);
    while(hash > N) hash -= N;
    return hash;
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
  
  /**
   *@param value : Integer, hace referencia al valor a transformar
   *@param N : int, numero de elementos en el conjunto de value
   *@param option : int, seleccion de tipo de transformacion
   *@return Integer : con valor de transformacion;
   */
  public Integer transformSelection(Integer value,int N,int option){
      switch(option){
          case 1:
            return modularHash(value,N);
          case 2:
            return cuadradoHash(value,N);
          case 3:
            return truncamientoHash(value,N);
          case 4:
            return plegamientoHash(value,N);
          default:
            return -1;  
      }
  }

}
