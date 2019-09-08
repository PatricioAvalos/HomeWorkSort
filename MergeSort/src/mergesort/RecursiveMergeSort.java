

package mergesort;


public class RecursiveMergeSort {
        public static void mergeSort(int[] enteros){
		rec_MergeSort(enteros, 0, enteros.length-1);
	}
	
	private static void rec_MergeSort(int[] enteros, int min, int max){

		if(max-min >0) {
			int divide= (min + max)/2;
			
			rec_MergeSort(enteros, min, divide);
			rec_MergeSort(enteros, divide+1, max);
			merge(enteros, min, max);	
		}
	}
	
        private static void insertionSort(int [] array, int min,int max) {
            for (int i = min+1; i <= max; ++i) {
                int current = array[i];
                int j = i-1;
                while (min <= j && current < array[j]) {
                    array[j+1] = array[j--];
                }
                array[j+1] = current;
            }
        }
        
	private static void merge(int[] enteros, int min, int max ){
		
		int mitad= ((max +min) /2);
		int s_enteros= mitad +1;
		int valor, apuntador;
	
		// Si está ordenado acabo el proceso
		if(enteros[mitad] <= enteros[s_enteros]){
			return;
		}
   
                if( (max - min) <= 16){
			//QuickSort.quickSort(enteros);
                        insertionSort(enteros,min,max);
		}
                else{
                
                    //Si no está ordenado
                    while(min <= mitad && s_enteros<=max){
                            // si el elemento de la posición menos (es menor) avanza 1 para buscar el que sea mayor
                            if(enteros[min] <=  enteros[s_enteros]){
                                    min++;
                            }
                            //si es mayor
                            else{
                                    //prepara para el swap
                                    valor= enteros[s_enteros];
                                    // guarda el lugar del arreglo para no modificar mi apuntador para el orden de ordenamiento
                                    apuntador=s_enteros;


                                    while(apuntador != min){
                                            enteros[apuntador]=enteros[apuntador-1];
                                            apuntador--;
                                    }
                                    enteros[min]= valor;

                                    min++;
                                    mitad++;
                                    s_enteros++;

                            }

                    }
		}
	}
        
        /*
        private static void ImprimeArreglo(int[] enteros){
		for(int i=0; i< enteros.length;i++){
			System.out.print(enteros[i]+",");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] entero= {15,5,8,20,25,30,1,50,6,7,2,68,54,33,26,39,55,44,41};
		
		ImprimeArreglo(entero);
		System.out.println(" ");
		mergeSort(entero);
		System.out.println(" ");
		ImprimeArreglo(entero);
		
		
		
	}*/
        
        
}
