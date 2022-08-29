package com.HibernateAssignments.problem5.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.HibernateAssignments.problem5.model.Assets;
import com.HibernateAssignments.util.HibernateUtil;

public class AssetsDAO {
	
	public void getAssetById(int assetId) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		
		Assets a = session.get(Assets.class, assetId);
		
		System.out.println(a);
		
	}
	
	public void getMaxPriceAsset() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Query selQuery = session.createQuery("select m from Assets m order by m.assetPrice desc");
		Assets a= (Assets) selQuery.getResultList().get(0);	
		System.out.println("Max price asset is below");
		System.out.println(a);
	}
	
	

}
