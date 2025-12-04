package blackjack.modele;

import cartes.model.Paquet;

/**
 * Règles du blackjack.
 * @author lebasni231
 */
public class BlackJack {
    
    /**
     * Vérifie si le paquet est un BlackJack (21 avec 2 cartes).
     * @param p le paquet
     * @return true si BlackJack, false sinon
     */
    public static boolean estBLackJack(Paquet p){
        return p.getSum() == 21 && (p.getPaquet().size() == 2);
    }
    
    /**
     * Vérifie si le paquet dépasse 21.
     * @param p le paquet
     * @return true si supérieur à 21, false sinon
     */
    public static boolean supperieur(Paquet p){
        return p.getSum() > 21;
    }
}
