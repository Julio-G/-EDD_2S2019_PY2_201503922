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
public class bnodo{
    public String descripcion;
    public String tiempo;
    public String usuario;
    public bnodo sig;
   
    public bnodo(String descripcion,String tiempo,String usuario, bnodo sig){
        this.descripcion=descripcion;
        this.tiempo=tiempo;
        this.usuario=usuario;
        this.sig=sig;
    }
}
