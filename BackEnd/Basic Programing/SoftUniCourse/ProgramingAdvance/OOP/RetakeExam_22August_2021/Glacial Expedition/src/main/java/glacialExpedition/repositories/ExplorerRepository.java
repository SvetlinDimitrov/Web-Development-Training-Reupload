package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExplorerRepository implements Repository<Explorer>{
    private Map<String , Explorer> map ;

    public ExplorerRepository() {
        this.map = new LinkedHashMap<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableCollection(map.values());
    }

    @Override
    public void add(Explorer entity) {
        map.putIfAbsent(entity.getName() , entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        boolean toReturn = map.containsKey(entity.getName());
        map.remove(entity.getName());
        return toReturn;
    }

    @Override
    public Explorer byName(String name) {
        return map.get(name);
    }
}
