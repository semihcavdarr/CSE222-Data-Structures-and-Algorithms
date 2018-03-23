/**
 * Created by semih on 15.03.2017.
 */
import java.util.*;
import java.io.*;

public class myStringBuilder<E>{
    /**single linkedlist reference*/
    public singleLinkedList<E> array = new singleLinkedList<E>();

    private int capacity ;

    /**Constructors
     */

    /**Creates new myStringBuilder with default capacity*/
    public myStringBuilder(){

        capacity = 16;

    }

    /**Create new myStringBuilder with _capacity
     @param _capacity The capacity of myStringBuilder reference*/
    public myStringBuilder(int _capacity){

        capacity = _capacity;
    }

    /**Insert the specified item at index
     @throws IndexOutOfBoundsException if index is out of range
     * @param anyThing The item to be inserted
     */
    public void append(Object anyThing){

        array.add((E) anyThing,array.getSize());

    }

    /**This method creat total return value using index and get method
     @return Total result
     */
    public String toStringIndex(){

		/*uses index and get method*/

        String result ="";

        int i ;

        for(i = 0; i < array.getSize() ; i++){

            result += array.get(i) + ", ";
        }

        return "toStringIndex : " + result;

    }

    /**This method creat total return value using linkedlist skills
     @return Total result
     */
    public String toStringLinkedlist(){
		/*linkedlist*/

        String result = "";

        Node<E> current = array.head;

        while(current != null){

            result +=current.data + ", ";

            current = current.next;

        }

        return "toStringLinkedlist : " + result;

    }

    /**This method creat total return value using iterator
     @return Total result
     */
	public String toStringIterator(){

		Iterator<E> it = array.iterator();

		String result="";

		while(it.hasNext()){

			result += it.next() + ", ";

		}

		return result;

	}

}