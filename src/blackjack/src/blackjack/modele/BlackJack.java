/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.modele;

import cartes.model.Paquet;

/**
 * Regles du blackjack
 * @author lebasni231@CAMPUS
 */
public class BlackJack {
    public static boolean estBLackJack(Paquet p){
        return p.getSum() == 21 && (p.getPaquet().size() == 2);
    }
    
    public static boolean supperieur(Paquet p){
        return p.getSum() > 21;
    }
}
