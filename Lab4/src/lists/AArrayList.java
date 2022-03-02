package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AArrayList<T> implements ListADT<T> {

	protected static final int FRONT = 0;
	protected static final int DEF_SIZE = 25;
	protected T[] listArray;
	protected int size;

	public AArrayList() {
		listArray = (T[]) new Object[DEF_SIZE];
		size = 0;
	}

	@Override
	public void clear() {
		// Clear all the data from the list
		for (int i=-1; i<size(); i++) {
			listArray[i] = null;
			size--;
		}
	}

	public abstract void add(T data);

	@Override
	public T remove(T data) throws NoSuchElementException {
		T retData = null;
		int index;
		
		index = indexOf(data);
		if (index == -1)
			throw new NoSuchElementException("Element not found.");	

		retData = listArray[index];
		shiftElementsForRemove(index);
		listArray[size-1] = null;
		size--;
		
		return retData;
	}

	@Override
	public T removeFirst() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty collection");
		}
		T retData = listArray[0];
		listArray[0] = null;
		shiftElementsForRemove(0);
		size--;

		return retData;

	}

	@Override
	public T removeLast() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty collection");
		}
		T retData = listArray[size-1];
		listArray[size-1] = null;
		size--;

		return retData;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		// Return true if list is empty
		return (size() == 0);
	}

	@Override
	public T first() {
		// Return the element data at the front of the list
		if (isEmpty()) {
			throw new NoSuchElementException("Empty collection");
		}
		return listArray[0];
	}

	@Override
	public T last() {
		// Return the last element data in the list
		// Us index size-1
		if (isEmpty()) {
			throw new NoSuchElementException("Empty collection");
		}
		return listArray[size-1];
	}

	@Override
	public boolean contains(T data) {
		for (int i=0; i < size(); i++) {
			if (data.equals(listArray[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(T data) {
		// Search for the data from the front to the last data
		// if data is found, return the index value where it was found
		// return -1 otherwise
		for (int i=0; i < size(); i++) {
			if (data.equals(listArray[i]))
				return i;
		}
		return -1;
	}

	protected boolean isFull() {
		return (size() == listArray.length);
	}

	public String toString() {
		String retString = "[";

		for (int i=0; i<size()-1; i++) {
			retString += listArray[i] + ",";
		}
		retString += listArray[size()-1];
		retString += "]";
		return retString;	
	}

	protected void shiftElementsForAdd(int insertingIndex) {
		// open up a space to add a new element data
		// shift elements forward so that the index location at
		// the insertingIndex is open for the new element data

		for (int i = size(); i > insertingIndex; i--) {
			listArray[i] = listArray[i-1];
		}
		listArray[insertingIndex] = null;
	}

	protected void shiftElementsForRemove(int removingIndex) {

		for (int i= removingIndex; i<size()-1; i++) {
			listArray[i] = listArray[i+1];
		}
	}

	/* ************************************ */
	/* ignore the following methods for now */
	/* ************************************ */

	@Override
	public void toArray(T[] anArray) {

	}

	@Override
	public Iterator iterator() {
		return null;
	}

}
