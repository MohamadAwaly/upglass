package be.atc.connection;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Renaud DIANA
 * 
 */
public interface EntityFinder<T> {
	
	/**	 
	 * Interface method to find an entity from the database
	 * 	 
	 * @param <T>
	 *          Generic backing bean
	 * @param Object
	 *          Backing bean's id to find
	 *                   
	 * @return 
	 * 			Generic backing bean
	 */	
	public T findOne(T t, int id);
	
	/**	 
	 * Interface method to find a result of entities based on a NamedQuery from the database
	 * 	 
	 * @param String
	 *          The NamedQuery          
	 * @param <T>
	 *          Generic backing bean
	 * @param param
	 *          Query parameters
	 *          For Date params, key must contains the word(ci) 'date'
	 *
	 * @return 
	 * 			List of generic backing beans
	 */
	public <K, V> List<T> findByNamedQuery(String namedQuery, T t, Map<K, V> param, int maxSize);
	
	/**	 
	 * Interface method to find a result of entities based on a customQuery from the database
	 * 	 
	 * @param String
	 *          The customQuery          
	 * @param <T>
	 *          Generic backing bean
	 * @param param
	 *          Query parameters
	 *          For Date params, key must contains the word(ci) 'date'
	 *          
	 * @return 
	 * 			List of generic backing beans
	 */	
	public <K, V> List<T> findByCustomQuery(String customQuery, T t, Map<K, V> param);

	/**
	 * Interface method to find a single result of entities;  entities based on a NamedQuery from the database
	 *
	 * @param <K>        the type parameter
	 * @param <V>        the type parameter
	 * @param namedQuery The NamedQuery
	 * @param t          Generic backing bean
	 * @param param      Query parameters      For Date params, key must contain the word(ci) 'date'
	 * @return only one Entity
	 */
	public <K, V> T findOneByNamedQuery(String namedQuery, T t, Map<K, V> param);
}
