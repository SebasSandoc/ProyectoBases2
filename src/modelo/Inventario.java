
package modelo;

public class Inventario {
    
    private int inventarioid;
    private int autoid;
    private int sucursalid;
    private int cantidad;

    public Inventario(int inventarioid, int autoid, int sucursalid, int cantidad) {
        this.inventarioid = inventarioid;
        this.autoid = autoid;
        this.sucursalid = sucursalid;
        this.cantidad = cantidad;
    }

    public Inventario() {
    }

    public int getInventarioid() {
        return inventarioid;
    }

    public void setInventarioid(int inventarioid) {
        this.inventarioid = inventarioid;
    }

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public int getSucursalid() {
        return sucursalid;
    }

    public void setSucursalid(int sucursalid) {
        this.sucursalid = sucursalid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
