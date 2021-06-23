package by.it.sapazhkou.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    int idBuyer;
    ArrayList<Good> listGoods = new ArrayList<>();

    public Basket(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public void addToBasket(Good good) {
        listGoods.add(good);
    }

    public ArrayList getBasket() {
        return listGoods;
    }

//    public void toConsoleBasket(){
//        HashMap good = new PriceOfGood().getGoods();
//        double sum = 0.0;
//        System.out.println("Bayer #"+idBuyer+" chose a goods:");
//        for (int i = 0; i < listGoods.size(); i++) {
//            System.out.print("good "+ listGoods.get(i).name()+" ");

//            System.out.println("price "+ good.get(Good.valueOf(listGoods.get(i).name())));
//            sum = sum + (double)good.get(Good.valueOf(listGoods.get(i).name()));
//
//        }
////            System.out.printf("good %10s price %s",listGood.name(),listGood.toString());
//
//        System.out.println("All "+sum);
//    }


}
