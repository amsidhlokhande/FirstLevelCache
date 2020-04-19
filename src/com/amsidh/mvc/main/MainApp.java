package com.amsidh.mvc.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.amsidh.mvc.domain.Shop;

public class MainApp {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//First Level Cache
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Shop shop1 = (Shop) session.get(Shop.class,1);
		/*Query query1=session.createQuery("from Shop where shopId =:shopId");
		query1.setInteger("shopId", 1);
		Shop shop1 =(Shop) query1.list().get(0);*/
		System.out.println(shop1.getShopName());
		session.evict(shop1); // this will remove the passed entity from the first level cache i.e. session cache
		
		/*Query query2=session.createQuery("from Shop where shopId =:shopId");
		query2.setInteger("shopId", 1);
		Shop shop2 =(Shop) query2.list().get(0);*/
		Shop shop2 = (Shop) session.get(Shop.class,1);
		System.out.println(shop2.getShopName());
		
		
		Shop shop11 = (Shop) session.get(Shop.class,2);
		session.clear(); //this will remove all the entities cached in first level cache ie. session cache
		Shop shop22 = (Shop) session.get(Shop.class,2);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		
/*
		//Second Level Cache And Query Cache
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		//Shop shop1 = (Shop) session1.get(Shop.class, 1);
		Query query1 = session1.createQuery("from Shop where shopId = :shopId");
		query1.setCacheable(true);
		
		query1.setInteger("shopId", 1);
		Shop shop1=(Shop)query1.list().get(0);
		System.out.println(shop1.getShopName());
		session1.flush();
		session1.getTransaction().commit();
		session1.close();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		//Shop shop2 = (Shop) session2.get(Shop.class, 1);
		Query query2 = session2.createQuery("from Shop where shopId = :shopId");
		query2.setInteger("shopId", 1);
		query2.setCacheable(true);
		Shop shop2=(Shop)query2.list().get(0);
		System.out.println(shop2.getShopName());
		session2.flush();
		session2.getTransaction().commit();
		session2.close();
*/
		
		
		sessionFactory.close();
	}

}
