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
public class nodoh {
    int llave;
    String nombre;
    String contraseña;
    String encrip;
    
    public nodoh(int key, String nombre,String contraseña,String encrip){
        this.llave=key;
        this.nombre=nombre;
        this.contraseña=contraseña;
        this.encrip=encrip;
    }
    public nodoh(){
        
    }
}