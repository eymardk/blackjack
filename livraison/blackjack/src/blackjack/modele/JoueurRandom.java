package blackjack.modele;

import cartes.model.Paquet;

/**
 * Joueur IA avec stratégie aléatoire.
 * Pattern Strategy.
 * @author lebasni231
 */
public class JoueurRandom extends Joueur {
    
    public JoueurRandom(String n){
        super(n);
    }

    @Override
    public void drawCard(Paquet pqt) {
        this.getPaquet().ajoutDessous(pqt.tiragePremiere());
    }

    /**
     * Stratégie : décision aléatoire (50% chance de tirer).
     */
    @Override
    public void tour(Paquet pqt, Joueur adv) {
        double random = Math.random();
        
        if(random > 0.5){
            drawCard(pqt);
        }
    }
}
