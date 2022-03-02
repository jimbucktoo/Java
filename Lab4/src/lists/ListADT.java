package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface ListADT<T> extends Iterable<T>{

	// Resets the list to that of a new, empty list
	public void clear();

	// Add an element to the list
	public void add(T element);
	
	// Remove and return the current element
	public T remove(T element) throws NoSuchElementException;

	// Remove and return the first element
	public T removeFirst() throws NoSuchElementException;

	// Remove and return the last element
	public T removeLast() throws NoSuchElementException;

	// Return the number of elements in the list
	public int size();

	// Tell if the list is empty or not
	public boolean isEmpty();

	// Return the first element in the list
	public T first();

	// Return the last element in the list
	public T last();

	// Tell if the element exists in the list
	public boolean contains (T element);

	// Return the index of the specified element
	public int indexOf(T element);

	// Copies the elements of the list onto the parameter array
	public void toArray(T[] anArray);

	// Returns an iterator for the list
	public Iterator iterator();



}
