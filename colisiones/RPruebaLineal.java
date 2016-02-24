/**
*@author Carlos Maximiliano Ortiz Escobar
*@version 0.1
*/
package colisiones;
import colisiones.*;

/**
*Clase para solucionar colisiones metodo Reasignacion - Prueba Lineal
*/

public class RPruebaLineal{

	//Contiene todo el arreglo de Datos
	private Integer datos[];
	private int n=0;
	public int nInsert;
	public int nSearch;

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
	*/

	public void insert(Integer dato,Integer info){
		int dx=0;
		nInsert=0;
		if (this.datos[dato] == null) {
			System.out.println("se inserto en la pos"+ dato);
			nInsert++;
			this.datos[dato]=info;
		}
		else
		{
			dx=dato;
			while((datos[dx]!=null)){
				dx++;
				if (dx>=this.n){
					dx=0;
				}
				nInsert++;
			}
			this.datos[dx]=info;
			System.out.println("se inserto en la pos "+ dx);
		}
	}



	public Integer[] getData(){
		return this.datos;
	}

	//dato --> posicion
	//k -->    Elemento que se busca
	public Integer search(Integer dato,Integer k){
		int dx=0;
		nSearch=0;
		if (this.datos[dato].compareTo(k)==0) {
			System.out.println("El elemento esta en la posicion : " + dato);
			nSearch++;
			return dato;
			
		}
		else{
			dx=dato+1;
			while((dx<=n) && (datos[dx]!=k) && (datos[dx]!=null) && (dx!=dato)){
				dx++;
				if (dx==n) {
					dx=0;
				}
				nSearch++;
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