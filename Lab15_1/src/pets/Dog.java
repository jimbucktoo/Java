package pets;

public class Dog extends Pet {
    public Dog() {
        sound = "woof";
        setName("dog");
    }

    public void fetch() {
        System.out.println(getName() + " is getting a ball...");
    }

    public void bark() {
        speak();
    }
}
