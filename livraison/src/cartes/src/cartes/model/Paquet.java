/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartes.model;

import cartes.control.AbstractModeleEcoutable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author lebasni231@CAMPUS
 */
public class Paquet extends AbstractModeleEcoutable {
    private static final String[] hauteur52 = {"2", "3", "4", "5","6","7","8","9","10","J","Q","K","A"};
    private static final String[] hauteur32 = {"7","8","9","10","J","Q","K","A"};
    
    
    private ArrayList<Carte> paquet;
    
    public Paquet(){
        this.paquet = new ArrayList<>();
    }
    
    public ArrayList<Carte> getPaquet() {
        return paquet;
    }
    
    
    public void ajoutDessus(Carte c){
        this.paquet.add(0,c);
        fireChange();
    }
    
    public void ajoutDessous(Carte c){
        this.paquet.add(c);
        fireChange();
    }
    
    public Carte tirageHasard(){
        int random = (int)(Math.random() * this.paquet.size());
        Carte c = this.paquet.get(random);
        this.paquet.remove(random);
        fireChange();
        return c;
    }
    
    public Carte tiragePremiere(){
        Carte c = this.paquet.get(0);
        this.paquet.remove(0);
        fireChange();
        return c;
    }
    
    public void melangerPaquet(){
        int tmpSize = this.paquet.size();
        ArrayList<Carte> paquetMelange = new ArrayList<>();
        
        while (tmpSize > 0) {
            Carte c = this.tirageHasard();
            paquetMelange.add(c);
            this.paquet.remove(c);
            tmpSize = this.paquet.size();
        }
        this.paquet = paquetMelange;
        fireChange();
    }
    
    public void couperPaquet(){
        int random = (int)(Math.random() * (this.paquet.size()- 5) + 5);
        Carte c1 = this.paquet.get(random);
        Carte c2 = this.paquet.get(this.paquet.size() - 1);
        while (c2 != c1){
            c2 = this.paquet.get(this.paquet.size() - 1);
            this.paquet.remove(c2);
            this.ajoutDessus(c2);
        }
        fireChange();
    }
    
    public static Paquet createPaquet32(){
        return createPaquet(hauteur32);
    }
    
    public static Paquet createPaquet52(){
        return createPaquet(hauteur52);
    }
    
    public static Paquet createPaquet(String [] hauteur){
        final ArrayList<String> couleur = new ArrayList<>(Arrays.asList("\u2665", "\u2663", "\u2660", "\u2666"));
        
        Paquet p = new Paquet();
        
        for (String couleur1 : couleur) {
            for(String hauteur1 : hauteur){
                Carte c = new Carte(hauteur1,couleur1);
                p.ajoutDessous(c);
            }
        }
        return p;
    }
    
    @Override
    public String toString(){
        String s = "";
        for(Carte carte1 : this.paquet){
            s += carte1 + " \n";
        }
        return s;
    }
    
}
