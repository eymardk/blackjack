/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.modele;


import cartes.model.Paquet;

/**
 *
 * @author lebasni231@CAMPUS
 */
public abstract class Joueur {
    private Paquet p;
    private String name;
    
    public Joueur(String n){
        this.name = n;
        this.p = new Paquet();
    }
    
    public String getName(){
        return this.name;
    }
    
    public Paquet getPaquet(){
        return this.p;
    }
    
    public void newHand(){
        this.p.vide();
    }
    
    public abstract void drawCard(Paquet p);
    
    public abstract void tour(Paquet p, Joueur adv);
    
}
