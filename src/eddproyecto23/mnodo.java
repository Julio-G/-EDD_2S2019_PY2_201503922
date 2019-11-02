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
public class mnodo {
    public mnodo der;
    public mnodo izq;
    public mnodo arriba;
    public mnodo abajo;
    public String carpeta;
    public String padre;
    public int x;
    public int y;
    public avl arbol;
    
    public mnodo(String padre,String carpeta, mnodo der, mnodo izq,mnodo arriba,mnodo abajo,int x, int y, avl arbol){
        this.der=der;
        this.izq=izq;
        this.arriba=arriba;
        this.abajo=abajo;
        this.padre=padre;
        this.carpeta=carpeta;
        this.x=x;
        this.y=y;
        this.arbol=arbol;
    }
}
