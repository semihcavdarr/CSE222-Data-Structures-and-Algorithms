import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by semih on 23.03.2017.
 */
public class Main {

    public static void main(String args[]) throws IOException{

        PriorityQueueA a = new PriorityQueueA();

        PriorityQueueB b = new PriorityQueueB();

        BufferedReader br = null;

        String line = "";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("testResult_3.csv");
            br = new BufferedReader(new FileReader("test.csv"));

            /*read line by line*/
            while ((line = br.readLine()) != null) {
            	/*parse the line to ";"*/
                for (String retval : line.split(",")) {
                    a.add(retval);
                    b.add(retval);
                }
            }
            fileWriter.append(a.toString());
            fileWriter.append("\n");
            fileWriter.append(b.toString());
            fileWriter.append("\n");
            fileWriter.flush();
            fileWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
