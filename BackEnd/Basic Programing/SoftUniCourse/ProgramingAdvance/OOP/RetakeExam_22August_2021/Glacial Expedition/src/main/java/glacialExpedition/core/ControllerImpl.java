package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Integer stateExploder = 0;
    private StateRepository stateRepository = new StateRepository();
    Mission mission = new MissionImpl();
    private ExplorerRepository explorerRepository = new ExplorerRepository();

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = null;
        if(type.equals("AnimalExplorer")){
            explorer = new AnimalExplorer(explorerName);
        }else if (type.equals("GlacierExplorer")){
            explorer = new GlacierExplorer(explorerName);
        }else if (type.equals("NaturalExplorer")){
            explorer = new NaturalExplorer(explorerName);
        }else{
            throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED,type,explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }
        stateRepository.add(state);
        return String.format(STATE_ADDED,stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);
        if(explorer == null){
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST,explorerName));
        }
        explorerRepository.remove(explorer);
        return String.format(EXPLORER_RETIRED,explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        State state = stateRepository.byName(stateName);

        List<Explorer> explorers = explorerRepository.getCollection().stream()
                .filter(e->e.getEnergy() > 50)
                .collect(Collectors.toList());
        if(explorers.isEmpty()){
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        mission.explore(state , explorers);
        List<Explorer> notRetired = explorers.stream()
                .filter(Explorer::canSearch)
                .collect(Collectors.toList());
        stateExploder++;
        return String.format(STATE_EXPLORER,stateName,explorers.size()-notRetired.size());
    }

    @Override
    public String finalResult() {
        StringBuilder print = new StringBuilder();
        print.append(String.format(FINAL_STATE_EXPLORED,stateExploder)).append(System.lineSeparator());
        print.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());
        for (Explorer explorer : explorerRepository.getCollection()) {
            print.append(String.format(FINAL_EXPLORER_NAME,explorer.getName())).append(System.lineSeparator());
            print.append(String.format(FINAL_EXPLORER_ENERGY,explorer.getEnergy())).append(System.lineSeparator());
            print.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,
                    explorer.getSuitcase().getExhibits().size() == 0 ? "None"
                    : String.join(", ", explorer.getSuitcase().getExhibits())));
            print.append(System.lineSeparator());
        }
        return print.toString().trim();
    }
}
