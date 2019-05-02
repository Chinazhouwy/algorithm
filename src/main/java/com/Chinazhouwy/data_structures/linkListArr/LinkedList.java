package com.Chinazhouwy.data_structures.linkListArr;

public class LinkedList<E> {
	private class Node {
		public E e;
		public Node next;

		public Node(E e, Node node) {
			this.e = e;
			this.next = node;
		}

		public Node(E e) {
			this(e, null);
		}

		public Node() {
			this(null, null);
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}

	private Node dummyHead;

	private int size;

	public LinkedList(){
		dummyHead = null;
		size = 0;
	}
	
	public int getSize(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public void addFirst(E e){
		// Node node = new Node(e);
		// node.next = head;
		// head = node;
		// head = new Node(e,head);
		// size ++;
		add(0,e);
	}

	public void add(int index ,E e){
		if(index < 0 || index > size){
			throw new IllegalArgumentException();
		}
		if(size == 0){
			addFirst(e);
		}else{
			Node prev = dummyHead;
			for (int i = 0; i < index; i++) {
				prev = prev.next;
			}
			// Node node = new Node(e);
			// node.next = prev.next;
			// prev.next = node;
			prev.next = new Node(e,prev.next);
			size ++;
		}
	}

	public void addLast(E e){
		add(size,e);
	}

	public E get(int index){
		if(index < 0 || index > size){
			throw new IllegalArgumentException();
		}
		Node cur = dummyHead.next;		
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur.e;
	}

	public E getFirst(){
		return get(0);
	}

	public E getLast(){
		return get(size -1);	
	}

	public void set(int index,E e){
		if(index < 0 || index > size){
			throw new IllegalArgumentException();
		}
		Node cur = dummyHead.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		cur.e = e;
	}

	public boolean contains(E e){
		Node cur = dummyHead.next;
		while(cur != null){
			if(cur.e.equals(e)){
				return true;
			}else{
				cur = cur.next;
			}
		}
		return false;

	}

	public E remove(int index){
		if(index < 0 || index > size){
			throw new IllegalArgumentException();
		}
		Node prev = dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		Node retNode = prev.next;
		prev.next = retNode.next;
		retNode.next = null;
		size --;
		return retNode.e;
	}

	public E removeFirst(){
		return remove(0);
	}

	public E removeLast(){
		return remove(size - 1);
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		Node cur = dummyHead.next;
		while(cur != null){
			res.append(cur + "->");
			cur = cur.next;
		}
		res.append("NULL");
		return super.toString();
	}

	  

}
