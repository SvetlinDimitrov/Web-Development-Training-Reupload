import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class BoardImpl implements Board {

    HashMap<String , Card > deckOfCards ;

    public BoardImpl() {
        deckOfCards = new LinkedHashMap<>();
    }

    @Override
    public void draw(Card card) {
        if(deckOfCards.containsKey(card.getName())){
            throw new IllegalArgumentException();
        }
        deckOfCards.put(card.getName() , card);
    }

    @Override
    public Boolean contains(String name) {
        return deckOfCards.containsKey(name);
    }

    @Override
    public int count() {
        return deckOfCards.size();
    }

    @Override
    public void play(String attackerCardName, String attackedCardName) {
        Card attacker = deckOfCards.get(attackerCardName);
        Card victim = deckOfCards.get(attackedCardName);
        if(attacker != null && victim !=null){
            if(attacker.getLevel() == victim.getLevel()) {
                if (victim.getHealth() > 0) {
                    int victimCurrentHealth = victim.getHealth();
                    victim.setHealth(victimCurrentHealth - attacker.getDamage());
                    if(victim.getHealth() <= 0){
                        int attackerCurrentScore = attacker.getScore();
                        attacker.setScore(attackerCurrentScore + victim.getLevel());
                    }
                    return;
                }else {
                    return;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void remove(String name) {
        if(deckOfCards.containsKey(name)){
            deckOfCards.remove(name);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void removeDeath() {
        deckOfCards.values().removeIf(e->e.getHealth()<=0);
    }

    @Override
    public Iterable<Card> getBestInRange(int start, int end) {

        return deckOfCards.values()
                .stream()
                .filter(e->e.getScore() >=start && e.getScore()<=end)
                .sorted(Comparator.comparing(Card::getLevel).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Card> listCardsByPrefix(String prefix) {
        return deckOfCards.values()
                .stream()
                .filter(e->isItValid(prefix,e.getName()))
                .sorted(Comparator.comparing(Card::getName).thenComparing(Card::getLevel))
                .collect(Collectors.toList());
    }

    private boolean isItValid(String prefix, String cardName) {
        for (int i = 0; i <prefix.length() ; i++) {
            if(prefix.charAt(i) != cardName.charAt(i)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterable<Card> searchByLevel(int level) {
        return deckOfCards.values()
                .stream()
                .filter(e->e.getLevel() == level)
                .sorted((f,s)->Integer.compare(s.getScore() , f.getScore()))
                .collect(Collectors.toList());
    }

    @Override
    public void heal(int health) {
       Card card = deckOfCards.values().stream()
               .sorted((f,s)->Integer.compare(f.getHealth() , s.getHealth()))
               .findFirst()
               .orElse(null);
       if(card != null){
           int currentHealth = card.getHealth();
           card.setHealth(currentHealth+ health);
       }
    }
}
