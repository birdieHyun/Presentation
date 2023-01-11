package polymorphism.secondexample.parttime;

import polymorphism.secondexample.icecream.IceCream;

public class Birdie implements PartTimeJob {

    private final String BIRDIE = "버디가 ";
    private final String SERVE = "을(를) 서빙합니다.";

    @Override
    public void serve(IceCream iceCream) {
        System.out.println(BIRDIE + iceCream.getTaste() + SERVE);
    }

}
