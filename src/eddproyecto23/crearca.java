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
public class crearca extends JFrame{
    JLabel lbbienvenida;
    JButton btningresar;
    JTextField txtcsv;
    public crearca(){
         super("EDD drive");
        //setSize(800,550);
        setBounds(550,200,350,250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        progra();
    }
    public void progra(){

        Font fuente= new Font("Comic Sans MS",0,18);
        lbbienvenida=new JLabel ("Ingrese el nombre");
	lbbienvenida.setFont(fuente); 
        lbbienvenida.setBounds(35,5,300,50);
        txtcsv = new JTextField();
        txtcsv.setBounds(120,80,150,20);
        btningresar = new JButton("Ingresar");
	btningresar.setBounds(110,120,100,20);
	btningresar.setBackground(Color.white);
        btningresar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                EDDproyecto23.rese.insertar(usuario.donde.carpeta,txtcsv.getText());
                usuario pos = new usuario();
                pos.setVisible(true);
                setVisible(false);
                dispose();
            }
        });
        
        add(lbbienvenida);
        add(txtcsv);
        add(btningresar);
    }
}
