import java.util.*;
import java.io.*;
@SuppressWarnings("unchecked")

public class Main {

    public static void main(String[] args) throws FileNotFoundException{

        myStringBuilder builder = new myStringBuilder();

        Scanner scanner = new Scanner(new File("numbers.txt"));

        try {

            while (scanner.hasNextInt()) {

            /*add to linkedlist*/
                builder.append(scanner.nextInt());

            }

            PrintStream out1=new PrintStream(new FileOutputStream("result1.txt"));
            PrintStream out2=new PrintStream(new FileOutputStream("result2.txt"));
            PrintStream out3=new PrintStream(new FileOutputStream("result3.txt"));

            long start = System.nanoTime();
            out1.print(builder.toStringIndex());
            long end = System.nanoTime();
            long total = end - start;
            System.out.println("İndex kullanan :" + total + " ns");

            start = System.nanoTime();
            out2.print(builder.toStringLinkedlist());
            end = System.nanoTime();
            total = end - start;
            System.out.println("LinkedList kullanan :" + total + " ns");

            start = System.nanoTime();
            out3.print(builder.toStringIterator());
            end = System.nanoTime();
            total = end - start;
            System.out.println("Iterator kullanan :" + total + " ns");
        }
        catch(Exception e){

            e.printStackTrace();

        }
    }
}
