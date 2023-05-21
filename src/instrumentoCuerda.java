public class instrumentoCuerda extends Instrumentos {

    private String codigoUnico;
    private String tipoDeCuerda;
    private int numeroDeCuerdas;
    private String tipoAcusElec;

    public instrumentoCuerda(String codigoUnico, double precio, int stockProducto, String nombreInstrumento,String tipoDeCuerda,int numeroDeCuerdas, String materialDeContruccion,String tipoAcusElec){

        super(precio,stockProducto,nombreInstrumento,materialDeContruccion);
        this.codigoUnico=codigoUnico;
        this.tipoDeCuerda=tipoDeCuerda;
        this.numeroDeCuerdas=numeroDeCuerdas;
        this.tipoAcusElec=tipoAcusElec;
    }
    public String getTipoDeCuerda() {
        return tipoDeCuerda;
    }

    public void setTipoDeCuerda(String tipoDeCuerda) {
        this.tipoDeCuerda = tipoDeCuerda;
    }

    public int getNumeroDeCuerdas() {
        return numeroDeCuerdas;
    }

    public void setNumeroDeCuerdas(int numeroDeCuerdas) {
        this.numeroDeCuerdas = numeroDeCuerdas;
    }

    public String getTipoAcusElec() {
        return tipoAcusElec;
    }

    public void setTipo(String tipo) {
        this.tipoAcusElec = tipo;
    }


    public void setTipoAcusElec(String tipoAcusElec) {
        this.tipoAcusElec = tipoAcusElec;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
}
