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
public class anodo {
    public String archivo="",contenido="",tiempo;
    public int eq=1,alt=0,archivo2;
    public anodo der,izq;
    
    public anodo(int archivo2,String archivo,String contenido,anodo der,anodo izq,String tiempo){
        this.archivo2=archivo2;
        this.archivo=archivo;
        this.contenido=contenido;
        this.tiempo=tiempo;
        this.der=der;
        this.izq=izq;
    }
    public anodo(){
        
    }
}
