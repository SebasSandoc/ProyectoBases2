
package modelo;


public class EnvioDetalle {
    
    private int envioDetalleid;
    private int envioid;
    private int autoid;
    private int cantidad;

    public EnvioDetalle(int envioDetalleid, int envioid, int autoid, int cantidad) {
        this.envioDetalleid = envioDetalleid;
        this.envioid = envioid;
        this.autoid = autoid;
        this.cantidad = cantidad;
    }

    public EnvioDetalle() {
    }

    public int getEnvioDetalleid() {
        return envioDetalleid;
    }

    public void setEnvioDetalleid(int envioDetalleid) {
        this.envioDetalleid = envioDetalleid;
    }

    public int getEnvioid() {
        return envioid;
    }

    public void setEnvioid(int envioid) {
        this.envioid = envioid;
    }

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
