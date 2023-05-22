package goldDigger.models.spot;

import java.util.ArrayList;
import java.util.Collection;

import static goldDigger.common.ExceptionMessages.SPOT_NAME_NULL_OR_EMPTY;

public class SpotImpl implements Spot{
    private Collection<String> exhibits ;
    private String name ;

    public SpotImpl(String name) {
        exhibits = new ArrayList<>();
        setName(name);
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new NullPointerException(SPOT_NAME_NULL_OR_EMPTY);
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
