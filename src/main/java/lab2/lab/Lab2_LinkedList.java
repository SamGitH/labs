package ru.spbstu.telematics.java.Lab2_0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Lab2_LinkedList<T> implements List<T> {
	 public static void main( String[] args )
	 {
		 Lab2_LinkedList<String> nn=new Lab2_LinkedList<String>();
		 nn.add("d");
		 nn.size();
		 String test=nn.get(0);
		 nn.remove("d");
		 
	 }
	
	private class Entry<T>{
		T element;
	    Entry<T> next;
	    Entry<T> prev;
	    Entry(){}
	    Entry(T e, Entry<T> next, Entry<T> prev) {
	    	element =e;//???????
	    	this.next=next;
	    	this.prev=prev;
	    }
	}
	private int  size=0;

    Entry<T> begin;
    Entry<T> end;
	
    public Lab2_LinkedList(){
    	begin=new Entry<T>();
    	end=new Entry<T>();
    	begin.next=end;
    	end.prev=begin;
    }
	public boolean add(T e) {
		size++;
		Entry<T> new_Entry=new Entry<T>(e,end,end.prev);
		end.prev.next=new_Entry;
		end.prev=new_Entry;
		return false;
	}

	public void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public boolean contains(Object o) {
		Entry<T> iter=begin.next;
		while(iter!=end)
		{
			if(iter.element==o)
				return true;
			iter=iter.next;
		}
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public T get(int index) {
		Entry<T> iter=begin.next;
		int num=0;
		while(iter!=end&&num<=index)
		{
			if(num==index)
			 return iter.element;
			iter=iter.next;
			num++;
		}
		return null;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(Object o) {
		Entry<T> iter=begin.next;
		while(iter!=end)
		{
			if(iter.element==o)
			{
				iter.prev.next=iter.next;
				iter.next.prev=iter.prev;
				size--;
				return true;			
			}
			iter=iter.next;
		}
		return false;
	}

	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
