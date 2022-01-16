package be.atc.connection;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.*;


/** 
 * Class to perform entity CRUD with the database
 * 
 * @author Renaud DIANA
 */
public class EntityFinderImpl<T> implements EntityFinder<T>, Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
	public EntityFinderImpl(){
		super();
	}
	
	// Log4j
	private static final Logger log = Logger.getLogger( EntityFinderImpl.class );
	
	@Override
	public T findOne(T t, int id) {
		
		EntityManager em = EMF.getEM();
		Class<? extends Object> ec = t.getClass();
		try {
	        
	    	t = (T)em.find(ec, id);
	    	
	    	em.clear();
	    	
	    	log.debug("Bean " + t + " find from database: Ok");
	    } finally {
	        em.close();
	        log.debug("Close em : Ok");
	    }
		
		return t;
	}

	@Override
	public <K, V> List<T> findByNamedQuery(String namedQuery, T t, Map<K, V> param, int maxSize) {

		List<T> listT = new ArrayList<T>();
		Class<? extends Object> ec = t.getClass();

		EntityManager em = EMF.getEM();
		try {
			Query query = em.createNamedQuery(namedQuery, ec);

			if(param != null) {

				setParameters(query, param);
			}
			if (maxSize>0){
				query.setMaxResults(maxSize);
			}
			listT = (List<T>) query.getResultList();

			//	log.debug("List " + t + " size: " + listT.size());
			//	log.debug("Named query " + namedQuery + " find from database: Ok");
		}
		finally {
			em.close();
		}
		return listT;
	}
	
	@Override
	public <K, V> List<T> findByCustomQuery(String customQuery, T t, Map<K, V> param) {
		
		List<T> listT = new ArrayList<T>();
		Class<? extends Object> ec = t.getClass();
	    
		EntityManager em = EMF.getEM();
		try {
	    	Query query = em.createQuery(customQuery, ec);
	    	if(param != null) {
	    		
	    		setParameters(query, param);
	    	}
	    	listT = (List<T>) query.getResultList();
	    	    	
	    	log.debug("List " + t + " size: " + listT.size());       
	    	log.debug("Custom query " + customQuery + " find from database: Ok");
		}
		finally {
			
			em.clear();
	        em.close();
	    }
		return listT;
	}

	@Override
	public <K,V> T findOneByNamedQuery(String namedQuery, T t, Map<K,V>param){
		List<T> listT = new ArrayList<T>();
		listT = findByNamedQuery(namedQuery,t,param,1);
		if(listT.isEmpty()){
			t = null;
		} else {
			t=listT.get(0);
		}
		return t;
	}



	/**  
	 * @param query
	 * @param param
	 * @return
	 * 			the query with parameters
	 */
	private <K, V> void setParameters(Query query, Map<K, V> param) {
		
		Set<Map.Entry<K, V>> entries = param.entrySet();
		Iterator<Map.Entry<K, V>> itr = entries.iterator();
		while(itr.hasNext()){
			Map.Entry<K, V> entry = itr.next();
			if((boolean) entry.getKey().toString().toLowerCase().contains("date"))
				query.setParameter((String) entry.getKey(),(Date) entry.getValue(), TemporalType.DATE);
			else
				query.setParameter((String) entry.getKey(),entry.getValue());
			//log.debug("entry.getValue: " + entry.getValue());
		}
	}
	
}