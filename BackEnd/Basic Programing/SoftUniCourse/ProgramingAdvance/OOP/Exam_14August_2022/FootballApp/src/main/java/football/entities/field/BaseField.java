package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field{
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        supplements = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void setName(String name) {
        if(null == name || name.trim().length() == 0){
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int sumEnergy() {
        return supplements.stream()
                .mapToInt(Supplement::getEnergy)
                .sum();
    }

    @Override
    public void addPlayer(Player player) {
        if(capacity <=players.size()){
            throw new IllegalStateException("Not enough capacity.");
        }
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder print = new StringBuilder();
        print.append(String.format("%s (%s):%n",name , getClass().getSimpleName()));
        String player = players.isEmpty() ? "none" : players.stream().map(Player::getName).collect(Collectors.joining(" "));
        print.append(String.format("Player: %s%n",player));
        print.append(String.format("Supplement: %d%n",supplements.size()));
        print.append(String.format("Energy: %d",sumEnergy()));
        return print.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public String getName() {
        return name;
    }
}
