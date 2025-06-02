package com.chinazhouwy.data_structures;

public interface Queue<E> {
	
	int getSize();
	
	boolean isEmpty();
	
	void enqueue(E e);
	
	E dequeue();
	
	E getFront();

}
