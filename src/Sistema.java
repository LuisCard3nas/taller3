import ucn.StdIn;
import ucn.StdOut;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Sistema {
    /**
     * Metodo que permite al usuario agregar un instrumento al especificar que tipo es (Viento,Percusion,Cuerda)
     * agregandolos respectivos parametros se las clases hijas
     */
    void agregarInstrumento();

    /**
     * ENVIA LA SELECCION DEL MENU DEL USUARIO AL SISTEMA IMPL PARA EJECUTARLO
     */

    void menuPrincipal() throws IOException;

    /**
     * LEE LOS INSTRUMENTOS DESDE EL ARCHIVO CSV PARA ALMACENARLOS EN EL VECTOR DE INSTRUMENTOS
     */
    void cargarInformacion() throws IOException;

    /**
     * Metodo que despliega la informacion alamcenada de los contenedores de cada tipo de isntrumento (Cuerda, viento o percusion)
     * utilizando los "gets" de cada clase
     */
    void consultarInventario();

    /**
     * SUBPROGRAMA UTILIZADO PARA GENERAR BOLETA DE LA VENTA REALIZADA INDICANDO EL INSTRUMENTO COMPRADO Y EL VALOR TOTAL DE LA COMPRA
     * @param nombreInstrumento NOMBRE INSTRUMENTO A VENDER
     * @param valorInstrumento VALOR DEL INSTRUMENTO A COMPRAR
     * @param cantidadInstrumentosComprados CANTIDAD DE INSTRUMENTOS COMPRADOS QUE LUEGO SE MULTIPLICA CON EL VALOR DEL MISMO
     */
    void generarBoleta(String nombreInstrumento, Double valorInstrumento, int cantidadInstrumentosComprados);
}



