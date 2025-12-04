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
public class PaquetCacheVue extends JPanel implements EcouteurModele{
    private Paquet p;

    public PaquetCacheVue(Paquet p){
        this.p = p;
        setPreferredSize(new Dimension(200,200));
        this.p.ajoutEcouteur(this);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if (!this.p.getPaquet().isEmpty()){
            int hight = this.p.getPaquet().size() * 1/4;
            while(hight > 0){
                if(hight % 2 == 0){
                    g2.setColor(Color.WHITE);
                }
                else{
                    g2.setColor(Color.BLACK);
                }
                g2.fillRoundRect(15 + hight, 15, 100, 150 + hight, 15, 25);
                hight--;
            }

            g2.setColor(Color.BLUE);
            g2.fillRoundRect(15, 15, 100, 150, 15, 25);
        }
        else{
            g2.setColor(Color.BLACK);
            g2.drawRoundRect(15, 15, 100, 150, 15, 25);
        }
    }

    @Override
    public void modeleMisAJour(Object source){
        this.repaint();
    }
}
