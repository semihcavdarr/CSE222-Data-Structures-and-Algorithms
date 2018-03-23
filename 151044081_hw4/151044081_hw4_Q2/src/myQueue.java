import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by semih on 22.03.2017.
 */
public class myQueue<E> extends KWLinkedList<E> {

    ArrayList<E> arrayList = new ArrayList<E>();

    public void reverse() throws NoSuchElementException{

        if(head == null)
            throw new NoSuchElementException("Empty queue");

        else if(size() == 1)
            return;

        for(int i =0 ; i < size ; i++) {

            arrayList.add(get(i));
        }
        head = null;
        for(int j = arrayList.size()-1 ; j >= 0 ; j--){
            int k = 0 ;
            add(k,arrayList.get(j));
            k++;
        }

    }
    public String toString(){

        String result ="";

        for(int i = size-1 ; i >=1 ; i--){

            result += get(i) +",";
        }

        result+=get(0);

        return result;
    }
}
