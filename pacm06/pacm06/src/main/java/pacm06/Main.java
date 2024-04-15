package pacm06;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);        
       
		System.out.println("INICIO DEL PROGRAMA");
		//Definimos las interfaces que indican que queremos usar hibernate
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sessionFactory.openSession();
		System.out.println("CONFIGURACION REALIZADA");
		LibroDAO libroDAO = new LibroDAO(sessionFactory);
        LectorDAO lectorDAO = new LectorDAO(sessionFactory);
       PrestamoDAO prestamoService = new PrestamoDAO(sessionFactory);
		
		
		 boolean continuar = true;
		 //Menu para interactuar con la BBDD
	        while (continuar) {
	            System.out.println("Menú:");
	            System.out.println("1- Insertar Libro");
	            System.out.println("2- Insertar Lector");
	            System.out.println("3- Listado de Libros");
	            System.out.println("4- Listado de Lectores");
	            System.out.println("5- Ver Libro por ID");
	            System.out.println("6- Ver Lector por ID");
	            System.out.println("7- Prestar libro");
	            System.out.println("8- Devolver Libro");
	            System.out.println("9- Libros prestados a un lector");
	            System.out.println("10- Libros disponibles para préstamo");
	            System.out.println("11- Historial de préstamos por lector");
	            System.out.println("12- Salir");
	            System.out.print("Elija una opción: ");
	            int opcion = scanner.nextInt();
	            scanner.nextLine(); // Limpiar el buffer de entrada
	            switch (opcion) {
                case 1:
                    System.out.println("Insertar Libro:");
                    System.out.print("ID: ");
                    int idLibro = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    System.out.print("Nombre: ");
                    String nombreLibro = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autorLibro = scanner.nextLine();
                    System.out.print("Año de Publicación: ");
                    int añoPublicacion = scanner.nextInt();
                    System.out.print("Disponible (true/false): ");
                    boolean disponible = scanner.nextBoolean();
                    Libro nuevoLibro = new Libro(idLibro, nombreLibro, autorLibro, añoPublicacion, disponible);
                    LibroDAO.crearLibro(nuevoLibro);
                    break;
                case 2:
                    System.out.println("Insertar Lector:");
                    System.out.print("ID: ");
                    int idLector = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    System.out.print("Nombre: ");
                    String nombreLector = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoLector = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailLector = scanner.nextLine();
                    System.out.print("DNI: ");
                    String dniLector = scanner.nextLine();

                    Lector nuevoLector = new Lector(idLector, nombreLector, apellidoLector, emailLector, dniLector);
                    LectorDAO.crearLector(nuevoLector);

                    System.out.println("Lector creado exitosamente.");
                    break;
                case 3:
                    System.out.println("Listado de Libros:");
                    List<Libro> libros = LibroDAO.listarLibros();
                    for (Libro libro : libros) {
                        System.out.println(libro);
                    }
                    break;
                case 4:
                    System.out.println("Listado de Lectores:");
                    List<Lector> lectores = lectorDAO.listarLectores();
                    if (lectores.isEmpty()) {
                        System.out.println("No hay lectores registrados en la base de datos.");
                    } else {
                        for (Lector lector : lectores) {
                            System.out.println(lector);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Ver Libro por ID:");
                    System.out.print("ID del Libro: ");
                    int idVerLibro = scanner.nextInt();
                    Libro libro = LibroDAO.obtenerLibro(idVerLibro);
                    if (libro != null) {
                        System.out.println(libro);
                    } else {
                        System.out.println("No se encontró ningún libro con el ID especificado.");
                    }
                    break;
                case 6:
                    System.out.println("Ver Lector por ID:");
                    System.out.print("Ingrese el ID del lector: ");
                    int idLector1 = scanner.nextInt();
                    Lector lector = lectorDAO.obtenerLector(idLector1);
                    if (lector != null) {
                        System.out.println("Información del Lector:");
                        System.out.println(lector);
                    } else {
                        System.out.println("No se encontró ningún lector con el ID especificado.");
                    }
                    break;
               
                case 7:
                    // Prestar Libro
                    System.out.println("Prestar Libro:");
                    System.out.print("ID del Libro: ");
                    int idLibroPrestar = scanner.nextInt();
                    System.out.print("ID del Lector: ");
                    int idLectorPrestar = scanner.nextInt();
                    PrestamoService.asignarLibroALector(idLibroPrestar, idLectorPrestar);
                    break;
                case 8:
                    // Devolver Libro
                    System.out.println("Devolver Libro:");
                    System.out.print("ID del Libro: ");
                    int idLibroDevolver = scanner.nextInt();
                    System.out.print("ID del Lector: ");
                    int idLectorDevolver = scanner.nextInt();
                    PrestamoService.devolverLibro(idLibroDevolver, idLectorDevolver);
                    break;
                case 9:
                    // Libros prestados a un lector
                    System.out.println("Libros prestados a un lector:");
                    System.out.print("ID del Lector: ");
                    int idLectorPrestamos = scanner.nextInt();
                    List<Prestamo> prestamos = PrestamoService.obtenerPrestamosPorLector(idLectorPrestamos);
                    for (Prestamo prestamo : prestamos) {
                        System.out.println(prestamo);
                    }
                    break;
                case 10:
                    // Libros disponibles para préstamo
                    System.out.println("Libros disponibles para préstamo:");
                    List<Libro> librosDisponibles = PrestamoService.obtenerLibrosDisponibles();
                    for (Libro libroDisponible : librosDisponibles) {
                        System.out.println(libroDisponible);
                    }
                    break;
                case 11:
                    // Historial de préstamos por lector
                    System.out.println("Historial de préstamos por lector:");
                    System.out.print("ID del Lector: ");
                    int idLectorHistorial = scanner.nextInt();
                    List<Prestamo> historialPrestamos = PrestamoService.obtenerHistorialPrestamosPorLector(idLectorHistorial);
                    for (Prestamo prestamo : historialPrestamos) {
                        System.out.println(prestamo);
                    }
                    break;
                case 12:
                    continuar = false;
                    System.out.println("¡Adiós!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
                	
		session.close();
		sessionFactory.close();

	      }
	    
	        
	 }


