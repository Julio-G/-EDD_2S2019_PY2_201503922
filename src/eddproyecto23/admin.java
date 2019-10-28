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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.csvreader.CsvWriter;
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class admin extends JFrame {
    JLabel lbadmin;
    JTextField txtcsv;
    JButton btningresar;
    
    public admin(){
        super("EDD drive");
        //setSize(800,550);
        setBounds(550,200,350,350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        progra();
    }
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public static String toHexString(byte[] hash) 
    { 
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    } 
    public void progra(){
        lbadmin=new JLabel ("Nombre:");
        lbadmin.setBounds(50,85,200,50);
        txtcsv = new JTextField();
        txtcsv.setBounds(120,100,150,20);
        btningresar = new JButton("Ingresar");
	btningresar.setBounds(110,140,100,20);
	btningresar.setBackground(Color.white);
        btningresar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                String hola="";
                try{
                    CsvReader ag = new CsvReader(txtcsv.getText());
                    ag.readHeaders();
                
                    while (ag.readRecord()) {
                     
                        String nombre = ag.get(0);
                        String codigo = ag.get(1);
                        if(codigo.length()<8){
                            System.out.println("La contraseña tiene menos de 8 digitos");
                          
                        }else{
                            int cont=0;
                            char simbolo;
                            int ascii=0;
                            while(cont<nombre.length()){
                                simbolo=nombre.charAt(cont);
                                ascii=ascii+(int)simbolo;
                                cont++;
                            }
                            String sha=toHexString(getSHA(codigo));
                            EDDproyecto23.lol.insertar(ascii,nombre,codigo,sha);
                        }   
                            
                          
                    }
             
                    ag.close();
                    EDDproyecto23.lol.graficar();
                    EDDproyecto23.lol.graficar2();
                } catch (FileNotFoundException ev) {
                    ev.printStackTrace();
                } catch (IOException ev) {
                    ev.printStackTrace();
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(hola);
            }
        });
        add(btningresar);
        add(lbadmin);
        add(txtcsv);
    }
}
