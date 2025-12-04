package blackjack.modele.joueur;

import java.util.Random;


public class JoueurRandom extends Joueur {
    private final Random random = new Random();

    public JoueurRandom(String nom) {
        super(nom);
    }

    @Override
    public boolean veutTirer(String carteVisibleCroupier) {
        return random.nextBoolean();
    }
}
