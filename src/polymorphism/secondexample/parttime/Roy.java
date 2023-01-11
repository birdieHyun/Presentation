package polymorphism.secondexample.parttime;

import polymorphism.secondexample.icecream.IceCream;

public class Roy implements PartTimeJob {

    private final String ROY = "로이가 ";
    private final String SERVE = "을(를) 서빙합니다.";

    @Override
    public void serve(IceCream iceCream) {
        System.out.println(ROY + iceCream.getTaste() + SERVE);
    }

}
