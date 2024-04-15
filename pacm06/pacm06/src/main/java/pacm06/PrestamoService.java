package pacm06;

import pacm06.Prestamo;
import pacm06.LibroDAO;
import pacm06.LectorDAO;
import pacm06.PrestamoDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class PrestamoService {
	private static  LibroDAO libroDAO;
    private final LectorDAO lectorDAO;
	private SessionFactory sessionFactory;
    private static PrestamoDAO prestamoDAO;
    

    public PrestamoService(SessionFactory sessionFactory) {
        this.libroDAO = new LibroDAO(sessionFactory);
        this.lectorDAO = new LectorDAO(sessionFactory);
        this.prestamoDAO = new PrestamoDAO(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public static void asignarLibroALector(int idLibro, int idLector) {
        prestamoDAO.asignarLibroALector(idLibro, idLector);
    }
    public static void devolverLibro(int idLibro, int idLector) {
        // Verificar si el libro está prestado al lector
        List<Prestamo> prestamo = PrestamoDAO.obtenerPrestamosPorLector(idLibro, idLector);
        
        if (prestamo != null) {
            // Registrar la devolución del libro
            ((Prestamo) prestamo).setFecDevolucion(new Date()); // Suponiendo que estás utilizando java.util.Date
            PrestamoDAO.crearPrestamo((Prestamo) prestamo);
            
            // Marcar el libro como disponible
            Libro libro = LibroDAO.obtenerLibro(idLibro);
            libro.setDisponible(true);
            LibroDAO.actualizarLibro(libro);
            
            System.out.println("Libro devuelto exitosamente.");
        } else {
            System.out.println("El libro no está prestado a este lector.");
        }
    }
    private void actualizarEstadoLibro(int idLibro, boolean disponible) {
        Libro libro = libroDAO.obtenerLibro(idLibro);
        libro.setDisponible(disponible);
        libroDAO.actualizarLibro(libro);
    }
    public static List<Prestamo> obtenerPrestamosPorLector(int idLector) {
        return prestamoDAO.obtenerPrestamosPorLector(idLector, idLector);
    }
    public static List<Libro> obtenerLibrosDisponibles() {
        return libroDAO.obtenerLibrosDisponibles();
    }
    public static List<Prestamo> obtenerHistorialPrestamosPorLector(int idLector) {
        return prestamoDAO.obtenerHistorialPrestamosPorLector(idLector);
    }
    public void asignarLibroALector1(int idLibro, int idLector) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            
            // Obtener el libro y el lector
            Libro libro = session.get(Libro.class, idLibro);
            Lector lector = session.get(Lector.class, idLector);
            
            // Verificar si el libro está disponible
            if (libro.isDisponible()) {
                // Crear un nuevo objeto Prestamo
                Prestamo prestamo = new Prestamo();
                prestamo.setLibro(libro);
                prestamo.setLector(lector);
                prestamo.setFecPrestamo(new Date());
                
                // Actualizar el estado del libro a prestado
                libro.setDisponible(false);
                session.update(libro);
                
                // Guardar el objeto Prestamo en la base de datos
                session.save(prestamo);
                tx.commit();
                System.out.println("Libro asignado al lector exitosamente.");
            } else {
                System.out.println("El libro no está disponible para préstamo.");
            }
        }
    }

}
