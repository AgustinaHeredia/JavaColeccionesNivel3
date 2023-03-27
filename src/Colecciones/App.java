package Colecciones;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {
	
	static Scanner input = new Scanner(System.in);
    static String archivo = "/Users/agustinaheredia/Documents/eclipse-workspace/S1Tasca3N3Ejercicio1AgustinaHeredia/resources/personas.csv";
    static List<Persona> personas = CSVReader.leerArchivoCSV(archivo);
    
	public static void main(String[] args) {
		
		
        int opcion= menu();;
        
        while (opcion != 0) {
            
            switch (opcion) {
                case 1:
                    introducirPersona();
                    break;
                case 2:
                	ordenarPorNombreAZ();
                    mostrarPersonas();
                    break;
                case 3:
                    ordenarPorNombreZA();
                    mostrarPersonas();
                    break;
                case 4:
                    ordenarPorApellidoAZ();
                    mostrarPersonas();
                    break;
                case 5:
                    ordenarPorApellidoZA();
                    mostrarPersonas();
                    break;
                case 6:
                    ordenarPorDNI19();
                    mostrarPersonas();
                    break;
                case 7:
                    ordenarPorDNI91();
                    mostrarPersonas();
                    break;
                
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            opcion = menu();
        }
        System.out.println("Saliendo de la aplicación...");
    }

	static int menu() {
	      
        System.out.println("1.- Introducir persona.");
        System.out.println("2.- Mostrar a las personas ordenadas por nombre (AZ).");
        System.out.println("3.- Mostrar a las personas ordenadas por nombre (ZA).");
        System.out.println("4.- Mostrar a las personas ordenadas por apellidos (AZ).");
        System.out.println("5.- Mostrar a las personas ordenadas por apellidos (ZA).");
        System.out.println("6.- Mostrar a las personas ordenadas por DNI (1-9).");
        System.out.println("7.- Mostrar a las personas ordenadas por DNI (9-1).");
        System.out.println("0. Salir");
        int opcion = pedirInt("Introduce la opción deseada");
        return opcion;
    }
    private static void introducirPersona() {
        
        String nombre = pedirString("Introduzca el nombre:");
        String apellido = pedirString("Introduzca el apellido:");
        String dni = pedirString("Introduzca el DNI:");
        personas.add(new Persona(nombre, apellido, dni));
    }
	
    public static void mostrarPersonas() {
        System.out.println("Lista de personas:");
        for (Persona p : personas) {
            System.out.println(p.getNombre() + " " + p.getApellido() + " - DNI: " + p.getDni());
        }
    }


    public static void ordenarPorNombreAZ() {
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });
    }

    public static void ordenarPorNombreZA() {
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p2.getNombre().compareTo(p1.getNombre());
            }
        });
    }

    public static void ordenarPorApellidoAZ() {
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getApellido().compareTo(p2.getApellido());
            }
        });
    }

    public static void ordenarPorApellidoZA() {
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p2.getApellido().compareTo(p1.getApellido());
            }
        });
    }

    public static void ordenarPorDNI19() {
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getDni().compareTo(p2.getDni());
            }
        });
    }

    public static void ordenarPorDNI91() {
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p2.getDni().compareTo(p1.getDni());
            }
        });
    }

    
    static int pedirInt(String texto) {
		System.out.println(texto);
		int n1 = input.nextInt();
		return n1;
	}
	static String pedirString(String texto) {
		System.out.println(texto);
		String nom = input.next();
		return nom;
	}
}
