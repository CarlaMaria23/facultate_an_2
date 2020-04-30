package Meniu;
import Persoana.Persoana;
import Spectacol.*;
import Service.*;

import java.util.*;

public class Meniu {
    int Operation;
    List<Spectacol> listaSpectacole = new ArrayList<Spectacol>();
    public void operatiiRegistrii1(){
        Scanner in = new Scanner(System.in);
        Service service = new Service();
        service.initReportHeader();
        double procent;
        String name;
        Boolean sort;
        System.out.println("Registru sortat: (True/False)");
        sort = in.nextBoolean();
        if (sort) {
            System.out.println("Crescator:(True/False) ");
            sort = in.nextBoolean();
            if(sort)
                Collections.sort(listaSpectacole, Comparator.comparing(Spectacol::getNumeEv));
            else
                Collections.sort(listaSpectacole, Comparator.comparing(Spectacol::getNumeEv).reversed());
            for (Spectacol search : listaSpectacole) {
                procent = search.vizualizare();
                name = search.getNumeEv();
                service.writeDataToReport(name, procent);
            }
        }
        else{
            for (Spectacol search : listaSpectacole) {
                procent = search.vizualizare();
                name = search.getNumeEv();
                service.writeDataToReport(name, procent);
            }
        }
    }
    public void operatiiRegistrii2(){
        Service service = new Service();
        service.initReportHeader_();
        String namePers, nameEv;
        Double price;
        for (Spectacol search : listaSpectacole) {
            nameEv = search.getNumeEv();
            for ( Persoana p : search.planification) {
                namePers = p.getName();
                price = search.totalPlata(namePers);
                service.writeDataToReport_(namePers, nameEv, price);
            }
        }
    }
    public void introduceOperatie() {
        System.out.println("Alege un numar:");
        System.out.println("    1.Adauga spectacol.");
        System.out.println("    2.Lista spectacole.");
        System.out.println("    3.Vizualizare capacitate.");
        System.out.println("    4.Rezervare loc la spectacol.");
        System.out.println("    5.Anuleaza rezervare loc la spectacol.");
        System.out.println("    5.Vizualizare plata pentru o persoana.");
        System.out.println("    7.Raport Spectacole.");
        System.out.println("    8.Raport Persoane.");
        System.out.println("    9.Exit.");

        Scanner in = new Scanner(System.in);
        Operation = in.nextInt();
        if (Operation == 1)
            introducere(citireDate());
        if (Operation == 2)
            afisare();
        if (Operation == 3)
            vizualizaregetData();
        if (Operation == 4)
            rezervareLocGetData();
        if (Operation == 5)
            anuleazaRezervareGetdata();
        if (Operation == 6)
            totalPlataGetData();
        if (Operation == 7)
            operatiiRegistrii1();
        if (Operation == 8)
            operatiiRegistrii2();
        if (Operation == 9)
            System.exit(0);
        introduceOperatie();
    }

    public String citireDate() {
        String aux, aux1, aux3, aux4;
        double aux2;
        Scanner in = new Scanner(System.in);
        System.out.println("Date despre spectacol:");
        System.out.println("    0.Tip spectacol (Proiectie / Concert) :");
        aux = in.nextLine();
        System.out.println("    1.Nume spectacol");
        aux1 = in.nextLine();
        System.out.println("    2.Pret de plecare pentru un bilet");
        aux2 = in.nextDouble();
        in.nextLine();
        System.out.println("    3.Data spectacolului");
        aux3 = in.nextLine();
        System.out.println("    4.Ora spectacolului");
        aux4 = in.nextLine();
        if (aux.equals("Proiectie")) {
            int aux5, aux6;
            System.out.println("    5.Capacitatea salii (randuri):");
            aux5 = in.nextInt();
            System.out.println("    5.Capacitatea salii (scaune pe rand):");
            aux6 = in.nextInt();
            return aux + "~" + aux1 + "~" + aux2 + "~" + aux3 + "~" + aux4 + "~" + aux5 + "~" + aux6;
        } else if (aux.equals("Concert")) {
            int aux5;
            String aux6;
            System.out.println("    5.Numarul maxim estimat pentru spectacol:");
            aux5 = in.nextInt();
            in.nextLine();
            System.out.println("    6.Trupa ce va canta:");
            aux6 = in.nextLine();
            return aux + "~" + aux1 + "~" + aux2 + "~" + aux3 + "~" + aux4 + "~" + aux5 + "~" + aux6;
        } else {
            System.out.println("Spectacol inexistent");
            return null;
        }
    }

    public void introducere(String date) {
        String[] output = date.split("~");
        if (output[0].equals("Concert"))
            listaSpectacole.add(new Concert(output[1], Double.parseDouble(output[2]), output[3], output[4], Integer.parseInt(output[5]), output[6]));
        if (output[0].equals("Proiectie"))
            listaSpectacole.add(new Proiectie(output[1], Double.parseDouble(output[2]), output[3], output[4], Integer.parseInt(output[5]), Integer.parseInt(output[6])));
    }

    public void afisare() {
        for (Spectacol s : listaSpectacole) {
            s.doSomething();
        }
    }

    public void rezervareLocGetData() {
        String name, show, type = "Concert";
        boolean newPerson;
        Scanner in = new Scanner(System.in);
        System.out.println(" Nume spectacol: ");
        show = in.nextLine();
        System.out.println(" Nume persoana: ");
        name = in.nextLine();
        System.out.println(" Nu aveti rezervare la acest spectacol:(True/False) ");
        newPerson = in.nextBoolean();
        for (Spectacol search : listaSpectacole)
            if (search.getNumeEv().equals(show))
                if (search.getSpectacolType().equals("Proiectie")) {
                    int x, y;
                    String aux;
                    System.out.println(" Rand: ");
                    x = in.nextInt();
                    System.out.println(" Scaun: ");
                    y = in.nextInt();
                    in.nextLine();
                    System.out.println("Tip loc: (Basic/VIP/Economic)");
                    aux = in.nextLine();
                    type = "Proiectie~" + x + "~" + y + "~" + aux;
                }
        rezervareLoc(name, show, newPerson, type);
    }

    public void rezervareLoc(String name, String show, Boolean newPerson, String typeLoc) {
        for (Spectacol search : listaSpectacole) {
            if (search.getNumeEv().equals(show)) {
                if (newPerson)
                    search.adaugaPersoana(name);
                search.adaugaLoc(name, typeLoc);
            }
        }
    }

    public void anuleazaRezervareGetdata() {
        String show, name;
        Scanner in = new Scanner(System.in);
        System.out.println(" Nume spectacol: ");
        show = in.nextLine();
        System.out.println(" Nume persoana: ");
        name = in.nextLine();
        anuleazaRezervare(name, show);
    }

    public void anuleazaRezervare(String name, String show) {
        for (Spectacol search : listaSpectacole)
            if (search.getNumeEv().equals(show)) {
                search.anuleazaRezervare(name);
            }
    }

    public void vizualizaregetData() {
        String show;
        Scanner in = new Scanner(System.in);
        System.out.println(" Nume spectacol: ");
        show = in.nextLine();
        vizualizare(show);
    }

    public void vizualizare(String show) {
        for (Spectacol search : listaSpectacole)
            if (search.getNumeEv().equals(show)) {
                System.out.println(search.vizualizare());
            }
    }

    public void totalPlataGetData() {
        String name;
        Scanner in = new Scanner(System.in);
        System.out.println(" Nume persoana: ");
        name = in.nextLine();
        totalPlata(name);
    }

    public Double totalPlata(String name) {
        double sum = 0;
        for (Spectacol search : listaSpectacole)
            sum += search.totalPlata(name);
        return sum;
    }
}
