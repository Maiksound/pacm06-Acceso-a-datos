package pacm06;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pacm06.Lector;

public class LectorDAO {
	private static SessionFactory sessionFactory;

    public LectorDAO(SessionFactory sessionFactory) {
        LectorDAO.sessionFactory = sessionFactory;
    }

    public static void crearLector(Lector lector) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(lector);
            tx.commit();
        }
    }
    public List<Lector> listarLectores() {
        try (Session session = sessionFactory.openSession()) {
            Query<Lector> query = session.createQuery("FROM Lector", Lector.class);
            return query.getResultList();
        }
    }
    public Lector obtenerLector(int idLector) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Lector.class, idLector);
        }
    }
   

}
