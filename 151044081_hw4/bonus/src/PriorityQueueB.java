import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by semih on 22.03.2017.
 */
public class PriorityQueueB<E> {

    LinkedList<E> list = new LinkedList<E>();
    Iterator it = list.iterator();

    public PriorityQueueB(){

    }

    public void add(E item){
        list.add(item);
    }

    public int size(){

        return list.size();
    }

    public boolean isEmpty(){

        return size() == 0 ;
    }

    public E deleteMin(){

        return null;
    }
    public String toString(){

        return list.toString();
    }

}
