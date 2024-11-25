
package modelo;

import java.util.Date;

public class Cliente {
    
    private int clienteID;
    private String nomre;
    private String apellido;
    private String genero;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaNacimiento;

    public Cliente(int clienteID, String nomre, String apellido, String genero, String direccion, String telefono, String email, Date fechaNacimiento) {
        this.clienteID = clienteID;
        this.nomre = nomre;
        this.apellido = apellido;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getNomre() {
        return nomre;
    }

    public void setNomre(String nomre) {
        this.nomre = nomre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clienteID=" + clienteID + ", nomre=" + nomre + ", apellido=" + apellido + ", genero=" + genero + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + '}'+"\n";
    }
    
    
}
