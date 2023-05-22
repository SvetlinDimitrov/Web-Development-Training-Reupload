package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;
import glacialExpedition.models.suitcases.Suitcase;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, Collection<Explorer> explorers) {

        List<Explorer> list = explorers.stream()
                .filter(Explorer::canSearch)
                .collect(Collectors.toList());

        for (Explorer explorer : list) {
            Suitcase suitcase = explorer.getSuitcase();

            for (String exhibit : state.getExhibits()) {
                explorer.search();
                suitcase.getExhibits().add(exhibit);
                state.getExhibits().remove(exhibit);
                if(!explorer.canSearch()){
                    break;
                }
                if(state.getExhibits().isEmpty()){
                    break;
                }
            }

            if(state.getExhibits().isEmpty()){
                break;
            }
        }

    }
}
