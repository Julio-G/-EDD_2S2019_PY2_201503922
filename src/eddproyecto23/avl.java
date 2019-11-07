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
public class avl {
    public anodo inicio=null;
    public String run="";
    public anodo insertar(anodo raiz,int archivo2,String archivo,String contenido,String tiempo){
        if(raiz==null){ 
            
            anodo nuevo=new anodo(archivo2,archivo,contenido,null,null,tiempo);
            return nuevo;
        }
        else{
            if(archivo2 > raiz.archivo2){
               raiz.der=insertar(raiz.der,archivo2,archivo,contenido,tiempo);
            }else if(archivo2 < raiz.archivo2){
                 raiz.izq = insertar(raiz.izq,archivo2,archivo,contenido,tiempo);
            }else{
                System.out.println("El elemento ya existe");
            }
            raiz.eq = maximo(equilibrio(raiz.izq),equilibrio(raiz.der)) + 1;

            int fe = diferencia(raiz);
            raiz.alt=fe;

            int pos=1;
            int neg=-1;
            if (fe < neg && raiz.der.archivo2 <archivo2){ 
                return izqrot(raiz);

            }else if (fe > pos && raiz.izq.archivo2 > archivo2){ 
                return derrot(raiz); 
  
            }else if (fe > pos && raiz.izq.archivo2 < archivo2){ 
                raiz.izq = izqrot(raiz.izq); 
                return derrot(raiz); 
  
            }else if (fe < neg && raiz.der.archivo2 > archivo2){ 
                raiz.der = derrot(raiz.der); 
                return izqrot(raiz);
            }
            return raiz; 
        }
        
    }
    public anodo derrot(anodo raiz){
  
        anodo raiz2 = raiz.izq ;
        anodo temporal2 = raiz2.der;
  
        raiz2.der = raiz; 
        raiz.izq = temporal2; 
        int pos2=1;
        raiz.eq = maximo(equilibrio(raiz.izq),equilibrio(raiz.der)) +pos2;
        raiz2.eq =maximo(equilibrio(raiz2.izq),equilibrio(raiz2.der)) +pos2;
  
        return raiz2;
    }
    public anodo izqrot(anodo raiz){
  
        anodo raiz2 = raiz.der; 
        anodo temporal = raiz2.izq; 
  
        raiz2.izq = raiz;
        raiz.der = temporal;
        int pos3=1;
        raiz.eq = maximo(equilibrio(raiz.izq),equilibrio(raiz.der)) +pos3;
        raiz2.eq = maximo(equilibrio(raiz2.izq),equilibrio(raiz2.der)) + pos3;
  
        return raiz2;
    }
    public int equilibrio(anodo no){
        if (no !=null){
            return no.eq;
        }else{
            return 0;
        }
    }
    public int maximo(int x, int y){
        if(y<x){
            return x;
        }else{
            return y;
        }
    }
    public int diferencia(anodo no){
        if (no !=null){
            return equilibrio(no.izq) - equilibrio(no.der);
        }else{
            return 0;
        }

    }
    public void agraficar(String prop){
        run="digraph G {  node [shape=record, color=blue]\n";
        graficar(inicio,prop);
        run=run+"}";
        FileWriter fw = null;
    				PrintWriter pw = null;
        			try{
            			fw = new FileWriter("avl.txt");
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
                    String fileInputPath = "C:\\Users\\Julio Garcia\\Documents\\NetBeansProjects\\EDDproyecto23\\avl.txt";
                    System.out.println("d");
                    String fileOutputPath = "C:\\Users\\Julio Garcia\\Documents\\NetBeansProjects\\EDDproyecto23\\avl.png";
      
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
    public void graficar(anodo avl,String prop){
    
        if (avl.der==null && avl.izq==null){

            run=run+" node"+avl.archivo.replace(".","")+avl.archivo2+" [style=filled fillcolor=blue  label=\"Nombre: "+avl.archivo +"\\n contenido:"+avl.contenido+"\\n Altura: "+(avl.eq-1)+"\\n FE : "+avl.alt+"\\n Propietario: "+prop+"\\n Timestamp: "+avl.tiempo+"\"]\n";
    
        }else{
            if (avl.izq!=null){

                run=run+" node"+avl.archivo.replace(".","")+avl.archivo2+" [fillcolor=blue label=\"<C0>|Nombre:"+avl.archivo+"\\n contenido:"+avl.contenido+"\\n Altura: "+(avl.eq-1)+"\\n FE : "+(avl.alt)+"\\n Propietario: "+prop+"\\n Timestamp: "+avl.tiempo+"|<C1>\"] node"+avl.archivo.replace(".","")+avl.archivo2+":C0->node"+avl.izq.archivo.replace(".","")+avl.izq.archivo2+":C1\n";
                graficar(avl.izq,prop);
            }
            if (avl.der!=null){
                run=run+" node"+avl.archivo.replace(".","")+avl.archivo2+" [fillcolor=blue label=\"<C0>|Nombre:"+avl.archivo+"\\n contenido:"+avl.contenido+"\\n Altura: "+(avl.eq-1)+"\\n FE : "+(avl.alt)+"\\n Propietario: "+prop+"\\n Timestamp: "+avl.tiempo+"|<C1>\"] node"+avl.archivo.replace(".","")+avl.archivo2+":C1->node"+avl.der.archivo.replace(".","")+avl.der.archivo2+":C0\n";
                graficar(avl.der,prop);
            }
        }
    }
}
