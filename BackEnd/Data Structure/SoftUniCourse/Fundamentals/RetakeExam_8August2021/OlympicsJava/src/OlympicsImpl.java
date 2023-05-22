import java.util.*;

public class OlympicsImpl implements Olympics {

    TreeMap<Integer ,Competitor> competitors ;
    HashMap<Integer , Competition> competitions ;
    public OlympicsImpl() {
        competitors =  new TreeMap<>();
        competitions = new LinkedHashMap<>();
    }


    @Override
    public void addCompetitor(int id, String name) {
        Competitor competitorToAdd = new Competitor(id , name);
            if(competitors.containsKey(id)) {
                throw new IllegalArgumentException();
            }
        competitors.put(id , competitorToAdd);
    }

    @Override
    public void addCompetition(int id, String name, int score) {
        Competition competitionToAdd = new Competition(name , id ,score);
            if(competitions.containsKey(id)){
                throw new IllegalArgumentException();
        }
        competitions.put(id , competitionToAdd);
    }

    @Override
    public void compete(int competitorId, int competitionId) {
        Competition competition = competitions.get(competitionId);
        Competitor competitor = competitors.get(competitorId);
        if(competition != null && competitor != null){
            competition.getCompetitors().add(competitor);
            long currentScore = competitor.getTotalScore();
            competitor.setTotalScore(currentScore + competition.getScore());
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void disqualify(int competitionId, int competitorId) {
        Competition competition = competitions.get(competitionId);
        if(competition != null){
            for (Competitor competitor : competition.getCompetitors()) {
                if(competitor.getId() == competitorId){
                    long currentPoints = competitor.getTotalScore();
                    competitor.setTotalScore(currentPoints -competition.getScore());
                    competition.getCompetitors().remove(competitor);
                    return;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Competitor> findCompetitorsInRange(long min, long max) {
        ArrayList<Competitor> toReturn = new ArrayList<>();
        competitors.values()
                .stream()
                .filter(e->e.getTotalScore() >min && e.getTotalScore()<=max)
                .forEach(toReturn::add);
        return toReturn;
    }

    @Override
    public Iterable<Competitor> getByName(String name) {
        ArrayList<Competitor> toReturn = new ArrayList<>();
        competitors.values()
                .stream()
                .filter(e->e.getName().equals(name))
                .forEach(toReturn::add);

        if(toReturn.isEmpty()){
            throw new IllegalArgumentException();
        }
        return toReturn;
    }

    @Override
    public Iterable<Competitor> searchWithNameLength(int minLength, int maxLength) {
        ArrayList<Competitor> toReturn = new ArrayList<>();
        competitors.values()
                .stream()
                .filter(e->e.getName().length() >=minLength && e.getName().length()<=maxLength)
                .forEach(toReturn::add);
        return toReturn;
    }

    @Override
    public Boolean contains(int competitionId, Competitor comp) {
        Competition competition = competitions.get(competitionId);
        if(competition != null){
           return competition.getCompetitors().contains(comp);
        }
       throw new IllegalArgumentException();
    }

    @Override
    public int competitionsCount() {
        return competitions.size();
    }

    @Override
    public int competitorsCount() {
        return competitors.size();
    }

    @Override
    public Competition getCompetition(int id) {
        Competition competition = competitions.get(id);
        if(competition != null){
            return competition;
        }
        throw new IllegalArgumentException();
    }
}
