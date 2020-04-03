package Persoana;

import Loc.*;

import java.util.ArrayList;
import java.util.List;

public class Rezervare extends Persoana {
    List< Basic > listaLocuri = new ArrayList<>();

    public Rezervare(String setName) {
        super(setName);
    }

    @Override
    public Boolean accesibilitate(Integer x, Integer y){
        for ( Basic l : listaLocuri  )
            if(l.coordonate().get(0) == x && l.coordonate().get(1) == y)
                return false;
        return true;
    }



    @Override
    public Integer getNumarBilete() {
        for(Basic l : listaLocuri){
            System.out.println(l.getClass().getName());
        }
        return super.getNumarBilete();
    }

    @Override
    public Double calculPlata(Double pretPlecare) {
        double sumaPlata = 0.0;
        for( Basic loc : listaLocuri){
            sumaPlata += loc.calculPrice(pretPlecare);
        }
        return sumaPlata;
    }

    @Override
    public void adaugaLoc( String type ) {
        super.adaugaLoc( type );
        String[] output = type.split("~");
        if( output[3].equals("Basic"))
            listaLocuri.add( new Basic( Integer.parseInt(output[1]), Integer.parseInt(output[2]) ) );
        if( output[3].equals("VIP"))
            listaLocuri.add( new VIP( Integer.parseInt(output[1]), Integer.parseInt(output[2]) ) );
        if( output[3].equals("Economic"))
            listaLocuri.add( new Economic( Integer.parseInt(output[1]), Integer.parseInt(output[2]) )  );
    }

    @Override
    public Boolean[][] locuriOcupate(Boolean[][] sala) {
        for ( Basic l : listaLocuri  )
            sala[l.coordonate().get(0)][l.coordonate().get(1)] = true;
        return sala;
    }
}
