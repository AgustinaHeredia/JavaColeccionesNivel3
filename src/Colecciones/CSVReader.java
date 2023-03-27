package Colecciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    
    public static List<Persona> leerArchivoCSV(String rutaArchivo) {
        List<Persona> listaPersonas = new ArrayList<>();
        BufferedReader br = null;
        String linea = "";
        String separador = ",";
        try {
            br = new BufferedReader(new FileReader(rutaArchivo));
            while ((linea = br.readLine()) != null) {
                String[] datosPersona = linea.split(separador);
                String nombre = datosPersona[0];
                String apellido = datosPersona[1];
                String dni = datosPersona[2];
                Persona persona = new Persona(nombre, apellido, dni);
                listaPersonas.add(persona);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listaPersonas;
    }
}

