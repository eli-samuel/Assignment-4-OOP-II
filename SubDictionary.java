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
            output = new PrintWriter(new FileOutputStream("subdictionary.txt"));

            while (input.hasNext()) {

                String word = input.next()/*.trim()????*/;
                if (word.contains("’")) word = word.substring(0, word.indexOf("’"));
                word = word.replaceAll("[’'.?,!:;]$", "").toUpperCase();
                if (word.matches("([^\\d])+") && !word.matches("^[^A^I]$") && !dict.contains(word)) {
                    dict.add(word);
                }
            }
            dict.sort(null);
            output.println("There are " + dict.size() + " entries in this sub-dictionary.");

            char letter = 65;
            while (letter-65 < dict.size) {
                output.println(letter + "\n===");
                output.println(dict);
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
        //return in.next();
        return "PersonOfTheCentury.txt";
    }
}

//word = word.replaceAll("(?i)([\\.\\?\\,\\!\\:\\;]$|(\\WS)|(\\WM))", "").toUpperCase();
//word.matches("((?i)([^0-9]{2,})|(mcÂ²)|(^i$)|(^a$))") && !dict.contains(word)
