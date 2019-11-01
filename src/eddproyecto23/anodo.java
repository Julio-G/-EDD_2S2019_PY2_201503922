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
    public String archivo,contenido;
    public int eq=1,alt=0;
    public anodo der,izq;
    
    public anodo(String archivo,String contenido,anodo der,anodo izq){
        this.archivo=archivo;
        this.contenido=contenido;
        this.der=der;
        this.izq=izq;
    }
}
