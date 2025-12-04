/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.modele;

import cartes.model.Paquet;
import java.util.Random;

/**
 * Classe du joueur random pas de reflexion juste de l'aleatoire
 * 
 */
public class JoueurRandom extends Joueur {
    private Random r; 
    
    public JoueurRandom(String n){
        super(n);
        this.r = new Random();
    }

    @Override
    public void drawCard(Paquet pqt) {
        this.getPaquet().ajoutDessous(pqt.tiragePremiere());        
    }

    @Override
    public void tour(Paquet pqt, Joueur adv) {
        boolean rand = this.r.nextBoolean();
        if(rand){
            drawCard(pqt);
        }
    } 
}
