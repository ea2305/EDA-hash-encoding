/**
*@author Carlos Maximiliano Ortiz Escobar
*@version 0.1
*/
package colisiones;
import colisiones.*;
import transformacionClaves.*;

/**
*Clase para solucionar colisiones metodo Doble Dirección Hash
*/
public class TwoWay{

	//Contiene todo el arreglo de Datos
	private Integer datos[];
	private int n=0;
	private int metodoHash=0;

	/**
	*constructor
	*@param n: int, tamaño del arreglo
	*@param metodo: int, metodo hash
	*/
	public TwoWay(int n,int metodo){
		this.n=n;
		this.datos=new Integer[n];
		this.metodoHash=metodo;
	}

	/**
	*@param Integer info : valor general del dato
	*/

	public void insert(Integer info){
		int dx=0;

		Kernel kernel=new Kernel();

		Integer dato=(kernel.transformSelection(info,n,this.metodoHash))-1;
		System.out.println(dato);
		if (this.datos[dato] == null) {
			this.datos[dato]=info;
		}
		else
		{
			dx=(kernel.transformSelection(dato+1,n,this.metodoHash));
			while((datos[dx]!=null)){
				dx=(kernel.transformSelection(dato+1,n,this.metodoHash));
				if (dx>=this.n){
					dx=0;
				}
			}
			this.datos[dx]=info;
}
	}


	/**
	*@return value : Integer, arreglo que contiene todos los datos
	*/

	public Integer[] getData(){
		return this.datos;
	}

	/**
	*@param dato: Integer, pocision indicada de busqueda
	*@param k: Integer, Elemento como tal buscado
	*/

	public Integer search(Integer dato,Integer k){
		int dx=0;

		Kernel kernel=new Kernel();

		if (this.datos[dato] == null) {
			System.out.println("El elemento esta en la posicion : " + dato);
			return dato;
		}
		else
		{
			dx=(kernel.transformSelection(dato+1,n,this.metodoHash));
			while((dx<=n) && (datos[dx]!=k) && (datos[dx]!=null) && (dx!=dato)){
				dx=(kernel.transformSelection(dato+1,n,this.metodoHash));
				if (dx>=n) {
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