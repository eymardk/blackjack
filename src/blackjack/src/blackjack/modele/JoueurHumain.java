/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.modele;

import cartes.model.Paquet;

/**
 * Classe du joueur humain
 * 
 */
public class JoueurHumain extends Joueur {
    
    public JoueurHumain(String n){
        super(n);
    }

    @Override
    public void drawCard(Paquet pqt) {
        this.getPaquet().ajoutDessous(pqt.tiragePremiere());        
    }

    @Override
    public void tour(Paquet pqt, Joueur adv) {
        drawCard(pqt);
    } 
}
