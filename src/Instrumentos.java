public abstract class Instrumentos {

    //Definicion de parametros clase padre
    private String nombreInstrumento;
    private double precio;
    private int stockProducto;
    private String materialDeConstruccion;

    public Instrumentos(double precio, int stockProducto, String nombreInstrumento , String materialDeConstruccion){
        this.nombreInstrumento=nombreInstrumento;
        this.precio=precio;
        this.stockProducto=stockProducto;
        this.materialDeConstruccion=materialDeConstruccion;
    }



    //get´s and set´s
    public String getNombreInstrumento() {
        return nombreInstrumento;
    }

    public void setNombreInstrumento(String nombreInstrumento) {
        this.nombreInstrumento = nombreInstrumento;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto+this.stockProducto;

    }

    public String getMaterialDeConstruccion() {
        return materialDeConstruccion;
    }

    public void setMaterialDeConstruccion(String materialDeConstruccion) {
        this.materialDeConstruccion = materialDeConstruccion;
    }
}
