package by.it.karpovich.jd01_08;

abstract class Var implements Operation{

    @Override
    public String toString() {
        return "Abstract Var";
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция невозможна");
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция невозможна");
        return null;
    }
}
