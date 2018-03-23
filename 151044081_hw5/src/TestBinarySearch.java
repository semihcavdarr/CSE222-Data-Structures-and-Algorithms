import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by semih on 31.03.2017.
 */
public class TestBinarySearch {

    public static void main(String args[]) {
        BufferedReader br = null;
        String line = "";
        BinaryTree binaryTree = new BinaryTree();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        try {
            br = new BufferedReader(new FileReader("test.txt"));
            /*read line by line*/
            while ((line = br.readLine()) != null) {
                for (String retval : line.split(" ")) {
                    binaryTree.insertTree(retval);
                    binarySearchTree.add(retval);

                }
            }
            binaryTree.iterator();
            binarySearchTree.levelOrderIterator();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
