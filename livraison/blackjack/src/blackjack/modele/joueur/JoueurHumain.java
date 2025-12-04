package blackjack.modele.joueur;

// Joueur contrôlé par l'utilisateur (GUI)
public class JoueurHumain extends Joueur {

    public JoueurHumain(String nom) {
        super(nom);
    }

    @Override
    public boolean veutTirer(String carteVisibleCroupier) {
        // La décision réelle est prise par les boutons (Tirer/Rester).
        
        return false;
    }
}
