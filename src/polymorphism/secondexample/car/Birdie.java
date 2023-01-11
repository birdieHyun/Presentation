package polymorphism.secondexample.car;

public class Birdie {
    // 버디가 차를 드디어 구매했습니다!

    public static void main(String[] args) {

        OnlyCar onlyCar = new OnlyCar();
//        OnlyCar bmw = new BMW();        // 컴파일 에러 발생
        onlyCar.move();

        //--------------------------

        Car car = new Avante();     // BMW , Tesla 로 교체할 수 있다.
//        Car car = new BMW();
//        Car car = new Tesla();

        car.move();

    }
}
