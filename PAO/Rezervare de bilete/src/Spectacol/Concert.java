package Spectacol;

import Persoana.*;

public class Concert extends Spectacol {
    int capacitate;
    String Trupa;

    public Concert(String nume, Double pret, String data, String ora, int nrPersoane, String trupa) {
        super(nume, pret, data, ora);
        capacitate = nrPersoane;
        Trupa = trupa;
    }

    @Override
    public Boolean accesibilitate(String typeLoc) {
        int sum = 0;
        for (Persoana p : planification)
            sum = sum + p.getNumarBilete();
        return sum < capacitate;
    }

    @Override
    public Boolean[][] vizualizare() {
        int sum = 0;
        for (Persoana p : planification) {
            sum = sum + p.getNumarBilete();
        }
        int procent = (sum * capacitate) / 100;
        Boolean[][] sala = new Boolean[10][10];
        for (int i = 0; procent > i; i++) {
            sala[i / 100][i % 100] = true;
        }
        return sala;
    }

    @Override
    public void adaugaPersoana(String numePersoana) {
        planification.add(new Persoana(numePersoana));
    }

    @Override
    public String getSpectacolType() {
        return "Concert";
    }

    @Override
    public void doSomething() {
        System.out.println("in concert");
        super.doSomething();
    }
}