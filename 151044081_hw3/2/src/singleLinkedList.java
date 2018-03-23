/**
 * Created by semih on 15.03.2017.
 */
import java.util.*;
public class singleLinkedList<E>{

    /**Uses in reverseToString*/
    private String reverseString ="";

    private int sizeOfTemp = 0;

    /**Reference to list head*/
    public Node<E> head = null;
    /**The number of item in the list*/
    public int size;
    /**Getter for the list size
     @return size
     */
    public int getSize(){

        return size;
    }

    /**Setter for the list size
     @param _size length of list
     */
    public void setSize(int _size){

        size = _size;
    }
    /** Add an item to the front of the list.
     @param item The item to be added
     */
    public void addFirst(E item){

        head = new Node<E>(item,head);
        size++;
    }

    /** Add an node  after a given node.
     @param item The item to be inserted
     @param node The node preceding the new item
     */
    public void addAfter(Node<E> node,E item){


        node.next = new Node<E>(item,node.next);
        size++;
    }


    /**Remove the node  after a given node.
     @param node The node before the one to be removed
     @returns The data from the removed node,or null
     if there is a no node to remove
     */
    private E removeAfter(Node<E> node){

        Node<E> temp = node.next;

        if(temp != null){

            node.next = temp.next;

            size--;

            return temp.data;

        }
        else{

            return null;
        }
    }
    /**Remove the first node from the list.
     @returns The removed node's data or null
     if the list is empty
     */
    private E removeFirst(){

        Node<E> temp = head;

        if(head != null)

            head = head.next;

        if(temp != null){

            size--;

            return temp.data;
        }
        else
            return null;
    }
    /**Find the node at a specified position
     @param index The position of the node sought
     @return The node at index or null if it doesnt exist
     */
    public Node<E> getNode(int index){

        Node<E> node = head;

        for(int i = 0 ; i < index && node != null ; i++){

            node = node.next;
        }
        return node;
    }

    /**Get the data value at index
     @param index The position of the element to return
     @return The data at index
     @throws IndexOutOfBoundsException if index is out of range
     */

    public E get(int index){

        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException(Integer.toString(index));

        Node<E> node = getNode(index);

        return node.data;
    }


    /**Set the data value at index
     @param index The position of the item to change
     @param newValue The new value
     @return The data value priviously at index
     @throws IndexOutOfBoundsException if index is out of range
     */
    public E set(int index,E newValue){

        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException(Integer.toString(index));

        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }
    /**Insert the specified item at index
     @param index The position where item is to be inserted
     @param item The item to be inserted
     @throws IndexOutOfBoundsException if index is out of range
     */
    public void add(int index,E item){


        if(index < 0 || index >size)

            throw new IndexOutOfBoundsException(Integer.toString(index));

        if(index == 0)
            addFirst(item);

        else{

            Node<E> node = getNode(index-1);
            addAfter(node,item);
        }

    }
    /**Method for the SingleLinkedList class which will create a reversed String
     @return Reversed String
     */
    public String reverseToString(){

        if(size == 0){

            String tmp = reverseString;

            size = sizeOfTemp ;

            sizeOfTemp = 0 ;

            reverseString = "";

            return tmp;
        }
        else {

            reverseString = reverseString + get(size -1);

            size--;

            sizeOfTemp++;

            if(size > 0)

                reverseString = reverseString + ",";

        }

        return reverseToString();

    }

    public String toStringIndex(){

		/*uses index and get method*/

        String result ="";
        Node<E> temp = head.next;
        int i ;
        if(head == null)
            return result;

        result = result + head.data;
        while(temp != null)
        {
            result = result + "," +temp.data;
            temp = temp.next;
        }


        return result;

    }


}