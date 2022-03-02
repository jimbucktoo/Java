package stores;

public class Store {
    public int storeID;
    public String storeName;
    public static int storeCounter = 0;

    public Store() {
        this.storeID = storeCounter++;
    }

    public int getStoreID() {
        return this.storeID;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName(String name) {
        this.storeName = name;
    }
}
