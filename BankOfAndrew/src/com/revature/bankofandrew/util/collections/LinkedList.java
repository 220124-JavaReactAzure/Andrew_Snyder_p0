package com.revature.bankofandrew.util.collections;

import org.w3c.dom.Node;

import com.revature.bankofandrew.util.collections.List;

public class LinkedList<T> implements List<T> {
	
	private int size;
	private Node<T> head;
	private Node<T> tail;

	@Override // customerLinkedList.add(null)
	public boolean add(T element) {
		
		if(element == null) {
			return false;
		}
		
		Node<T> newNode = new Node<>(element);
		if(head == null) {
			tail = head = newNode;		
		} else {
			tail.nextNode = newNode;
			tail = newNode;
		}
		size++;
		
		return false;
	}

	@Override
	public boolean contains(T element) {

		Node<T> runner = head;
		
		while(runner != null) {
			if(runner.data.equals(element)) {
				return true;
			}
			
			runner = runner.nextNode;
		}

		
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<T> currentNode = head;
		for(int i = 0; i <= index; i++) {
			if(i == index) {
				return currentNode.data;
			}
			
			currentNode = currentNode.nextNode;
		}
		
		return null;

	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	private static class Node<T>{
		T data;
		Node<T> nextNode;
		
		public Node(T data) {
			this.data = data;
		}
	}

}