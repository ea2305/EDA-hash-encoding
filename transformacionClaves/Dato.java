/**
*@author Flyzx
*@version 0.1
*/
package transformacionClaves;
/**
*Clase con la estructura de un dato para Hash
*/
public class Dato<T extends Comparable<T>>{
  // contiene la clave
  private Integer clave;
  //contiene el dato
  private T dato;
  /**
  *constructor
  *@param Integer: la clave, T: el dato
  */
  public Dato(Integer clave, T dato){
    this.clave = clave;
    this.dato = dato;
  }
  /**
  *@return T: el dato
  */
  public T getDato(){
    return this.dato;
  }
  /**
  *@return Integer: la clave
  */
  public Integer getClave(){
    return this.clave;
  }
}
