package blackjack.modele;

/**
 * Écouteur générique de modèle (pattern Observer).
 * Les vues implémentent cette interface pour être notifiées.
 *
 * @author groupe_Kandji_Houssou_LeBasnier_
 */
public interface ModeleEcouteur {

    /**
     * Méthode appelée quand le modèle change.
     *
     * @param source le modèle qui a changé
     */
    void modeleMisAJour(Object source);
}
