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
public class Venta {
    private int ventaid;
    private int autoid;
    private int clienteid;
    private int pagoid;
    private int sucursalid;
    private Date fechaFinal;
    private float precioFinal;
    
    

    public Venta(int ventaid, int autoid, int clienteid, int pagoid, int sucursalid, Date fechaFinal, float precioFinal) {
        this.ventaid = ventaid;
        this.autoid = autoid;
        this.clienteid = clienteid;
        this.pagoid = pagoid;
        this.sucursalid = sucursalid;
        this.fechaFinal = fechaFinal;
        this.precioFinal = precioFinal;
    }

    public Venta() {
    }
    
    

    public int getVentaid() {
        return ventaid;
    }

    public void setVentaid(int ventaid) {
        this.ventaid = ventaid;
    }

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getPagoid() {
        return pagoid;
    }

    public void setPagoid(int pagoid) {
        this.pagoid = pagoid;
    }

    public int getSucursalid() {
        return sucursalid;
    }

    public void setSucursalid(int sucursalid) {
        this.sucursalid = sucursalid;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public float getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = precioFinal;
    }
    
    
}
