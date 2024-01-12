package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private PresentRepository presentRepository = new PresentRepository();
    private HelperRepository helperRepository = new HelperRepository();
    ShopImpl shop = new ShopImpl();

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else {
            throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        for (Helper model : helperRepository.getModels()) {
            if (model.getName().equals(helperName)) {
                model.getInstruments().add(new InstrumentImpl(power));
                return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
            }
        }
        throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        presentRepository.add(new PresentImpl(presentName, energyRequired));
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {

        List<Helper> toCheckTheSize = helperRepository.getModels().stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());
        if (toCheckTheSize.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        Present present = presentRepository.findByName(presentName);
        int currentInstrument = 0;
        for (Helper model : helperRepository.getModels()) {
            if (model.canWork() && model.getEnergy() > 50) {
                shop.craft(present, model);
                List<Instrument>brokenInstruments = model.getInstruments().stream().filter(Instrument::isBroken).collect(Collectors.toList());
                currentInstrument+= brokenInstruments.size();
                if(present.isDone()){
                    break;
                }

            }
        }

        StringBuilder print = new StringBuilder();
        print.append(String.format(PRESENT_DONE,present.getName() , present.isDone() ? "done" : "not done"));
        print.append(String.format(COUNT_BROKEN_INSTRUMENTS,currentInstrument));
        return print.toString();
    }

    @Override
    public String report() {
        StringBuilder print = new StringBuilder();
        List<Present>readyPresents = presentRepository.getModels().stream().filter(Present::isDone).collect(Collectors.toList());
        print.append(String.format("%d presents are done!%n",readyPresents.size()));
        print.append(String.format("Helpers info:%n"));
        for (Helper model : helperRepository.getModels()) {
            print.append(String.format("Name: %s%n",model.getName()));
            print.append(String.format("Energy: %d%n",model.getEnergy()));
            List<Instrument>Instruments = model.getInstruments().stream().filter(e->!e.isBroken()).collect(Collectors.toList());
            print.append(String.format("Instruments: %d not broken left",Instruments.size()));
            print.append(System.lineSeparator());
        }
        return print.toString().trim();
    }
}
