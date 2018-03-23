import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by semih on 21.03.2017.
 */
public class StackA<E> extends ArrayList<E> implements StackInterface<E> {

    public StackA(){
        super();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public E pop() throws NoSuchElementException{

        if(size() == 0 )
            throw new NoSuchElementException("Çıkartılacak eleman yok");

        E value = super.get(size()-1);
        super.remove(size()-1);
        return value;
    }

    @Override
    public E push(E item) {

        super.add(item);

        return item;
    }

    public String toString(){

       return super.toString();
    }
}
