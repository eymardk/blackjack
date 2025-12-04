package blackjack.modele;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de base pour les modèles observables (pattern Observer).
 */
public abstract class ModeleObservable {

    private final List<ModeleEcouteur> ecouteurs = new ArrayList<>();

    public void ajouterEcouteur(ModeleEcouteur e) {
        ecouteurs.add(e);
    }

    public void retirerEcouteur(ModeleEcouteur e) {
        ecouteurs.remove(e);
    }

    protected void fireChange() {
        for (ModeleEcouteur e : ecouteurs) {
            e.modeleMisAJour(this);
        }
    }
}
