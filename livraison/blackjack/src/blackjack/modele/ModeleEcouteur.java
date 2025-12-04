package blackjack.modele;

/**
 * Écouteur générique de modèle (pattern Observer).
 */
public interface ModeleEcouteur {
    /**
     * Méthode appelée quand le modèle change.
     * @param source le modèle qui a changé
     */
    void modeleMisAJour(Object source);
}
