package polymorphism.firstexample;

// 클래스를 사용 안하는 이유! (역할과 구현으로 분리)
// 클래스를 타입으로 선언하면 구현에 의존하게 된다.
// 인터페이스로 선언하면 구체 타입이 무엇인지 모른다 -> 캡슐화, 역할과 구현의 분리

public class Animal {
    void move() {
        System.out.println("동물은 움직입니다.");
    }
}