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
import java.io.IOException;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
public class EDDproyecto23 extends JFrame{
    
    JLabel lbbienvenida,lbnombre,lbcontra;
    JTextField Nsesion,Csesion;
    JButton btningresar,btnregistrar;
    public static hash lol= new hash();
    public static matriz rese;
    public static String hnom;
    public static String carp="raiz";
    public static bita reg= new bita();

   public EDDproyecto23(){
        super("EDD drive");
        //setSize(800,550);
        setBounds(550,200,350,420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        progra();
    }
   public void progra(){
        Font fuente1= new Font("Comic Sans MS",0,16);
        Font fuente= new Font("Comic Sans MS",0,26);
        lbbienvenida=new JLabel ("INICIO DE SESION");
	lbbienvenida.setFont(fuente); 
        lbbienvenida.setBounds(35,5,300,50);
        lbnombre=new JLabel ("Nombre:");
        lbnombre.setBounds(50,85,200,50);
        lbcontra=new JLabel ("Password:");
        lbcontra.setBounds(50,135,200,50);
        Nsesion= new JTextField();
        Nsesion.setBounds(120,100,150,20);
        Csesion= new JTextField();
        Csesion.setBounds(120,150,150,20);
        btningresar = new JButton("Ingresar");
	btningresar.setBounds(50,200,100,20);
	btningresar.setBackground(Color.white);
	btningresar.setFont(fuente1);
	btningresar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                if(Nsesion.getText().equals("admin") && Csesion.getText().equals("admin")){
                    admin y= new admin();
                    y.setVisible(true);
                }else{
                    rese= lol.buscar(Nsesion.getText(), Csesion.getText());
                    if(rese!=null){
                        hnom=Nsesion.getText();
                        carp="raiz";
                        usuario nuevo = new usuario();
                        nuevo.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Los datos no coinciden");
                    }
                    
                }
            }
        });
        btnregistrar = new JButton("Registrar");
	btnregistrar.setBounds(170,200,110,20);
	btnregistrar.setBackground(Color.white);
	btnregistrar.setFont(fuente1);
	btnregistrar.addActionListener(new ActionListener()
	{
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });
        add(lbbienvenida);
        add(Nsesion);
        add(Csesion);
        add(lbcontra);
        add(lbnombre);
        add(btnregistrar);
        add(btningresar);
        
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
    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        int cont=0;
        char simbolo;
        int ascii=0;
        String admin="admin";
        while(cont<admin.length()){
            simbolo=admin.charAt(cont);
            ascii=ascii+(int)simbolo;
            cont++;
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        lol.insertar(ascii,"admin","admin",toHexString(getSHA("admin")),null,timestamp.toString());
        EDDproyecto23 j=new EDDproyecto23();
        j.setVisible(true);
        
      /*  matriz jol = new matriz();
        jol.insertar("nada","raiz");
        jol.insertar("raiz","home");
        jol.insertar("home","documents");
        
        jol.insertar("documents","usac");
        jol.insertar("documents","vendor");
        jol.insertar("vendor","view");
        jol.graficar();
        EDDproyecto23 j=new EDDproyecto23();
        j.setVisible(true);*/
      
     /*  avl que= new avl();
       
       que.inicio=que.insertar(que.inicio,201005874,"201005874","contenido2");
       que.inicio=que.insertar(que.inicio,201403525,"201403525","contenido");
       que.inicio=que.insertar(que.inicio,201212963,"201212963","contenido1");
       que.inicio=que.insertar(que.inicio,201602255,"201602255","contenido6");
       que.inicio=que.insertar(que.inicio,201313526,"201313526","contenido3");
       que.inicio=que.insertar(que.inicio,201403819,"201403819","contenido4");
       que.inicio=que.insertar(que.inicio,201403624,"201403624","contenido5");
       
       que.agraficar(que.inicio,"john");
       EDDproyecto23 j=new EDDproyecto23();
       j.setVisible(true);*/
        
    }
    
}
