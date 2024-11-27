
package modelo;

public class Sucursal {
    private int sucursalid;
    private int gerenteid;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;

    public Sucursal(int sucursalid, int gerenteid, String nombre, String telefono, String direccion, String email) {
        this.sucursalid = sucursalid;
        this.gerenteid = gerenteid;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public Sucursal() {
    }

    public int getSucursalid() {
        return sucursalid;
    }

    public void setSucursalid(int sucursalid) {
        this.sucursalid = sucursalid;
    }

    public int getGerenteid() {
        return gerenteid;
    }

    public void setGerenteid(int gerenteid) {
        this.gerenteid = gerenteid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
