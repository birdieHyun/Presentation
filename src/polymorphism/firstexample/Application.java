package polymorphism.firstexample;

public class Application {

    public static void main(String[] args) {

        Animal animal1 = new Animal();
        Animal animal2 = new Human();
        Animal animal3 = new Eagle();


        animal1.move();

        animal2.move();

        animal3.move();
    }
}
