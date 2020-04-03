package Persoana;

public class Persoana {
    String Name;
    Integer NumarBilete;
    Double TotalPlata;

    public Persoana(String setName) {
        NumarBilete = 0;
        Name = setName;
    }

    public String getName(){
        return Name;
    }

    public  Integer getNumarBilete(){
        return NumarBilete;
    }

    public Boolean accesibilitate(Integer x, Integer y){
        return true;
    }

    public Double calculPlata(Double pretPlecare) {
        TotalPlata = NumarBilete * pretPlecare;
        return TotalPlata;
    }

    public void adaugaLoc(String type) {
            NumarBilete = NumarBilete + 1;
    }

    public Boolean[][] locuriOcupate( Boolean[][] sala) {
        return sala;
    }
}


