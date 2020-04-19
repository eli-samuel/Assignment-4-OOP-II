// -----------------------------------------------------
// Assignment 4
// Question: Part 2 (Driver)
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
* This is the drive class for part 2 of the Assignment, is creates two Cellist which will be used to test
* multiple componets of java linked lists. First is takes and input from the Cell info text file, recording every phone
* with the exception of duplicates. Then the each line of the txt file is input and converted into a cellphone object and
* added to the LinkedList, this is done using the addtostart method. We then show the content with a show method. After the
* contents are shown the program asks for the user to input some serial numbers which will be used to search the CellList for
* said numbers and display the phone info. After that other methods such as insertAtIndex, equals method, etc. are tested as
* well as special cases.
*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class CellListUtilization {

    public static void main(String[] args) {
        System.out.println("Welcome to Cell Phones Records program by Eli Samuel and David Roper!");
        CellList list1 = new CellList();
        CellList list2 = new CellList();

        // part a)
        Scanner input = null;
        //try catch block
        try {
            //input txt file
            input = new Scanner(new FileInputStream("Cell_Info.txt"));
            //initialize a empty cellphone object
            CellPhone c = new CellPhone(0, "", 0, 0);
            while (input.hasNextLine()) {
                //insert cellphone from the text file into the CellList
                c = new CellPhone(input.nextLong(), input.next(), input.nextDouble(), input.nextInt());
                if (!(list1.contains(c.getSerialNum()))) list1.addToStart(c);
            }
        }
        //catch exceptions
        catch(FileNotFoundException e) { System.out.println(e.getMessage()); }
        finally { if (input != null) input.close(); }

        // part b)
        list1.show();

        // part c)
        Scanner in = new Scanner(System.in);
        //for loop to search list for 3 serial numbers
        for (int i=0; i<3; i++) {
            System.out.print("Enter a serial number: ");
            long sNum = in.nextLong();
            CellList.CellNode a = list1.find(sNum);
            System.out.println("The serial number is in the list at location: " + (a == null ? "DOES NOT EXIST" : a));

            // to show that it does not change it in the list
            // a.getPhone().setBrand("newBrand");
            // System.out.println(a.getPhone());
            // list1.show();
        }

        // part d)
        // testing insertAtIndex
        in.next();
        System.out.println("\nTesting insert at index:\n");

        //list1.insertAtIndex(new CellPhone(111111, "insertAtIndex test", 0, 2020), 234);
        list1.insertAtIndex(new CellPhone(333333, "insertAtHeadIndex", 0, 2020), 0); // special case insert at head
        list1.insertAtIndex(new CellPhone(111111, "insertAtIndex test", 0, 2020), 3);
        list1.insertAtIndex(new CellPhone(444444, "insertAtTailIndex", 0, 2020), 25); // special case insert at tail

        list1.show();
        in.next();

        // testing deleteFromIndex
        System.out.println("\nTesting delete from index:\n");
        //list1.deleteFromIndex(234);
        list1.deleteFromIndex(3);
        list1.deleteFromIndex(0);
        list1.deleteFromIndex(23);

        list1.show();
        in.next();

        // testing deleteFromStart
        System.out.println("\nTesting delete from start:\n");
        list1.deleteFromStart();
        list1.show();
        in.next();

        // testing replaceAtIndex
        System.out.println("\nTesting replace at index:\n");
        list1.replaceAtIndex(new CellPhone(222222, "replaceAtIndex test", 0, 2020), 10);
        list1.show();
        in.next();

        // testing equals (also tests CellNode and CellList clone)
        System.out.println("\nTesting equals:\n");
        System.out.println("List 1 is " + (list1.equals(list2) ? "" : "not") + " equal to list 2");
        list2 = list1.clone();
        System.out.println("List 1 is " + (list1.equals(list2) ? "" : "not") + " equal to list 2");
        list1.show();
        list2.show();

        // testing CellPhone clone
        System.out.println("\nTesting cellphone clone:\n");
        CellPhone cell = new CellPhone(123456, "clone test", 0, 2021);
        CellPhone cellClone = cell.clone();

        System.out.println(cell);
        System.out.println(cellClone);

        System.out.println("Thank you for using our program!");
    }
}
