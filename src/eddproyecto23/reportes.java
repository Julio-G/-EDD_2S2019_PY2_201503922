/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eddproyecto23;

/**
 *
 * @author Julio Garcia
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class reportes extends JFrame{
    JButton btnhash,btnmatriz,btnavl,btngrafo,btnbita;
    JLabel lbhash,lbimagen,lbmatriz,lbavl,lbgrafo,lbbita;
    public reportes(){
        super("EDD drive");
        setSize(1200,700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        progra();
    }
    public void progra(){
        Font fuente= new Font("Comic Sans MS",0,25);
        lbhash=new JLabel ("Tabla Hash");
	lbhash.setFont(fuente); 
        lbhash.setBounds(15,5,300,50);
        lbimagen=new JLabel(new ImageIcon("matriz.png"));
        lbimagen.setBounds(200,10,950,620);
        btnhash = new JButton("Tabla hash");
	btnhash.setBounds(15,65,110,30);
	btnhash.setBackground(Color.white);
        btnhash.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
               EDDproyecto23.lol.graficar2();
               
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                ImageIcon icon= new ImageIcon("hash.png");
                Image img = icon.getImage() ;  
                Image newimg = img.getScaledInstance( 950, 620,  java.awt.Image.SCALE_SMOOTH ) ; 
                icon = new ImageIcon( newimg );
                lbimagen.setIcon(icon);
                lbimagen.setBounds(200,10,950,620);
                lbimagen.setVisible(true);
                lbimagen.repaint();
               
              
            }

        });
        lbmatriz=new JLabel ("Matriz");
	lbmatriz.setFont(fuente); 
        lbmatriz.setBounds(15,110,300,50);
        btnmatriz = new JButton("matriz");
	btnmatriz.setBounds(15,170,110,30);
	btnmatriz.setBackground(Color.white);
        btnmatriz.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
               EDDproyecto23.rese.graficar();
               
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                ImageIcon icon= new ImageIcon("matriz.png");
                Image img = icon.getImage() ;  
                Image newimg = img.getScaledInstance( 950, 620, java.awt.Image.SCALE_SMOOTH ) ; 
                icon = new ImageIcon( newimg );
                lbimagen.setIcon(icon);
                lbimagen.setBounds(200,10,950,620);
                lbimagen.setVisible(true);
                lbimagen.repaint();
            }

        });
        lbavl=new JLabel ("Arbol AVL");
	lbavl.setFont(fuente); 
        lbavl.setBounds(15,215,300,50);
        btnavl = new JButton("AVL");
	btnavl.setBounds(15,275,110,30);
	btnavl.setBackground(Color.white);
        btnavl.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                mnodo cinicio=EDDproyecto23.rese.inicio;
                while(cinicio.carpeta!=EDDproyecto23.carp){
                    cinicio=cinicio.der;
                }
                cinicio=cinicio.abajo;
                cinicio.arbol.agraficar(cinicio.carpeta);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                ImageIcon icon= new ImageIcon("avl.png");
                Image img = icon.getImage() ;  
                Image newimg = img.getScaledInstance( 950, 620, java.awt.Image.SCALE_SMOOTH ) ; 
                icon = new ImageIcon( newimg );
                lbimagen.setIcon(icon);
                lbimagen.setBounds(200,10,950,620);
                lbimagen.setVisible(true);
                lbimagen.repaint();
            }

        });
        lbgrafo=new JLabel ("Grafo");
	lbgrafo.setFont(fuente); 
        lbgrafo.setBounds(15,320,300,50);
        btngrafo = new JButton("Grafo");
	btngrafo.setBounds(15,380,110,30);
	btngrafo.setBackground(Color.white);
        btngrafo.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
               EDDproyecto23.rese.graficar2();
               
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                ImageIcon icon= new ImageIcon("grafo.png");
                Image img = icon.getImage() ;  
                Image newimg = img.getScaledInstance( 950, 620, java.awt.Image.SCALE_SMOOTH ) ; 
                icon = new ImageIcon( newimg );
                lbimagen.setIcon(icon);
                lbimagen.setBounds(200,10,950,620);
                lbimagen.setVisible(true);
                lbimagen.repaint();
            }

        });
        lbbita=new JLabel ("Bitacora");
	lbbita.setFont(fuente); 
        lbbita.setBounds(15,425,300,50);
        btnbita = new JButton("Bitacora");
	btnbita.setBounds(15,485,110,30);
	btnbita.setBackground(Color.white);
        btnbita.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
               EDDproyecto23.reg.graficar();
               
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(reportes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                ImageIcon icon= new ImageIcon("bita.png");
                Image img = icon.getImage() ;  
                Image newimg = img.getScaledInstance( 950, 620, java.awt.Image.SCALE_SMOOTH ) ; 
                icon = new ImageIcon( newimg );
                lbimagen.setIcon(icon);
                lbimagen.setBounds(200,10,950,620);
                lbimagen.setVisible(true);
                lbimagen.repaint();
            }

        });
        add(lbhash);
        add(lbimagen);
        add(btnhash);
        add(btnmatriz);
        add(lbmatriz);
        add(lbavl);
        add(btnavl);
        add(lbgrafo);
        add(btngrafo);
        add(lbbita);
        add(btnbita);
        
        
        
    }
}
