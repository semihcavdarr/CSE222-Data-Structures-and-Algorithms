/**
 * Created by semih on 01.04.2017.
 */
public class FamilyTree<E extends Comparable<E>> extends BinaryTree<E> {
    //Data field
    private E name;
    public E nameOfF;
    private E nick;
    private Node<E> temp = null;
    //Constructor
    public FamilyTree(E data){
        root = new Node<E>(data);
    }

    public FamilyTree(){
        super();
    }
    /**add method to FamilyTree using insert method
     * @param nameOfPerson person to be adding
     * @param personsFOrM name of person's father/mother
     * @param nickPersonsFOrM nickname of person's father's/mother's*/
    public void add(E nameOfPerson,E personsFOrM ,E nickPersonsFOrM){
        name = nameOfPerson;
        nameOfF = personsFOrM;
        nick = nickPersonsFOrM;
        insert(nameOfPerson);
    }
    public void add(E nameofp){
        name = nameofp;
        add(nameofp,null,null);
    }

    public void insert(E data) {
        root = insert(root, data);
    }

     /**FamilyTree insert method
      * @param localRoot beginning root to insert
      * @param data Node's data to stored
      * @return localRoot*/

    private Node<E> insert(Node<E> localRoot, E data) {
        if (localRoot == null)
            localRoot = new Node(data);
        else {
            Node<E> cur = find(nameOfF);
            if(cur == null) {
                System.out.println("Böyle bir parent yok");
                return null;
            }
            else {
                if (cur.getLeft() == null)
                    cur.left = new Node<E>(data);
                else if(cur.getLeft() != null) {
                    if (cur.left.data == name)
                        System.out.println("Bu kişi ağaçta var");
                    cur.left.right = new Node<E>(data);
                }
            }
        }
        return localRoot;
    }
    public Node<E> find(E target){
        return find(root,target);
    }
    /** Recursive find method.
     @param localRoot The local subtree's root
     @param target The object being sought
     @return The object, if found, otherwise null
     */
    private Node<E> find(Node<E> localRoot,E target){

        if(localRoot == null)
            return null;
        int compResult = target.compareTo(localRoot.data);

        if(compResult == 0)
            return localRoot;
        else if(compResult < 0)
            return find(localRoot.left,target);
        else
            return find(localRoot.right,target);

    }
}
