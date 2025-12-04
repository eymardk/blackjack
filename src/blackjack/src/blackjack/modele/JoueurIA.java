/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.modele;

import cartes.model.Paquet;

/**
 * Classe du joueur ia avec un peu de reflexion
 * 
 */
public class JoueurIA extends Joueur {
    
    public JoueurIA(String n){
        super(n);
    }

    @Override
    public void drawCard(Paquet pqt) {
        this.getPaquet().ajoutDessous(pqt.tiragePremiere());        
    }

    @Override
    public void tour(Paquet pqt, Joueur adv) {
        int scoreOpp = adv.getPaquet().getSum();
        int sumJ = this.getPaquet().getSum();
        
        if((sumJ < 11) || (sumJ < 17 && scoreOpp > sumJ)){
            drawCard(pqt);
        }
    }
}
