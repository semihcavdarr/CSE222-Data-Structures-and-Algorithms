/**
 * Created by semih on 15.03.2017.
 */
import java.util.*;
import java.io.*;

public class singleLinkedList<E>{

    public class Node<E>{
        //Data fields

        /**The reference to the data*/
        private Node<E> next;

        /**The reference to the next node*/
        private E data;

        //Constructors

        /**Creates a new node with a null next field.
         @param _data The data stored
         */
        private Node(E _data)
        {
            next = null;
            data = _data;
        }


        /**Creates a new node that references another node.
         @param _data The data stored
         @param _next The node references by new node
         */
        private Node(E _data, Node<E> _next)
        {
            next = _next;
            data = _data;
        }

        //getter for Node<E> next
        public Node<E> getNext() {

            return next;
        }

    }

    public ArrayList<Node<E>> deletedNodes = new ArrayList();


    /**Reference to list head*/
    private Node<E> head = null;

    /**The number of item in the list*/
    private int size;

    public singleLinkedList(){

        size = 0 ;
    }

    /**Getter for the list size
     @return size
     */
    public int getSize(){

        return size;
    }

    /** Add an item to the front of the list using deletedNodes
     @param item The item to be added
     */
    public void addFirst(E item){

        if(deletedNodes.size() != 0){


            Node<E> tmp = deletedNodes.get(0);

            deletedNodes.remove(0);

            tmp.next = head;

            head = tmp;

            head.data = item;

            size++;

            return;
        }

        head = new Node<E>(item,head);
        size++;
    }

    /** Add an node  after a given node using deletedNodes.
     @param item The item to be inserted
     @param node The node preceding the new item
     */
    public void addAfter(Node<E> node,E item){

        if(deletedNodes.size() != 0){

            Node<E> tmp = deletedNodes.get(0);

            Node<E> tmp2 = node.next;

            deletedNodes.remove(0);

            node.next = tmp;

            tmp.next = tmp2;

            node.data = item;

            size++;

            return;
        }


        node.next = new Node<E>(item,node.next);
        size++;
    }

    /**Remove the node  after a given node.
     Store the removed node into deletedNodes
     @param node The node before the one to be removed
     @return The data from the removed node,or null
     if there is a no node to remove
     */
    public E removeAfter(Node<E> node){

        Node<E> temp = node.next;

        deletedNodes.add(temp);

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
     Store the removed node into deletedNodes
     @return The removed node's data or null
     if the list is empty
     */
    public E removeFirst(){

        Node<E> temp = head;

        deletedNodes.add(temp);

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

    public E get(int index){

        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException(Integer.toString(index));

        Node<E> node = getNode(index);

        return node.data;
    }

    /**Get the data value at index
     @param index The position of the element to return
     @return The data at index
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
    public void add(int index, E item){


        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException(Integer.toString(index));

        if(index == 0)
            addFirst(item);

        else{

            Node<E> node = getNode(index-1);
            addAfter(node,item);
        }
    }

    /**Add the deletedNodes to string result
     @return Total result
     */
    public String deletedToString(){

        String result = "";

        for(int i = 0 ; i < deletedNodes.size() ; i++){

            result+= deletedNodes.get(i).data +", ";
        }

        return result;
    }
    /**
     * Display the total string in list
     * @return total string
     * */
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


        return "toStringIndex : " + result;

    }
}
