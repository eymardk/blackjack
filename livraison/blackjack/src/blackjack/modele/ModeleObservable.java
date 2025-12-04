package blackjack.modele;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de base pour les modèles observables (pattern Observer).
 * Gère une liste d'écouteurs et notifie les changements.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public abstract class ModeleObservable {

    private final List<ModeleEcouteur> ecouteurs = new ArrayList<>();

    /**
     * Ajoute un écouteur au modèle.
     *
     * @param e l'écouteur à ajouter
     */
    public void ajouterEcouteur(ModeleEcouteur e) {
        ecouteurs.add(e);
    }

    /**
     * Retire un écouteur du modèle.
     *
     * @param e l'écouteur à retirer
     */
    public void retirerEcouteur(ModeleEcouteur e) {
        ecouteurs.remove(e);
    }

    /**
     * Notifie tous les écouteurs que le modèle a changé.
     */
    protected void fireChange() {
        for (ModeleEcouteur e : ecouteurs) {
            e.modeleMisAJour(this);
        }
    }
}
