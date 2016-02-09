/**
*@author Flyzx
*@version 0.1
*/
package transformacionClaves;
/**
*Clase con la Transformacion por funcion Truncamiento
*/
public class TruncamientoHash{
  //Contiene el numero de elementos
  private final int N;
  /**
  *constructor
  *@param int: numero de elementos
  */
  public TruncamientoHash(int N){
    this.N = N;
  }
  /**
  *@param Integer: el dato
  *@return int: la clave
  */
  public int transformElement(Integer dato){
    return(
      elegirDigitos(dato) + 1
    );
  }
  /**
  *@param Integer: el dato
  *@return int: digitos elegidos
  */
  private int elegirDigitos(Integer dato){
    int numero = dato;
    String box = dato.toString();
    int numDigitos = box.length();
    while(numero > N && numDigitos > 1){
      String aux = "0";
      for (int i=0; i<numDigitos ; i+=2) {
        aux += box.charAt(i);
      }
      numero = Integer.parseInt(aux);
      box = Integer.toString(numero);
      numDigitos = box.length();
    }
    return numero;
  }
}
