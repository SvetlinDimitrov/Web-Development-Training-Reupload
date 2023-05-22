package core;

import model.Message;
import model.TextMessage;
import shared.DataTransferSystem;

import java.util.*;
import java.util.stream.Collectors;

public class MessagingSystem implements DataTransferSystem {
    HashMap<Integer , Message> map = new LinkedHashMap<>();
    PriorityQueue<Message> que = new PriorityQueue<>();
    @Override
    public void add(Message message) {
        if(map.containsKey(message.getWeight())){
            throw new IllegalArgumentException();
        }
        map.put(message.getWeight() , message);
        que.add(message);
    }

    @Override
    public Message getByWeight(int weight) {
        if(map.containsKey(weight)){
            return map.get(weight);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Message getLightest() {
        if(map.isEmpty()){
            throw new IllegalArgumentException();
        }
        return que.peek();
    }

    @Override
    public Message getHeaviest() {
        if(map.isEmpty()){
            throw new IllegalArgumentException();
        }

        Message massageToReturn  = null;
        for (Message message : que) {
            massageToReturn = message;
        }
        return massageToReturn ;
    }

    @Override
    public Message deleteLightest() {
        if(size() == 0){
            throw new IllegalArgumentException();
        }
        Message messageToRemove = que.poll();
        map.remove(messageToRemove.getWeight());
        return messageToRemove;
    }

    @Override
    public Message deleteHeaviest() {
        if(map.isEmpty()){
            throw new IllegalArgumentException();
        }

        Message massageToReturn  = null;
        for (Message message : que) {
            massageToReturn = message;
        }
        map.remove(massageToReturn.getWeight());
        que.remove(massageToReturn);
        return massageToReturn ;
    }

    @Override
    public Boolean contains(Message message) {
        return map.containsKey(message.getWeight());
    }

    @Override
    public List<Message> getOrderedByWeight() {
        return new ArrayList<>(que);
    }

    @Override
    public List<Message> getPostOrder() {

        List<Message> toTrack = que.stream()
                .sorted(Comparator.comparing(Message::getWeight))
                .collect(Collectors.toList());;

        List<Message> listToReturn = new ArrayList<>();

        PostOrderRecursive(toTrack , listToReturn , 0);
        return listToReturn;
    }

    private void PostOrderRecursive(List<Message> toTrack, List<Message> listToReturn , int currentIndex) {
        if(currentIndex > toTrack.size()-1){
            return;
        }

        listToReturn.add(toTrack.get(currentIndex));
        PostOrderRecursive(toTrack , listToReturn , (currentIndex *2)+1);
        PostOrderRecursive(toTrack , listToReturn , (currentIndex *2)+2);
    }

    @Override
    public List<Message> getPreOrder() {
        return new ArrayList<>(que);
    }

    @Override
    public List<Message> getInOrder() {
        return new ArrayList<>(que);
    }

    @Override
    public int size() {
        return map.size();
    }
}
