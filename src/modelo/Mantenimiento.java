/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author SEBASTIAN
 */
public class Mantenimiento {
     private int mantenimientoid;
     private int autoid;
     private int tipoMantenimientoid;
     private Date fecha;
     private String detalles;

    public Mantenimiento(int mantenimientoid, int autoid, int tipoMantenimientoid, Date fecha, String detalles) {
        this.mantenimientoid = mantenimientoid;
        this.autoid = autoid;
        this.tipoMantenimientoid = tipoMantenimientoid;
        this.fecha = fecha;
        this.detalles = detalles;
    }

    public Mantenimiento() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }



    public int getMantenimientoid() {
        return mantenimientoid;
    }

    public void setMantenimientoid(int mantenimientoid) {
        this.mantenimientoid = mantenimientoid;
    }

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public int getTipoMantenimientoid() {
        return tipoMantenimientoid;
    }

    public void setTipoMantenimientoid(int tipoMantenimientoid) {
        this.tipoMantenimientoid = tipoMantenimientoid;
    }
     
     
}
