package polymorphism.firstexample;

public class Human extends Animal{

    @Override
    void move() {
        System.out.println("사람은 걷습니다.");
    }

}
