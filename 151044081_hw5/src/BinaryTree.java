import java.util.Iterator;

/**
 * Created by semih on 30.03.2017.
 */
public class BinaryTree<E> implements Iterable<E>{
    /**
     * Iterate the binary tree with preOrderTraverse*/
    public Iterator<E> iterator() {
        if(root == null)
            return null;
        else{
            System.out.println(toString());
        }
        return new Iterator<E>() {
            public void remove() {

            }

            public boolean hasNext() {
                return (root.right != null && root.left != null);
            }

            public E next() {
                return root.data;
            }
        };
    }
    /**
     The root of binaryTree*/
    protected Node<E> root = null;

    //Constructors
    public BinaryTree(){
        root = null;
    }

    protected BinaryTree(Node<E> root){
        this.root = root;
    }

    /** Constructs a new binary tree with data in its root leftTree
     as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data,BinaryTree<E> leftTree,BinaryTree<E> rightTree){

        root = new Node<E>(data);
        if(leftTree != null)
            root.left =leftTree.root;
        else
            root.left=null;
        if(rightTree != null)
            root.right = rightTree.root;
        else
            root.right = null;
    }
    /**BinaryTree insert method*/
    public void insertTree(E data) {
        root = insertTree(root, data);
    }

     /* Function to insert data recursively */

    private Node<E> insertTree(Node<E> localRoot, E data) {
        if (localRoot == null)
            localRoot = new Node(data);
        else {
            if (localRoot.getRight() == null)
                localRoot.right = insertTree(localRoot.right, data);
            else
                localRoot.left = insertTree(localRoot.left, data);
        }
        return localRoot;
    }
    /**
     * Return the left subtree
     * @return The left subtree or null if either the root or the left subtree is null*/
    public BinaryTree<E> getLeftSubtree(){
        if(root != null && root.left != null)
            return new BinaryTree<E>(root.left);
        else
            return null;
    }

    /**
     * Determine whether this tree is a leaf
     * @return true if the root has no children
     * */
    public boolean isLeaf(){
        return (root.left == null && root.right == null);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        toString(root,1,sb);
        return sb.toString();
    }
    /** Converts a sub‐tree to a string.
     Performs a preorder traversal.
     @param node The local root
     @param depth The depth
     @param sb The StringBuilder to save the output
     */
    private void toString(Node<E> node, int depth,
                          StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append(" ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left, depth + 1, sb);
            toString(node.right, depth + 1, sb);
        }
    }

}
