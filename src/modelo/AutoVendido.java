
package modelo;

public class AutoVendido {
    
    private int autoVendidoId;
    private int autoid;
    private int ventaid;

    public AutoVendido() {
    }

    public AutoVendido(int autoVendidoId, int autoid, int ventaid) {
        this.autoVendidoId = autoVendidoId;
        this.autoid = autoid;
        this.ventaid = ventaid;
    }

    public int getAutoVendidoId() {
        return autoVendidoId;
    }

    public void setAutoVendidoId(int autoVendidoId) {
        this.autoVendidoId = autoVendidoId;
    }

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public int getVentaid() {
        return ventaid;
    }

    public void setVentaid(int ventaid) {
        this.ventaid = ventaid;
    }
    
    
}
