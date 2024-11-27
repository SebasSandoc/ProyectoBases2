/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author SEBASTIAN
 */
public class VentaServicio {
    private int ventaServicioid;
    private int ventaid;
    private int servicioid;

    public VentaServicio(int ventaServicioid, int ventaid, int servicioid) {
        this.ventaServicioid = ventaServicioid;
        this.ventaid = ventaid;
        this.servicioid = servicioid;
    }

    public VentaServicio() {
    }

    public int getVentaServicioid() {
        return ventaServicioid;
    }

    public void setVentaServicioid(int ventaServicioid) {
        this.ventaServicioid = ventaServicioid;
    }

    public int getVentaid() {
        return ventaid;
    }

    public void setVentaid(int ventaid) {
        this.ventaid = ventaid;
    }

    public int getServicioid() {
        return servicioid;
    }

    public void setServicioid(int servicioid) {
        this.servicioid = servicioid;
    }
    
    
}
