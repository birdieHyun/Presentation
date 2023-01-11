package polymorphism.secondexample;

import polymorphism.secondexample.icecream.IceCream;
import polymorphism.secondexample.parttime.PartTimeJob;

public class Customer {

    static IceCream iceCream;
    static PartTimeJob partTimeJob;

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        iceCream = appConfig.iceCream();
        partTimeJob = appConfig.partTimeJob();


        partTimeJob.serve(iceCream);
    }
}
