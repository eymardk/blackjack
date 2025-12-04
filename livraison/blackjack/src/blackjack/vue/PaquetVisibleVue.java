/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack.vue;

import cartes.control.EcouteurModele;
import cartes.model.Paquet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author lebasni231@CAMPUS
 */
public class PaquetVisibleVue extends JPanel implements EcouteurModele{
    private Paquet p;
    private String owner;

    public PaquetVisibleVue(Paquet p, String name){
        this.p = p;
        this.owner = name;
        setPreferredSize(new Dimension(200, 500));
        this.p.ajoutEcouteur(this);
    }
    
    public String getNom(){
        return this.owner;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int k = 0;
        g2.drawString(this.owner, 5, 10);
        for(int i = 0; i < this.p.getPaquet().size(); i++){
            int j = i % 10;
            System.out.println(k + " " + (i%10) + " " + i);
            g2.setColor(Color.BLUE);
            g2.fillRoundRect(15 + 105*j, 15 + 160*k, 100, 150, 15, 25);
            g2.setColor(Color.LIGHT_GRAY);
            g2.fillRoundRect(25 + 105*j, 25 + 160*k, 80, 130, 15, 25);
            g2.setColor(Color.BLACK);
            g2.drawString(this.p.getPaquet().get(i).toString(), 35 + 105*j, 40 + 160*k);
            if (j == 9){
                k++;
            }
        }
    }

    @Override
    public void modeleMisAJour(Object source){
        this.repaint();
    }
}

