package polymorphism.secondexample;

import polymorphism.secondexample.icecream.AmondBongBong;
import polymorphism.secondexample.icecream.IceCream;
import polymorphism.secondexample.icecream.MintChoco;
import polymorphism.secondexample.parttime.Birdie;
import polymorphism.secondexample.parttime.PartTimeJob;
import polymorphism.secondexample.parttime.Roy;

public class AppConfig {

    // 아몬드 봉봉
    public IceCream iceCream() {
        return new AmondBongBong();
    }


    // 민트초고
//    public IceCream iceCream() {
//        return new MintChoco();
//    }


    // 버디
    public PartTimeJob partTimeJob() {
        return new Birdie();
    }


    // 로이
//    public PartTimeJob partTimeJob() {
//        return new Roy();
//    }
}
