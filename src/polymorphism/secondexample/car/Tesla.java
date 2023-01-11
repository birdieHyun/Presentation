package polymorphism.secondexample.car;

public class Tesla implements Car{
    @Override
    public void move() {
        System.out.println("테슬라를 운전합니다.");
    }
}
