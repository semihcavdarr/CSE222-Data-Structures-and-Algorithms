import java.util.NoSuchElementException;

/**
 * Created by semih on 21.03.2017.
 */
public class StackC<E> implements StackInterface<E> {

    public Node<E> head = null;

    private int size = 0 ;

    public StackC(){


    }
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public E pop() throws NoSuchElementException{

        if(size() == 0)
            throw new NoSuchElementException("Çıkartılacak eleman yok");
        else{
            head = head.next;
            size--;
            return head.next.data;
        }
    }

    @Override
    public E push(E item) {

        if(head == null)

            head = new Node<E>(item);

        if(head != null) {

            head.next = new Node<E>(item);


//            Node<E> temp = head;

            head.prev = head;
//            head.next = temp;

        }
        size++;
        return item;
    }

    /*public String toString(){

        String result = "";

        Node<E> current;
        current = head;

        int i = size();
        while(i>0){
            result += current.data + ", ";
            current = current.next;

            i--;
        }

        return result;
    }*/
}
