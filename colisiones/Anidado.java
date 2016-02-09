package colisiones;

public class Anidado{
	Integer[][] arreglo; 

	Anidado(int tamano){
		arreglo = new Integer[tamano][tamano];
	}

	Anidado(){
		arreglo = new Integer[50][50];

	}

	public void insertar(Integer object){
		int i = 0;
		int h = (object % 10) +1;
	//	System.out.println(arreglo.length);
		if(arreglo[h][i] == null){
			arreglo[h][i] = object;
		}else{
			for(i=0; i< arreglo.length; i++){
				if(arreglo[h][i] == null){
					arreglo[h][i] = object;
					i = arreglo.length;
				}
			}
		}
	//	printArray();
	}

	public void buscar(Integer object, int pos){
		for(int i=0; i< arreglo.length; i++){
			if(arreglo[pos][i] == object){
				System.out.println("Objeto encontrado");
				return;
			}
		}
		System.out.println("Objeto no encontrado");
	}

	private void printArray(){
		for(int i=0; i<arreglo.length; i++){
			for (int x=0; x < arreglo.length; x++){
				if(arreglo[i][x] != null)
					System.out.println("Pos ["+i+"]["+x+"]: "+arreglo[i][x]);
			}
		}
	}
/*
	public static void main(String[] args) {
		Anidado anidar = new Anidado();
		anidar.insertar(25);
		anidar.insertar(25);
		anidar.insertar(50);
		anidar.insertar(75);
		anidar.insertar(50);
		anidar.insertar(1);
		anidar.insertar(1);
		anidar.printArray();
		anidar.buscar(1, 2);
	}*/
}