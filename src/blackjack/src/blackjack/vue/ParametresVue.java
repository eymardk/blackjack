/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.vue;

import blackjack.controleur.ParametresControleur;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Vue pour le choix des parametres de jeu
 * @author lebasni231@CAMPUS
 */
public class ParametresVue extends JFrame {
    private ParametresControleur pC;
    
    private JPanel panel;
    private JPanel bIAPanel;
    private JPanel bPSPanel;
    
    private JButton iaRandom;
    private JButton ia;
    
    private JButton p32;
    private JButton p52;
    
    private JButton startB;
    
    public ParametresVue(){
        this.setTitle("BlackJack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10,10));
        
        this.pC = new ParametresControleur();
        
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(3,2));
        
        //Choix taille paquet
        this.bPSPanel = new JPanel();
        this.bPSPanel.setLayout(new GridLayout(1,2));
        
        this.p32 = new JButton("Paquet 32");
        this.p32.addActionListener(e -> pSize(32));
        this.p52 = new JButton("Paquet 52");
        this.p52.addActionListener(e -> pSize(52));
        
        this.bPSPanel.add(this.p32);
        this.bPSPanel.add(this.p52);
        
        //Choix difficulte
        this.bIAPanel = new JPanel();
        this.bIAPanel.setLayout(new GridLayout(1,2));
        
        this.iaRandom = new JButton("IA facile");
        this.iaRandom.addActionListener(e -> iaDiff("f"));
        this.ia = new JButton("IA medium");
        this.ia.addActionListener(e -> iaDiff("m"));
        
        this.iaRandom.setEnabled(false);
        this.ia.setEnabled(false);
        
        this.bIAPanel.add(this.iaRandom);
        this.bIAPanel.add(this.ia);
        
        //Le reste
        this.startB = new JButton("Lancer Partie");
        this.startB.addActionListener(e -> startGame());
        this.startB.setEnabled(false);
        
        this.panel.add(this.bPSPanel);
        this.panel.add(this.bIAPanel);
        this.panel.add(this.startB);
        
        this.add(this.panel);
        this.setSize(300,300);
        this.pack();
        this.setVisible(true);
    }
    
    public void pSize(int size){
        this.p32.setEnabled(false);
        this.p52.setEnabled(false);
        
        this.iaRandom.setEnabled(true);
        this.ia.setEnabled(true);
        
        this.pC.setSizeP(size);
    }
    
    public void iaDiff(String s){
        this.iaRandom.setEnabled(false);
        this.ia.setEnabled(false);
        
        this.startB.setEnabled(true);
        
        this.pC.setDiff(s);
    }
    
    public void startGame(){
        this.dispose();
        this.pC.start();
    }
}
