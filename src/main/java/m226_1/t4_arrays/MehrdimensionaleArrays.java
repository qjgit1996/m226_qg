package m226_1.t4_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Minimums {
    int zeile;
    int gruppe;
    int element;
    Minimums(int z, int g, int e) {
        this.zeile = z;
        this.gruppe = g;
        this.element = e;
    }
}

public class MehrdimensionaleArrays {
    public static void main(String[] args) {
        int[][][] matrix = ArraysGenerieren();
        int min = MinimumSuchen(matrix);
        ArrayList<Minimums> mins = MinimumOrte(matrix);
        printMatrix(min, mins);
    }
    public static int[][][] ArraysGenerieren() {
        int[][][] matrix = new int[6][3][4];
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    matrix[i][j][k] = 20 + rnd.nextInt(11);
                }
                System.out.print(Arrays.toString(matrix[i][j]));
            }
            System.out.println();
        }
        return matrix;
    }

    public static int MinimumSuchen(int [][][] matrix) {
        int min = 35;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    if (matrix[i][j][k] <= min) {
                        min = matrix[i][j][k];
                    }
                }
            }
        }
        return min;
    }

    public static ArrayList<Minimums> MinimumOrte(int [][][] matrix) {
        ArrayList<Minimums> mins = new ArrayList<>();
        int min = 35;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    if (matrix[i][j][k] < min) {
                        min = matrix[i][j][k];
                        mins.clear();
                        mins.add(new Minimums(i, j, k));
                    } else if (matrix[i][j][k] == min) {
                        min = matrix[i][j][k];
                        mins.add(new Minimums(i, j, k));
                    }
                }
            }
        }
        return mins;
    }



    public static void printMatrix(int min, ArrayList<Minimums> mins) {
        System.out.println("Minimum der Zahlen ist: " + min + ", an Position:");
        for (int i = 0; i < mins.size(); i++) {
            System.out.format("Zeile %d, Gruppe %d, Element %d", mins.get(i).zeile, mins.get(i).gruppe, mins.get(i).element);
            System.out.println();
        }
    }
}