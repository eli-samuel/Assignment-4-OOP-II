// -----------------------------------------------------
// Assignment 4
// Question: Part 2 (LinkedList)
// Written by: Eli Samuel (40122277) and David Roper (40131739)
// -----------------------------------------------------

/**
* Names
* @author Eli Samuel 40122277
* @author David Roper 40131739
* Comp249
* Assignment 4
* Due Date: April 19th 2020
*/

/*
* This Subdictionary program is one that takes a text file and store it into a arraylist using File I/O scanner and printwriter
* methods as well as the replaceAll method. First it asks a user for the text file input which it reads with a scanner variable
* and places it in the arraylist, however before it does this the replaceAll method is used to remove all special characters (?!:;) as well
* as apostrophes before a m or s. Then converts the word to uppercase and then checks if it contains a digit, is a single letter (except A or I)
* and if its not already part of the Arraylist for adding it to the list. After going through the text file and adding the words to the
* Arraylist the list is sorted alphabetically using .sort() and then output into a subdictionary text file where every letter is labeled and
* the words starting with that letter are listed under it.
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SubDictionary {

    public static void main(String[] args) {
        System.out.println("Welcome to the SubDictionary program by Eli Samuel and David Roper");
        System.out.print("Enter file name: ");

        //initialize ArrayList dict of type string and the file I/O variables
        ArrayList<String> dict = new ArrayList<>();
        Scanner input = null;
        PrintWriter output = null;

        //try catch blocks for input/output exception catching
        try {
            input = new Scanner(new FileInputStream(/*new Scanner(System.in).next()*/"PersonOfTheCentury.txt"));
            output = new PrintWriter(new FileOutputStream("SubDictionary.txt"));

            while (input.hasNext()) {
                //removes special characters from the string
                String word = input.next().replaceAll("(’[ms])$|[’'.?,!:;]$", "").toUpperCase();

                //if the word matches any digit or is a single letter (exception of A and I) and the arraylist doesn't
                //already have the word in it it will add the word to the arraylist
                if (word.matches("([^\\d])+") && !word.matches("^[^A^I]$") && !dict.contains(word)) dict.add(word);
            }
            dict.sort(null); //dict.trimToSize();
            output.println("There are " + dict.size() + " entries in this sub-dictionary.");

            //start char variable at 'A'-1
            char letter = 64;

            //for loop iterates through the ArrayList dict.
            for (String word : dict) {
                //if the first letter of a word in dict is not the same char as letter, we change the label
                if (word.charAt(0) != letter) {
                    //while loop to increment letter until the chars are the same
                    while (word.charAt(0) != letter) letter++;
                    output.println("\n" + letter + "\n===");
                }
                output.println(word);
            }
        }
        //catch when file is not found
        catch(FileNotFoundException e) { System.out.println(e.getMessage()); }
        //close streams
        finally {
            if (input != null) input.close();
            if (output != null) output.close();
        }
        System.out.println("Thank you for using our program!");
    }
}
