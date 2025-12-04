/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartes.vue;

import cartes.model.Carte;
import cartes.model.Paquet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author lebasni231@CAMPUS
 */
public class PaquetGUI extends JFrame implements ActionListener {
    private Paquet p;
    private Paquet p2;
    private PaquetCacheVue panelPaquetC;
    private PaquetVisibleVue panelPaquetV;
    
    public PaquetGUI(Paquet p){
        this.p = p;
        this.p2 = new Paquet();
        
        this.setSize(1900,1200);
        //setBackground(Color.GREEN);
        
        this.setLayout(new BorderLayout());
        this.panelPaquetC = new PaquetCacheVue(this.p);
        this.panelPaquetV = new PaquetVisibleVue(this.p2);
        
        this.panelPaquetC.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me) {
                if(!p.getPaquet().isEmpty()){
                    Carte c = p.tirageHasard();
                    p2.ajoutDessous(c);
                    System.out.println(me.getX());
                }
            }
        });
        this.add(this.panelPaquetC, BorderLayout.NORTH);
        this.add(this.panelPaquetV, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 

    }
    
    public void actionPerformed(ActionEvent ae) {
       Carte c = this.p.tirageHasard();
       this.p2.ajoutDessous(c);
       System.out.println(this.p2);
    }
}
