package m226_1.t4_arrays;

import java.util.Random;

public class Taschenrechner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Random rnd = new Random();
            int operand1 = rnd.nextInt(20)+1;
            int operand2 = rnd.nextInt(20)+1;
            int operator = rnd.nextInt(7)+1;
            int resultat = Berechnen(operand1, operand2, operator);
            printResultat(operand1, operand2, operator, resultat);
        }

    }

    private static int Berechnen(int operand1, int operand2, int operator) {
        int resultat = 0;
        try {
            switch (operator) {
                case 1:
                    resultat = operand1 + operand2;
                    break;
                case 2:
                    resultat = operand1 - operand2;
                    break;
                case 3:
                    resultat = operand1 * operand2;
                    break;
                case 4:
                    resultat = operand1 / operand2;
                    break;
                case 5:
                    resultat = operand1 % operand2;
                    break;
            }
            return resultat;
        } catch (Exception e) {
            System.out.println("Dieser Operator ist ungültig");
            return resultat;
        }
    }

    public static void printResultat(int o1, int o2, int o, int resultat) {
        System.out.println("Operand 1: " + o1 + " " + "Operand 2: " +o2 + " " + "Operator: " +o + " " + "Resultat: " + resultat);
    }
}
