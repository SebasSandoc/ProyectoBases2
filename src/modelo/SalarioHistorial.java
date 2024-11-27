
package modelo;

import java.sql.Date;

public class SalarioHistorial {
    
    private int salarioHistorialid;
    private int empleadoid;
    private Date fechaModificacion;
    private float salarioAnt;
    private float salarioNew;

    public SalarioHistorial(int salarioHistorialid, int empleadoid, Date fechaModificacion, float salarioAnt, float salarioNew) {
        this.salarioHistorialid = salarioHistorialid;
        this.empleadoid = empleadoid;
        this.fechaModificacion = fechaModificacion;
        this.salarioAnt = salarioAnt;
        this.salarioNew = salarioNew;
    }

    public SalarioHistorial() {
    }

    public int getSalarioHistorialid() {
        return salarioHistorialid;
    }

    public void setSalarioHistorialid(int salarioHistorialid) {
        this.salarioHistorialid = salarioHistorialid;
    }

    public int getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(int empleadoid) {
        this.empleadoid = empleadoid;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public float getSalarioAnt() {
        return salarioAnt;
    }

    public void setSalarioAnt(float salarioAnt) {
        this.salarioAnt = salarioAnt;
    }

    public float getSalarioNew() {
        return salarioNew;
    }

    public void setSalarioNew(float salarioNew) {
        this.salarioNew = salarioNew;
    }
    
    
}
