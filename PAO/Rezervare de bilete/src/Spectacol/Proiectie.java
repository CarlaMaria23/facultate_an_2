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
    public double vizualizare() {
        Boolean[][] sala = new Boolean[nrRow + 1][nrColl +1];
        for (Persoana p : planification){
            sala = p.locuriOcupate(sala);
        }
        int procent = 0;
        for (int i = 1; i <= nrRow; i++)
            for (int j = 1; j <= nrColl; j++)
                if(sala[i][j] != null )
                    procent ++;
        return (procent * 100.0) / (nrColl*nrColl);
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