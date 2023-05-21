public class instrumentoViento extends Instrumentos {

    private String codigoUnico;
    public instrumentoViento(String codigoUnico, double precio, int stockProducto, String nombreInstrumento,String materialDeConstruccion) {
        super(precio,stockProducto,nombreInstrumento,materialDeConstruccion);
        this.codigoUnico=codigoUnico;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
}
