# 람다와 스트림 발표

### 함수형 프로그래밍

함수를 값으로 취급한다.

## 목차

1. 람다란?
   예전에 자바에서 함수 타입을 표현할 때, 추상 메서드를 하나만 당믕ㄴ 인터페이스를 사용했다.  
   이런 인터페이스의 인스턴스를 함수객체 (function object) 라고 하여, 특정 함수나 동작을 나타내는데 사용했다.

```java
public class MyLambda {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1000");
        list.add("100");
        list.add("10");
        list.add("1");

        // list 를 문자열 길이순으로 정렬하고 싶다면?
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String s : list) {
            System.out.println(s); // 1, 10, 100, 1000 순으로 정렬된다.
        }
    }

} 
```

자바 8 이전, 함수 객체를 사용하는 과거 객체지향 디자인 패턴에는 익명 클래스면 충분했다.  
이 코드에서는 Comparator 인터페이스가 정렬을 담당한다.  
이 익명 클래스 방식은 코드가 너무 길기 때문에 자바는 함수형 프로그래밍에 적합하지 않았다.

자바 8에 와서 추상 메서드 하나짜리 인터페이스는 특별한 의미를 인정받아 특별한 대우를 받고 **람다식**이 탄생했다.
> 람다 표현은 익명 함수(이름 없는 함수)를 간결하고 읽기 쉬운 구문으로 표현하는 새로운 방법으로 자바 8에 도입되었다.   
> 함수 구성, 함수 커리링, 고차 함수와 같은 함수 프로그래밍 구조를 자바 코드로 작성할 수 있게 한다.   
> 또한 특정 기능을 구현하는 데 필요한 코드의 양을 단순화하고 줄일 수 있는 기능 동작을 정의하고 실행하기 위한 보다 간결하고 읽기 쉬운 구문을 제공한다.  
  

위 코드를 람다식으로 바꾸면

```java
public class Lambda {
    public static void main(String[] args) {
        Collections.sort(list,
                (s1, s2) -> Integer.compare(s1.length(), s2.length));
    }
}
```  

여기서 람다의 타입은 Comparator<String>  
매개변수 s1, s2 의 타입은 String,  
반환값의 타입은 int 이지만  
코드에서 언급이 없다.  
우리 대신 컴파일러가 문맥을 읽고 타입을 추론해주었다.
**타입을 명시해야 코드가 더 명확할 때만 제외하고, 람다의 모든 매개변수 타입은 생략하자**
> 람다의 타입은 제네릭을 통해 추론할 수 있다. 즉 컴파일러는 제네릭을 통해 타입을 추론한다.

주의점 : 람다는 이름도 없고 문서화도 못하기 때문에, 코드 자체로 동작히 명확히 설명되지 않거나, 코드 줄 수가 많아지면 람다를 사용하면 안된다.  
(추가 공부할 점 : 지금까지 본 람다는 대부분 한줄로 해결되었다. 여러줄 되는 람다? 공부해서 다시 내용 추가하자)

   람다 자리에 비교자 생성 메서드를 사용하면 코드가 더 간결해진다.

```java
public class Lambda {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("0");
        }

        // 자바 8때 List 인터페이스에 추가된 sort 메서드를 활용하면 더 짧아진다. 
        Collections.sort(list, Comparator.comparingInt(String::length));

        list.sort(comparingInt(String::length));
    }
}
```

> 메서드 참조도 함수형 프로그래밍의 일부이다. 또한 람다보다 가독성이 더 좋다는 장점을 가지고 있다.

람다로 구현했을 때 코드가 너무 길거나 복잡하면 메서드 참조가 좋은 대안이 되어준다.  
IDE 에서 주로 메서드 참조를 추천해주는데,  
**메서드 참조가 짧다면 메서드 참조를 사용하고, 그렇지 않으면 람다를 사용한다.**   
**무조건적으로 짧은 것이 아닌 가독성이 좋은 것을 선택한다.**

람다는 간단한 계산이 필요할 때 사용하도록 하고,  
메서드참조는 메서드 명이 있기 때문에 가독성에 도움을 줄 수 있다.

2. 스트림    
   스트림의 기본적인 특징

- 스트림은 데이터 소스를 변경하지 않는다.
- 스트림은 데이터 소스로부터 데이터를 읽기만 할 뿐 데이터 소스를 변경하지 않는다. -> 필요하다면 정렬된 결과를 컬렉션이나 배열에 담아서 반환할 수 있다.
```java
List<String> sortedList=strStream.sorted()
        .collect(Collectors.toList());
```
스트림의 결과를 새로운 List 에 담아서 반환한다.    
  

- 스트림의 연산
  - 중간연산 최종연산

- 지연된 연산 
  - 중간 연산에서는 계산이 되지 않는다. 
  - 수 많은 데이터를 다룰 경우 메모리상의 이점이 있다. 


- 스트림은 일회용이다.
    - 스트림의 최종 연산이 종료되고 나면, 닫혀서 다시 사용할 수 없다.
    - 필요하다면 스트림을 다시 생성해야 한다.
  

3. 함수형 인터페이스

### 함수형 인터페이스
자바가 람다를 지원하면서, 상위 클래스의 기본 메서드를 재정의해 원하는 동작을 수현하는 템플릿 메서드 패턴의 매력이 크게 줄었다.  
**필요한 용도에 맞는게 있다면, 직접 구현하지 말고, 표준 함수형 인터페이스를 활용하라** 그러면 API 가 다루는 개념의 수가 줄어들어 익히기 더 쉬워진다.

|인터페이스|함수 시그니처|예|
|:---|:---:|:---:|
|UnaryOperator<T>|T apply(T t)|String::toLowerCase|
|BinaryOperator<T>|T apply(T t1, T t2)|BigInteger::add|
| Predicate<T>    |boolean test(T t)|Collection::isEmpty|
| Function<T, R>  |R apply(T t)|Arrays::asList|
| Supplier<T>     |T get()|Instant::now|
| Consumer<T>     |void accept(T t)|System.out::println|    

기본 인터페이스는 기본 타입인 int, lond, double 용으로 각 3개씩 변형이 생겨난다.  
그 이름은 인터페이스 앞에 int, long, double 을 붙여서 만들어진다.

기본 인터페이스의 변형까지 생각하면 모든 것을 외우기 힘들기 때문에, 자주 사용되는 것들 암기하고, 모르는 부분은 찾아보도록 하자.

  

4. 버디 수준에서 어떻게 활용할 수 있을까?


### 이번 미션
#### Predicate
특정 수가 n 보다 큰지 판별하기

```java
import java.util.function.Predicate;

public class PredicateImpl {
    public static void main(String[] args) {
        Predicate<Integer> checkNum = i -> i > 100;
        checkNum.test(200);                                 //  i 가 100보다 큰지 확인해준다. 
    }
}
```  
  
Predicate 는 하나만 사용할 수도 있지만, 두 개 이상 결합도 가능하다.   
  

```java
public class PredicateImpl {
    public static void main(String[] args) {
        Predicate<Integer> lessThan100 = i -> i < 100;
        Predicate<Integer> moreThan50 = i -> i > 50;
        Predicate<Integer> evenNum = i -> i % 2 == 0;
        Predicate<Integer> oddNum = i -> i % 2 != 0;

        Predicate<Integer> sample = lessThan100.and(moreThan50);

        Predicate<Integer> and = lessThan100.and(moreThan50.and(evenNum));

        boolean test = and.test(70);
        boolean test2 = and.test(75);

        System.out.println("test = " + test);             // true
        System.out.println("test2 = " + test2);           // false
    }
}
```
위와 같이 Predicate 를 여러개 결합해서 n 개의 조건을 판별할 수도 있다.    
  
#### Stream 의 forEach  
스트림의 최종연산자로 가장 기본적인 사용법은 출력하는 것이다.  
**기존 코드**

```java
import java.util.*;

public class legacy {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(3);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
```
**스트림을 사용한 코드**

```java
import java.util.*;

public class Stream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(3);

        list.stream().forEach(i -> System.out.println(i));
//        list.stream().forEach(System.out::println);  // 람다로 표현할 경우 메서드 참조형식으로 변경하도록 IDE 가 추천해준다. 

    }
}
```  
코드의 길이가 짧아지고, 가독성이 좋아진 것을 확인할 수 있다.   

### 특정 범위의 정수 
IntStream 
   
---  

# 추가적으로 공부한 개념들

### 함수형 프로그래밍

함수형 프로그래밍이란 함수나 메서드가 수학의 함수처럼 동작함을, 즉 부작용 없이 동작함을 의미한다.    
즉, 함수를 마치 일반값처럼 사용해서 인수로 전달하거나, 결과로 반환받거나, 자료구조에 저장할 수 있음을 의미한다.  
일반값처럼 취급할 수 있는 함수를 **일급 함수**라고 한다.  
자바 8이 이전 버전과 구별되는 특징 중 하나가 일급함수를 지원한다는 점이다.

#### 고차원 함수

- 고차원 함수
    - 하나 이상의 함수를 인수로 받음
    - 함수를 결과로 반환 

스트림 연산으로 전달하는 함수는 부작용이 없어야 하며, 부작용을 포함하는 함수를 사용하면 문제가 발생한다는 사실을 설명했다.  
(부작용을 포함하는 함수를 사용하면 문제가 발생한다.)

- 함수를 묘듈화하고 코드를 재사용하는데 도움을 주는 기법인 **커링**을 알아보자   
  **커링**은 x 와 y 라는 두 인수를 받는 함수 f 를 한 개의 인수를 받는 g 라는 함수로 대체하는 기법이다. 이때 g 라는 함수 역시 하나의 인수를 받는 함수를 반환한다.
- 함수 g 와 원래함수 f 가 최정족으로 반환하는 값은 같다.   
  즉 f(x, y) = (g(x))(y) 가 성립한다.     
  
> https://www.acmicpc.net/problem/10867  
```java
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        Object[] tmp  = Arrays.stream(input).sorted()
                .distinct()
                .toArray();
        
    }
}
```
  
  
# 결론!  
- 익숙하진 않지만, 많이 사용해보면서 익숙해지도록 할것! 
- for 문과 stream이 고민될 땐, 둘 다 구현해보고 가독성이 좋은 것을 선택해라! 
  - 최고의 선택은 두 개를 적절히 섞는 것이다.   
