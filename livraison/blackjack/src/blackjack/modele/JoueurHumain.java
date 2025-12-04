package blackjack.modele;

import cartes.model.Paquet;

/**
 * Joueur humain contrôlé par l'interface.
 * @author lebasni231
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
        // Géré par l'interface utilisateur
    }
}
