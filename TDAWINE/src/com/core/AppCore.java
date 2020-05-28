/**
 * 
 */
package com.core;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.database.model.HibernateUtil;
import com.database.model.TiposVino;
import com.database.model.TiposVinoDAO;
import com.database.model.Vino;

/**
 * @author Admin-AE
 *
 */
public class AppCore {

	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	public void run() {
		
		TiposVinoDAO tvDAO = new TiposVinoDAO(session);
		List<TiposVino> list = tvDAO.findAllObjects();
		for (TiposVino tiposVino : list) {
			System.out.println("\t"+tiposVino.getDescripcion());
		}
		
		TiposVino ahh = tvDAO.get(1);
		if (null != ahh)
			System.out.println("Ahh "+ahh.getIdTiposVino()+"\t"+ahh.getDescripcion());
		
//		ahh.setDescripcion("Prueba "+ ahh.getDescripcion());
//		tvDAO.saveOrUpdate(ahh);
		
//		TiposVino ahh2 = new TiposVino();
//		ahh2.setDescripcion("HOla hola");
//		tvDAO.create(ahh2);
		
		
//		list = tvDAO.findAllObjects();
//		for (TiposVino tiposVino : list) {
//			System.out.println("\t"+tiposVino.getDescripcion());
//		}
		
		
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Vino> query = session.createQuery("from Vino where descripcion = :desc and tiposVino.idTiposVino = 2 order by tiposVino.descripcion asc");
		query.setParameter("desc", "Tinto 2015");
		List<Vino> list2 = query.list();
		for (Vino vino : list2) {
			System.out.println(vino.getDescripcion()+"\t"+vino.getTiposVino().getDescripcion());
		}
		session.getTransaction().commit();
		session.clear();
		
	}

}
