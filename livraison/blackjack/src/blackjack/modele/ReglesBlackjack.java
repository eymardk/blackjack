package blackjack.modele;

import cartes.Carte;
import cartes.Paquet;

/**
 * Regroupe des méthodes utilitaires pour les règles du blackjack.
 * Calcul du score et test de blackjack.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class ReglesBlackjack {

    /**
     * Calcule le score d'une main de blackjack.
     * Les figures valent 10, les As valent 11 ou 1.
     *
     * @param main la main à évaluer
     * @return le score de la main
     */
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

    /**
     * Indique si une main est un blackjack.
     *
     * @param main la main à tester
     * @return true si la main contient deux cartes et vaut 21
     */
    public static boolean estBlackjack(Paquet main) {
        return main.getTaille() == 2 && calculerScore(main) == 21;
    }
}
