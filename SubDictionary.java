import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SubDictionary {

    public static void main(String[] args) {
        System.out.print("Enter file name: ");

        ArrayList<String> dict = new ArrayList<>();

        Scanner input = null;
        PrintWriter output = null;

        try {
            input = new Scanner(new FileInputStream(/*new Scanner(System.in).next()*/"PersonOfTheCentury.txt"));
            output = new PrintWriter(new FileOutputStream("SubDictionary.txt"));

            while (input.hasNext()) {
                String word = input.next().replaceAll("(’[ms])$|[’'.?,!:;]$", "").toUpperCase();
                if (word.matches("([^\\d])+") && !word.matches("^[^A^I]$") && !dict.contains(word)) dict.add(word);
            }
            dict.sort(null);
            // DO ARRALIST TRIM THING FIRST JUST IN CASE THERE ARE LESS THAN 10 ELEMENTS
            output.println("There are " + dict.size() + " entries in this sub-dictionary.");

            char letter = 64;
            for (String word : dict) {
                if (word.charAt(0) != letter) {
                    while (word.charAt(0) != letter) letter++;
                    output.println("\n" + letter + "\n===");
                }
                output.println(word);
            }
        }
        catch(FileNotFoundException e) { System.out.println(e.getMessage()); }
        finally {
            if (input != null) input.close();
            if (output != null) output.close();
        }
    }
}
