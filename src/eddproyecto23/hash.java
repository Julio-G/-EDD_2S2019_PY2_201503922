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
public class hash {
  int [] valsrehash;
  int porehash;
  nodoh [] vectorh;
  float porcentaje;
  int valrehash;
  int llenos;
  float pactual;
  int iteracion;
  String run="";
  public hash(){
      this.valsrehash= new int [] { 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53};
      porehash=0;
      valrehash=valsrehash[porehash];
      porcentaje=75.0f;
      llenos=0;
      pactual=calcularpactual();
      iteracion=0;
      vectorh=new nodoh[valrehash];
      
  }
  public float calcularpactual(){
      return (llenos*100)/valrehash;
  }
  public int funcionh(int k){
      return k % valrehash;
  }
  public int funcionreh(int k,int i){
      return k+(int)Math.pow(i,2);
  }
  public void rehash(){
      nodoh [] aux= new nodoh [valrehash];
      for(int i=0;i<vectorh.length;i++){
          aux[i]=vectorh[i];
      }
      porehash++;
      valrehash=valsrehash[porehash];
      vectorh=new nodoh[valrehash];
      for(int i=0;i<aux.length;i++){
          vectorh[i]=aux[i];
      }
      graficar();
  }
  public void insertar(int k, String val,String val2,String val3,matriz matrix,String tiempo){
      int f= funcionh(k);
      System.out.println(k+","+f+","+val);
      if(vectorh[f]==null){
          vectorh[f]= new nodoh(k,val,val2,val3,matrix,tiempo);
          llenos+=1;
          pactual=calcularpactual();
          if(pactual>=porcentaje){
              rehash();
          }
      }else{
          
          if(existe(f,val)==1){
            iteracion++;
            if(funcionreh(k,iteracion)==f){
                rehash();
            }
            if(iteracion>=vectorh.length){
                rehash();
            }
            insertar(funcionreh(k,iteracion), val,val2,val3,matrix,tiempo);
            iteracion=0;
          }else{
              System.out.println("El usuario "+val+" ya existe");
          }
      }
  }
  public int existe(int f,String val){
      for(int i=0;i<vectorh.length;i++){
          if(vectorh[i]!=null){
              if(vectorh[i].nombre.equals(val)){
                  return 0;
              }
          }else{
              
          }
      }
      return 1;
  }
  public void graficar(){
       System.out.println("----------------------------");
      for(int i=0;i<vectorh.length;i++){
          if(vectorh[i]!=null){
              System.out.println(vectorh[i].llave+","+vectorh[i].nombre+","+vectorh[i].contraseña);
          }else{
              System.out.println(0);
          }
         
      }
      System.out.println("----------------------------");
  }
  public matriz buscar(String nombre,String contraseña){
      for(int i=0;i<vectorh.length;i++){
          if(vectorh[i]!=null){
              if(vectorh[i].nombre.equals(nombre)&&vectorh[i].contraseña.equals(contraseña)){
                  return vectorh[i].matrix;
              }
             
          }
         
      }
      return null;
  }
  public void graficar2(){
      int cont=0;
      run+="digraph G { \n";
      run+="rankdir=LR \n label=\"Tabla hash\" \n node [shape=record,width=.01,height=.2, style=filled,fillcolor=cyan]\n";
      run+="node0 [label = \"";
       for(int i=0;i<vectorh.length;i++){
          if(vectorh[i]!=null){
             run+=cont+")       Nombre: "+vectorh[i].nombre+"  Contraseña:"+vectorh[i].contraseña+"  Encriptada: "+vectorh[i].encrip+"  Timestamp: "+vectorh[i].tiempo+"|";
          }else{
              run+=cont+") -----|";
              
          }
          cont++;
         
      }
      run+="\",height=.5];\n";
      run+="}";
      FileWriter fw = null;
    				PrintWriter pw = null;
        			try{
            			fw = new FileWriter("hash.txt");
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
                    String fileInputPath = "C:\\Users\\Julio Garcia\\Documents\\NetBeansProjects\\EDDproyecto23\\hash.txt";
                    System.out.println("d");
                    String fileOutputPath = "C:\\Users\\Julio Garcia\\Documents\\NetBeansProjects\\EDDproyecto23\\hash.png";
      
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
