package structure;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public class MyArrayList<E> 
	implements  RandomAccess , Cloneable , Serializable{
	
	private static final long serialVersionUID = 711426901010490972L;
	
	protected transient int modCount = 0;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private static final Object[] EMPTY_ELEMTDATA = {};
	
	private transient Object[] elemtData = {};
	
	private int size;
	
	//Initialize ArrayList with specified Capacity
	public MyArrayList(int initialCapacity) {
		if(initialCapacity < 0)
			throw new IllegalArgumentException("Illegal ArgumentException" + initialCapacity);
		this.elemtData = new Object[initialCapacity];
	}
	
	//Initialize Empty ArrayList 
	public MyArrayList(){
		this.elemtData = EMPTY_ELEMTDATA;
	}
	
	//Initialize ArrayList by a Collection
	public MyArrayList(Collection<? extends E> c){
		//将 c 转化为数组 ，但是数组可能不是Object[]类型
		elemtData = c.toArray();
		size = elemtData.length;
		//如果不是Object[] 类型，进行转化
		if(elemtData.getClass() != Object[].class)
			elemtData = Arrays.copyOf(elemtData,size,Object[].class);
	}
	
	//
	public void trimToSize(){
		modCount++;
		if(size < elemtData.length)
			elemtData = Arrays.copyOf(elemtData, size);
	}
	
	
	public void ensureCapacity(int minCapacity){
		int minExpand = (elemtData != EMPTY_ELEMTDATA)
				?0
				:DEFAULT_CAPACITY;
		if(minCapacity > minExpand)
			ensureExplicitCapacity(minCapacity);
	}
	
	public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;
	
	private void ensureExplicitCapacity(int minCapacity) {
		modCount++;
		if(minCapacity - elemtData.length > 0)
			grow(minCapacity);
	}

	private void grow(int minCapacity) {
		int oldCapacity = elemtData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if(newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		if(newCapacity - MAX_ARRAY_SIZE > 0 )
			newCapacity = hugeCapacity(minCapacity);
		elemtData = Arrays.copyOf(elemtData, minCapacity);
	}

	private int hugeCapacity(int minCapacity) {
		if(minCapacity < 0)
			throw new OutOfMemoryError();
		return (minCapacity > MAX_ARRAY_SIZE)
				?Integer.MAX_VALUE
				:MAX_ARRAY_SIZE;
	}
	
	public int size() {
        return size;
    }
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean contains(Object o){
		return indexOf(o) >= 0;
	}

	private int indexOf(Object o) {
		if(o == null){
			for(int i = 0 ; i < size ; i++)
				if(elemtData[i] == null)
					return i;
		}else{
			for(int i = 0 ; i < size ; i++)
				if(o.equals(elemtData[i]))
					return i;
		}
		return -1;
	}
	
	public Object clone(){
		try {
			@SuppressWarnings("unchecked")
			MyArrayList<E> v = (MyArrayList<E>) super.clone();
			v.elemtData = Arrays.copyOf(elemtData, size);
			v.modCount = 0;
			return v;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return elemtData;
	}
	
	
	
	
	
	
	
	
	
	
}
