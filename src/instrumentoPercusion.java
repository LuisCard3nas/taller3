public class instrumentoPercusion extends Instrumentos {
    private String tipoDePercucion;
    private String altura;

    private String codigoUnico;

    public instrumentoPercusion(String codigoUnico, double precio, int stockProducto, String nombreInstrumento,String tipoDePercucion, String materialDeConstruccion, String altura) {
        super(precio,stockProducto,nombreInstrumento,materialDeConstruccion);
        this.tipoDePercucion=tipoDePercucion;
        this.altura=altura;
        this.codigoUnico=codigoUnico;
    }

    public String getTipoDePercucion() {
        return tipoDePercucion;
    }

    public void setTipoDePercucion(String tipoDePercucion) {
        this.tipoDePercucion = tipoDePercucion;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
}
