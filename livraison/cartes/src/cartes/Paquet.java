package cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Paquet {
    private List<Carte> cartes;

    public Paquet() {
        this.cartes = new ArrayList<>();
    }

    public void ajouter(Carte c) {
        if (c != null) {
            cartes.add(c);
        }
    }

    public Carte retirer() {
        if (cartes.isEmpty()) {
            return null;
        }
        return cartes.remove(cartes.size() - 1);
    }

    public Carte retirerAleatoire() {
        if (cartes.isEmpty()) {
            return null;
        }
        Random r = new Random();
        int index = r.nextInt(cartes.size());
        return cartes.remove(index);
    }

    public void melanger() {
        Collections.shuffle(cartes);
    }

    public int getTaille() {
        return cartes.size();
    }

    public boolean estVide() {
        return cartes.isEmpty();
    }

    public Carte getCarte(int index) {
        if (index < 0 || index >= cartes.size()) {
            return null;
        }
        return cartes.get(index);
    }

    @Override
    public String toString() {
        String resultat = "";
        for (Carte c : cartes) {
            resultat += c.toString() + "\n";
        }
        return resultat;
    }

}
