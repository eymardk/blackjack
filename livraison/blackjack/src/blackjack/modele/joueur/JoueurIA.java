package blackjack.modele.joueur;

// Joueur IA avec stratégie simple basée sur son score et la carte visible du croupier
public class JoueurIA extends Joueur {

    public JoueurIA(String nom) {
        super(nom);
    }

    @Override
    public boolean veutTirer(String carteVisibleCroupier) {
        int score = getScore();

        // Si score <= 11 : toujours tirer
        if (score <= 11) {
            return true;
        }

        // Croupier montre une carte "forte" ?
        boolean croupierFort = carteVisibleCroupier.equals("7")
                || carteVisibleCroupier.equals("8")
                || carteVisibleCroupier.equals("9")
                || carteVisibleCroupier.equals("10")
                || carteVisibleCroupier.equals("Valet")
                || carteVisibleCroupier.equals("Dame")
                || carteVisibleCroupier.equals("Roi")
                || carteVisibleCroupier.equals("AS");

        if (croupierFort) {
            // Contre une carte forte, l’IA tire jusqu’à 17
            return score < 17;
        } else {
            // Contre une carte faible (2–6), l’IA reste dès 12
            return score < 12;
        }
    }
}
