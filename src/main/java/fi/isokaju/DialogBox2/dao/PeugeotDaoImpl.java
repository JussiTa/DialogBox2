/**
 * 
 */
package fi.isokaju.DialogBox2.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;










import fi.isokaju.DialogBox2.model.Peugeot;

/**
 * @author Jussi
 *
 */
public class PeugeotDaoImpl implements PeugeotDao {
	
	private SessionFactory sessionFactory;
	private Session session;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	 private static final Log log =
		      LogFactory.getLog(PeugeotDaoImpl.class);

	
	public PeugeotDaoImpl(){		
				
		
	}	
	

	public void addModel(Peugeot p) throws Exception {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		
		
		Session session;
		session =sessionFactory.openSession();	
		Transaction tx = null;
		 try {
		     tx = session.beginTransaction();
		     session.save(p);
		     tx.commit();
		 }
		 catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     throw e;
		 }
		 finally {
		     session.close();
		 }
		
		//session.flush(); 
		log.info(session);
		// TODO Auto-generated method stub
		/*entityManagerFactory =
		        Persistence
		            .createEntityManagerFactory("KAUPPA");
		    entityManager =
		        entityManagerFactory.createEntityManager();
		
	
		entityManager.getTransaction().begin();
		entityManager.persist(p);
		entityManager.getTransaction().commit();
		System.out.println(p.getId());*/
	}

	

	
	public Peugeot[] getModel() {
		session = null;
		Peugeot[] p = new Peugeot[10];
		
		session = sessionFactory.openSession();
		//session.
		String hql = "FROM Peugeot P";
		Query query = session.createQuery(hql);
		//session.load(Peugeot.class, arg1)
		
		@SuppressWarnings("unchecked")
		final List<Peugeot> results =  query.list();
		p[0]= results.get(0);
		
		return   p;
	}


	public void updateModel(Peugeot p) {
		// TODO Auto-generated method stub
		
	}








	
}
