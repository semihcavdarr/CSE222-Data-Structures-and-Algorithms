/**
 * Created by semih on 21.03.2017.
 */
public interface StackInterface<E> {

    public boolean isEmpty();

    public int size();

    public E pop();

    public E push(E item);
}
