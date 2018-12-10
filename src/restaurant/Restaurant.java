package restaurant;

import static Provizii.ProviziiVanzariVacante.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.util.Calendar.*;
import java.util.Locale;

public class Restaurant {

    public static String numeRestaurant;
    public String numeAngajat;
    public int zileVacanta;
    protected double salariu;

    LocalDate ld = LocalDate.now();

    

    public void adaugaZileVacanta(double x) {
        zileVacanta += x;
    }

    public static Restaurant[] angajati = new Restaurant[4];
    public static int nrOspatari;
    public static int nrBucatari;
    public static int nrManageri;
    public static double totalSalarii;

    private int zileleLucrate = 1;
    public int ziAn = 0;
    public LocalDate[] zile = new LocalDate[9999];

    public Restaurant(String n) {
        Restaurant.numeRestaurant = n;
    }

    @Override
    public String toString() {
        return "Restaurant " + numeRestaurant + " : \nOspatari:" + nrOspatari
                + "  |  Bucatari:" + nrBucatari
                + "  |  Manageri:" + nrManageri
                + "\nStatusul zilei:\n" + getStatus()
                + "Bugetul restaurantului:" + getProfit() + "\n";
    }

    public static void vanzareRandom() {
        int felMancare = (int) Math.floor(Math.random() * 7);
        int portie = 10 + (int) Math.floor(Math.random() * 10);
        switch (felMancare) {
            case 0:
                Ospatar.servesteSnitel(portie);
                break;
            case 1:
                Ospatar.servestePieptPui(portie);
                break;
            case 2:
                Ospatar.servestePiure(portie);
                break;
            case 3:
                Ospatar.servesteCartofiPrajiti(portie);
                break;
            case 4:
                Ospatar.servesteSalataVara(portie);
                break;
            case 5:
                Ospatar.servesteSalataMuraturi(portie);
                break;
            case 6:
                Ospatar.servesteChifla(portie);
                break;
        }
    }

    private void incheiereZi() {
        System.out.println(toString());
        Provizii.ProviziiVanzariVacante.refresh();
    }

    public void genereazaZi() {
        System.out.println("Ziua " + zileleLucrate + ":");
        for (int i = 9; i < 21; i++) {
            Ospatar.vanzareRandom();
            
        }
        incheiereZi();
        zileleLucrate++;

    }

    public void genereazaLuna(int n) {

        for (int i = n; i < n + 30; i++) {

            if (ld.getDayOfWeek().equals(SATURDAY)) {
                System.out.println(zile[i].format(DateTimeFormatter.ofPattern("EEEE dd MMMM YYYY", new Locale("ro", "RO"))));

                zile[i] = ld.plusDays(i);
            } else if (ld.getDayOfWeek().equals(SUNDAY)) {
                System.out.println(zile[i].format(DateTimeFormatter.ofPattern("EEEE dd MMMM YYYY", new Locale("ro", "RO"))));

                zile[i] = ld.plusDays(i);

            } else {
                zile[i] = ld.plusDays(i);
                System.out.println(zile[i].format(DateTimeFormatter.ofPattern("EEEE dd MMMM YYYY", new Locale("ro", "RO"))));
                genereazaZi();
            }

            if (zile[i].getDayOfMonth() == 10) {
                lichidareSalarii();
                platesteChiriaLunara();
                adaugaZileVacantaAngajati();
            }
        }
    }

    public void genereazaAn() {

        for (int i = 0; i < 12; i++) {
            genereazaLuna(ziAn);
            ziAn += 30;
        }
        eTimpulVacantei();
        System.out.println("\n\nRestaurantul " + Restaurant.numeRestaurant + " este inchis timp de o luna\n\n");
        ziAn += 30;
    }

    public static void main(String[] args) {

        /* Programul va afisa activitatea lunara timp de un an
        (sau cat ii spunem noi) a unui restaurant,ce consta in activitatea
        staffului:
        -ospatarii primesc comenzi generata random
        -se verifica daca produsele comenzii sunt in provizii
        -daca nu,managerii cumpara produse,
        -bucatarii prepara produsele,
        -ospatarii servesc produsele clientilor.
        Activitatea fiecarei zi din an este generata random
        Si se tine evidenta de profit.
        In fiecare luna pe data de 10:
        -se dau salariile angajatilor
        -angajatii isi platesc chiriile
        -angajatilor li se acumuleaza o zi jumate de concediu
        La sfarsitul fiecarui an,ospatarii si Bucatarii merg in vacante timp 
        de o luna.
        
        
        
        
        614 linii cod
        4 clase 
        1 interfata
        36 campuri
        49 functii
         */
        Restaurant LaTudor = new Restaurant("La Tudor");

        Manager m1 = new Manager("La Tudor", "Sorin", 4000);
        angajati[0] = m1;
        Bucatar b1 = new Bucatar("La Tudor", "Andrei", 2900);
        angajati[1] = b1;
        Ospatar o1 = new Ospatar("La Tudor", "Matei", 2500);
        angajati[2] = o1;
        Ospatar o2 = new Ospatar("La Tudor", "Cali", 2500);
        angajati[3] = o2;

        LaTudor.genereazaAn();
        LaTudor.genereazaAn();

    }
}
