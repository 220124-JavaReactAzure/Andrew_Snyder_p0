package com.revature.bankofandrew.util.collections;

//generics - they're used to help with varying/muiltiple data types
public interface Collection<T> {

	boolean add(T element);
	
	boolean contains(T element);
	
	boolean isEmpty();
	
	boolean remove(T element);
	
	int size();

	
}