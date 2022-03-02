import java.util.NoSuchElementException;

//import lists.AArrayList;
import lists.UnorderedArrayList;

public class ArrayListTester {

	public static void main(String[] args) {
				testAdd();
				testRemoveLast();
				testAddAfter();
				testRemove();
				testAddAt();
				testAddAtFront();
				testRemoveFirst();
				testObserverMethods();
				testEmptyCollectorException();
				testNoSuchElementException();
	}

	public static void testAdd() {
		System.out.println("\n*** Test Add Method ***");
		UnorderedArrayList<String> al = new UnorderedArrayList<String>();
		System.out.println("Size [0]: " + al.size());
		al.add("G");
		al.add("W");
		System.out.println("Size [2]: " + al.size());
		al.add("E");
		System.out.println("Size [3]: " + al.size());
		al.add("B");
		al.add("Z");
		al.add("X");
		System.out.println("Size [6]: " + al.size());
		System.out.println("[G,W,E,B,Z,X]: " + al);
	}

	public static void testAddAfter() {
		System.out.println("\n*** Test Add After Method ***");
		UnorderedArrayList<String> al = new UnorderedArrayList<String>();
		al.add("G");
		al.add("W");
		al.add("E");
		System.out.println("Size [3]: " + al.size());
		System.out.println("[G,W,E]: " + al);
		System.out.println("Add B after G");
		al.addAfter("G","B");
		System.out.println("[G,B,W,E]: " + al );
		System.out.println("Size [4]: " + al.size());

		try {
			al.addAfter("A","B");
		} 
		catch (NoSuchElementException e) {
			System.out.println("Existing element not found: " + e.getMessage());;
		}
	}

	public static void testRemoveLast() {
		System.out.println("\n*** Test Remove Last Method ***");
		UnorderedArrayList<String> al = new UnorderedArrayList<String>();
		try {
			al.removeLast();
		} 
		catch (NoSuchElementException e) {
			System.out.println("On empty collection: " + e.getMessage());;
		}
		al.add("G");
		al.add("W");
		al.add("E");
		System.out.println("Size [3]: " + al.size());
		System.out.println("[G,W,E]: " + al);
		System.out.println("Remove Last [E]: " + al.removeLast());
		System.out.println("Size [2]: " + al.size());
		System.out.println(al);
	}

	public static void testRemove() {
		System.out.println("\n*** Test Remove Method ***");
		UnorderedArrayList<String> al = new UnorderedArrayList<String>();
		try {
			al.remove("W");
		} 
		catch (NoSuchElementException e) {
			System.out.println("On empty collection: " + e.getMessage());;
		}
		al.add("G");
		al.add("W");
		al.add("E");
		System.out.println("Size [3]: " + al.size());
		System.out.println("[G,W,E]: " + al);
		System.out.println("Remove [W]: " + al.remove("W"));
		System.out.println("[G,E]: " + al);
		System.out.println("Size [2]: " + al.size());
		System.out.println(al);
		try {
			System.out.print("Remove [W]: ");
			al.remove("W");
		} 
		catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());;
		}
	}

	public static void testAddAt() {
		System.out.println("\n*** Test Add At Method ***");
		UnorderedArrayList<String> al = new UnorderedArrayList<String>();
		al.add("G");
		al.add("W");
		al.add("E");
		System.out.println("Size [3]: " + al.size());
		System.out.println("[G,W,E]: " + al);
		System.out.println("Add Z at index 2");
		al.addAt(2,"Z");
		System.out.println("[G,W,Z,E]: " + al );
		System.out.println("Size [4]: " + al.size());

		try {
			al.addAt(5,"B");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Index is invalid: " + e.getMessage());;
		}
	}

	public static void testAddAtFront() {
		System.out.println("\n*** Test Add At Front Method ***");
		UnorderedArrayList<String> al = new UnorderedArrayList<String>();
		al.add("G");
		al.add("W");
		al.add("E");
		System.out.println("Size [3]: " + al.size());
		System.out.println("[G,W,E]: " + al);
		System.out.println("Add A at front");
		al.addAtFront("A");
		System.out.println("[A,G,W,E]: " + al );
		System.out.println("Size [4]: " + al.size());
	}

	public static void testRemoveFirst() {
		System.out.println("\n*** Test Remove First method ***");
		UnorderedArrayList<String> al = new UnorderedArrayList<String>();
		try {
			al.removeFirst();
		}
		catch (NoSuchElementException e) {
			System.out.println("On empty collection: " + e.getMessage());;
		}
		al.add("G");
		al.add("W");
		al.add("E");
		System.out.println("Size [3]: " + al.size());
		System.out.println("[G,W,E]: " + al);
		System.out.println("Remove First [G]: " + al.removeFirst());
		System.out.println("Size [2]: " + al.size());
		System.out.println(al);
	}

	public static void testObserverMethods() {
		System.out.println("\n*** Test Observer Methods ***");
		UnorderedArrayList<String> al = new UnorderedArrayList<String>();
		al.add("G");
		al.add("W");
		al.add("E");
		System.out.println("Size [3]: " + al.size());
		System.out.println("[G,W,E]: " + al);
		System.out.println("Test First [G]: " + al.first());
		System.out.println("Test Last [E]: " + al.last());
		System.out.println("Test Contains [true]: " + al.contains(al.first()));
		System.out.println("Test IndexOf [0]: " + al.indexOf(al.first()));
		System.out.println("Test Size [3]: " + al.size());
		System.out.println("Test IsEmpty [false]: " + al.isEmpty());
	}

	public static void testEmptyCollectorException() {
		System.out.println("\n*** Test Empty Collector Exception ***");
		UnorderedArrayList<String> al = new UnorderedArrayList<String>();
		System.out.println("Size [0]: " + al.size());

		try {
			System.out.print("Test First [Empty collection]: ");
			al.first();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.print("Test Last [Empty collection]: ");
			al.last();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.print("Test RemoveFirst [Empty collection]: ");
			al.first();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.print("Test RemoveLast [Empty collection]: ");
			al.first();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testNoSuchElementException() {
		System.out.println("\n*** Test No Such Element Exception ***");
		UnorderedArrayList<String> al = new UnorderedArrayList<String>();
		al.add("G");
		al.add("W");
		al.add("E");
		System.out.println("Size [3]: " + al.size());
		System.out.println("[G,W,E]: " + al);

		try {
			System.out.print("Test AddAfter: ");
			al.addAfter("X","Y");
		}
		catch (NoSuchElementException e) {
			System.out.println("class java.util.NoSuchElementException: " + e.getClass());
		}

		UnorderedArrayList<String> alEmpty = new UnorderedArrayList<String>();

		try {
			System.out.print("Test First: ");
			alEmpty.first();
		}
		catch (NoSuchElementException e) {
			System.out.println("class java.util.NoSuchElementException: " + e.getClass());
		}

		try {
			System.out.print("Test Last: ");
			alEmpty.last();
		}
		catch (NoSuchElementException e) {
			System.out.println("class java.util.NoSuchElementException: " + e.getClass());
		}

		try {
			System.out.print("Test RemoveFirst: ");
			alEmpty.removeFirst();
		}
		catch (NoSuchElementException e) {
			System.out.println("class java.util.NoSuchElementException: " + e.getClass());
		}

		try {
			System.out.print("Test RemoveLast: ");
			alEmpty.removeLast();
		}
		catch (NoSuchElementException e) {
			System.out.println("class java.util.NoSuchElementException: " + e.getClass());
		}

		try {
			System.out.print("Test Remove: ");
			alEmpty.remove("A");
		}
		catch (NoSuchElementException e) {
			System.out.println("class java.util.NoSuchElementException: " + e.getClass());
		}
	}
}
