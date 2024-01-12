package glacialExpedition.models.states;

import java.util.ArrayList;
import java.util.Collection;

import static glacialExpedition.common.ExceptionMessages.*;

public class StateImpl implements State{
    private String name;
    private Collection<String> exhibits;

    public StateImpl(String name) {
        setName(name);
        exhibits = new ArrayList<>();
    }

    public void setName(String name) {
        if(null == name || name.trim().length() ==0){
            throw new NullPointerException(STATE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }

    @Override
    public String getName() {
        return name;
    }
}
