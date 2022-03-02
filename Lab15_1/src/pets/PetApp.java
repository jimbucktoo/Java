package pets;

public class PetApp {
    public static void main(String[] args) {

        Pet myPet = new Pet();

        System.out.println(myPet.getName());
        myPet.setName("toby");
        System.out.println(myPet.getName());
        myPet.speak();

        Pet myOtherPet = new Pet("babs", "meow");
        myOtherPet.speak();

        Dog myDog = new Dog();
        myDog.setName("toby");
        myDog.speak();
        myDog.fetch();
        myDog.bark();
    }
}
