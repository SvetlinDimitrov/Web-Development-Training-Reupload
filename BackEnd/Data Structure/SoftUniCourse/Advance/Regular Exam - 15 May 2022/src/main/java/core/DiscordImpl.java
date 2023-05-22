package core;

import models.Message;

import java.util.*;
import java.util.stream.Collectors;

public class DiscordImpl implements Discord {
    Map<String , Message> messageMap;
    Map<String , Set<Message>> chanelMap;

    public DiscordImpl() {
        this.messageMap = new LinkedHashMap<>();
        chanelMap = new LinkedHashMap<>();
    }

    @Override
    public void sendMessage(Message message) {
        Message message1 = messageMap.get(message.getId());
        if(message1 == null){
            messageMap.put(message.getId() , message);
            chanelMap.putIfAbsent(message.getChannel() , new LinkedHashSet<>());
            chanelMap.get(message.getChannel()).add(message);
        }
    }

    @Override
    public boolean contains(Message message) {
        return messageMap.containsKey(message.getId());
    }

    @Override
    public int size() {
        return messageMap.size();
    }

    @Override
    public Message getMessage(String messageId) {
        Message message = messageMap.get(messageId);
        if(message == null){throw new IllegalArgumentException();}
        return message;
    }

    @Override
    public void deleteMessage(String messageId) {
        Message message = getMessage(messageId);
        messageMap.remove(messageId);
        chanelMap.get(message.getChannel()).remove(message);
    }

    @Override
    public void reactToMessage(String messageId, String reaction) {
        Message message = getMessage(messageId);
        message.getReactions().add(reaction);
    }

    @Override
    public Iterable<Message> getChannelMessages(String channel) {
        Set<Message> messages = chanelMap.get(channel);
        if(messages == null || messages.isEmpty()){throw new IllegalArgumentException();}
        return messages;
    }

    @Override
    public Iterable<Message> getMessagesByReactions(List<String> reactions) {
        return messageMap.values().stream()
                .filter(e-> new HashSet<>(e.getReactions()).containsAll(reactions))
                .sorted((f,s) -> {
                    if(f.getReactions().size() != s.getReactions().size()){
                        return s.getReactions().size() - f.getReactions().size();
                    }
                    if(f.getTimestamp() != s.getTimestamp()){
                        return f.getTimestamp() - s.getTimestamp();
                    }
                    return 0;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Message> getMessageInTimeRange(Integer lowerBound, Integer upperBound) {
        return messageMap.values().stream()
                .filter(e->e.getTimestamp() >= lowerBound && upperBound >= e.getTimestamp())
                .sorted((f,s) -> {

                    int chanel1 = chanelMap.get(f.getChannel()).size();
                    int chanel2 = chanelMap.get(s.getChannel()).size();

                    return chanel2 - chanel1;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Message> getTop3MostReactedMessages() {
        return messageMap.values().stream()
                .sorted((f,s) -> s.getReactions().size() - f.getReactions().size())
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Message> getAllMessagesOrderedByCountOfReactionsThenByTimestampThenByLengthOfContent() {
        return messageMap.values().stream()
                .sorted((f,s) -> {
                    if(f.getReactions().size() != s.getReactions().size()){
                        return s.getReactions().size() - f.getReactions().size();
                    }
                    if(f.getTimestamp() != s.getTimestamp()){
                        return f.getTimestamp() - s.getTimestamp();
                    }
                    if(f.getContent().length() != s.getContent().length()){
                        return f.getContent().length() - s.getContent().length();
                    }
                    return 0;
                })
                .collect(Collectors.toList());
    }
}
