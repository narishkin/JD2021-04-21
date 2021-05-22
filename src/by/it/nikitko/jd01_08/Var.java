package by.it.nikitko.jd01_08;

abstract class Var implements Operation {

    @Override
    public Var add(Var other) {
        System.out.println("Operation additions " + this + "+" + other + " is impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Operation subtraction " + this + "-" + other + " is impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Operation multiplication " + this + "*" + other + " is impossible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Division operation " + this + "/" + other + " is impossible");
        return null;
    }
}
