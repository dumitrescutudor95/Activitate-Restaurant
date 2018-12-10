/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Provizii;

import restaurant.Bucatar;
import restaurant.Manager;
import restaurant.Ospatar;
import restaurant.Restaurant;
import static restaurant.Restaurant.angajati;

/**
 *
 * @author Dell
 */
public class ProviziiVanzariVacante {

    public static void lichidareSalarii() {
        for (Restaurant o : angajati) {
            if (o instanceof Manager) {
                ((Manager) o).primesteSalariul();
                System.out.println("Managerul " + ((Manager) o).numeAngajat + " a primit salariul");
                System.out.println("Economii totale:" + ((Manager) o).getBaniStransi() + "\n");
            }
            if (o instanceof Bucatar) {
                ((Bucatar) o).primesteSalariul();
                System.out.println("Bucatarul " + ((Bucatar) o).numeAngajat + " a primit salariul");
                System.out.println("Economii totale:" + ((Bucatar) o).getBaniStransi() + "\n");

            }
            if (o instanceof Ospatar) {
                ((Ospatar) o).primesteSalariul();
                System.out.println("Ospatarul " + ((Ospatar) o).numeAngajat + " a primit salariul");
                System.out.println("Economii totale:" + ((Ospatar) o).getBaniStransi() + "\n");

            }
        }
        System.out.println("\n");
    }

    public static void platesteChiriaLunara() {
        for (Restaurant o : angajati) {
            if (o instanceof Ospatar) {
                ((Ospatar) o).cheltuieO(1200);
            }
            if (o instanceof Bucatar) {
                ((Bucatar) o).cheltuieB(1500);
            }
            if (o instanceof Manager) {
                ((Manager) o).cheltuieM(2500);
            }
        }
    }

    public static void adaugaZileVacantaAngajati() {
        for (Restaurant o : angajati) {
            if (o instanceof Ospatar) {
                ((Ospatar) o).adaugaZileVacanta(1.5);
            }
            if (o instanceof Bucatar) {
                ((Bucatar) o).adaugaZileVacanta(1.5);
            }
            if (o instanceof Manager) {
                ((Manager) o).adaugaZileVacanta(1.5);
            }
        }
    }

    public static void eTimpulVacantei() {
        for (Restaurant o : angajati) {
            if (o instanceof Ospatar) {
                if (((Ospatar) o).zileVacanta >= 30) {
                    ((Ospatar) o).mergeInVacanta();
                } else {
                    System.out.println("Ospatarul " + o.numeAngajat
                            + " nu are suficiente zile de concediu disponibile");
                }
            }
            if (o instanceof Bucatar) {
                if (((Bucatar) o).zileVacanta >= 30) {
                    ((Bucatar) o).mergeInVacanta();
                } else {
                    System.out.println("Bucatarul " + o.numeAngajat
                            + " nu are suficiente zile de concediu disponibile");

                }
            }
        }
    }

    private static double profit = 0;

    public static double getProfit() {
        return profit;
    }

    public static void scadereProfit(double d) {
        profit -= d;
    }

    public static void achitareProdus(double d) {
        profit -= d;
    }

    public static void cresteProfit(double d) {
        profit += d;
    }

    public static int puiNefacut;
    public static int cartofiNefacuti;
    public static int salataVaraNefacut;
    public static int salataMuraturiNefacut;

    public static int snitel;
    public static int piure;
    public static int cartofiPrajiti;
    public static int pieptPui;
    public static int salataVara;
    public static int salataMuraturi;
    public static int chifle;

    public static int snitelVandut;
    public static int piureVandut;
    public static int cartofiPrajitiVanduti;
    public static int pieptPuiVandut;
    public static int salataVaraVanduta;
    public static int salataMuraturiVanduta;
    public static int chifleVandute;

    public static String getStatus() {
        return "Snitel pui vandut:" + snitelVandut
                + "\nPiept pui vandut:" + pieptPuiVandut
                + "\nPiure de cartofi vandut:" + piureVandut
                + "\nCartofi prajiti vanduti:" + cartofiPrajitiVanduti
                + "\nSalata de vara vanduta:" + salataVaraVanduta
                + "\nSalata de muraturi vanduta:" + salataMuraturiVanduta
                + "\nChifle vandute:" + chifleVandute + "\n";
    }

    public static void refresh() {
        snitelVandut = 0;
        piureVandut = 0;
        cartofiPrajitiVanduti = 0;
        pieptPuiVandut = 0;
        salataVaraVanduta = 0;
        salataMuraturiVanduta = 0;
        chifleVandute = 0;
    }

}
