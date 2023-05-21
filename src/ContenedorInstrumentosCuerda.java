public class ContenedorInstrumentosCuerda {

    instrumentoCuerda[] contenedorInstrumentos;

    int cantidadActual;

    public void agregar(Instrumentos instrumento) {
        contenedorInstrumentos[this.cantidadActual] = (instrumentoCuerda) instrumento;
        this.cantidadActual++;
    }

    public ContenedorInstrumentosCuerda(int cantidadActual) {
        this.contenedorInstrumentos = new instrumentoCuerda[cantidadActual];
        this.cantidadActual = 0;
    }
    public Instrumentos obtenerInstrumento(int pos){
        if(pos < 0 || pos >= this.cantidadActual){
            return null;
        }
        return contenedorInstrumentos[pos];
    }
}

