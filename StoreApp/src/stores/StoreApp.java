package stores;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Store App
 * @author James Liang
 * @version 1.0
 */

public class StoreApp {

    public static Store createStore(Scanner scnr) {
        scnr.nextLine();
        Store store = new Store();
        System.out.println("Enter Store Name for Store:");
        String storeName = scnr.nextLine();
        store.setStoreName(storeName);
        System.out.println("Store " + store.getStoreName() + " has been created");
        return store;
    }

    public static int getID(Store store) {
        System.out.println("Store ID: " + store.getStoreID());
        return store.getStoreID();
    }

    public static String getName(Store store) {
        System.out.println("Store Name: " + store.getStoreName());
        return store.getStoreName();
    }

    public static void listStores(ArrayList<Store> stores) {
        for (int i = 0; i < stores.size(); ++i) {
            System.out.println(stores.get(i).getStoreID() + " - " + stores.get(i).getStoreName());
        }
    }


    public static int countStores(ArrayList<Store> stores) {
        System.out.println("There are " + stores.size() + " stores in the database.");
        return stores.size();
    }

    public static void removeStore(ArrayList<Store> stores, Scanner scnr) {
        scnr.nextLine();
        System.out.println("Please enter store name you wish to remove: ");
        String storeToRemove = scnr.nextLine();
        String storeRemoved = "";

        for (int i = 0; i < stores.size(); ++i) {
            if (stores.get(i).getStoreName().equals(storeToRemove)) {
                storeRemoved = stores.get(i).getStoreName();
                stores.remove(i);
            }
        }
        System.out.println(storeRemoved + " has been successfully removed.");
    }

    public static void removeAllStores(ArrayList<Store> stores) {
        stores.clear();
        System.out.println("All stores have successfully been removed.");
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<Integer> storeIDs = new ArrayList<Integer>();
        ArrayList<String> storeNames = new ArrayList<String>();
        ArrayList<Store> stores = new ArrayList<Store>();
        Store store = null;
        int choice = -1;

        do {
            System.out.println();
            System.out.println("1) create a store");
            System.out.println("2) get store id");
            System.out.println("3) get store name");
            System.out.println("4) list stores");
            System.out.println("5) count stores");
            System.out.println("6) remove a store");
            System.out.println("7) removal all stores");
            System.out.println();
            System.out.println("9) exit");
            System.out.println();
            System.out.println("Enter your choice: ");
            choice = scnr.nextInt();

            switch (choice) {
                case 1:
                    store = createStore(scnr);
                    stores.add(store);
                    break;
                case 2:
                    getID(store);
                    break;
                case 3:
                    getName(store);
                    break;
                case 4:
                    listStores(stores);
                    break;
                case 5:
                    countStores(stores);
                    break;
                case 6:
                    removeStore(stores, scnr);
                    break;
                case 7:
                    removeAllStores(stores);
                    break;
            }
        } while (choice != 9);
        System.out.println("Program ended");
    }
}
