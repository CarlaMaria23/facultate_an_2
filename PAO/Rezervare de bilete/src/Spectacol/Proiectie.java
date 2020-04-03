package Spectacol;

import Persoana.*;

public class Proiectie extends Spectacol {
    int nrRow;
    int nrColl;

    public Proiectie(String nume, Double pret, String data, String ora, int randuri, int coloane) {
        super(nume, pret, data, ora);
        nrRow = randuri;
        nrColl = coloane;
    }

    @Override
    public Boolean accesibilitate(String typeLoc) {
        String[] output = typeLoc.split("~");
        Integer x = Integer.parseInt(output[1]), y = Integer.parseInt(output[2]);
        for (Persoana p : planification)
            if (!p.accesibilitate(x, y))
                return false;
        if (x > nrRow || y > nrColl)
            return false;
        System.out.println("Loc rezervat");
        return true;
    }

    @Override
    public Boolean[][] vizualizare() {
        Boolean[][] sala = new Boolean[nrRow][nrColl];
        for (Persoana p : planification){
            sala = p.locuriOcupate(sala);
        }
        return sala;
    }

    @Override
    public void adaugaPersoana(String numePersoana) {
        planification.add(new Rezervare(numePersoana));
    }

    @Override
    public String getSpectacolType() {
        return "Proiectie";
    }

    @Override
    public void doSomething() {
        System.out.println("la cinema");
        super.doSomething();
    }
}