package Loc;

public class Economic extends Basic {
    public Economic(int rand, int coloana) {
        super(rand, coloana);
    }

    @Override
    public double calculPrice(double x) {
        return x * 75 / 100;
    }
}
