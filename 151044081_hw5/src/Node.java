/**
 * Created by semih on 31.03.2017.
 */
public class Node<E> {
        //Data fields

        /**The reference to the left child*/
        protected Node<E> left;
        /**The reference to the right child*/
        protected Node<E> right;

        /**The reference to the data*/
        protected E data;

        //Constructors

        /**Creates a new node with given data and no child
         @param data The data stored
         */
        public Node(E data)
        {
            this.data = data;
            left=null;
            right=null;
        }

        /**
         Return a string representation of the data
         @return A string representation of the data fields
         */
        public String toString(){

            return data.toString();
        }
        public Node<E> getLeft() {
            return left;
        }

        /* Function to get right node */

        public Node<E> getRight() {
            return right;
        }

        /* Function to set data to node */

        public void setData(E data) {
            this.data = data;
        }

        /* Function to get data from node */

        public E getData() {
            return data;
        }
}
