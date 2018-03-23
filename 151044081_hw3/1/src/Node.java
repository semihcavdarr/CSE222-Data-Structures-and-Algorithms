/**
 * Created by semih on 15.03.2017.
 */
public class Node<E>{
    //Data fields

    /**The reference to the data*/
    public Node<E> next;

    /**The reference to the next node*/
    public E data;


    //Constructors

    /**Creates a new node with a null next field.
     @param _data The data stored
     */
    public Node(E _data)
    {
        next = null;
        data = _data;
    }

    /**Creates a new node that references another node.
     @param _data The data stored
     @param _next The node references by new node
     */
    public Node(E _data, Node<E> _next)
    {
        next = _next;
        data = _data;
    }

    //getter for Node<E> next
    public Node<E> getNext() {

        return next;
    }

    //getter for E data
    public E getData(){

        return data;
    }


}
