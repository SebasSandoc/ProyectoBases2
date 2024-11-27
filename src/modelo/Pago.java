
package modelo;

public class Pago {
    
    private int pagoid;
    private int pagoTipoid;
    private float monto;

    public Pago(int pagoid, int pagoTipoid, float monto) {
        this.pagoid = pagoid;
        this.pagoTipoid = pagoTipoid;
        this.monto = monto;
    }

    public Pago() {
    }

    public int getPagoid() {
        return pagoid;
    }

    public void setPagoid(int pagoid) {
        this.pagoid = pagoid;
    }

    public int getPagoTipoid() {
        return pagoTipoid;
    }

    public void setPagoTipoid(int pagoTipoid) {
        this.pagoTipoid = pagoTipoid;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    
}
