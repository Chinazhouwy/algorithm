package com.Chinazhouwy.data_structures.setstruct;

import com.Chinazhouwy.data_structures.tree.BST;

public class BSTSet<E extends Comparable<E>> implements Set<E>{
	
	private BST<E> bst = new BST<E>();

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		bst.add(e);
	}

	@Override
	public void remove(E e) {
		// TODO Auto-generated method stub
		bst.removeNode(e);
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return bst.contains(e);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return bst.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return bst.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
