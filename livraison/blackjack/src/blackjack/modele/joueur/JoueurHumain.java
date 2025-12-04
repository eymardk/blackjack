package blackjack.modele.joueur;

/**
 * Joueur contrôlé par l'utilisateur via l'interface graphique.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public class JoueurHumain extends Joueur {

    /**
     * Crée un joueur humain.
     *
     * @param nom le nom du joueur
     */
    public JoueurHumain(String nom) {
        super(nom);
    }

    /**
     * Retourne false car la décision est prise par les boutons GUI.
     *
     * @param carteVisibleCroupier valeur de la carte visible du croupier (ignorée)
     * @return false (décision gérée par l'interface)
     */
    @Override
    public boolean veutTirer(String carteVisibleCroupier) {
        // La décision réelle est prise par les boutons (Tirer/Rester).
        return false;
    }
}
