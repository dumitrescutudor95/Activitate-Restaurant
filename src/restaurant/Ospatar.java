package restaurant;

import static Provizii.ProviziiVanzariVacante.*;
import Vacanta.mergeInVacanta;

public class Ospatar extends Restaurant implements mergeInVacanta {

    private double baniStransi;

    public Ospatar(String nR, String nA, double sa) {
        super(nR);
        numeAngajat = nA;
        salariu = sa;
        zileVacanta = 20;
        nrOspatari++;
        totalSalarii += sa;
    }

    public double getBaniStransi() {
        return baniStransi;
    }

    public void cheltuieO(int n) {
        baniStransi -= n;
    }

    public void primesteSalariul() {
        baniStransi += salariu;
        scadereProfit(salariu);
    }

    public static void servesteSnitel(int n) {
        if (n >= snitel) {
            snitelVandut += n;
            snitel -= n;
            cresteProfit(20 * n);
        } else {
            Bucatar.preparaSnitel(Math.abs(snitel - n));
            snitelVandut += n;
            snitel -= n;
            cresteProfit(20 * n);
        }
    }

    public static void servestePieptPui(int n) {
        if (n >= pieptPui) {
            pieptPuiVandut += n;
            pieptPui -= n;
            cresteProfit(25 * n);
        } else {
            Bucatar.preparaPieptPui(n);
            pieptPuiVandut += n;
            pieptPui -= n;
            cresteProfit(25 * n);
        }
    }

    public static void servestePiure(int n) {
        if (n >= piure) {
            piure -= n;
            cresteProfit(15 * n);
        } else {
            Bucatar.preparaPiure(n);
            piure -= n;
            cresteProfit(15 * n);
        }
    }

    public static void servesteCartofiPrajiti(int n) {
        if (n >= cartofiPrajiti) {
            cartofiPrajitiVanduti += n;
            cartofiPrajiti -= n;
            cresteProfit(15 * n);
        } else {
            Bucatar.preparaCartofiPrajiti(n);
            cartofiPrajiti -= n;
            cartofiPrajitiVanduti += n;
            cresteProfit(15 * n);
        }
    }

    public static void servesteSalataVara(int n) {
        if (n >= salataVara) {
            salataVaraVanduta += n;
            salataVara-=n;
            cresteProfit(15 * n);
        } else {
            Bucatar.preparaSalataVara(n);
            salataVaraVanduta += n;
            salataVara-=n;
            cresteProfit(15 * n);
        }
    }

    public static void servesteSalataMuraturi(int n) {
        if (n >= salataMuraturi) {
            salataMuraturiVanduta += n;
            salataMuraturi-=n;
            cresteProfit(15 * n);
        } else {
            Bucatar.preparasalataMuraturi(n);
            salataMuraturiVanduta += n;
            salataMuraturi-=n;
            cresteProfit(15 * n);
        }
    }

    public static void servesteChifla(int n) {
        if (n >= chifle) {
            chifleVandute += n;
            chifle-=n;
            cresteProfit(4 * n);
        } else {
            Manager.cumparaChifla(n);
            chifleVandute += n;
            chifle-=n;
            cresteProfit(4 * n);
        }
    }

    @Override
    public void mergeInVacanta() {
        int x = (int) Math.floor(Math.random() * locatii.length);
        System.out.println("Ospatarul " + numeAngajat + ",acumuland suma de "
                + baniStransi + "de lei,\na plecat in vacanta " + locatii[x] + " timp de o luna");

        switch (x) {
            case 1:
                baniStransi -= 6500;
            case 2:
                baniStransi -= 5000;
            case 3:
                baniStransi -= 500;
            case 4:
                baniStransi -= 2000;
            case 5:
                baniStransi -= 2000;
        }
        System.out.println("La sfarsitul acesteia,a ramas cu suma de " + baniStransi + " lei\n");
    }
}
