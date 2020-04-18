import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class CellListUtilization {

    public static void main(String[] args) {
        CellList list1 = new CellList();
        CellList list2 = new CellList();

        // part a)
        Scanner input = null;
        try {
            input = new Scanner(new FileInputStream("Cell_Info.txt"));

            CellPhone c = new CellPhone(0, "", 0, 0);
            while (input.hasNextLine()) {
                c = new CellPhone(input.nextLong(), input.next(), input.nextDouble(), input.nextInt());
                if (!(list1.contains(c.getSerialNum()))) {
                    list1.addToStart(c);
                    System.out.println("added");
                }

            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (input != null) input.close();
        }

        // part b)
        list1.show();

        // part c)
        Scanner in = new Scanner(System.in);
        for (int i=0; i<3; i++) {
            System.out.print("Enter a serial number: ");
            long sNum = in.nextLong();
            if (list1.contains(sNum)) {System.out.println("The serial number is in the list at location: " + (list1.find(sNum)));
        }
            else System.out.println("Sorry, that serial number is not in the list.");
        }

        // part d)
        // testing insertAtIndex
        System.out.println();

        try {
            //list1.insertAtIndex(new CellPhone(111111, "insertAtIndex test", 0, 2020), 234);
            list1.insertAtIndex(new CellPhone(111111, "insertAtIndex test", 0, 2020), 3);
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        list1.show();

        // testing deleteFromIndex
        System.out.println();
        try {
            //list1.deleteFromIndex(234);
            list1.deleteFromIndex(3);
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        list1.show();

        // testing deleteFromStart
        System.out.println();
        list1.deleteFromStart();
        list1.show();

        // testing replaceAtIndex
        System.out.println();
        list1.replaceAtIndex(new CellPhone(222222, "replaceAtIndex test", 0, 2020), 10);
        list1.show();

        // testing equals
        System.out.println();
        System.out.println("List 1 is " + (list1.equals(list2) ? "" : "not") + " equal to list2");
        list2 = new CellList(list1);
        System.out.println("List 1 is " + (list1.equals(list2) ? "" : "not") + " equal to list2");
        //list1.show();

    }
}
