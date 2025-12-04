/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.controleur;

import blackjack.modele.Joueur;
import blackjack.modele.JoueurHumain;
import blackjack.modele.JoueurIA;
import blackjack.modele.JoueurRandom;
import blackjack.modele.Partie;
import blackjack.vue.PartieGUI;
import cartes.model.Paquet;

/**
 * Met en place les choix fait dans parametresVue et lance l'interface graphique du jeu
 * @author lebasni231@CAMPUS
 */
public class ParametresControleur {
    private Partie jeu;
    private JoueurHumain joueur;
    private Joueur adversaire;
    
    private Paquet p;
    
    public ParametresControleur(){
        this.p = null;
        this.joueur = new JoueurHumain("Joueur");
        this.adversaire = null;
    } 
    
    public void setDiff(String s){
        if("f".equals(s)){
            this.adversaire = new JoueurRandom("IA 1");
        }
        else {
            this.adversaire = new JoueurIA("IA 1");
        }
    }
    
    public void setSizeP(int s){
        if( s == 32){
            this.p = Paquet.createPaquet32();
            System.out.print("32");
        }
        else {
            this.p = Paquet.createPaquet52();
            System.out.print("52");
        }
    }
    
    public void start(){
        this.jeu = new Partie(this.joueur,this.adversaire,this.p);
        this.jeu.init();
        new PartieGUI(this.jeu);
    }
}

