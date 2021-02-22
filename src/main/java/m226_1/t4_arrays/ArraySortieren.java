package m226_1.t4_arrays;

import java.lang.reflect.Array;
import java.util.*;

class Result {
    int swapps;
    int[] sortedArray;
    int[] unsortedArray;

    Result(int swap, int[] sorArr, int[] unsorArr)
    {
        this.swapps = swap;
        this.sortedArray = sorArr;
        this.unsortedArray = unsorArr;
    }
}

public class ArraySortieren {
    public static void main(String[] args) {
        int[] arrayToBeSorted = ArrayGenerieren();
        Result sortingResult = ArraySortieren(arrayToBeSorted);
        printResult(sortingResult);
    }

    public static int[] ArrayGenerieren() {
        Random rnd = new Random();
        int[] unsortedArr = rnd.ints(30, 0,100).toArray();
        System.out.println(Arrays.toString(unsortedArr));
        return unsortedArr;
    }

    public static Result ArraySortieren(int [] arrayRnd) {
        int [] arrayUnsort = arrayRnd.clone();
        boolean swapped = true;
        int j = 0;
        int tmp;
        int swapps = 0;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arrayRnd.length - j; i++) {
                if (arrayRnd[i] > arrayRnd[i + 1]) {
                    tmp = arrayRnd[i];
                    arrayRnd[i] = arrayRnd[i + 1];
                    arrayRnd[i + 1] = tmp;
                    swapped = true;
                    swapps ++;
                }
            }
        }
        return new Result(j, arrayRnd, arrayUnsort);
    }

    public static void printResult(Result result) {
        System.out.println("Unsortierte Zahlen: " + Arrays.toString(result.unsortedArray));
        System.out.println("Sortierte Zahlen: " + Arrays.toString(result.sortedArray));
        System.out.println("An " + result.swapps + " Positionen waren im unsortierten Array grössere Zahlen");
    }
}
