package by.it.sapazhkou.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    int idBuyer;
    ArrayList<GoodEnum> listGoods = new ArrayList<>();

    public Basket(int idBuyer) {
        this.idBuyer = idBuyer;
    }

    public void addToBasket(GoodEnum good) {
        listGoods.add(good);
    }

    public ArrayList getBasket() {
        return listGoods;
    }

    public void toConsoleBasket(){
        HashMap good = new PriceOfGood().getGoods();
        double sum = 0.0;
        System.out.println("\n"+"Bayer #"+idBuyer+" chose a goods:");
        for (int i = 0; i < listGoods.size(); i++) {
            System.out.print(listGoods.get(i).name()+" ");

            System.out.println("= "+ good.get(listGoods.get(i).name()));
            sum = sum + (double)good.get(listGoods.get(i).name());

        }
//            System.out.printf("good %10s price %s",listGood.name(),listGood.toString());

        System.out.println("All "+sum);
        System.out.println();
    }



}
