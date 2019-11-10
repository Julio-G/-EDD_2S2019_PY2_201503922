/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eddproyecto23;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Julio Garcia
 */
public class bita {
    public bnodo inicio;
    public void insertar(String descripcion,String tiempo,String usuario){
        if(inicio==null){
            bnodo nuevo= new bnodo(descripcion,tiempo,usuario,null);
            inicio=nuevo;
        }else{
             bnodo nuevo= new bnodo(descripcion,tiempo,usuario,inicio);
             inicio=nuevo;
        }
    }
    public void graficar(){
        String run="";
        run+="digraph G { \n";
        run+="rankdir=LR \n label=\"Bitacora\" \n node [shape=record,width=.01,height=.2, style=filled,fillcolor=cyan]\n";
        run+="node0 [label = \"";
        if(inicio!=null){
            bnodo aux=inicio;
            while(aux!=null){
                run+= "Usuario: "+aux.usuario+" Descripcion: "+aux.descripcion+" Timestamp: "+ aux.tiempo+"|";
                aux=aux.sig;
            }
            run+="\",height=.5];\n";
            run+="}";
            FileWriter fw = null;
    				PrintWriter pw = null;
        			try{
            			fw = new FileWriter("bita.txt");
            			pw = new PrintWriter(fw);

                                
                                pw.println(run);
                                    	
                                
            			pw.close();
            			fw.close();
            
            			
        			} catch(IOException v){
            			
        			} finally {
                
        			}
                    run="";
                    try {
      
                    String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
                     System.out.println("d");
                    String fileInputPath = "C:\\Users\\Julio Garcia\\Documents\\NetBeansProjects\\EDDproyecto23\\bita.txt";
                    System.out.println("d");
                    String fileOutputPath = "C:\\Users\\Julio Garcia\\Documents\\NetBeansProjects\\EDDproyecto23\\bita.png";
      
                    String tParam = "-Tpng";
                    String tOParam = "-o";
        
                    String[] cmd = new String[5];
                    cmd[0] = dotPath;
                    cmd[1] = tParam;
                    cmd[2] = fileInputPath;
                    cmd[3] = tOParam;
                    cmd[4] = fileOutputPath;
                  
                    Runtime rt = Runtime.getRuntime();
      
                    rt.exec( cmd );
      
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                }
        }
        
    }
}
