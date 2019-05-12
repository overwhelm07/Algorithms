package DataStructure.Lists;

public class ListTest {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		
		ll.insertHead(3);
		ll.insertHead(5);
		ll.insertHead(7);
		ll.deleteHead();
		ll.insertHead(9);		
		ll.display();
		ll.insertNth(2, 1);
		ll.display();
		ll.insertNth(2, 1);
		ll.display();
		ll.deleteNth(2);
		ll.display();

	}

}
