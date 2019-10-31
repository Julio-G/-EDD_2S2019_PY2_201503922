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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class usuario extends JFrame{
    JLabel lbusuario,lbcarpeta,lbarchivo,lbreportes,lbcar;
    JButton btncrearc,btnsubirc,btncrearar,btnmasiva,btnreportes;
    JButton[] botones = new JButton[10];
    JPanel panel;
    public usuario(){
        super("USAC FILE DRIVE");
        setSize(800,550);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        progra();
    }
    public void progra(){
        Font fuente= new Font("Comic Sans MS",0,25);
        panel= new JPanel();
        panel.setBounds(200,70,500,300);
        panel.setBackground(Color.white);
        
        EDDproyecto23.rese.insertar("raiz","home");
        EDDproyecto23.rese.insertar("home","documents");
        pol();
        add(panel);
        panel.repaint();
        this.repaint();
        mnodo cinicio=EDDproyecto23.rese.inicio;
        cinicio=cinicio.abajo;
        String link="";
        if(cinicio.carpeta.equals("raiz")){
            link="/";
        }
           
        lbcar=new JLabel (link);
        lbcar.setFont(fuente);
        lbcar.setBounds(200,50,300,20);
        
        lbusuario=new JLabel ("USUARIO: "+EDDproyecto23.hnom);
	lbusuario.setFont(fuente); 
        lbusuario.setBounds(10,5,300,20);
        lbcarpeta=new JLabel ("CARPETAS");
	lbcarpeta.setFont(fuente); 
        lbcarpeta.setBounds(10,50,300,20);
        btncrearc = new JButton("Crear");
	btncrearc.setBounds(10,80,110,30);
	btncrearc.setBackground(Color.white);
        btncrearc.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
         

        });
        btnsubirc = new JButton("Subir");
	btnsubirc.setBounds(10,110,110,30);
	btnsubirc.setBackground(Color.white);
        btnsubirc.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
         

        });
        lbarchivo=new JLabel ("ARCHIVOS");
	lbarchivo.setFont(fuente); 
        lbarchivo.setBounds(10,160,300,20);
        btncrearar = new JButton("Crear");
	btncrearar.setBounds(10,220,110,30);
	btncrearar.setBackground(Color.white);
        btncrearar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
         

        });
        btnmasiva = new JButton("Carga masiva");
	btnmasiva.setBounds(10,190,110,30);
	btnmasiva.setBackground(Color.white);
        btnmasiva.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
         

        });
        lbreportes=new JLabel ("REPORTES");
	lbreportes.setFont(fuente); 
        lbreportes.setBounds(10,270,300,20);
        btnreportes = new JButton("Reportes");
	btnreportes.setBounds(10,300,110,30);
	btnreportes.setBackground(Color.white);
        btnreportes.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                reportes dol=new reportes();
                dol.setVisible(true);
            }
         

        });
        add(lbusuario);
        add(lbcarpeta);
        add(btncrearc);
        add(lbarchivo);
        add(btncrearar);
        add(btnmasiva);
        add(btnsubirc);
        add(lbreportes);
        add(btnreportes);
        add(lbcar);
        
    }
    public void pol(){
        mnodo cinicio=EDDproyecto23.rese.inicio;
        cinicio=cinicio.abajo;
        int cont=0;
        while(cinicio.der!=null){
            if(!cinicio.der.carpeta.endsWith("raiz")){
                botones[cont]= new JButton(cinicio.der.carpeta);
                System.out.println(cinicio.der.carpeta);
                panel.add(botones[cont]);
                cont++;
            }
            
            cinicio=cinicio.der;
        }
    }
     
}
