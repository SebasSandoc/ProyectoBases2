
package modelo;

public class Auto {
    
    private int autoid;
    private String fabricante;
    private String modelo;
    private int anio;
    private String color;
    private float km;

    public Auto(int autoid, String fabricante, String modelo, int anio, String color, float km) {
        this.autoid = autoid;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.km = km;
    }

    public Auto() {
    }

    public int getAutoid() {
        return autoid;
    }

    public void setAutoid(int autoid) {
        this.autoid = autoid;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }
    
    
}
