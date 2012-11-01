package dndhelpermk2.storage;

import dndhelpermk2.exception.CRUDException;
import java.util.Map;

public interface CRUD<K extends Comparable<K>, V extends Storable<K>>
  {
    public void create(V content) throws CRUDException;
    
    public V read(final K key) throws CRUDException;
    
    public void update(final V context) throws CRUDException;
    
    public void delete(final K key) throws CRUDException;
    
    public void clear() throws CRUDException;
    
    public Map<K, V> getStorage() throws CRUDException;
    
    public boolean containsKey(K key) throws CRUDException;
    
    public K getLastID() throws CRUDException;
  }
