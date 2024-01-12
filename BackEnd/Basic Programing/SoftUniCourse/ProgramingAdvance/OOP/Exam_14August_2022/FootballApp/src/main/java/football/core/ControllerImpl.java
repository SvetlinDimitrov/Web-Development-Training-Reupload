package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        supplement = new SupplementRepositoryImpl();
        fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        if (fieldType.equals("ArtificialTurf") || fieldType.equals("NaturalGrass")) {
            switch (fieldType) {
                case "ArtificialTurf":
                    fields.add(new ArtificialTurf(fieldName));
                    break;
                case "NaturalGrass":
                    fields.add(new NaturalGrass(fieldName));
                    break;
            }
            return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
        }
        throw new NullPointerException(INVALID_FIELD_TYPE);
    }

    @Override
    public String deliverySupplement(String type) {
        if (type.equals("Powdered") || type.equals("Liquid")) {
            switch (type) {
                case "Liquid":
                    supplement.add(new Liquid());
                    break;
                case "Powdered":
                    supplement.add(new Powdered());
                    break;
            }
            return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
        }
        throw new NullPointerException(INVALID_SUPPLEMENT_TYPE);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supToAdd = supplement.findByType(supplementType);
        if (supToAdd == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        supplement.remove(supToAdd);
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                field.addSupplement(supToAdd);
                break;
            }
        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player playerToAdd;
        String out = "";
        if (playerType.equals("Men") || playerType.equals("Women")) {
            switch (playerType) {
                case "Men":
                    playerToAdd = new Men(playerName, nationality, strength);
                    for (Field field : fields) {
                        if (field.getName().equals(fieldName)) {
                            field.addPlayer(playerToAdd);
                            out = String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
                            break;
                        }
                    }
                    break;
                case "Women":
                    playerToAdd = new Women(playerName, nationality, strength);
                    for (Field field : fields) {
                        if (field.getName().equals(fieldName)) {
                            field.addPlayer(playerToAdd);
                            out = String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
                        }
                    }
                    break;
            }
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        if(out.trim().length() == 0){
            return "The pavement of the terrain is not suitable.";
        }
        return out;
    }

    @Override
    public String dragPlayer(String fieldName) {
        int count = 0;
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                count += field.getPlayers().size();
                break;
            }
        }
        return String.format(PLAYER_DRAG, count);
    }

    @Override
    public String calculateStrength(String fieldName) {
        int strength = 0;
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {

                strength += field.getPlayers().stream()
                        .mapToInt(Player::getStrength)
                        .sum();

                break;
            }
        }
        return String.format(STRENGTH_FIELD, fieldName, strength);
    }

    @Override
    public String getStatistics() {
        StringBuilder print = new StringBuilder();
        for (Field field : fields) {
            print.append(field.getInfo()).append(System.lineSeparator());
        }

        return print.toString().trim();
    }
}
