package util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class LeerEscribirArchivoCSV {

    private static final String RUTA_ARCHIVO = "./src/test/resources/";

    public static ArrayList<String> leerDatosCSV(String nombreArchivoCSV) throws IOException {
        ArrayList<String> listaProductos = new ArrayList<String>();
        String rutaMasArchivo = RUTA_ARCHIVO + nombreArchivoCSV + ".csv";
        Reader reader = Files.newBufferedReader(Paths.get(rutaMasArchivo));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim());
        for (CSVRecord csvRecord : csvParser) {
            listaProductos.add(csvRecord.get("productos"));
        }
        return listaProductos;
    }


    public static void escribirDatosCSV(String nombreArchivoCSV, ArrayList<String> detallesProductos ) throws IOException {
        String rutaMasNombreArchivo = RUTA_ARCHIVO + nombreArchivoCSV + ".csv";
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(rutaMasNombreArchivo));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                .withHeader("Nombre Producto", "SKU", "Despacho a Domicilio", "Retiro en Tienda"));
        int j = 0;
        for (int i = 0; i < detallesProductos.size()/4; i++) {
            csvPrinter.printRecord(detallesProductos.get(j), detallesProductos.get(j+1), detallesProductos.get(j+2), detallesProductos.get(j+3));
            j += 4;
        }
        csvPrinter.flush();
    }

}
