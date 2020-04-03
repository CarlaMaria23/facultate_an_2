package Spectacol;

import Persoana.Persoana;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Spectacol {
    String NumeEv;
    Double pretDePlecare;
    String Data;
    String Ora;
    List<Persoana> planification = new CopyOnWriteArrayList<>();

    public Spectacol(String nume, Double pret, String data, String ora) {
        NumeEv = nume;
        pretDePlecare = pret;
        Data = data;
        Ora = ora;
    }

    public Boolean accesibilitate(String typeLoc) {
        return false;
    }

    public void adaugaPersoana(String numePersoana) {
    }

    public void anuleazaRezervare(String nume) {
        int index = 0;
        for (Persoana name : planification) {
            if (name.getName().equals(nume)) {
                planification.remove(index);
                System.out.println("aici");
            }
            index++;
        }

    }

    public void adaugaLoc(String numePersoana, String typeLoc) {
        if (accesibilitate(typeLoc))
            for (Persoana name : planification)
                if (name.getName().equals(numePersoana))
                    name.adaugaLoc(typeLoc);
    }

    public String getNumeEv() {
        return NumeEv;
    }

    public String getSpectacolType() {
        return null;
    }

    public Boolean[][] vizualizare(){
        return null;
    }

    public Double totalPlata(String nume){
        for (Persoana name : planification)
            if (name.getName().equals(nume))
                return name.calculPlata(pretDePlecare);
        return 0.0;
    }

    public void doSomething() {
        System.out.println("############" + NumeEv + "#############");
        for (Persoana p : planification) {
            System.out.println(p.getName());
            System.out.println(p.getNumarBilete());
        }
    }
}