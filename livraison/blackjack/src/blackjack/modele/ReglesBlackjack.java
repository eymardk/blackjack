package blackjack.modele;

import cartes.Carte;
import cartes.Paquet;

public class ReglesBlackjack {

    public static int calculerScore(Paquet main) {
        int score = 0;
        int nbAs = 0;

        for (int i = 0; i < main.getTaille(); i++) {
            Carte c = main.getCarte(i);
            String valeur = c.getValeur();

            if (valeur.equals("Valet") || valeur.equals("Dame") || valeur.equals("Roi")) {
                score += 10;
            } else if (valeur.equals("AS")) {
                nbAs++;
                score += 11;
            } else {
                score += Integer.parseInt(valeur);
            }
        }

        // Ajuste les As si on dépasse 21
        while (score > 21 && nbAs > 0) {
            score -= 10;
            nbAs--;
        }

        return score;
    }

    public static boolean aDepasse(Paquet main) {
        return calculerScore(main) > 21;
    }

    public static boolean estBlackjack(Paquet main) {
        return main.getTaille() == 2 && calculerScore(main) == 21;
    }
}
