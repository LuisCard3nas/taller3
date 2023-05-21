
import ucn.StdIn;
import ucn.StdOut;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;


public class SistemaIMPL implements Sistema {
    private static ContenedorInstrumentosCuerda Instrumentos1;
    private static ContenedorInstrumentosViento Instrumentos2;
    private static ContenedorInstrumentosPercusion Instrumentos3;
    private BufferedReader BufferedReader;


    public SistemaIMPL() throws IOException {

        this.Instrumentos1 = new ContenedorInstrumentosCuerda(999);
        this.Instrumentos2 = new ContenedorInstrumentosViento(999);
        this.Instrumentos3 = new ContenedorInstrumentosPercusion(999);
        cargarInformacion();

    }

    @Override
    public void menuPrincipal() throws IOException {

        String opcion = null;
        while (!Objects.equals(opcion, "4")) {
            StdOut.println("Bienvenido");
            StdOut.println("Escoja una opcion: ");
            StdOut.println("(1) Agregar Instrumento");
            StdOut.println("(2) Vender Instrumento");
            StdOut.println("(3) Consultar Inventaro De Instrumento");
            StdOut.println("(4) Salir del Sistema ");
            StdOut.print("Menu a elegir: ");

            opcion = StdIn.readLine();

            switch (opcion) {
                case "1" -> agregarInstrumento();
                case "2" -> venderInstrumento();
                case "3" -> consultarInventario();
                case "4" -> actualizarDato();
                default -> StdOut.println("Opcion no valida, intente nuevamente");
            }
        }
    }

   // Definimos el separador que existe en nuestro archivo .csv
    public final String Separador = ",";

    public void cargarInformacion() throws IOException {
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("csv_prueba.csv"));

            String linea = bufferedReader.readLine();

            while (linea != null) {
                String[] instrumento = linea.split(Separador);
                String codigoUnico = instrumento[0];
                //verificamos que el nombre del instrumento sea parte de alguno de las listas y lo guardamos en la misma.
                if (instrumento[3].equalsIgnoreCase("guitarra") || instrumento[3].equalsIgnoreCase("bajo")||
                instrumento[3].equalsIgnoreCase("arpa")|| instrumento[3].equalsIgnoreCase("violin")){

                    //lectura de la linea extraida del .csv
                    String precio = instrumento[1];
                    String stock = instrumento[2];
                    String nombreInstrumento = instrumento[3];
                    String tipoCuerda = instrumento[4];
                    String cantidadCuerda = instrumento[5];
                    String tipoMaterial = instrumento[6];
                    String tipoAcusElec = instrumento[7];

                    Instrumentos instrumentoCuerdaLeido = new instrumentoCuerda(codigoUnico,Integer.parseInt(precio),Integer.parseInt(stock),nombreInstrumento,tipoCuerda,Integer.parseInt(cantidadCuerda),tipoMaterial,tipoAcusElec);
                    Instrumentos1.agregar(instrumentoCuerdaLeido);
                }
                if (instrumento[3].equalsIgnoreCase("bongo") || instrumento[3].equalsIgnoreCase("cajon")||
                        instrumento[3].equalsIgnoreCase("campanas tubulares")|| instrumento[3].equalsIgnoreCase("bombo")){
                    String precio = instrumento[1];
                    String stock = instrumento[2];
                    String nombreInstrumento = instrumento[3];
                    String tipoPercusion = instrumento[4];
                    String tipoMaterial = instrumento[5];
                    String altura = instrumento[6];

                    Instrumentos instrumentoPercusionLeido = new instrumentoPercusion(codigoUnico,Integer.parseInt(precio),Integer.parseInt(stock),nombreInstrumento,tipoPercusion,tipoMaterial,altura);
                    Instrumentos3.agregar(instrumentoPercusionLeido);

                }
                if (instrumento[3].equalsIgnoreCase("trompeta") || instrumento[3].equalsIgnoreCase("saxofon")||
                        instrumento[3].equalsIgnoreCase("clarinete")|| instrumento[3].equalsIgnoreCase("flauta traversa")){
                    String precio = instrumento[1];
                    String stock = instrumento[2];
                    String nombreInstrumento = instrumento[3];
                    String tipoMaterial = instrumento[4];

                    Instrumentos instrumentoVientoLeido = new instrumentoViento(codigoUnico,Integer.parseInt(precio),Integer.parseInt(stock),nombreInstrumento,tipoMaterial);
                    Instrumentos2.agregar(instrumentoVientoLeido);
                }
                linea = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void agregarInstrumento() {

        //Pregunta el tipo de instrumeno.
        String tipo = "";
        int condicion = 0;

        while (condicion == 0){
            StdOut.println("Especifique si el instrumento agregar es de viento, percusion o cuerda");
            tipo = StdIn.readLine();

            if (tipo.equalsIgnoreCase("Cuerda") || tipo.equalsIgnoreCase("Viento") || tipo.equalsIgnoreCase("Percusion")){
                condicion++;

            }
        }

        //Busca el tipo de instrumento a agregar, para comenzar a preguntar parametros
        if (tipo.equalsIgnoreCase("cuerda")) {
            //Construccion del nuevo instrumento a agregar segun los parametros
            StdOut.println("Ingrese el codigo unico del instrumento");
            String codigoUnico = StdIn.readLine();
            StdOut.println("Ingrese el nombre del instrumento (Guitarra, Bajo, Violin o Arpa)");
            String nombreInstrumento = StdIn.readLine();
            StdOut.println("Ingrese el tipo de material (Madera o  Metal)");
            String tipoMaterial = StdIn.readLine();
            StdOut.println("Ingrese el precio");
            Double precio = StdIn.readDouble();
            StdOut.println("Ingrese el stock");
            int stock = StdIn.readInt();
            StdOut.println("Ingrese tipo de cuerda (Nylon, Acero o Tripa)");
            String tipoCuerda = StdIn.readLine();
            StdOut.println("Ingrese numero de cuerdas");
            int numeroCuerdas = StdIn.readInt();
            StdOut.println("Ingrese el tipo (Acustico o Electrico)");
            String tipoAcusElec = StdIn.readLine();
            Instrumentos instrumentoCuerdaNuevo = new instrumentoCuerda(codigoUnico, precio,stock,nombreInstrumento,tipoCuerda,numeroCuerdas,tipoMaterial,tipoAcusElec);
            //Agregamos el nuevo instrumento a la lista correspondiente
            this.Instrumentos1.agregar(instrumentoCuerdaNuevo);


        }
        if (tipo.equalsIgnoreCase("viento")) {
            //Construccion del nuevo instrumento a agregar segun los parametros
            StdOut.println("Ingrese el codigo unico del instrumento");
            String codigoUnico = StdIn.readLine();
            StdOut.println("Ingrese el nombre del instrumento (Trompeta, Saxofon, Clarinete o Flauta traversa)");
            String nombreInstrumento = StdIn.readLine();
            StdOut.println("Ingrese el tipo de material (Madera o Metal)");
            String tipoMaterial = StdIn.readLine();
            StdOut.println("Ingrese el valor del producto");
            double valorInstrumento = StdIn.readDouble();
            StdOut.println("Ingrese el stock de producto");
            int stockProducto = StdIn.readInt();
            Instrumentos instrumentoVientoNuevo = new instrumentoViento(codigoUnico,valorInstrumento,stockProducto,nombreInstrumento,tipoMaterial);
            //Agregamos el nuevo instrumento a la lista correspondiente
            this.Instrumentos2.agregar(instrumentoVientoNuevo);

        }
        if (tipo.equalsIgnoreCase("percusion")) {
            //Construccion del nuevo instrumento a agregar segun los parametros
            StdOut.println("Ingrese el codigo unico del instrumento");
            String codigoUnico = StdIn.readLine();
            StdOut.println("Ingrese el nombre del instrumento (Bongo, Cajon, Campanas Tubulares o Bombo)");
            String nombreInstrumento = StdIn.readLine();
            StdOut.println("Ingrese el tipo de material");
            String tipoMaterial = StdIn.readLine();
            StdOut.println("Ingrese el valor del producto");
            double valorInstrumento = StdIn.readDouble();
            StdOut.println("Ingrese el stock de producto");
            int stockProducto = StdIn.readInt();
            StdOut.println("Ingrese el tipo de percusion (Membranofono o Idiofono)");
            String tipoPercusion = StdIn.readLine();
            StdOut.println("ingrese altura del Instrumento");
            String altura = StdIn.readLine();
            Instrumentos instrumentosPercusionNuevo = new instrumentoPercusion(codigoUnico,valorInstrumento,stockProducto,nombreInstrumento,tipoPercusion,tipoMaterial,altura);
            //Agregamos el nuevo instrumento a la lista correspondiente
            this.Instrumentos3.agregar(instrumentosPercusionNuevo);
        }


    }

    public void consultarInventario() {

        StdOut.println("/// INSTRUMENTOS DE TIPO CUERDA ///");
        //Buscar y desplega la informacion de cada contenedor (cuerda, viento o percusion) segun su tamaño.
        for (int i = 0; i < Instrumentos1.cantidadActual; i++) {
            instrumentoCuerda instrumentoAux = (instrumentoCuerda) Instrumentos1.obtenerInstrumento(i);
            StdOut.println((i + 1) + ") ----------------------------------------");
            StdOut.println("Nombre: " + instrumentoAux.getNombreInstrumento());
            StdOut.println("Codigo unico: " + instrumentoAux.getCodigoUnico());
            StdOut.println("Precio: " + instrumentoAux.getPrecio());
            StdOut.println("Stock disponible: " + instrumentoAux.getStockProducto());
            StdOut.println("Numero de cuerdas: " + instrumentoAux.getNumeroDeCuerdas());
            StdOut.println("Material de construccion: "+ instrumentoAux.getMaterialDeConstruccion());
            StdOut.println("Tipo de cuerda: " + instrumentoAux.getTipoDeCuerda());
            StdOut.println("Tipo de guitarra: " + instrumentoAux.getTipoAcusElec());


        }
        StdOut.println("/// INSTRUMENTOS DE TIPO VIENTO ///");
        //Buscar y desplega la informacion de cada contenedor (cuerda, viento o percusion) segun su tamaño.
        for (int i = 0; i < Instrumentos2.cantidadActual; i++) {
            instrumentoViento instrumentoAux = (instrumentoViento) Instrumentos2.obtenerInstrumento(i);
            StdOut.println((i + 1) + ") ----------------------------------------");
            StdOut.println("Nombre: " + instrumentoAux.getNombreInstrumento());
            StdOut.println("Codigo unico: " + instrumentoAux.getCodigoUnico());
            StdOut.println("Material de construccion: "+ instrumentoAux.getMaterialDeConstruccion());
            StdOut.println("Precio: " + instrumentoAux.getPrecio());
            StdOut.println("Stock disponible: " + instrumentoAux.getStockProducto());


        }
        StdOut.println("/// INSTRUMENTOS DE TIPO PERCUCION ///");
        //Buscar y desplega la informacion de cada contenedor (cuerda, viento o percusion) segun su tamaño.
        for (int i = 0; i < Instrumentos3.cantidadActual; i++) {
            instrumentoPercusion instrumentoAux = (instrumentoPercusion) Instrumentos3.obtenerInstrumento(i);
            StdOut.println((i + 1) + ") ----------------------------------------");
            StdOut.println("Nombre: " + instrumentoAux.getNombreInstrumento());
            StdOut.println("Codigo unico: " + instrumentoAux.getCodigoUnico());
            StdOut.println("Precio: " + instrumentoAux.getPrecio());
            StdOut.println("Material de construccion: "+ instrumentoAux.getMaterialDeConstruccion());
            StdOut.println("Stock disponible: " + instrumentoAux.getStockProducto());
            StdOut.println("Tipo de percusion: " + instrumentoAux.getTipoDePercucion());
            StdOut.println("Altura: " + instrumentoAux.getAltura());
        }
    }

    public void venderInstrumento() {

        //Pregunta el tipo de intrumento a buscar.
        StdOut.println("Ingrese el tipo de instrumento a comprar: ");
        String tipo = StdIn.readLine();
        //Boolean creado para que en caso de no encontrar el codigo dentro del ciclo, retorne al menu principal.
        boolean encontrado = true;
        //Guarda la informacion y empieza a buscar que instrumento se vendera y una vez dentro busca el codigo del intrumento especificado.
        if (tipo.equalsIgnoreCase("cuerda")){
            StdOut.println("Ingrese el codigo del instrumento: ");
            String codigo = StdIn.readLine();
            for (int i = 0; i < Instrumentos1.cantidadActual; i++) {
                instrumentoCuerda instrumentoAux = (instrumentoCuerda) Instrumentos1.obtenerInstrumento(i);
                if (instrumentoAux.getCodigoUnico().equalsIgnoreCase(codigo)) {
                    encontrado = false;
                    if (instrumentoAux.getStockProducto() != 0) {
                        StdOut.println("Intrumento disponible, hay: " + instrumentoAux.getStockProducto() + " ¿Cuanto desea comprar?");
                        int cantidadComprar = StdIn.readInt();
                        if (instrumentoAux.getStockProducto() >= cantidadComprar) {
                            cantidadComprar = cantidadComprar * -1;
                            instrumentoAux.setStockProducto(cantidadComprar);
                            generarBoleta(instrumentoAux.getNombreInstrumento(),instrumentoAux.getPrecio(),cantidadComprar);
                        } else {
                            StdOut.println("El numero de productos a comprar sobrepasa el stock actual");
                            break;
                        }
                    } else {
                        StdOut.println("No hay stock disponible ;(");
                        break;
                    }
                } else if(encontrado=false) {
                    StdOut.println("El codigo ingresado no se encuentra registrado.");
                    break;
                }
            }
        }
        if (tipo.equalsIgnoreCase("Viento")){
            StdOut.println("Ingrese el codigo del instrumento: ");
            String codigo = StdIn.readLine();

            for (int i = 0; i < Instrumentos2.cantidadActual; i++) {
                instrumentoViento instrumentoAux = (instrumentoViento) Instrumentos2.obtenerInstrumento(i);
                if (instrumentoAux.getCodigoUnico().equalsIgnoreCase(codigo)) {
                    encontrado=false;

                    if (instrumentoAux.getStockProducto() != 0) {
                        StdOut.println("Intrumento disponible, hay: " + instrumentoAux.getStockProducto() + " ¿Cuanto desea comprar?");
                        int cantidadComprar = StdIn.readInt();
                        if (instrumentoAux.getStockProducto() >= cantidadComprar) {
                            cantidadComprar = cantidadComprar * -1;
                            instrumentoAux.setStockProducto(cantidadComprar);
                            generarBoleta(instrumentoAux.getNombreInstrumento(),instrumentoAux.getPrecio(),cantidadComprar);
                        } else {
                            StdOut.println("El numero de productos a comprar sobrepasa el stock actual");
                            break;
                        }
                    } else {
                        StdOut.println("No hay stock disponible ;(");
                        break;
                    }
                } else if(encontrado=false) {
                    StdOut.println("El codigo ingresado no se encuentra registrado.");
                    break;
                }
            }
        }
        if (tipo.equalsIgnoreCase("Percusion")){
            StdOut.println("Ingrese el codigo del instrumento: ");
            String codigo = StdIn.readLine();
            for (int i = 0; i < Instrumentos3.cantidadActual; i++) {
                instrumentoPercusion instrumentoAux = (instrumentoPercusion) Instrumentos3.obtenerInstrumento(i);
                if (instrumentoAux.getCodigoUnico().equalsIgnoreCase(codigo)) {
                    encontrado=false;
                    if (instrumentoAux.getStockProducto() != 0) {
                        StdOut.println("Intrumento disponible, hay: " + instrumentoAux.getStockProducto() + " ¿Cuanto desea comprar?");
                        int cantidadComprar = StdIn.readInt();
                        if (instrumentoAux.getStockProducto() >= cantidadComprar) {
                            cantidadComprar = cantidadComprar * -1;
                            instrumentoAux.setStockProducto(cantidadComprar);
                            generarBoleta(instrumentoAux.getNombreInstrumento(),instrumentoAux.getPrecio(),cantidadComprar);
                        } else {
                            StdOut.println("El numero de productos a comprar sobrepasa el stock actual");
                            break;
                        }
                    } else {

                        StdOut.println("No hay stock disponible ;(");
                        break;
                    }
                } else if(encontrado=false) {
                    StdOut.println("El codigo ingresado no se encuentra registrado.");
                    break;
                }
            }
        }
    }
    @Override
    public void generarBoleta(String nombreInstrumento, Double valorInstrumento, int cantidadInstrumentosComprados){

        //Generacion de boleta con varios "StdOut" para simular una boleta en la consola
        StdOut.println("-------------------------------");
        StdOut.println("------  BOLETA COMPRA  --------");
        StdOut.println("----  Instrumento comprado  ---");
        StdOut.println("           "+nombreInstrumento);
        StdOut.println("-----     Valor Total     -----");
        StdOut.println("            "+"$"+valorInstrumento*cantidadInstrumentosComprados*-1);
        StdOut.println("-------------------------------");

    }

    public void actualizarDato() throws IOException {
        StdOut.println("d");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("csv_prueba.csv"));

            // Sobrescribir la informacion en el archivo CSV
            for (int i = 0; i < Instrumentos1.cantidadActual; i++) {
                //asigno el instrumento a desplegar
                instrumentoCuerda instrumentoAux = (instrumentoCuerda) Instrumentos1.obtenerInstrumento(i);
                String codigoUnico = instrumentoAux.getCodigoUnico();
                double precio = instrumentoAux.getPrecio();
                int stock = instrumentoAux.getStockProducto();
                String nombreInstrumento = instrumentoAux.getNombreInstrumento();
                String tipoCuerda = instrumentoAux.getTipoDeCuerda();
                int numeroCuerda = instrumentoAux.getNumeroDeCuerdas();
                String tipoMaterial = instrumentoAux.getMaterialDeConstruccion();
                String tipoAcusElec = instrumentoAux.getTipoAcusElec();

                writer.write(codigoUnico);
                writer.write(",");
                writer.write(String.valueOf(precio));
                writer.write(",");
                writer.write(String.valueOf(stock));
                writer.write(",");
                writer.write(nombreInstrumento);
                writer.write(",");
                writer.write(tipoCuerda);
                writer.write(",");
                writer.write(String.valueOf(numeroCuerda));
                writer.write(",");
                writer.write(tipoMaterial);
                writer.write(",");
                writer.write(tipoAcusElec);
                writer.newLine();
            }

            for (int i = 0; i < Instrumentos3.cantidadActual; i++) {
                //asigno el instrumento a desplegar
                instrumentoPercusion instrumentoAux = (instrumentoPercusion) Instrumentos3.obtenerInstrumento(i);
                String codigoUnico = instrumentoAux.getCodigoUnico();
                double precio = instrumentoAux.getPrecio();
                int stock = instrumentoAux.getStockProducto();
                String nombreInstrumento = instrumentoAux.getNombreInstrumento();;
                String tipoPercusion = instrumentoAux.getTipoDePercucion();
                String tipoMaterial = instrumentoAux.getMaterialDeConstruccion();
                String altura = instrumentoAux.getAltura();

                writer.write(codigoUnico);
                writer.write(",");
                writer.write(String.valueOf(precio));
                writer.write(",");
                writer.write(String.valueOf(stock));
                writer.write(",");
                writer.write(nombreInstrumento);
                writer.write(",");
                writer.write(tipoPercusion);
                writer.write(",");
                writer.write(tipoMaterial);
                writer.write(",");
                writer.write(altura);
                writer.newLine();
            }

            for (int i = 0; i < Instrumentos2.cantidadActual; i++) {
                //asigno el instrumento a desplegar
                instrumentoViento instrumentoAux = (instrumentoViento) Instrumentos2.obtenerInstrumento(i);

                String codigoUnico = instrumentoAux.getCodigoUnico();
                double precio = instrumentoAux.getPrecio();
                int stock = instrumentoAux.getStockProducto();
                String nombreInstrumento = instrumentoAux.getNombreInstrumento();
                String materialDeConstruccion = instrumentoAux.getMaterialDeConstruccion();

                writer.write(codigoUnico);
                writer.write(",");
                writer.write(String.valueOf(precio));
                writer.write(",");
                writer.write(String.valueOf(stock));
                writer.write(",");
                writer.write(nombreInstrumento);
                writer.write(",");
                writer.write(materialDeConstruccion);
                writer.newLine();
            }
            writer.close();
            StdOut.println("Datos actualizados correctamente :)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

