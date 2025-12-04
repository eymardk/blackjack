package blackjack.controleur;

import blackjack.modele.Partie;
import blackjack.vue.VuePartie;

import javax.swing.*;
import java.awt.BorderLayout;

public class ControleurPartie {

    private Partie partie;
    private final VuePartie vue;

    public ControleurPartie(Partie partie, VuePartie vue) {
        this.partie = partie;
        this.vue = vue;

    }

}
