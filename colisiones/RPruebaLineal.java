/**
*@author Carlos Maximiliano Ortiz Escobar
*@version 0.1
*/
package colisiones;
import colisiones.*;
import struct.*;

/**
*Clase para solucionar colisiones metodo Reasignacion - Prueba Lineal
*/

public class RPruebaLineal{

	//Contiene todo el arreglo de Datos
	private Integer datos[];
	private int n=0;

	/**
	*constructor
	*@param Integer: Arreglo que contiene los datos 
	*/
	public RPruebaLineal(int n){
		this.n=n;
		this.datos=new Integer[n];
	}

	/**
	*@param Integer dato: codigo hash
	*@param Integer info : valor general del dato
	*@param int n : tamano del arreglo
	*@return int : posicion en donde se debe insertar el dato
	*/

	public void insert(Integer dato,Integer info){
		int dx=0;

		if (this.datos[dato] == null) {
			this.datos[dato]=info;
		}
		else
		{
			dx=dato+1;
			while((datos[dx]!=null)){
				dx++;
				if (dx==this.n){
					dx=0;
				}
			}
			this.datos[dx]=info;
		}
	}



	public Integer[] getData(){
		return this.datos;
	}

	public Integer search(Integer dato,Integer k){
		int dx=0;
		if (this.datos[dato].compareTo(k)==0) {
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