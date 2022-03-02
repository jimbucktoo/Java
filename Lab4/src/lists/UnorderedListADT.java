package lists;

public interface UnorderedListADT<T> extends ListADT<T> {
	
	public void addAtFront(T data);
	public void addAfter(T refData,T data);
	public void addAt(int index, T data);

}
