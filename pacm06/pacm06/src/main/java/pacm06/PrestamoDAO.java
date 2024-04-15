package pacm06;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PrestamoDAO {
	 private static SessionFactory sessionFactory;

	    public PrestamoDAO(SessionFactory sessionFactory) {
	        PrestamoDAO.sessionFactory = sessionFactory;
	    }
	    public static void crearPrestamo(Prestamo prestamo) {
	        try (Session session = sessionFactory.openSession()) {
	            Transaction tx = session.beginTransaction();
	            session.save(prestamo);
	            tx.commit();
	        }
	    }
	    public static void devolverPrestamo(int idPrestamo) {
	        try (Session session = sessionFactory.openSession()) {
	            Transaction tx = session.beginTransaction();
	            Prestamo prestamo = session.get(Prestamo.class, idPrestamo);
	            prestamo.setFecDevolucion(new Date()); 
	            session.update(prestamo);
	            tx.commit();
	        }
	    }
	    public static List<Prestamo> obtenerPrestamosPorLector(int idLector, int idLector2) {
	        try (Session session = sessionFactory.openSession()) {
	            Query<Prestamo> query = session.createQuery("FROM Prestamo WHERE idLector = :idLector", Prestamo.class);
	            query.setParameter("idLector", idLector);
	            return query.getResultList();
	        }
	    }
	    public List<Prestamo> obtenerHistorialPrestamosPorLector(int idLector) {
	        try (Session session = sessionFactory.openSession()) {
	            Query<Prestamo> query = session.createQuery("FROM Prestamo WHERE idLector = :idLector", Prestamo.class);
	            query.setParameter("idLector", idLector);
	            return query.getResultList();
	        }
	    }
	    public static void asignarLibroALector(int idLibro, int idLector) {
	        try (Session session = sessionFactory.openSession()) {
	            Transaction tx = session.beginTransaction();
	            
	            // Obtener el libro y el lector
	            Libro libro = session.get(Libro.class, idLibro);
	            Lector lector = session.get(Lector.class, idLector);
	            
	            // Crear un nuevo objeto Prestamo y asignar el libro y el lector
	            Prestamo prestamo = new Prestamo();
	            prestamo.setLibro(libro);
	            prestamo.setLector(lector);
	            prestamo.setFecPrestamo(new Date()); 
	            // Guardar el objeto Prestamo en la base de datos
	            session.save(prestamo);
	            
	            tx.commit();
	        }
	    }
		
			    
	}