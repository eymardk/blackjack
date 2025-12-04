package blackjack.modele.joueur;


public class JoueurIA extends Joueur {

    public JoueurIA(String nom) {
        super(nom);
    }

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
