package blackjack.modele.joueur;

/**
 * Joueur contrôlé par une IA "moyenne".
 * Décide de tirer en fonction de son score et de la carte visible du croupier.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class JoueurIA extends Joueur {

    /**
     * Crée un joueur IA.
     *
     * @param nom le nom du joueur
     */
    public JoueurIA(String nom) {
        super(nom);
    }

    /**
     * Indique si l'IA veut tirer une carte.
     * Stratégie :
     * - toujours tirer si score <= 11
     * - si le croupier est "fort", tirer jusqu'à 16
     * - sinon, tirer jusqu'à 11
     *
     * @param carteVisibleCroupier valeur de la carte visible du croupier
     * @return true pour tirer, false pour rester
     */
    @Override
    public boolean veutTirer(String carteVisibleCroupier) {
        int score = getScore();

        if (score <= 11) {
            return true;
        }

        boolean croupierFort = carteVisibleCroupier.equals("7")
                || carteVisibleCroupier.equals("8")
                || carteVisibleCroupier.equals("9")
                || carteVisibleCroupier.equals("10")
                || carteVisibleCroupier.equals("Valet")
                || carteVisibleCroupier.equals("Dame")
                || carteVisibleCroupier.equals("Roi")
                || carteVisibleCroupier.equals("AS");

        if (croupierFort) {
            return score < 17;
        } else {
            return score < 12;
        }
    }
}
