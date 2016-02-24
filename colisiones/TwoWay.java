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
	public int nInsert;
	public int nSearch;

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

		nInsert=0;
		int dx=0;

		Kernel kernel=new Kernel();

		Integer dato=(kernel.transformSelection(info,n,this.metodoHash));
		System.out.println("Se genero el primer codigo de insercion :"+dato);
		System.out.println(dato);
        
		if (this.datos[dato] == null) {
			this.datos[dato]=info;
			//System.out.println("El elemento " + info + "fue insertado en la pos : " + dato);
			nInsert++;
		}
		else
		{
			dx=(kernel.transformSelection(dato,n,this.metodoHash)-1);
            int contador=0;
            int tol = 0;
            nInsert++;
			while((datos[dx]!=null)){
                
				dx=(kernel.transformSelection(dx+1,n,this.metodoHash));

				if (dx>=this.n){
					dx=1;
				}
				nInsert++;
                
			}
			this.datos[dx]=info;
			System.out.println("El elemento " + info + "fue insertado en la pos : " + dx);

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
		nSearch=0;

		Kernel kernel=new Kernel();

		System.out.println(this.datos[dato]+ "==" +k);
		if (this.datos[dato].equals(k)) {
			System.out.println("El elemento esta en la posicion : " + dato);
			nSearch++;
			return dato;
		}
		else
		{
			dx=(kernel.transformSelection(dato,n,this.metodoHash));
			nSearch++;
			while((dx<n) && (!datos[dx].equals(k)) && (!datos[dx].equals(null)) && (dx!=dato)){
				dx=(kernel.transformSelection(dx+1,n,this.metodoHash));
				if (dx>=n) {
					dx=1;
				}
				nSearch++;
								System.out.println(k+"  "+ datos[dx]);

			}
			if (datos[dx].equals(k)) {
				System.out.println("El elemento esta en la posicion : "+dx);
				return dx;
			}else{
				System.out.println("El elemento no esta en el arreglo");
				return -1;
			}
		}
	}
}