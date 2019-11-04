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
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class cmasiva extends JFrame {
    JLabel lbbienvenida;
    JButton btningresar;
    JTextField txtcsv;
    public cmasiva(){
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
                mnodo cinicio=EDDproyecto23.rese.inicio;
                while(cinicio.carpeta!=EDDproyecto23.carp){
                    cinicio=cinicio.der;
                }
                cinicio=cinicio.abajo;
                String hola="";
                try{
                    CsvReader ag = new CsvReader(txtcsv.getText());
                    ag.readHeaders();
                
                    while (ag.readRecord()) {
                     
                        String nombre = ag.get(0);
                        String codigo = ag.get(1);
                        
                        int cont=0;
                        char simbolo;
                        int ascii=0;
                        while(cont<nombre.length()){
                            simbolo=nombre.charAt(cont);
                            ascii=ascii+(int)simbolo;
                            cont++;
                        }
                        cinicio.arbol.inicio=cinicio.arbol.insertar(cinicio.arbol.inicio,ascii,nombre,codigo);
                    }   
                    ag.close();
                } catch (FileNotFoundException ev) {
                    ev.printStackTrace();
                } catch (IOException ev) {
                    ev.printStackTrace();
                }
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
