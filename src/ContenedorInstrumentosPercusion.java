public class ContenedorInstrumentosPercusion {



    instrumentoPercusion [] contenedorInstrumentos;

    int cantidadActual;

    public void agregar(Instrumentos instrumento) {
        contenedorInstrumentos[this.cantidadActual] = (instrumentoPercusion) instrumento;
        this.cantidadActual++;
    }

    public ContenedorInstrumentosPercusion(int cantidadActual) {
        this.contenedorInstrumentos = new instrumentoPercusion[cantidadActual];
        this.cantidadActual = 0;
    }
    public Instrumentos obtenerInstrumento(int pos){
        if(pos < 0 || pos >= this.cantidadActual){
            return null;
        }
        return contenedorInstrumentos[pos];
    }
}
