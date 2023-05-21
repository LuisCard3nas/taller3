public class ContenedorInstrumentosViento {


    instrumentoViento [] contenedorInstrumentos;

    int cantidadActual;

    public void agregar(Instrumentos instrumento) {
        contenedorInstrumentos[this.cantidadActual] = (instrumentoViento) instrumento;
        this.cantidadActual++;
    }

    public ContenedorInstrumentosViento(int cantidadActual) {
        this.contenedorInstrumentos = new instrumentoViento[cantidadActual];
        this.cantidadActual = 0;
    }
    public Instrumentos obtenerInstrumento(int pos){
        if(pos < 0 || pos >= this.cantidadActual){
            return null;
        }
        return contenedorInstrumentos[pos];
    }
}
