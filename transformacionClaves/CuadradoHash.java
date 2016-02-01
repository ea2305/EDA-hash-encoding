/**
*@author Flyzx
*@version 0.1
*/
package transformacionClaves;
/**
*Clase con la Transformacion por funcion Cuadrado
*/
public class CuadradoHash{
  //Contiene el numero de elementos
  private final int N;
  /**
  *constructor
  *@param int: numero de elementos
  */
  public CuadradoHash(int N){
    this.N = N;
  }
  /**
  *@param Integer: el dato
  *@return int: la clave
  */
  public int transformElement(Integer dato){
    return(
      datosCentrales(dato*dato) + 1
    );
  }
  /**
  *@param Integer: el dato
  *@return int: digitos centrales del dato
  */
  private int datosCentrales(Integer dato){
    int digitosCentrales = dato;
    String box = dato.toString();
    int numDigitos = box.length();
    while(digitosCentrales > N){
      if(numDigitos % 2 == 0) box = box.substring(1);
      else box = box.substring(0,numDigitos-1);
      digitosCentrales = Integer.parseInt(box);
      numDigitos = box.length();
    }
    return digitosCentrales;
  }
}
