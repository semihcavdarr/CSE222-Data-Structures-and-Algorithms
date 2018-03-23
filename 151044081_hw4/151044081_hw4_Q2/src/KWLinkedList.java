import java.util.*;

public class KWLinkedList<E> {
    // Data fields
    protected Node<E> head = null;   // points to the head of the list
    protected Node<E> tail = null;   //points to the tail of the list
    protected int size = 0;    // the number of items in the list

    public void add(int index, E obj) {
        ListIterator<E> iter = listIterator(index);
        iter.add(obj);
    }
    public void addFirst(E obj) { add(0, obj);  }
    public void addLast(E obj) { add(size, obj);  }

    public E get(int index) {
        ListIterator<E> iter = listIterator(index);
        return iter.next();
    }
    public E getFirst() { return head.data;  }
    public E getLast() { return tail.data;  }

    public int size() {  return size;  }

    public E remove(int index) {
        E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext()) {
            returnValue = iter.next();
            iter.remove();
        }
        else {
            throw new IndexOutOfBoundsException();
        }
        return returnValue;
    }

    public Iterator iterator() { return new KWListIter(0);  }

    public ListIterator listIterator() { return new KWListIter(0);  }

    public ListIterator listIterator(int index){return new KWListIter(index);}

    public ListIterator listIterator(ListIterator iter) {
        return new KWListIter( (KWListIter) iter);
    }

    // Inner Classes
    protected static class Node<E> {
        protected E data;
        protected Node<E> next = null;
        protected Node<E> prev = null;

        protected Node(E dataItem)  //constructor
        {
            data = dataItem;
        }
    }  // end class Node

    public class KWListIter implements ListIterator<E> {

        protected Node<E> nextItem;      // the current node
        protected Node<E> lastItemReturned;   // the previous node
        protected int index = 0;   //

        public KWListIter(int i)  // constructor for KWListIter class
        {   if (i < 0 || i > size)
        {     throw new IndexOutOfBoundsException("Invalid index " + i); }
            lastItemReturned = null;

            if (i == size)     // Special case of last item
            {
                index = size;
                nextItem = null;      }
            else          // start at the beginning
            {   nextItem = head;
                for (index = 0; index < i; index++)
                    nextItem = nextItem.next;
            }// end else
        }  // end constructor

        public KWListIter(KWListIter other)
        {   nextItem = other.nextItem;
            index = other.index;    }

        public boolean hasNext() {   return nextItem != null;    }
        public boolean hasPrevious()
        {   return (nextItem == null && size != 0) || nextItem.prev != null;   }
        public int previousIndex() {  return index - 1;    }
        public int nextIndex() {  return index;    }
        public void set(E o)  { }  // not implemented
        public void remove(){

            Node<E> temp = head;

            if(head != null)

                head = head.next;

            if(temp != null){

                size--;
            }
        }      // not implemented

        public E next()
        {   if (!hasNext()) {  throw new NoSuchElementException();   }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        public E previous()
        {   if (!hasPrevious()) {   throw new NoSuchElementException();   }
            if (nextItem == null) { nextItem = tail;  }
            else {  nextItem = nextItem.prev;  }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        public void add(E obj) {
            if (head == null){     // add to an empty list
                head = new Node(obj);
                tail = head;
            }
            else if (nextItem == head){  // insert at head
                Node newNode = new Node(obj);    // Create a new node
                newNode.next = nextItem; // link it to the nextItem
                nextItem.prev = newNode;  // link nextItem to the new node
                head = newNode; // The new node is now the head
            }
            else if (nextItem == null){ // insert at tail
                Node newNode = new Node(obj);// Create a new node
                tail.next = newNode; // Link the tail to the new node
                newNode.prev = tail;      // Link the new node to the tail
                tail = newNode; // The new node is the new tail
            }
            else{      // insert into the middle
                Node newNode = new Node(obj);
                newNode.prev = nextItem.prev; // Link it to nextItem.prev
                nextItem.prev.next = newNode;  // Link it to the nextItem
                newNode.next = nextItem;
                nextItem.prev = newNode;
            }
            // Increase size and index

            size++;
            index++;
        } // end of method add


    }// end of inner class KWListIter
}// end of class KWLinnkedList
