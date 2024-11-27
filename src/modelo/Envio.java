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
public class Envio {
    private int envioid;
    private int sucursalid;
    private int proveedorid;
    private Date fechaEnvio;
    private float costo;

    public Envio(int envioid, int sucursalid, int proveedorid, Date fechaEnvio, float costo) {
        this.envioid = envioid;
        this.sucursalid = sucursalid;
        this.proveedorid = proveedorid;
        this.fechaEnvio = fechaEnvio;
        this.costo = costo;
    }

    public Envio() {
    }
    
    

    public int getEnvioid() {
        return envioid;
    }

    public void setEnvioid(int envioid) {
        this.envioid = envioid;
    }

    public int getSucursalid() {
        return sucursalid;
    }

    public void setSucursalid(int sucursalid) {
        this.sucursalid = sucursalid;
    }

    public int getProveedorid() {
        return proveedorid;
    }

    public void setProveedorid(int proveedorid) {
        this.proveedorid = proveedorid;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    
    
}
