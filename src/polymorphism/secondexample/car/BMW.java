package polymorphism.secondexample.car;

public class BMW implements Car{
    @Override
    public void move() {
        System.out.println("BMW를 운전합니다.");
    }
}
