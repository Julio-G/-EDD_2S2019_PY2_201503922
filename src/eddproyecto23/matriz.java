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
public class matriz {
    public  mnodo inicio=null;
    public  mnodo ultimox=null;
    public  mnodo ultimoy=null;
    public  int x=1;
    public  int y=1;
    public void insertar(String padre, String carpeta,avl ar){
        if(inicio==null){
            mnodo nuevo1= new mnodo(padre,carpeta,null,null,null,null,x,0,ar);
            mnodo nuevo2= new mnodo(padre,carpeta,null,null,null,null,0,y,ar);
            mnodo nuevo3= new mnodo("inicio","inicio",nuevo1,null,null,nuevo2,0,0,ar);
            mnodo nuevo4= new mnodo(padre,carpeta,null,nuevo2,nuevo1,null,x,y,ar);
            nuevo1.abajo=nuevo4;
            nuevo2.der=nuevo4;
            nuevo1.izq=nuevo3;
            nuevo2.arriba=nuevo3;
            ultimox=nuevo1;
            ultimoy=nuevo2;
            inicio=nuevo3;
            x++;
            y++;
        }else{
            mnodo nuevo1= new mnodo(padre,carpeta,null,ultimox,null,null,x,0,null);
            mnodo nuevo2= new mnodo(padre,carpeta,null,null,ultimoy,null,0,y,null);
            mnodo nuevo3= new mnodo(padre,carpeta,null,null,nuevo1,null,x,0,ar);
            x++;
            y++;
            nuevo1.abajo=nuevo3;
            ultimox.der=nuevo1;
            ultimoy.abajo=nuevo2;
            ultimox=nuevo1;
            ultimoy=nuevo2;
            
            mnodo aux1=encontrar2(padre);
            nuevo3.y=aux1.y;
            while (aux1.der!=null){
                aux1=aux1.der;
            }
            nuevo3.izq=aux1;
            aux1.der=nuevo3;
            
        }
        
    }
    public mnodo encontrar2(String padre){
        mnodo aux=inicio.abajo;
        
        while(aux!=null){
            if(aux.carpeta.equals(padre)){
                return aux;
            }
            aux=aux.abajo;
        }
        return null;
    }
    public void graficar(){
        System.out.println("llego");
        int contx=0;
        int conty=0;
        mnodo aux1= null;
        mnodo aux2= null;
        String contenido="";
        contenido="digraph G {\n";
        contenido += "node[shape=record, style=filled];\n";
        contenido+= "graph[pencolor=transparent]\n";
        contenido += "edge[color=black];\n";
        if(inicio!=null){
            aux1=inicio.der;
            if(aux1!=null){
                contenido+= "MATRIZ[label=\"Matriz\",pos=\"0,0!\"];\n";
                contx++;
                contenido+= "MATRIZ ->ndC"+aux1.carpeta+";\n";
                if(aux1.carpeta.equals("raiz")){
                    contenido += "ndC" + aux1.carpeta + " [label = \"\\\\\",fillcolor = orangered, pos=\""+(aux1.x*1.3)+",0!\"];\n";
                }else{
                    contenido += "ndC" + aux1.carpeta + " [label = \""+aux1.carpeta+"\",fillcolor = orangered, pos=\""+(aux1.x*1.3)+",0!\"];\n";
                }
                contx++;
                while(aux1.der!=null){
                    
                    contenido += "ndC" + aux1.carpeta + "->" + "ndC" +aux1.der.carpeta+"[dir=both];\n";
                    contenido += "ndC" + aux1.der.carpeta + " [label = \"" + aux1.der.carpeta +"\",fillcolor = orangered, pos=\""+(aux1.der.x*1.3)+",0!\"];\n";
                    contx++;
                    aux1 = aux1.der;
                }
                 
            }
            contenido += "\n";
            aux2=inicio.abajo;
            if(aux2!=null){
                
                conty++;
                contenido+= "MATRIZ ->ndF"+aux2.carpeta+";\n";
                if(aux2.carpeta.equals("raiz")){
                    contenido += "ndF" + aux2.carpeta + " [label = \"\\\\\",fillcolor = orangered, pos=\""+0+",-"+aux2.y+"!\"];\n";
                }else{
                    contenido += "ndF" + aux2.carpeta + " [label = \""+aux2.carpeta+"\",fillcolor = orangered, pos=\""+0+",-"+aux2.y+"!\"];\n";
                }
                conty++;
                while(aux2.abajo!=null){
                    
                    contenido += "ndF" + aux2.carpeta + "->" + "ndF" +aux2.abajo.carpeta+"[dir=both];\n";
                    contenido += "ndF" + aux2.abajo.carpeta + " [label = \"" + aux2.abajo.carpeta +"\",fillcolor = orangered, pos=\""+0+",-"+aux2.abajo.y+"!\"];\n";
                    conty++;
                    aux2 = aux2.abajo;
                }
                 
            }
            conty=1;
            contx=1;
            contenido += "\n";
            aux2 = inicio.abajo;
            if(aux2!=null){
                while(aux2!=null){
                    aux1=aux2;
                    if(aux1.der!=null){
                        contenido += "ndF" +aux1.carpeta + "-> nd" +aux1.der.carpeta+"F"+aux1.der.padre+ "[dir=both];\n";
                        if(aux1.der.carpeta.equals("raiz")){
                            contenido += "nd" +aux1.der.carpeta +"F"+aux1.der.padre + "[label = \"\\\\\",fillcolor=gold, pos=\""+(aux1.der.x*1.3)+",-"+aux1.der.y+"!\" ];\n";
                        }else{
                            contenido += "nd" +aux1.der.carpeta +"F"+aux1.der.padre + "[label = \"" +aux1.der.padre+"\\\\"+aux1.der.carpeta + "\",fillcolor=gold, pos=\""+(aux1.der.x*1.3)+",-"+aux1.der.y+"!\" ];\n";
                        }
                        contx++;
                        aux1=aux1.der;
                        while(aux1.der!=null){
                            contenido += "nd" + aux1.carpeta +"F"+aux1.padre + " -> nd" + aux1.der.carpeta+"F"+aux1.der.padre+ "[dir=both];\n";
                            contenido += "nd" +aux1.der.carpeta +"F"+aux1.der.padre + "[label = \"" +aux1.der.padre+"\\\\"+aux1.der.carpeta+ "\",fillcolor=gold,  pos=\""+(aux1.der.x*1.3)+",-"+aux1.der.y+"!\"];\n";
                            contx++;
                            aux1 = aux1.der;
                        }
                    }
                    aux2=aux2.abajo;
                    
                    conty++;
                    contx=conty;
                }
                
            }
            conty=1;
            contx=1;
            aux1=inicio.der;
            if(aux1!=null){
                while(aux1!=null){
                    aux2=aux1;
                    if(aux2.abajo!=null){
                        contenido += "ndC" +aux2.carpeta + "-> nd" +aux2.abajo.carpeta+"F"+aux2.abajo.padre+ "[dir=both];\n";
			//contenido += "nd" +aux2.abajo.carpeta +"F"+aux2.abajo.padre + "[label = \"" +aux2.abajo.padre+"\\"+aux2.abajo.carpeta + "\",fillcolor=gold, pos=\""+contx+",-"+conty+"!\" ];\n";
                        conty++;
                        aux2=aux2.abajo;
                        while(aux2.abajo!=null){
                            contenido += "nd" + aux2.carpeta +"F"+aux2.padre + " -> nd" + aux2.abajo.carpeta+"F"+aux2.abajo.padre+ "[dir=both];\n";
                        //    contenido += "nd" +aux2.abajo.carpeta +"F"+aux2.abajo.padre + "[label = \"" +aux2.abajo.padre+"\\"+aux2.abajo.carpeta+ "\",fillcolor=gold,  pos=\""+contx+",-"+conty+"!\"];\n";
                            conty++;
                            aux2 = aux2.abajo;
                        }
                    }
                    aux1=aux1.der;
                    
                    contx++;
                    conty=contx-1;
                }
            }
            contenido+="\n }";
            
            FileWriter fw = null;
    				PrintWriter pw = null;
        			try{
            			fw = new FileWriter("matriz.txt");
            			pw = new PrintWriter(fw);

                                
                                pw.println(contenido);
                                    	
                                
            			pw.close();
            			fw.close();
            
            			
        			} catch(IOException v){
            			
        			} finally {
                
        			}
    contenido="";
    try {
      
                    String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\neato.exe";
                     System.out.println("d");
                    String fileInputPath = "C:\\Users\\Julio Garcia\\Documents\\NetBeansProjects\\EDDproyecto23\\matriz.txt";
                    System.out.println("d");
                    String fileOutputPath = "C:\\Users\\Julio Garcia\\Documents\\NetBeansProjects\\EDDproyecto23\\matriz.png";
      
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
