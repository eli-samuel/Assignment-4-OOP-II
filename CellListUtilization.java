import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class CellListUtilization {

    public static void main(String[] args) {
        CellList list1 = new CellList();
        CellList list2 = new CellList();

        Scanner input = null;
        try {
            input = new Scanner(new FileInputStream("Cell_Info.txt"));

            CellPhone c = new CellPhone(input.nextLong(), input.next(), input.nextDouble(), input.nextInt());
            System.out.println(c.getSerialNum());
            while (input.hasNextLine() && !(list1.contains(c.getSerialNum()))) {
                list1.addToStart(c);
                System.out.println("added");
                c = new CellPhone(input.nextLong(), input.next(), input.nextDouble(), input.nextInt());
            }

            list1.show();
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (input != null) input.close();
        }

    }
}
