package com.chinazhouwy.data_structures.linkListArr;

import com.Chinazhouwy.data_structures.Queue;

public class LinkedListQueue<E> implements Queue<E> {
	
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
	
	private Node head, tail;
	private int size;
	
	public LinkedListQueue() {
		head = null;
		tail = null;
		size = 0;
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		if(tail == null) {
			tail = new Node(e);
			head = tail;
		}else {
			tail.next = new Node(e);
			tail = tail.next;
		}
		size ++;
	}

	@Override
	public E dequeue() {
		if(isEmpty()) {
			throw new IllegalArgumentException();
		}
		Node retNode = head;
		head = head.next;
		retNode.next = null;
		if(head == null) {
			tail = null;
		}
		size --;
		return retNode.e;
	}

	@Override
	public E getFront() {
		if(isEmpty()) {
			throw new IllegalArgumentException();
		}
		return head.e;
	}

}
