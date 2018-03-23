/**
 * Created by semih on 22.03.2017.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
public class Main {
    public static void main(String args[]){

        BufferedReader br = null;
        String line = "";
        StackA a = new StackA();
        StackB b = new StackB();
        StackC c = new StackC();
        StackD d = new StackD();
        FileWriter fileWriter = null;
        String result="";
        String result2 = "";
        String result3 = "";
        String result4 = "";
        try {
            fileWriter = new FileWriter("testResult_1.csv");
            br = new BufferedReader(new FileReader("test.csv"));

            /*read line by line*/
            while ((line = br.readLine()) != null) {
            	/*parse the line to ";"*/
                for (String retval: line.split(",")) {
                    a.push(retval);
                    b.push(retval);
                    c.push(retval);
                    d.push(retval);
                }
            }
            long start = System.nanoTime();
            for(int i = 0 ; i < 20 ; i++){

                a.push(i);


            }
            long end = System.nanoTime();
            long total = end - start;
            System.out.println("StackA : " +total+ "ns");
            start = System.nanoTime();
            for(int j = 0 ; j < 20 ; j++){

                b.push(j);

            }
            end = System.nanoTime();
            total = end - start;
            System.out.println("StackB : " +total+ "ns");
            start = System.nanoTime();
            for(int t = 0 ; t < 20 ; t++){

                c.push(t);

            }
            end = System.nanoTime();
            total = end - start;
            System.out.println("StackC : " +total+ "ns");
            start = System.nanoTime();
            for(int k = 0 ; k < 20 ; k++){

                d.push(k);

            }
            end = System.nanoTime();
            total = end - start;
            System.out.println("StackD : " +total+ "ns");



            fileWriter.append(String.valueOf(a.size()));
            fileWriter.append(",");
            fileWriter.append(a.toString());
            fileWriter.append("\n");
            fileWriter.append(String.valueOf(b.size()));
            fileWriter.append(",");
            fileWriter.append(b.toString());
            fileWriter.append("\n");
            fileWriter.append(String.valueOf(c.size()));
            fileWriter.append(",");
            fileWriter.append(c.toString());
            fileWriter.append("\n");
            fileWriter.append(String.valueOf(d.size()));
            fileWriter.append(",");
            fileWriter.append(d.toString());
            fileWriter.append("\n");

            fileWriter.flush();
            fileWriter.close();

        } /*Throw exception*/
        catch(Exception e){

            e.printStackTrace();
        }
    }
}
