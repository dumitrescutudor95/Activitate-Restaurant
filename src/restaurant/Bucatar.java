/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import static Provizii.ProviziiVanzariVacante.*;
import Vacanta.mergeInVacanta;

/**
 *
 * @author Dell
 */
public class Bucatar extends Restaurant implements mergeInVacanta{
       private int baniStransi;

    public Bucatar(String nR,String nA,double sa) {
        super(nR);
        numeAngajat=nA;
        salariu=sa;
        zileVacanta=20;
        nrBucatari++;
        totalSalarii+=sa;
    }
    
     
    public void primesteSalariul(){
        baniStransi+=salariu;
        scadereProfit(salariu);
    }
    
    
 public static void preparaSnitel(int n){
     if (n>=puiNefacut) {
         snitel+=n;
         puiNefacut-=n;
     }
     else{
         Manager.cumparaPui(n);
         snitel+=n;
         puiNefacut-=n;
         
     }
 }
    
 public static void preparaPieptPui(int n){
     if (n>=puiNefacut) {
     pieptPui+=n;
     puiNefacut-=n;
     }
      else{
        Manager.cumparaPui(Math.abs(pieptPui-n));
     }
 }
 
 public static void preparaPiure(int n){
     if (n>=cartofiNefacuti) {
     cartofiNefacuti-=n;
     piure+=n;
        
     }
     else{
          Manager.cumparaCartofi(Math.abs(piure-n));
     }
 }
 
 public static void preparaCartofiPrajiti(int n){
     if (n>=cartofiNefacuti) 
     {
     cartofiNefacuti-=n;
     cartofiPrajiti+=n;
     }
     else{
         System.out.println("Cartofi insuficienti;");
     }
 }
 
 public static  void preparaSalataVara(int n){
     if (n>=salataVaraNefacut) {
         
     
     salataVaraNefacut-=n;
     salataVara+=n;
     }
     else{
         System.out.println("Ingrediente insuficiente pentru salata de vara");
     }
 }
 
 public static void preparasalataMuraturi(int n){
     if (n>=salataMuraturiNefacut) {
     salataMuraturiNefacut-=n;
     salataMuraturi+=n;
     }
     else{
         System.out.println("Ingrediente insuficiente pentru salata de muraturi");
     }
 }
 public void cheltuieB(int n){
        baniStransi-=n;
    }
 public double getBaniStransi(){
    return baniStransi;
    }
 
 @Override
 public void mergeInVacanta(){
     int x=(int)Math.floor(Math.random()*locatii.length);
        System.out.println("Bucatarul "+numeAngajat+",acumuland suma de "
                +baniStransi+"de lei,\na plecat in vacanta in "+locatii[x]+" timp de o luna");
        
             switch(x){
                 case 1:baniStransi-=6500;
                 case 2:baniStransi-=5000;
                 case 3:baniStransi-=500;
                 case 4:baniStransi-=2000;
                 case 5:baniStransi-=2000;
             }
             System.out.println("La sfarsitul acesteia,a ramas cu suma de "+baniStransi+" lei\n");
 }
    
}
