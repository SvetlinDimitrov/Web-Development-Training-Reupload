package christmasPastryShop.core;

import christmasPastryShop.common.enums.BoothType;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.*;

import static christmasPastryShop.common.ExceptionMessages.*;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Double finalPrice =0.0;
    DelicacyRepository<Delicacy>delicacyRepository ;
    CocktailRepository<Cocktail> cocktailRepository;
    BoothRepository<Booth> boothRepository;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = null;

        if(type.equals("Gingerbread")){
            delicacy = new Gingerbread(name , price);
        }else if (type.equals("Stolen")){
            delicacy = new Stolen(name,price);
        }

        Delicacy checkIfExits = delicacyRepository.getByName(name);

        if(checkIfExits == null ){
            delicacyRepository.add(delicacy);
            return String.format(DELICACY_ADDED,name,type);
        }else {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = null;
        if(type.equals("Hibernation")){
            cocktail = new Hibernation(name,size , brand);
        }else if (type.equals("MulledWine")){
            cocktail = new MulledWine(name , size , brand);
        }

        Cocktail checkIfExits = cocktailRepository.getByName(name);
        if(checkIfExits == null ){
            cocktailRepository.add(cocktail);
            return String.format(COCKTAIL_ADDED,name,brand);
        }else{
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type,name));
        }
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = null;
        if(type.equals("OpenBooth")){
            booth = new OpenBooth(boothNumber , capacity);
        }else if (type.equals("PrivateBooth")){
            booth = new PrivateBooth(boothNumber , capacity);
        }

        Booth checkIfExits = boothRepository.getByNumber(boothNumber);
        if(checkIfExits == null){
            boothRepository.add(booth);
            return String.format(BOOTH_ADDED,boothNumber);
        }else{
            throw new IllegalArgumentException(String.format(BOOTH_EXIST,boothNumber));
        }
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        for (Booth booth : boothRepository.getAll()) {
            if(!booth.isReserved() && booth.getCapacity() >= numberOfPeople){
                booth.reserve(numberOfPeople);
                return String.format(BOOTH_RESERVED,booth.getBoothNumber(),numberOfPeople);
            }
        }
       throw new IllegalArgumentException(String.format(RESERVATION_NOT_POSSIBLE,numberOfPeople));
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth both = boothRepository.getByNumber(boothNumber);
        String bill = String.format(BILL,boothNumber, both.getBill() + both.getPrice());
        finalPrice+=both.getBill() + both.getPrice() ;
        both.clear();
        return bill;
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME,finalPrice);
    }
}
