package dndhelpermk2.storage;

import dndhelpermk2.exception.CRUDException;
import java.util.HashMap;
import java.util.Map;

public class MapCRUD <K extends Comparable<K>, V extends Storable<K>> implements CRUD<K, V>
{
    
    Map<K, V> storage = new HashMap<K, V>();

    @Override
    public void create(V content) throws CRUDException
      {
        if (storage.containsKey(content.getID())) {
            throw new CRUDException("An object already exist with that Key: " + content.getID());
        }
        
        this.storage.put(content.getID(), content);
      }

    @Override
    public V read(K key) throws CRUDException
      {
        V value = this.storage.get(key);
        
        if (value == null) {
            throw new CRUDException("No object with that ID");
        } else {
            return value;
        }
      }

    @Override
    public void update(V context) throws CRUDException
      {
        if (storage.containsKey(context.getID())) {
			storage.remove(context.getID());
			storage.put(context.getID(), context);
		} else {
			throw new CRUDException("Storage does not contain this object to update.");
		}
      }

    @Override
    public void delete(K key) throws CRUDException
      {
        this.storage.remove(key);
      }

    @Override
    public void clear() throws CRUDException
      {
        this.storage.clear();
      }

    @Override
    public Map<K, V> getStorage() throws CRUDException
      {
        return this.storage;
      }

    @Override
    public boolean containsKey(K key) throws CRUDException
      {
        return this.storage.containsKey(key);
      }

    @Override
    public K getLastID() throws CRUDException
      {
        K latestKey = null;

		if (!this.storage.isEmpty()) {
			latestKey = this.storage.keySet().iterator().next();
		}

		for (K key : this.storage.keySet()) {
			if (key.compareTo(latestKey) == 1) {
				latestKey = key;
			}
		}
		return latestKey;
      }

}
