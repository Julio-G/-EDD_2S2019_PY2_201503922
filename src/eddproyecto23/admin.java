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
import java.sql.Timestamp;
public class admin extends JFrame {
    JLabel lbadmin,lbbienvenida,lbreporte;
    JTextField txtcsv;
    JButton btningresar,btnreporte;
    
    
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
        Font fuente= new Font("Comic Sans MS",0,26);
        lbbienvenida=new JLabel ("Carga Masiva");
	lbbienvenida.setFont(fuente); 
        lbbienvenida.setBounds(35,5,300,50);
        lbreporte=new JLabel ("Reportes");
	lbreporte.setFont(fuente); 
        lbreporte.setBounds(35,155,300,50);
        lbadmin=new JLabel ("Nombre:");
        lbadmin.setBounds(50,65,200,50);
        txtcsv = new JTextField();
        txtcsv.setBounds(120,80,150,20);
        btningresar = new JButton("Ingresar");
	btningresar.setBounds(110,120,100,20);
	btningresar.setBackground(Color.white);
        btningresar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                String hola="";
                int acont=0;
                try{
                    CsvReader ag = new CsvReader(txtcsv.getText());
                    ag.readHeaders();
                
                    while (ag.readRecord()) {
                     
                        String nombre = ag.get(0);
                        String codigo = ag.get(1);
                        acont++;
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
                            matriz pe = new matriz();
                            avl ra = new avl();
                            pe.insertar("nada","raiz",ra);
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            EDDproyecto23.lol.insertar(ascii,nombre,codigo,sha,pe,timestamp.toString());
                        }   
                            
                          
                    }
             
                    ag.close();
                    Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
                    EDDproyecto23.reg.insertar("Registro "+acont+" usuarios","Fecha: "+timestamp2.toString(),"Usuario: admin");
                    //EDDproyecto23.lol.graficar();
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
        btnreporte = new JButton("Reportes");
	btnreporte.setBounds(110,210,110,30);
	btnreporte.setBackground(Color.white);
        btnreporte.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                reportes kal = new reportes();
                kal.setVisible(true);
            }
        });
        add(btningresar);
        add(lbadmin);
        add(txtcsv);
        add(lbbienvenida);
        add(lbreporte);
        add(btnreporte);
    }
}
