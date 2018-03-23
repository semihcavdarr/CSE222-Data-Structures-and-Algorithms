import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by semih on 21.03.2017.
 */
public class StackB<E> implements StackInterface<E> {

    public ArrayList<E> array;

    public StackB(){


        array = new ArrayList<E>();
    }
    @Override
    public boolean isEmpty() {
        if ((size() == 0)) return true;
        else return false;
    }

    @Override
    public int size() {

        return array.size();
    }

    @Override
    public E pop() throws NoSuchElementException{

        if(size() == 0 )

            throw new NoSuchElementException("Çıkartılacak eleman yok");

        int index = array.size();

        E value = array.get(index-1);

        array.set(index-1,null);

        return value;
    }

    @Override
    public E push(E item) {

        array.add(item);

        return item;
    }

    public String toString(){

        return array.toString();
    }
}
