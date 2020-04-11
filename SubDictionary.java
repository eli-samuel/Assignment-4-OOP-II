import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SubDictionary {

    public static void main(String[] args) {

        String filename = start();

        ArrayList<String> dict = new ArrayList<String>();

        Scanner input = null;
        PrintWriter output = null;

        try {
            input = new Scanner(new FileInputStream(filename));
            output = new PrintWriter(new FileOutputStream("SubDictionary.txt"));

            while (input.hasNext()) {

                String word = input.next();
                word = word.replaceAll("(’[ms])$|[ï¿½'.?,!:;]$", "").toUpperCase();
                if (word.matches("([^\\d])+") && !word.matches("^[^A^I]$") && !dict.contains(word)) {
                    dict.add(word);
                }
            }
            dict.sort(null);
            output.println("There are " + dict.size() + " entries in this sub-dictionary.");

            char letter = 64;
            for (String word : dict) {
                if (word.charAt(0) != letter) output.println("\n" + ++letter + "\n===");
                output.println(word);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (input != null) input.close();
            if (output != null) output.close();
        }
    }

    public static String start() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter file name: \n");
        //return in.next();
        return "PersonOfTheCentury.txt";
    }
}
