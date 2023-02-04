package lambdastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delivery {
    // 10000원 이상의 주문만 무료배달을 해주기로 했다.
    // 여러 주문이 들어오면 무료 배달 주문만 따로 분류해서 새로운 배열 반환
    public static void main(String[] args) {


        int[] delivery = {10000, 7000, 13000, 4000, 12000};
        List<Integer> freeDeliveryList = new ArrayList<>();

        for (int i = 0; i < delivery.length; i++) {
            if (delivery[i] >= 10000) {
                freeDeliveryList.add(delivery[i]);
            }
        }

        int[] freeDelivery = new int[freeDeliveryList.size()];

        for (int i = 0; i < freeDeliveryList.size(); i++) {
            freeDelivery[i] = freeDeliveryList.get(i);
        }


//        int[] freeDelivery = Arrays.stream(delivery).filter(i -> i >= 10000)
//                .toArray();
    }
}
