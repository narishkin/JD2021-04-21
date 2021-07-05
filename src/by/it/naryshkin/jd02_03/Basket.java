package by.it.naryshkin.jd02_03;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Basket {

    public static BlockingQueue<Short> basketBlockingQueue = new ArrayBlockingQueue<>(Config.BASKET_POOL_SIZE);


}
