
package modelo;

public class Categoria {
    private int categoriaid;
    private String nombre;
    private String descripcion;

    public Categoria(int categoriaid, String nombre, String descripcion) {
        this.categoriaid = categoriaid;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(int categoriaid) {
        this.categoriaid = categoriaid;
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
    
    
}
