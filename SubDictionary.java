import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//https://medium.com/factory-mind/regex-tutorial-a-simple-cheatsheet-by-examples-649dc1c3f285

public class SubDictionary {

    public static void main(String[] args) {

        String filename = start();

        ArrayList<String> dict = new ArrayList<String>();

        Scanner input = null;
        PrintWriter output = null;

        try {
            input = new Scanner(new FileInputStream(filename));
            output = new PrintWriter(new FileOutputStream("subdictionary.txt"));

            while (input.hasNext()) {

                String word = input.next()/*.trim()????*/;
                //if (word.contains("’")) word = word.substring(0, word.indexOf("’"));
                word = word.replaceAll("(’[ms])$|[’'.?,!:;]$", "").toUpperCase();
                if (word.matches("([^\\d])+") && !word.matches("^[^A^I]$") && !dict.contains(word)) {
                    dict.add(word);
                }
            }
            dict.sort(null);
            output.println("There are " + dict.size() + " entries in this sub-dictionary.");

            char letter = 64;

            int i=0;
            while (i < dict.size()) {
                if (dict.get(i).charAt(0) != letter) output.println("\n" + ++letter + "\n===");
                output.println(dict.get(i++));
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (input != null) input.close();
            if (output != null) output.close();
        }
        dict.sort(null);
        System.out.println("There are " + dict.size() + " entries in this sub-dictionary.");
        System.out.println(dict);
    }

    public static String start() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter file name: ");
        //  return in.next();
        return "PersonOfTheCentury.txt";
    }
}
