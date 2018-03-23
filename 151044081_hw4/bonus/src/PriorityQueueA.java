import java.util.LinkedList;

/**
 * Created by semih on 22.03.2017.
 */
public class PriorityQueueA<E> extends LinkedList<E> {

    public PriorityQueueA(){

        super();
    }

    public boolean add(E item){

        return super.add(item);
    }
    public void addLast(E item){

        super.addLast(item);

    }

    public int size(){

        return super.size();
    }

    public boolean isEmpty(){

        return size() == 0 ;
    }
    public E deleteMin(){



        return null;
    }
    public String toString(){

        return super.toString();
    }

}
