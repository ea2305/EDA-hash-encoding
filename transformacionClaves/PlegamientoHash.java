/**
*@author Flyzx
*@version 0.2
*/
package transformacionClaves;
/**
*Clase con la Transformacion por funcion Plegamiento
*/
public class PlegamientoHash{
  //Contiene el numero de elementos
  private final int N;
  /**
  *constructor
  *@param int: numero de elementos
  */
  public PlegamientoHash(int N){
    this.N = N;
  }
  /**
  *@param Integer: el dato
  *@return int: la clave
  */
  public int transformElement(Integer dato){
    return(
      digitosMenosSignificativos(dato) + 1
    );
  }
  /**
  *@param Integer: el dato
  *@return int: digitos Menos Significativos
  */
  private int digitosMenosSignificativos(Integer dato){
    int numero = dato;
    String box = dato.toString();
    int numDigitos = box.length();
    while(numero > N){
      String s1 = box.substring(0, numDigitos/2);
      String s2 = box.substring(numDigitos/2);
      int i1 = Integer.parseInt(s1);
      int i2 = Integer.parseInt(s2);
      numero = i1+i2;
      box = Integer.toString(numero);
      numDigitos = box.length();
    }
    return numero;
  }
}
