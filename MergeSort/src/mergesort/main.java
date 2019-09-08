
package mergesort;
import java.util.Random;
import java.util.Scanner;


public class main{
    
    private static int [] getArrayN(int amount){
        return new Random().ints(amount).toArray(); 
    }
    
    public static void main(String[] args) {
            
            System.out.println("MergeSort");
            System.out.println("------------------------");
            System.out.println("Enter amount of numbers:");
            Scanner scan = new Scanner(System.in);
            while (!scan.hasNextInt()) {
              System.out.println("Invalid input!");
              scan.nextLine();
            }
            int cantidadElementos = scan.nextInt();
            
            System.out.println("Enter THRESHOLD:");
            scan = new Scanner(System.in);
            while (!scan.hasNextInt()) {
              System.out.println("Invalid input!");
              scan.nextLine();
            }
            int THRESHOLD = scan.nextInt();
            
            System.out.println("--Preparing Arrays--");
            int[] array1 = getArrayN(cantidadElementos);
            int[] array2 = getArrayN(cantidadElementos);
            System.out.println("--Arrays Done--");
            MergeSortParallel paralellSort = new MergeSortParallel(array1);
            System.out.println("------------------------");
            System.out.println("--Computing--");
            System.out.println("------------------------");
            paralellSort.setSORT_THRESHOLD(THRESHOLD);
            long start = System.currentTimeMillis();
            paralellSort.sort();
            System.out.println("Merge Sort Parallel done in: "
                + ((System.currentTimeMillis())-start)+" miliseconds " 
                        + "With a THRESHOLD of "+THRESHOLD);
            
            start = System.currentTimeMillis();
            RecursiveMergeSort.mergeSort(array2);
            System.out.println("Merge Sort Recursive done in: "
                + ((System.currentTimeMillis())-start)+" miliseconds ");
	}

}


