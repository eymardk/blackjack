/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.vue;

import blackjack.modele.Partie;
import cartes.model.Paquet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Vue graphique de la partie
 * @author lebasni231@CAMPUS
 */
public class PartieGUI extends JFrame {
    private Partie jeu;
    private Paquet p;
    private PaquetCacheVue panelPaquetC;
    private PaquetVisibleVue panelPaquetV1;
    private PaquetVisibleVue panelPaquetV2;
    private JButton bNewPartie;
    private JButton bDrawCard;
    private JButton bPass;
    
    public PartieGUI(Partie jeu){
        this.jeu = jeu;
        this.p = this.jeu.getPioche();        
        
        this.setTitle("BlackJack");
        this.setSize(1600,1200);
        this.setLayout(new BorderLayout());
        this.panelPaquetC = new PaquetCacheVue(this.p);
        
        JPanel panelJ = new JPanel(new GridLayout(1,3));
        panelJ.setPreferredSize(new Dimension(1500, 600));
        
        JPanel panelB = new JPanel();
        this.bNewPartie = new JButton("Nouvelle Partie");
        this.bNewPartie.addActionListener(e -> {
            this.restart();
            System.out.println("AGAIN");
        });
        this.bDrawCard = new JButton("Tirer Carte");
        this.bDrawCard.addActionListener(e -> {
            this.draw(this.p);
            System.out.println("DRAW");
        });
        this.bPass = new JButton("Passer");
        this.bPass.addActionListener(e -> {
            this.pass(this.p);
            System.out.println("PASS");
        });
        panelB.add(this.bDrawCard);
        panelB.add(this.bPass);
        panelB.add(this.bNewPartie);
   
        this.panelPaquetV1 = new PaquetVisibleVue(this.jeu.getJ1().getPaquet(), this.jeu.getJ1().getName());            
        this.panelPaquetV2 = new PaquetVisibleVue(this.jeu.getJ2().getPaquet(), this.jeu.getJ2().getName());            
        
        panelJ.add(this.panelPaquetV1);
        panelJ.add(this.panelPaquetV2);
        
        this.add(this.panelPaquetC, BorderLayout.NORTH);
        this.add(panelJ, BorderLayout.CENTER);
        this.add(panelB, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public JButton getBNewPartie(){
        return this.bNewPartie;
    }
    
    public void draw(Paquet pqt){
        if(!this.jeu.getPioche().getPaquet().isEmpty() && !this.jeu.isOver()){
            this.jeu.getJ1().drawCard(this.p);
            this.jeu.getJ2().tour(this.p,this.jeu.getJ1());
        }
        else{
            ResultatsVue res = new ResultatsVue(this.jeu,this);
        }
    }
    
    public void pass(Paquet pqt){
        if(!this.jeu.getPioche().getPaquet().isEmpty() && !this.jeu.isOver()){
            this.jeu.getJ2().tour(this.p,this.jeu.getJ1());
        }
        else {
            ResultatsVue res = new ResultatsVue(this.jeu,this);
        }
    }
    
    public void restart(){
        this.jeu.restart();
        this.jeu.init();
    }
}
