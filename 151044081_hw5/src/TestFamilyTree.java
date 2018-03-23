import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by semih on 03.04.2017.
 */
public class TestFamilyTree {

    public static void main(String args[]){

        FamilyTree familyTree = new FamilyTree();
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader("family.txt"));
            /*read line by line*/
            while ((line = br.readLine()) != null) {
                String [] array = line.split(",");
                if(array.length == 1)
                    familyTree.add(array[0]);
                else
                    familyTree.add(array[0],array[1],array[2]);

            }
            familyTree.toString();
            System.out.println(familyTree.root.data);
            System.out.println(familyTree.root.left.data);
            System.out.println(familyTree.root.left.left.data);
            System.out.println(familyTree.root.left.right.data);
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }
}
