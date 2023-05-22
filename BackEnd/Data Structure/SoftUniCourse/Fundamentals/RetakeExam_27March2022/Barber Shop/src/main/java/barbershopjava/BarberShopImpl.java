package barbershopjava;

import java.awt.*;
import java.awt.List;
import java.util.*;
import java.util.stream.Collectors;

public class BarberShopImpl implements BarberShop {
    HashMap<String , Barber> barberHashMap ;
    HashMap<String , Client> clientHashMap;
    HashMap<Barber , ArrayList<Client>> shop;

    public BarberShopImpl() {
        barberHashMap = new LinkedHashMap<>();
        clientHashMap = new LinkedHashMap<>();
        shop = new LinkedHashMap<>();
    }

    @Override
    public void addBarber(Barber b) {
        if(barberHashMap.containsKey(b.name)){
            throw new IllegalArgumentException();
        }
        barberHashMap.put(b.name, b);
        shop.put(b , new ArrayList<>());
    }

    @Override
    public void addClient(Client c) {
        if(clientHashMap.containsKey(c.name)){
            throw new IllegalArgumentException();
        }
        clientHashMap.put(c.name, c);
    }

    @Override
    public boolean exist(Barber b) {
        return barberHashMap.containsKey(b.name);
    }

    @Override
    public boolean exist(Client c) {
        return clientHashMap.containsKey(c.name);
    }

    @Override
    public Collection<Barber> getBarbers() {
        return barberHashMap.values();
    }

    @Override
    public Collection<Client> getClients() {
        return clientHashMap.values();
    }

    @Override
    public void assignClient(Barber b, Client c) {
        if(barberHashMap.containsKey(b.name) && clientHashMap.containsKey(c.name)){
            clientHashMap.get(c.name).barber = b;
            shop.get(b).add(c);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void deleteAllClientsFrom(Barber b) {
        if(barberHashMap.containsKey(b.name)){
            for (Client client : shop.get(b)) {
                clientHashMap.get(client.name).barber = null;
            }
            shop.get(b).clear();
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<Client> getClientsWithNoBarber() {
        return getClients().stream().filter(e->e.barber ==null).collect(Collectors.toList());
    }

    @Override
    public Collection<Barber> getAllBarbersSortedWithClientsCountDesc() {
        return shop.entrySet().stream()
                .sorted((f,s) ->Integer.compare(s.getValue().size() , f.getValue().size()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Barber> getAllBarbersSortedWithStarsDescendingAndHaircutPriceAsc() {
        return getBarbers().stream()
                .sorted(Comparator.comparing(Barber::getStars).reversed().thenComparing(Barber::getHaircutPrice))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Client> getClientsSortedByAgeDescAndBarbersStarsDesc() {
        return getClients().stream()
                .filter(e->e.getBarber() != null)
                .sorted((f,s)->{
                    boolean isEqual = Integer.compare(f.age , s.age) == 0;
                    if(isEqual){
                        return Integer.compare(s.barber.stars , f.barber.stars);
                    }
                    return Integer.compare(s.age , f.age);
                })
                .collect(Collectors.toList());
    }
}
