package Loc;

import java.util.ArrayList;
import java.util.List;

public class Basic {
    int row;
    int coll;

    public Basic(int rand, int coloana) {
        row = rand;
        coll = coloana;
    }

    public List<Integer> coordonate() {
        List<Integer> list = new ArrayList<>();
        list.add(row);
        list.add(coll);
        return list;
    }

    public double calculPrice(double x) {
        return x;
    }
}