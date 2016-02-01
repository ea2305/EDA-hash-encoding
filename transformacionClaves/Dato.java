/**
*@author Flyzx
*@version 0.2
*/
package transformacionClaves;
/**
*Clase con la estructura de un Integer para Hash
*/
public class Dato{
  // contiene la clave
  private int clave;
  //contiene el dato
  private Integer dato;
  /**
  *constructor
  *@param int: la clave, Integer: el dato
  */
  public Dato(int clave, Integer dato){
    this.clave = clave;
    this.dato = dato;
  }
  /**
  *@return int: la clave
  */
  public int getClave(){
    return this.clave;
  }
  /**
  *@return Integer: el dato
  */
  public Integer getDato(){
    return this.dato;
  }
}
