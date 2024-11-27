
package modelo;

public class TipoMantenimiento {
    
    
    private int tipoMantenimientoid;
    private String nombre;
    private String descripcion;
    private float precio;

    public TipoMantenimiento(int tipoMantenimientoid, String nombre, String descripcion, float precio) {
        this.tipoMantenimientoid = tipoMantenimientoid;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public TipoMantenimiento() {
    }

    public int getTipoMantenimientoid() {
        return tipoMantenimientoid;
    }

    public void setTipoMantenimientoid(int tipoMantenimientoid) {
        this.tipoMantenimientoid = tipoMantenimientoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
