
package modelo;

public class AutoCategoria {
    
    private int autoCategoriaid;
    private int autoid;
    private int categoriaid;

    public AutoCategoria(int autoCategoriaid, int autoid, int categoriaid) {
        this.autoCategoriaid = autoCategoriaid;
        this.autoid = autoid;
        this.categoriaid = categoriaid;
    }

    public AutoCategoria() {
    }

    public int getAutoCategoriaid() {
        return autoCategoriaid;
    }

    public void setAutoCategoriaid(int autoCategoriaid) {
        this.autoCategoriaid = autoCategoriaid;
    }

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public int getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(int categoriaid) {
        this.categoriaid = categoriaid;
    }
    
    
}
