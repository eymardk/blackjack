package blackjack.modele;

import cartes.model.Paquet;

/**
 * Joueur IA avec stratégie réfléchie.
 * Pattern Strategy.
 * @author lebasni231
 */
public class JoueurIA extends Joueur {
    
    public JoueurIA(String n){
        super(n);
    }

    @Override
    public void drawCard(Paquet pqt) {
        this.getPaquet().ajoutDessous(pqt.tiragePremiere());        
    }

    /**
     * Stratégie : tire si score < 11 ou si score < 17 et adversaire devant.
     */
    @Override
    public void tour(Paquet pqt, Joueur adv) {
        int scoreOpp = adv.getPaquet().getSum();
        int sumJ = this.getPaquet().getSum();
        
        if((sumJ < 11) || (sumJ < 17 && scoreOpp > sumJ)){
            drawCard(pqt);
        }
    }
}
