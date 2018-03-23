import java.util.*;
import java.io.*;
@SuppressWarnings("unchecked")

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
	// write your code here

        Scanner scanner = new Scanner(new File("numbers.txt"));

        singleLinkedList array = new singleLinkedList();

        int i = 0 ;

        try{
            System.out.println("Elemanlar okunuyor:");
            while (scanner.hasNextInt()) {

                array.add(i,scanner.nextInt());

                //System.out.println(array.get(i));

                i++;
            }

            scanner.close();
            System.out.println(array.toStringIndex()+"\n");
            for(int a = 0 ; a < 50 ; a++){
                array.removeFirst();
            }

            i = i-50;

            System.out.println("50 eleman silindi\n");

            System.out.println(array.toStringIndex());

            System.out.println("Silinenler :" + array.deletedToString());

            Scanner scanner2 = new Scanner(new File("numbers.txt"));

            System.out.println("Elemanlar okunuyor:");

            while (scanner2.hasNextInt()) {

                array.add(i,scanner2.nextInt());

                //System.out.println(array.get(i));

                i++;
            }

            System.out.println(array.toStringIndex());

        }

        catch(Exception e){

            e.printStackTrace();
        }

    }
}
