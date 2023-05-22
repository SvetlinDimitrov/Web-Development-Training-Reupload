package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation{

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        for (Discoverer discoverer : discoverers) {
            if(discoverer.canDig()) {
                for (String exhibit : spot.getExhibits()) {
                    discoverer.dig();
                    discoverer.getMuseum().getExhibits().add(exhibit);
                    spot.getExhibits().remove(exhibit);
                    if (!discoverer.canDig()) {
                        discoverers.remove(discoverer);
                        break;
                    }
                }
            }
        }
    }
}
