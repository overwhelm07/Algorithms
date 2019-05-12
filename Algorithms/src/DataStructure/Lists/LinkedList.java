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
		
		if(position < 0 || position >= size + 1) {
			return;
		}
		
		int idx;
		Node node;
		Node insertNode = new Node(data);
		
		//start head
		if(Math.abs(0 - position) < Math.abs(size-1 - position)) {
			idx = 0;
			node = head;
			while(idx!=position) {
				node = node.next;				
				idx++;
			}
		}
		else {
			idx = size-1;
			node = tail;
			while(idx!=position) {
				node = node.prev;
				idx--;
			}
		}
		
		insertNode.prev = node.prev;
		insertNode.next = node;
		node.prev.next = insertNode;
		node.prev = insertNode;
		
		size++;
		
		
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
	
		if(position < 0 || position >= size) {
			return;
		}
		
		int idx;
		Node node;
		
		//start head
		if(Math.abs(0 - position) < Math.abs(size-1 - position)) {
			idx = 0;
			node = head;
			while(idx!=position) {
				node = node.next;				
				idx++;
			}
		}
		else {
			idx = size-1;
			node = tail;
			while(idx!=position) {
				node = node.prev;
				idx--;
			}
		}
		
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		node.next = node.prev = node = null;
		
		size--;
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
