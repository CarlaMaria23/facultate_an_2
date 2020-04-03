package Loc;

public class VIP extends Basic {
    public VIP(int rand, int coloana) {
        super(rand, coloana);
    }

    @Override
    public double calculPrice(double x) {
        return x * 150 / 100;
    }
}
