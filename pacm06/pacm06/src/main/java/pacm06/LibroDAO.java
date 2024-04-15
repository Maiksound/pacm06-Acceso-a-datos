package pacm06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;;


public class LibroDAO {
	 private static SessionFactory sessionFactory = null;

	    public LibroDAO(SessionFactory sessionFactory) {
	        LibroDAO.sessionFactory = sessionFactory;
	    }
	    public static void crearLibro(Libro libro) {
	        try (Session session = sessionFactory.openSession()) {
	            Transaction tx = session.beginTransaction();
	            session.save(libro);
	            tx.commit();
	        }
	    }
	    public static List<Libro> listarLibros() {
	        try (Session session = sessionFactory.openSession()) {
	            Query<Libro> query = session.createQuery("FROM Libro", Libro.class);
	            return query.getResultList();
	        }
	    }
	        public static Libro obtenerLibro(int idLibro) {
	            try (Session session = sessionFactory.openSession()) {
	                return session.get(Libro.class, idLibro);
	            }
	        }
	        public List<Libro> obtenerLibrosDisponibles() {
	            try (Session session = sessionFactory.openSession()) {
	                Query<Libro> query = session.createQuery("FROM Libro WHERE disponible = true", Libro.class);
	                return query.getResultList();
	            }
	        }
	        public static void actualizarLibro(Libro libro) {
	            try (Session session = sessionFactory.openSession()) {
	                Transaction tx = session.beginTransaction();
	                session.update(libro);
	                tx.commit();
	            }
	        }
			


}
