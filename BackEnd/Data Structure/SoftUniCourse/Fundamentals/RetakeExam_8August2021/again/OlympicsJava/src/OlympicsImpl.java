import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OlympicsImpl implements Olympics {
    HashMap<Integer, Competition> competitionHashMap = new LinkedHashMap<>();
    HashMap<Integer, Competitor> challengers = new LinkedHashMap<>();
    HashMap<Competition, HashMap<Integer, Competitor>> map = new HashMap<>();

    public OlympicsImpl() {

    }


    @Override
    public void addCompetitor(int id, String name) {
        if (challengers.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        Competitor competitor = new Competitor(id, name);
        challengers.put(id, competitor);
    }

    @Override
    public void addCompetition(int id, String name, int score) {
        if (competitionHashMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        Competition competition = new Competition(name, id, score);
        competitionHashMap.put(id, competition);
        map.put(competition, new HashMap<>());
    }

    @Override
    public void compete(int competitorId, int competitionId) {
        if (challengers.containsKey(competitorId) && competitionHashMap.containsKey(competitionId)) {

            Competitor currentCompetitor = challengers.get(competitorId);
            Competition currentCompetition = competitionHashMap.get(competitionId);

            map.get(currentCompetition).put(competitorId, currentCompetitor);
            long currentScore = currentCompetitor.getTotalScore();
            currentCompetitor.setTotalScore(currentScore + currentCompetition.getScore());
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void disqualify(int competitionId, int competitorId) {
        if (competitionHashMap.containsKey(competitionId)) {
            Competition currentCompetition = competitionHashMap.get(competitionId);

            if (map.get(currentCompetition).containsKey(competitionId)) {
                map.get(currentCompetition).remove(competitionId);
                long currentScore = challengers.get(competitorId).getTotalScore();
                challengers.get(competitorId).setTotalScore(currentScore - currentCompetition.getScore());
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Competitor> findCompetitorsInRange(long min, long max) {

        return challengers.values().stream()
                .filter(e -> e.getTotalScore() > min && e.getTotalScore() <= max)
                .sorted(Comparator.comparing(Competitor::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Competitor> getByName(String name) {

        List<Competitor> competitorList = challengers.values()
                .stream()
                .filter(e -> e.getName().equals(name))
                .sorted(Comparator.comparing(Competitor::getId))
                .collect(Collectors.toList());

        if (competitorList.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return competitorList;
    }

    @Override
    public Iterable<Competitor> searchWithNameLength(int minLength, int maxLength) {
        return challengers.values().stream()
                .filter(e -> e.getName().length() >= minLength && e.getName().length() <= maxLength)
                .sorted(Comparator.comparing(Competitor::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean contains(int competitionId, Competitor comp) {
        if (competitionHashMap.containsKey(competitionId)) {
            Competition currentCompetition = competitionHashMap.get(competitionId);
            if(map.get(c))
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int competitionsCount() {
        return competitionHashMap.size();
    }

    @Override
    public int competitorsCount() {
        return challengers.size();
    }

    @Override
    public Competition getCompetition(int id) {
        if (competitionHashMap.containsKey(id)) {
            return competitionHashMap.get(id);
        }
        throw new IllegalArgumentException();
    }
}
