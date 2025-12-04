package blackjack.modele.joueur;

import java.util.Random;

/**
 * Joueur contrôlé par une IA aléatoire.
 * Décide de tirer ou rester au hasard.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class JoueurRandom extends Joueur {
    private final Random random = new Random();

    /**
     * Crée un joueur aléatoire.
     *
     * @param nom le nom du joueur
     */
    public JoueurRandom(String nom) {
        super(nom);
    }

    /**
     * Décide aléatoirement de tirer ou non.
     *
     * @param carteVisibleCroupier valeur de la carte visible du croupier (ignorée ici)
     * @return true pour tirer, false pour rester
     */
    @Override
    public boolean veutTirer(String carteVisibleCroupier) {
        return random.nextBoolean();
    }
}
