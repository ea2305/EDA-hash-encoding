/**
*@author Flyzx
*@version 0.2
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
      digitosCentrales(dato*dato) + 1
    );
  }
  /**
  *@param Integer: el dato
  *@return int: digitos centrales del dato
  */
  private int digitosCentrales(Integer dato){
    int numero = dato;
    String box = dato.toString();
    int numDigitos = box.length();
    
    while(numero > N  && numDigitos > 1){
      if(numDigitos % 2 == 0) box = box.substring(1);
      else box = box.substring(0,numDigitos-1);
      numero = Integer.parseInt(box);
      box = Integer.toString(numero);
      numDigitos = box.length();
    }
    return numero;
  }
}
