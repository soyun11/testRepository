package ArrList;

import java.util.NoSuchElementException;

public class ArrList<E> {
	private E a[];
	private int size;
	
	public ArrList(){
		a=(E[]) new Object[1];
		size=0;
	}
	public E delete(int k) {
		if(isEmpty()) throw new NoSuchElementException();
		E item = a[k];
		for(int i=k; i<size ; i++) a[i]=a[i+1];
		size--;
		if(size>0 && size==a.length/4)
			resize(a.length/2);
		return item;
	}
	private void resize(int newSize) {
		Object[] t = new Object[newSize];
		for(int i=0;i<size;i++)
			t[i]=a[i];
		a=(E[])t;
	}
	public void insertLast(E newItem) {
		if(size==a.length)
			resize(2*a.length);
		a[size++]=newItem;
	}
	public void insert(E newItem, int k) {
		if(size == a.length)
			resize(2*a.length);
		for(int i=size-1; i>=k; i--) a[i+1] = a[i];
		a[k]=newItem;
		size++;

	}
	public E peek(int k) {
		if (size==0)
			throw new NoSuchElementException();
		return a[k];
	}
	public void print() {
		if(isEmpty())
			System.out.print("배열이 비어있음.");
		else
			for(int i=0;i<a.length;i++) System.out.print(a[i]+"\t");
		System.out.println();
	}
	public boolean isEmpty(){return size==0;}
	
}

