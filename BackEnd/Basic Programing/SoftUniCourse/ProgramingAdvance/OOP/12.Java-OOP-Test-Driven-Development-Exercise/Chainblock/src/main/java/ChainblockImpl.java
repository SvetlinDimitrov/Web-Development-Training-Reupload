import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{
    Map<Integer , Transaction> map ;

    public ChainblockImpl() {
        map =  new LinkedHashMap<>();
    }
    public int getCount() {
        return map.size();
    }
    public void add(Transaction transaction) {
        map.putIfAbsent(transaction.getId() , transaction);
    }
    public boolean contains(Transaction transaction) {
        return map.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return map.containsKey(id);
    }
    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if(map.containsKey(id)){
            map.get(id).setStatus(newStatus);
            return;
        }
        throw new IllegalArgumentException();
    }
    public void removeTransactionById(int id) {
        if(map.containsKey(id)){
            map.remove(id);
            return;
        }
        throw new IllegalArgumentException();
    }
    public Transaction getById(int id) {
        if(map.containsKey(id)){
            return map.get(id);
        }
        throw new IllegalArgumentException();
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {

        List<Transaction> transactionList =
                map.values().stream()
                        .filter(e->e.getStatus().equals(status))
                        .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                        .collect(Collectors.toList());

        if(transactionList.isEmpty()){
            throw new IllegalArgumentException();
        }
        return transactionList;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {

        List<String> transactionList =
                map.values().stream()
                        .filter(e->e.getStatus().equals(status))
                        .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                        .map(Transaction::getFrom)
                        .collect(Collectors.toList());

        if(transactionList.isEmpty()){
            throw new IllegalArgumentException();
        }
        return transactionList;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {

        List<String> transactionList =
                map.values().stream()
                        .filter(e->e.getStatus().equals(status))
                        .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                        .map(Transaction::getTo)
                        .collect(Collectors.toList());

        if(transactionList.isEmpty()){
            throw new IllegalArgumentException();
        }
        return transactionList;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {

        return map.values().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {

        List<Transaction> list= map.values().stream()
                .filter(e-> e.getFrom().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        if(list.isEmpty()){
            throw new IllegalArgumentException();
        }
        return list ;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {

        List<Transaction> list= map.values().stream()
                .filter(e-> e.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        if(list.isEmpty()){
            throw new IllegalArgumentException();
        }
        return list ;

    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {

        return map.values().stream()
                .filter(e-> e.getStatus().equals(status))
                .filter(e->e.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {

        List<Transaction> transactionList = map.values().stream()
                .filter(e->e.getFrom().equals(sender))
                .filter(e->e.getAmount() > amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if(transactionList.isEmpty()){
            throw new IllegalArgumentException();
        }
        return transactionList;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {

        List<Transaction> transactionList = map.values().stream()
                .filter(e->e.getTo().equals(receiver))
                .filter(e->e.getAmount() >= lo && e.getAmount() <hi)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        if(transactionList.isEmpty()){
            throw new IllegalArgumentException();
        }
        return transactionList;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {

        return map.values().stream()
                .filter(e->e.getAmount() >=lo && e.getAmount() <=hi)
                .collect(Collectors.toList());

    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
