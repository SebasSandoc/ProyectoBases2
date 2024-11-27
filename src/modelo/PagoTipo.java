/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author SEBASTIAN
 */
public class PagoTipo {
    
    private int pagoTipoid;
    private String nombre;

    public PagoTipo(int pagoTipoid, String nombre) {
        this.pagoTipoid = pagoTipoid;
        this.nombre = nombre;
    }

    public PagoTipo() {
    }

    public int getPagoTipoid() {
        return pagoTipoid;
    }

    public void setPagoTipoid(int pagoTipoid) {
        this.pagoTipoid = pagoTipoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
