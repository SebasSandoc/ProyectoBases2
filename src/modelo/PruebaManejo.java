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
public class PruebaManejo {
    
    private int pruebaid;
    private int clienteid;
    private int empleadoid;
    private int autoid;
    private Date fecha;
    private String resultado;

    public PruebaManejo(int pruebaid, int clienteid, int empleadoid, int autoid, Date fecha, String resultado) {
        this.pruebaid = pruebaid;
        this.clienteid = clienteid;
        this.empleadoid = empleadoid;
        this.autoid = autoid;
        this.fecha = fecha;
        this.resultado = resultado;
    }

    public PruebaManejo() {
    }

    public int getPruebaid() {
        return pruebaid;
    }

    public void setPruebaid(int pruebaid) {
        this.pruebaid = pruebaid;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(int empleadoid) {
        this.empleadoid = empleadoid;
    }

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
}
