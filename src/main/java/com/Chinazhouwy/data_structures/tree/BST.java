package com.chinazhouwy.data_structures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

	private class Node {
		public E e;
		public Node left, right;

		public Node(E e) {
			this.e = e;
			this.left = null;
			this.right = null;
		}
	}

	private int size;
	private Node root;

	public BST() {
		root = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(E e) {
//		if (root == null) {
//			root = new Node(e);
//			size++;
//		} else {
//			add(root, e);
//		}
		root = add(root, e);
	}

//	private void add(BST<E>.Node node, E e) {
//		// TODO Auto-generated method stub
//		if(e.equals(node.e)) {
//			return;
//		}else if(e.compareTo(node.e) < 0 && node.left == null) {
//			node.left = new Node(e);
//			size ++;
//			return ;
//		}else if(e.compareTo(node.e) > 0 && node.right == null) {
//			node.right = new Node(e);
//			size ++;
//			return ;
//		}
//		if(e.compareTo(node.e) < 0) {
//			add(node.left,e);
//		}else {
//			add(node.right,e);
//		}
//	} 

	private Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}

		if (e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		} else {
			node.right = add(node.right, e);
		}

		return node;
	}

	public boolean contains(E e) {
		return contains(root, e);
	}

	private boolean contains(BST<E>.Node node, E e) {
		// TODO Auto-generated method stub
		if (node == null) {
			return false;
		}

		if (e.compareTo(e) == 0) {
			return true;
		} else if (e.compareTo(e) < 0) {
			return contains(node.left, e);
		} else {
			return contains(node.right, e);
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node != null) {
			
			System.out.println(node.e);

			preOrder(node.left);

			preOrder(node.right);
		}

	}
	
	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node != null) {
			
			inOrder(node.left);
			
			System.out.println(node.e);

			inOrder(node.right);
		}

	}
	
	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node != null) {
			
			postOrder(node.left);
			
			System.out.println(node.e);

			postOrder(node.right);
		}

	}
	
	public void preOrderNR() {
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.e);
			if(cur.right != null) {
				stack.push(cur.right);
			}
			if(cur.left != null) {
				stack.push(cur.left);
			}
		}
	}
	
	public void levelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			if(cur != null) {
				System.out.println(cur.e);
				queue.offer(cur.left);
				queue.offer(cur.right);
			}
		}
	}
	
	public E mininum() {
		if(size == 0) {
			throw new IllegalArgumentException("BST is empty");
		}
		return mininum(root).e;
	}
	
	
	private Node mininum(BST<E>.Node node) {
		// TODO Auto-generated method stub
		if(node.left == null) {
			return node;
		}
		return mininum(node.left);
	}
	
	public E maxinum() {
		if(size == 0) {
			throw new IllegalArgumentException("BST is empty");
		}
		return maxinum(root).e;
	}
	
	
	private Node maxinum(BST<E>.Node node) {
		// TODO Auto-generated method stub
		if(node.right == null) {
			return node;
		}
		return maxinum(node.right);
	}
	
	public E removeMin() {
		E ret = mininum();
		removeMin(root);
		return ret;
	}
	
	private Node removeMin(BST<E>.Node node) {
		// TODO Auto-generated method stub
		if(node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size --;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}
	
	public E removeMax() {
		E ret = maxinum();
		removeMax(root);
		return ret;
	}
	
	private Node removeMax(BST<E>.Node node) {
		// TODO Auto-generated method stub
		if(node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size --;
			return leftNode;
		}
		node.right = removeMin(node.right);
		return node;
	}
	
	public void removeNode(E e) {
		root = remove(root,e);
	}

	private Node remove( BST<E>.Node node,E e) {
		// TODO Auto-generated method stub
		if(node == null) {
			return null;
		}
		
		if(e.compareTo( node.e) < 0) {
			node.left = remove(node.left,e);
			return node;
		}else if(e.compareTo( node.e) < 0) {
			node.right = remove(node.right,e);
			return node;
		}else {
			if(node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size --;
				return leftNode;
			}
			
			if(node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size --;
				return rightNode;
			} 
			
			Node successor = mininum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			node.left = node.right = null; 
			return successor;
		}
		
	}
	
	//需找某一个点的前驱和后继
	
	// rank select
	
	// 支持重复元素

	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		int[] nums = {5,3,6,8,4,2};
		for(int num : nums) {
			bst.add(num);
		}
		
		bst.preOrder();
		System.out.println("\n");
		bst.preOrderNR();
		System.out.println("\n");
		bst.levelOrder();
	}

}
