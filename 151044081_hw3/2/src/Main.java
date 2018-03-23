public class Main {

    public static void main(String[] args) {
	// write your code here

        singleLinkedList array = new singleLinkedList();

        array.add(0,"nilay");
        array.add(1,"semih");
        array.add(2,"yağmur");

        System.out.println("ilk hali: "+array.toStringIndex()+"\n");

        System.out.println("Reverse: "+array.reverseToString()+"\n");
    }
}
