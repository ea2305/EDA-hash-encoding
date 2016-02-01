/**
*@author Carlos Maximiliano Ortiz Escobar
*@version 0.1 
*/

package search;

public class BPruebaLineal{

	//Contiene todo el arreglo de Datos
	private Integer datos[];

	/**
	*constructor
	*@param Integer: Arreglo que contiene los datos 
	*/
	public BPruebaLineal(Integer datos[]){
	this.datos = datos;
	}

	/**
	*@param Integer: el dato que se desea insertar
	*@param Integer : codigo hash
	*@param int: tamano del arreglo
	*@return int: la posicion en donde se encuentra el dato buscado 0 -1 si no se encuentra en el arreglo
	*/
	public int solveCollision(Integer dato,Integer k,int n){
		int dx=0;
		if (this.datos[dato]==k) {
			System.out.println("El elemento esta en la posicion : " + dato);
			return dato;
		}
		else{
			dx=dato+1;
			while((dx<=n) && (datos[dx]!=k) && (datos[dx]!=null) && (dx!=dato)){
				dx++;
				if (dx==n) {
					dx=0;
				}
			}
			if (datos[dx]==k) {
				System.out.println("El elemento esta en la posicion : "+dx);
				return dx;
			}else{
				System.out.println("El elemento no esta en el arreglo");
				return -1;
			}
		}
	}
}