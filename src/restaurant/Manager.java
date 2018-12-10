/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import static Provizii.ProviziiVanzariVacante.*;

public class Manager extends Restaurant {
    private int baniStransi;
    public Manager(String nR,String nA,double sa) {
        super(nR);
        numeAngajat=nA;
        salariu=sa;
        zileVacanta=20;
        nrManageri++;
        totalSalarii+=sa;
    }
    
    public double getBaniStransi(){
    return baniStransi;
    }
    
    public  void primesteSalariul(){
        baniStransi+=salariu;
        scadereProfit(salariu);
    }
    
    public void cheltuieM(int n){
        baniStransi-=n;
    }
     

    
    public static void cumparaPui(int n){
        puiNefacut+=n;
        achitareProdus(10*n);
    }
    public static void cumparaCartofi(int n){
        cartofiNefacuti+=n;
        achitareProdus(5*n);
    }
    public static void cumparaSalataVara(int n){
        salataVaraNefacut+=n;
        achitareProdus(5*n);
    }
    public static void cumparaSalataMuraturi(int n){
        salataMuraturiNefacut+=n;
        achitareProdus(5*n);
    }
    public static void cumparaChifla(int n){
        chifle+=n;
        achitareProdus(n);
    }
    
    
}
