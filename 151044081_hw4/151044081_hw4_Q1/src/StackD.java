import java.util.*;

/**
 * Created by semih on 21.03.2017.
 */
public class StackD<E> implements StackInterface<E> {

    Queue<E> array = new LinkedList();

    public StackD(){
    }
    @Override
    public boolean isEmpty() {
        if (size() == 0) return true;
        else return false;
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public E pop() {

        if(size() == 0)
            throw new NoSuchElementException("Çıkartılacak eleman yok");
        int i = 0 ;
        while(i < size()-1){

            array.add(array.remove());
        }

        return (E) array.remove();
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
