package m226_1.t1_hello_world;
import javax.sound.midi.SysexMessage;
import java.util.*;

public class Mastermind {
    Character[] colorArray = new Character[]{'r', 'b', 'g', 'y', 'w', 's'};
    ArrayList<Character> colors = new ArrayList<>(Arrays.asList(colorArray));
    ArrayList<Character> colorsCopy = new ArrayList<>(colors);
    public static void main(String[] args) {
        boolean found = false;
        ArrayList<Character> codeToCrack = GeheimCodeSetzen();
        while (found == false){
            ArrayList<Character> correctInput = InputKontrollieren();
            int [] resultKnacken = GeheimCodeKnacken(codeToCrack, correctInput);
            if (resultKnacken[2] == 1) {
                found = true;
            }
            ResultatAusgeben(resultKnacken);
        }

    }

    public static ArrayList<Character> GeheimCodeSetzen(){
        Random rand = new Random();
        Character[] colorArray = new Character[]{'r', 'b', 'g', 'y', 'w', 's'};
        ArrayList<Character> colors = new ArrayList<>(Arrays.asList(colorArray));
        ArrayList<Character> colorsCopy = new ArrayList<>(colors);
        ArrayList<Character> codeToCrack = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int upperbound = colorsCopy.size();
            int int_random = rand.nextInt(upperbound);
            codeToCrack.add(colorsCopy.get(int_random));
        }
        System.out.println(codeToCrack);
        return codeToCrack;
    }

    public static ArrayList<Character> InputKontrollieren() {
        Character[] colorArray = new Character[]{'r', 'b', 'g', 'y', 'w', 's'};
        ArrayList<Character> colors = new ArrayList<>(Arrays.asList(colorArray));
        System.out.println("Have a guess what the Code could be? [r,b,g,y,w,s]");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String guessString = myObj.nextLine();  // Read user input
        ArrayList<Character> guess = new ArrayList<>();
        for (char c : guessString.toCharArray()) {
            if (colors.contains(c)) {
                guess.add(c);
            } else {
                System.out.println("This is not a valid color!" + guessString);
                guess.clear();
                return InputKontrollieren();
            }
        }
        if (guessString.length() != 4) {
            System.out.println("The input needs to be 4 character string and can only contain characters: r,b,g,y,w,s!" + guess);
            return InputKontrollieren();
        }
        return guess;
    }

    public static int[] GeheimCodeKnacken(ArrayList<Character> codeToCrack,ArrayList<Character> guess){
        int found = 0;
        int truePos = 0;
        int trueCol = 0;
        int indexGuess = 0;

        if (codeToCrack.equals(guess))
        {
            found = 1;
        }

        for (char bs1 : guess) {
            int indexCode = 0;
            for (char bs2 : codeToCrack) {
                if (bs1 == bs2 && indexGuess == indexCode) {
                    truePos++;
                } else if (bs1 == bs2 && indexGuess != indexCode) {
                    trueCol++;
                }
                indexCode++;
            }
            indexGuess++;
        }
        int[] result = new int[3];
        result[0] = truePos;
        result[1] = trueCol;
        result[2] = found;
        return result;
    }

    public static void ResultatAusgeben(int[] trueVals){
        if (trueVals[2] == 1) {
            System.out.println("Your guess was correct!");
        }
        else {
            System.out.println(trueVals[0] + " of your guess character(s) were on the correct Position and " + trueVals[1] + " of your guess character(s) were the right color but not on the right position");
        }
    }
}
