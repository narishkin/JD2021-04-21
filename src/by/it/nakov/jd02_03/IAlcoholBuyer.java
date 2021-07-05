package by.it.nakov.jd02_03;

public interface IAlcoholBuyer {
    void enteredToTheStore(); //вошел в магазин (мгновенно)

    void chooseTheAlcohol(); //выбрал товар (от 0,5 до 2 секунд)

    void takeBasket();

    void putGoodsToBasket();

    void goOut(); //отправился на выход(мгновенно)
}
