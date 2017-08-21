package test;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public class MyArrayList<E> extends AbstractList<E> 
		implements List<E>, RandomAccess, Cloneable, Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1524805664248531627L;
	
	private static final int DEFAULT_CAPACITY = 10 ;
	
	private static final Object[] EMPTY_ELEMENTDATA ={};
	
	private transient Object[] elementData;
	
	private int size;
	
	
	
	public MyArrayList(int initialCapacity) {
		super();
		if(initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity" + initialCapacity);
		this.elementData = new Object[initialCapacity];
	}
	public MyArrayList() {
		super();
		this.elementData = EMPTY_ELEMENTDATA;
	}
	
	public MyArrayList(Collection<? extends E> c){
		elementData = c.toArray();
		size = elementData.length;
		if(elementData.getClass() != Object[].class)
			elementData = Arrays.copyOf(elementData, size ,Object[].class);
	}
	
	public void trimToSize(){
		modCount++;
		if (size <elementData.length){
			elementData = Arrays.copyOf(elementData, size);
		}
	}
	
	
	public void ensureCapacity(int minCapacity){
		int minExpand = (elementData != EMPTY_ELEMENTDATA)
				? 0 : DEFAULT_CAPACITY;
		if(minCapacity > minExpand){
			ensureExplicitCapacity(minCapacity);
		}
	}
	
	private void ensureCapacityInternal(int minCapacity){
		if (elementData == EMPTY_ELEMENTDATA){
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
		}
		ensureExplicitCapacity(minCapacity);
	}	
	
	private void ensureExplicitCapacity(int minCapacity) {
		modCount++;
		if(minCapacity - elementData.length > 0){
			grow(minCapacity);
		}
	}
	private static final int MAX_ARRAY_SIZE =Integer.MAX_VALUE;
	private void grow(int minCapacity) {
		
	}
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return super.add(e);
	}
	
	
	
	
	
	
	
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
