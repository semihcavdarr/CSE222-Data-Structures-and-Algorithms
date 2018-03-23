import java.util.Iterator;

/**
 * Created by semih on 30.03.2017.
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>{
    // Data Fields
    /** Return value from the public add method. */
    protected boolean addReturn;
    /** Return value from the public delete method. */
    protected E deleteReturn;

    public Iterator<E> levelOrderIterator(){
        printTree(root);
        return new Iterator<E>() {
            public void remove() {

            }

            public boolean hasNext() {
                return false;
            }

            public E next() {
                return null;
            }
        };

    }
    /** Starter method find.
     pre: The target object must implement
     the Comparable interface.
     @param target The Comparable object being sought
     @return The object, if found, otherwise null
     */
    public E find(E target){
        return find(root,target);
    }
    /** Recursive find method.
     @param localRoot The local subtree's root
     @param target The object being sought
     @return The object, if found, otherwise null
     */
    private E find(Node<E> localRoot,E target){

        if(localRoot == null)
            return null;
        int compResult = target.compareTo(localRoot.data);

        if(compResult == 0)
            return localRoot.data;
        else if(compResult < 0)
            return find(localRoot.left,target);
        else
            return find(localRoot.right,target);

    }
    /** Starter method add.
     pre: The object to insert must implement the
     Comparable interface.
     @param item The object being inserted
     @return true if the object is inserted, false
     if the object already exists in the tree
     */
    public boolean add(E item){
        root = add(root,item);
        return addReturn;
    }
    /** Recursive add method.
     post: The data field addReturn is set true if the item is added to
     the tree, false if the item is already in the tree.
     @param localRoot The local root of the subtree
     @param item The object to be inserted
     @return The new local root that now contains the
     inserted item
     */
    private Node<E> add(Node<E> localRoot,E item){
        if(localRoot == null){
            addReturn = true;
            return new Node<E>(item);
        }
        else if(item.compareTo(localRoot.data) == 0){
            addReturn = false;
            return localRoot;
        }
        else if(item.compareTo(localRoot.data) < 0){
            localRoot.left = add(localRoot.left,item);
            return localRoot;
        }
        else{
            localRoot.right = add(localRoot.right,item);
            return localRoot;
        }
    }
    /** Starter method delete.
     post: The object is not in the tree.
     @param target The object to be deleted
     @return The object deleted from the tree
     or null if the object was not in the tree
     @throws ClassCastException if target does not implement
     Comparable
     */
    public E delete(E target){

        root = delete(root,target);
        return deleteReturn;
    }
    /** Recursive delete method.
     post: The item is not in the tree;
     deleteReturn is equal to the deleted item
     as it was stored in the tree or null
     if the item was not found.
     @param localRoot The root of the current subtree
     @param item The item to be deleted
     @return The modified local root that does not contain
     the item
     */
    private Node<E> delete(Node<E> localRoot,E item){
        if(localRoot == null){
            deleteReturn =null;
            return localRoot;
        }
        int compResult = item.compareTo(localRoot.data);
        if(compResult < 0){
            localRoot.left = delete(localRoot.left,item);
            return localRoot;
        }
        else if(compResult > 0){
            localRoot.right = delete(localRoot.right,item);
            return localRoot;
        }
        else{
            deleteReturn = localRoot.data;
            if(localRoot.left == null){
                return localRoot.right;
            }
            else if(localRoot.right == null){
                return localRoot.left;
            }
            else{
                if(localRoot.left.right == null){
                    localRoot.data = localRoot.left.data;
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                }
                else
                    localRoot.data = findLargestChild(localRoot.left);
                return localRoot;
            }
        }
    }
    /**Calculate the maximum depth in the tree
     @param root
     @return the max depth*/
    private int depth(Node<E> root){
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        int ldepth = depth(root.left);

        int rdepth = depth(root.right);

        if(ldepth < rdepth)

            return rdepth+1;

        else if(ldepth > rdepth)

            return ldepth+1;

        else

            return rdepth+1;
    }
    /** Find the node that is the
     inorder predecessor and replace it
     with its left child (if any).
     post: The inorder predecessor is removed from the tree.
     @param parent The parent of possible inorder
     predecessor (ip)
     @return The data in the ip
     */
    private E findLargestChild(Node<E> parent){
        if(parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        }
        else
            return findLargestChild(parent.right);
    }
    /**Prints the tree with levelorder
     * @param root*/
    private void printTree(Node<E> root){
        int level;
        int depth = depth(root);

        for(level=1; level<= depth; level++){
            System.out.println("Level:"+ level);
            levelOrderTraver(root, level);
        }
    }

    /**
     * Traverse the tree with levelorder
     * @param root
     * @param level*/
    private void levelOrderTraver(Node<E> root, int level){
        if(root == null)
            return;
        if (level == 1)
            System.out.println(root.data);

        levelOrderTraver(root.left, level-1);
        levelOrderTraver(root.right, level-1);
    }

}
