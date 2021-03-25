package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import model.Post;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public static List<Post> listPosts() {
		List<Post> resultList = new ArrayList<Post>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null; // each process needs transaction and commit the changes in DB.

		try {
			tx = session.beginTransaction();
			List<?> Posts = session.createQuery("FROM Post").list();
			for (Iterator<?> iterator = Posts.iterator(); iterator.hasNext();) {
				Post Post = (Post) iterator.next();
				resultList.add(Post);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	public static void createPost(String title, String body) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new Post(title, body));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static List<Post> findPosts( String keyword) {
		List<Post> resultList = new ArrayList<Post>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null; // each process needs transaction and commit the changes in DB.

		try {
			tx = session.beginTransaction();
			String sql = " SELECT * FROM Post P where P.post_body like  '%" + keyword + "%'  or P.title like '%" + keyword + "%';";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Post.class);
			List<?> Posts = query.list();
			for (Iterator<?> iterator = Posts.iterator(); iterator.hasNext();) {
				Post Post = (Post) iterator.next();
				resultList.add(Post);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

}
