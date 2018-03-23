/**
 * Created by semih on 23.03.2017.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main{

    public static void main(String args[]) throws IOException{

        myQueue q1 = new myQueue();
        BufferedReader br = null;
        String line = "";
        FileWriter fileWriter = null;
        String result="";
        int i = 0 ;


        try {
            fileWriter = new FileWriter("testResult_2.csv");
            br = new BufferedReader(new FileReader("test.csv"));

            /*read line by line*/
            while ((line = br.readLine()) != null) {
            	/*parse the line to ";"*/
                for (String retval : line.split(",")) {
                    q1.add(i, retval);
                    i++;
                }
            }
            //q1.reverse();
            fileWriter.append(q1.toString());
            fileWriter.append("\n");
            fileWriter.flush();
            fileWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();

        }


    }

}
