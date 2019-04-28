package DataStructure.Lists;


class LinkedList {
	private class Node{
		int val;
		Node next, prev;
		
		public Node(int val) {
			this.val = val;
			this.next = null;
			this.prev = null;
		}
		
	}
	
	private Node head, tail;
	private int size;
	
	public LinkedList() {
		this.size = 0;
		head = null;
		tail = null;
	}
	
	public void insertHead(int x) {
		
		if(isEmpty()) {
			head = tail = new Node(x);
			head.next = head.prev = tail;
			tail.next = tail.prev = head;
		}
		else {
			Node newNode = new Node(x);
			
			newNode.next = head;
			newNode.prev = tail;
			head.prev = newNode;
			tail.next = newNode;
			
			head = newNode;			
		}
		
		size++;
		
	}
	
	public void insertNth(int data, int position) {
		
	}
	
	public void deleteHead() {
		if(!isEmpty()) {			
			head = head.next;
			head.next.prev = head;
			head.prev = tail;
			tail.next = head;
			
			size--;
			
		}
	}
	
	public void deleteNth(int position) {
		
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {		
		return getSize()==0;
	}
	
	public void display() {
		System.out.println("Size : " + getSize());
		
		Node cur = head;
		
		while(cur!=null) {
			System.out.print(cur.val);
			cur = cur.next;
			if(cur!=head) {
				System.out.print(" -> ");
			}else {
				break;
			}
		}
		
		System.out.println();
	}
	

}
