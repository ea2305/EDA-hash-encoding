/**
*@author Carlos Maximiliano Ortiz Escobar
*@version 0.1
*/

package transformacionClaves.fixer;

/**
*Clase para solucionar colisiones metodo Reasignacion - Prueba Lineal
*/

public class RPruebaLineal{

	//Contiene todo el arreglo de Datos
	private Integer datos[];

	/**
	*constructor
	*@param Integer: Arreglo que contiene los datos 
	*/
	public RPruebaLineal(Integer datos[]){
	   this.datos = datos;
	}

	/**
	*@param Integer dato: codigo hash
	*@param int n : tamano del arreglo
	*@return int : posicion en donde se debe insertar el dato
	*/

	public int solveCollision(Integer dato,int n){
		int dx=0;

		if (this.datos[dato] == null) {
			return dato;
		}
		else
		{
			dx=dato+1;
			while((datos[dx]!=null)){
				dx++;
				if (dx==n){
					dx=0;
				}
			}
			return dx;
		}
	}
}