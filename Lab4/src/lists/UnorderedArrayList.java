package lists;

import java.util.NoSuchElementException;

public class UnorderedArrayList<T> extends AArrayList<T> implements UnorderedListADT<T> {

	@Override
	public void addAtFront(T data) {
		shiftElementsForAdd(0);
		listArray[0] = data;
		size++;
	}

	@Override
	public void addAfter(T existingData, T data) {
		int existIndex = indexOf(existingData);
		if (existIndex == -1) {
			throw new NoSuchElementException("Element not found");
		}
		
		shiftElementsForAdd(existIndex+1);
		listArray[existIndex+1] = data;
		size++;
	}

	@Override
	public void addAt(int index, T data) {
		if (index > size) {
			throw new IndexOutOfBoundsException("Index is invalid");
		}

		shiftElementsForAdd(index);
		listArray[index] = data;
		size++;
	}

	@Override
	public void add(T data) {
		if (isFull()) {
			System.out.println("full, add did not happen");
		}
		else {
			listArray[size] = data;
			size++;
		}
	}
}
