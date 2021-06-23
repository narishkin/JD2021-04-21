package by.it.sapazhkou.jd02_01;

import java.util.ArrayList;

public class Basket {

    int idBuyer;
    ArrayList<Good> listGoods = new ArrayList<>();

    Basket(int idBuyer){
        this.idBuyer = idBuyer;
    }

    private void addToBasket(Good good){
        listGoods.add(good);
    }

    private ArrayList getBasket(){
        return listGoods;
    }
}
