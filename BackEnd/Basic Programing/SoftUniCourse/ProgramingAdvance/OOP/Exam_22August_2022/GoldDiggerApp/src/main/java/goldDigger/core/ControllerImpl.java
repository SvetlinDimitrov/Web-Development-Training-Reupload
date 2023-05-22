package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private DiscovererRepository discovererRepository = new DiscovererRepository();
    private SpotRepository spotRepository = new SpotRepository();
    private Operation operation = new OperationImpl();
    private int potsExplored=0;
    public ControllerImpl() {
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer = null;
        if(kind.equals(Anthropologist.class.getSimpleName())){
            discoverer = new Anthropologist(discovererName);
        }else if (kind.equals(Archaeologist.class.getSimpleName())){
            discoverer = new Archaeologist(discovererName);
        }else if (kind.equals(Geologist.class.getSimpleName())){
            discoverer = new Geologist(discovererName);
        }else{
            throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        discovererRepository.add(discoverer);
        return String.format(DISCOVERER_ADDED,kind ,discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }
        spotRepository.add(spot);
        return String.format(SPOT_ADDED,spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        for (Discoverer discoverer : discovererRepository.getCollection()) {
            if(discoverer.getName().equals(discovererName)){
                discovererRepository.remove(discoverer);
                return String.format(DISCOVERER_EXCLUDE,discovererName);
            }
        }
        throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST,discovererName));
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> discovererWithAbove45 =
                discovererRepository.getCollection().stream()
                        .filter(e->e.getEnergy() > 45)
                        .collect(Collectors.toList());
        if(discovererWithAbove45.isEmpty()){
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        int currentCountDis = discovererRepository.getCollection().size();
        operation.startOperation(spotRepository.byName(spotName),discovererWithAbove45);
        currentCountDis-=discovererRepository.getCollection().size();
        potsExplored+=1;
        return String.format("The spot %s was inspected. %d discoverers have been excluded on this operation.",spotName ,currentCountDis);
    }

    @Override
    public String getStatistics() {
        StringBuilder print = new StringBuilder();
        print.append(String.format("%d spots were inspected.%n",potsExplored));
        print.append(String.format("Information for the discoverers:%n"));
        for (Discoverer discoverer : discovererRepository.getCollection()) {
            String infoOfDiscoverers =
                    String.format("Name: %s%n", discoverer.getName()) +
                    String.format("Energy: %.0f%n", discoverer.getEnergy()) +
                    String.format("Museum exhibits: %s",
                            discoverer.getMuseum().getExhibits().size() == 0
                                    ? "None" : String.join(" ",
                                    discoverer.getMuseum().getExhibits()));

            print.append(String.format("%s%n", infoOfDiscoverers));
        }
        return print.toString().trim();
    }
}
