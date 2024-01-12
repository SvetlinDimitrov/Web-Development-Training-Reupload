package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StateRepository implements Repository<State>{
    private Map<String , State> map ;

    public StateRepository() {
        this.map = new LinkedHashMap<>();
    }

    @Override
    public Collection<State> getCollection() {
            return Collections.unmodifiableCollection(map.values());
    }

    @Override
    public void add(State entity) {
        map.putIfAbsent(entity.getName() , entity);
    }

    @Override
    public boolean remove(State entity) {
        boolean isThere = map.containsKey(entity.getName());
        map.remove(entity.getName());
        return isThere;
    }

    @Override
    public State byName(String name) {
        return map.get(name);
    }
}
