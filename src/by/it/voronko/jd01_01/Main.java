package by.it.voronko.jd01_01;

public class Main {

    public static void main(String[] args) {
	Hello hello=new Hello();
	hello.printSlogan();
	hello.setSlogan("Привет космос");
	hello.printSlogan();

	Args argsObject=new Args();
	argsObject.printArgs();
    }
}
