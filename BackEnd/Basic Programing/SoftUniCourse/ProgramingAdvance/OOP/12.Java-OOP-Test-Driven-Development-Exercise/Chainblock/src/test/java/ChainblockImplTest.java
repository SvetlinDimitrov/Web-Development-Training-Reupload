import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest{
    Chainblock data ;
    ArrayList<Transaction> transactionList;
    Transaction a1;
    Transaction a2;
    @Before
    public void setUp(){
        data  = new ChainblockImpl();
        transactionList = new ArrayList<>();
        a1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Ivan", "Pesho", 101110.00);
        a2 = new TransactionImpl(10, TransactionStatus.SUCCESSFUL, "Ivan", "Pesho", 101110.00);

    }
    private void FillWithTransactions() {
        Transaction a1 = new TransactionImpl(1 , TransactionStatus.SUCCESSFUL ,"Ivan" , "Pesho" ,101110.00);
        Transaction a2 =  new TransactionImpl(12 , TransactionStatus.SUCCESSFUL ,"Ivan" , "Shao" ,120.2);
        Transaction a3 =  new TransactionImpl(109 , TransactionStatus.FAILED ,"Gosho" , "Shao" ,2);
        Transaction a4 =  new TransactionImpl(509 , TransactionStatus.SUCCESSFUL ,"Mosq" , "Mosq" ,0);
        Transaction a5 =  new TransactionImpl(1902 , TransactionStatus.ABORTED ,"Svetlin" , "Divan" ,4);
        Transaction a6 =  new TransactionImpl(3 , TransactionStatus.ABORTED ,"Divan" , "Svetlin" ,40.00);
        Transaction a7 =  new TransactionImpl(15, TransactionStatus.SUCCESSFUL ,"Dido" , "Bojoxd" ,120.00);
        Transaction a8 =  new TransactionImpl(2 , TransactionStatus.UNAUTHORIZED ,"Divan" , "Bojoxd" ,10000.00);
        Transaction a9 =  new TransactionImpl(11 , TransactionStatus.UNAUTHORIZED ,"Svetlin" , "Divan" ,1000.00);

        data.add(a1);
        data.add(a2);
        data.add(a3);
        data.add(a4);
        data.add(a5);
        data.add(a6);
        data.add(a7);
        data.add(a8);
        data.add(a9);

        transactionList.add(a1);
        transactionList.add(a2);
        transactionList.add(a3);
        transactionList.add(a4);
        transactionList.add(a5);
        transactionList.add(a6);
        transactionList.add(a7);
        transactionList.add(a8);
        transactionList.add(a9);
    }

    @Test
    public void testAdd_TheSizeShouldBeDiff(){
        data.add(a1);
        int expectedSize = 1;
        assertEquals(expectedSize , data.getCount());
    }
    @Test
    public void testAdd_TheSizeShouldBeZero(){
        int expectedSize = 0;
        assertEquals(expectedSize , data.getCount());
    }
    @Test
    public void testAdd_TheMultiAdding(){
        FillWithTransactions();
        int expectedSize = 9;
        assertEquals(expectedSize , data.getCount());
    }
    @Test
    public void testContains_TestingIfTheTransWasAddedCorrectly() {
        data.add(a1);
        assertTrue(data.contains(a1));
    }
    @Test
    public void testContains_ShouldThrowFalseForAnEmptyData() {
        assertFalse(data.contains(a1));
    }
    @Test
    public void testContains_ShouldThrowFalseForNoEqualTrans() {
        data.add(a1);
        assertFalse(data.contains(a2));
    }
    @Test
    public void testGetCount_TheCountShouldReturnZeroForAnEmptyData() {
        int expectedSize =0;
        assertEquals(expectedSize , data.getCount());
    }
    @Test
    public void testGetCount_TheCountShouldReturnTheCorrectSize() {
        data.add(a1);
        data.add(a2);
        int expectedSize =2;
        assertEquals(expectedSize , data.getCount());
    }
    @Test
    public void testContainsByTrans_ShouldReturnTrue() {
        data.add(a1);
        assertTrue(data.contains(a1));
    }
    @Test
    public void testContainsByTrans_ShouldReturnFalse() {
        data.add(a1);
        assertFalse(data.contains(a2));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatus_ShouldThrowException() {
        data.changeTransactionStatus(a2.getId(), TransactionStatus.FAILED);
    }
    @Test
    public void testChangeTransactionStatus_ShouldChangeItCorrectly() {
        data.add(a1);
        data.changeTransactionStatus(a1.getId(), TransactionStatus.ABORTED);
        assertEquals(a1 , data.getById(a1.getId()));
    }
    @Test
    public void testRemoveTransactionById_ShouldRemoveItCorrectly() {
        data.add(a1);
        int expectedSize = 0;
        data.removeTransactionById(a1.getId());
        assertEquals(expectedSize , data.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionById_ShouldThrowException() {
        data.removeTransactionById(a1.getId());
    }
    @Test
    public void testGetById_ShouldGetItCorrectly() {
        data.add(a1);
        Transaction transactionFromData = data.getById(a1.getId());
        assertEquals(a1 , transactionFromData);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetById_ShouldThrowException() {
        data.getById(a1.getId());
    }
    @Test
    public void testGetByTransactionStatus_ShouldReturnOrderedTransByStatusCorrectly() {
        FillWithTransactions();
        TransactionStatus status = TransactionStatus.SUCCESSFUL;

        Iterable<Transaction> orderedTrans =
                transactionList.stream()
                        .filter(e->e.getStatus().equals(status))
                        .sorted(Comparator.comparing(Transaction::getAmount) .reversed())
                        .collect(Collectors.toList());

        assertEquals(orderedTrans , data.getByTransactionStatus(status));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatus_ShouldThrowException() {
        data.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testGetAllSendersWithTransactionStatus_ShouldReturnOrderedTransByStatusCorrectly() {
        FillWithTransactions();
        TransactionStatus status = TransactionStatus.SUCCESSFUL;

        Iterable<String> orderedTrans =
                transactionList.stream()
                        .filter(e->e.getStatus().equals(status))
                        .sorted(Comparator.comparing(Transaction::getAmount) .reversed())
                        .map(Transaction::getFrom)
                        .collect(Collectors.toList());

        assertEquals(orderedTrans , data.getAllSendersWithTransactionStatus(status));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatus_ShouldThrowException() {
        data.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }
    @Test
    public void testGetAllReceiversWithTransactionStatus_ShouldReturnOrderedTransByStatusCorrectly() {
        FillWithTransactions();
        TransactionStatus status = TransactionStatus.SUCCESSFUL;

        Iterable<String> orderedTrans =
                transactionList.stream()
                        .filter(e->e.getStatus().equals(status))
                        .sorted(Comparator.comparing(Transaction::getAmount) .reversed())
                        .map(Transaction::getTo)
                        .collect(Collectors.toList());

        assertEquals(orderedTrans , data.getAllReceiversWithTransactionStatus(status));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatus_ShouldThrowException() {
        data.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }
    @Test
    public void testGetAllOrderedByAmountDescendingThenById_ShouldReturnOrderedTransByStatusCorrectly() {
        FillWithTransactions();

        Iterable<Transaction> orderedTrans =
                transactionList.stream()
                        .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                        .collect(Collectors.toList());

        assertEquals(orderedTrans , data.getAllOrderedByAmountDescendingThenById());
    }
    @Test
    public void testGetBySenderOrderedByAmountDescending_ShouldReturnOrderedSendersByAmount() {
        FillWithTransactions();
        String sender = "Svetlin";

        Iterable<Transaction> orderedTrans =
                transactionList.stream()
                        .filter(e->e.getFrom().equals(sender))
                        .sorted(Comparator.comparing(Transaction::getAmount) .reversed())
                        .collect(Collectors.toList());

        assertEquals(orderedTrans , data.getBySenderOrderedByAmountDescending(sender));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescending_ShouldThrowException() {
        data.getBySenderOrderedByAmountDescending("Svetlin");
    }
    @Test
    public void testGetByReceiverOrderedByAmountThenById_ShouldReturnOrderedToByAmount() {
        FillWithTransactions();
        String to = "Svetlin";

        Iterable<Transaction> orderedTrans =
                transactionList.stream()
                        .filter(e->e.getTo().equals(to))
                        .sorted(Comparator.comparing(Transaction::getAmount) .reversed())
                        .collect(Collectors.toList());

        assertEquals(orderedTrans , data.getByReceiverOrderedByAmountThenById(to));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenById_ShouldThrowException() {
        data.getByReceiverOrderedByAmountThenById("Svetlin");
    }
    @Test
    public void testGetByTransactionStatusAndMaximumAmount_ShouldReturnTransactionsWithTheCorrectStatusOrderedByAmount() {
        FillWithTransactions();
        TransactionStatus status = TransactionStatus.SUCCESSFUL;
        double amount = 1000 ;

        Iterable<Transaction> orderedTrans =
                transactionList.stream()
                        .filter(e->e.getStatus().equals(status))
                        .filter(e->e.getAmount()<=amount)
                        .sorted(Comparator.comparing(Transaction::getAmount) .reversed())
                        .collect(Collectors.toList());

        assertEquals(orderedTrans , data.getByTransactionStatusAndMaximumAmount(status , amount));
    }
    @Test
    public void testGetBySenderAndMinimumAmountDescending_ShouldReturnTransactionsFromTheCorrectSendersBiggerThenTheGivenAmountOrderedByAmount() {
        FillWithTransactions();
        String name = "Divan";
        double amount = 250 ;

        Iterable<Transaction> orderedTrans =
                transactionList.stream()
                        .filter(e->e.getFrom().equals(name))
                        .filter(e->e.getAmount()>=amount)
                        .sorted(Comparator.comparing(Transaction::getAmount) .reversed())
                        .collect(Collectors.toList());

        assertEquals(orderedTrans , data.getBySenderAndMinimumAmountDescending(name , amount));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescending_ShouldThrowException() {
        data.getBySenderAndMinimumAmountDescending("Svetlin" , 20);
    }
    @Test
    public void testGetByReceiverAndAmountRange_ShouldReturnTransactionsFromTheCorrectReceiverBiggerInTheCurrentAmountOrderedByAmountAndId() {
        FillWithTransactions();
        String name = "Divan";
        double lowerAmount = 10 ;
        double maxAmount = 1001;

        Iterable<Transaction> orderedTrans =
                transactionList.stream()
                        .filter(e->e.getTo().equals(name))
                        .filter(e->e.getAmount()>=lowerAmount && e.getAmount() < maxAmount)
                        .sorted(Comparator.comparing(Transaction::getAmount) .reversed().thenComparing(Transaction::getId))
                        .collect(Collectors.toList());

        assertEquals(orderedTrans , data.getByReceiverAndAmountRange(name ,lowerAmount , maxAmount));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRange_ShouldThrowException() {
        data.getByReceiverAndAmountRange("Svetlin" , 20 , 1000);
    }
    @Test
    public void testGetAllInAmountRange_ShouldReturnTransactionsBetweenTheGivenRangeInclusive() {
        FillWithTransactions();
        double lowerAmount = 10 ;
        double maxAmount = 1001;

        Iterable<Transaction> orderedTrans =
                transactionList.stream()
                        .filter(e->e.getAmount()>=lowerAmount && e.getAmount() <= maxAmount)
                        .collect(Collectors.toList());

        assertEquals(orderedTrans , data.getAllInAmountRange(lowerAmount , maxAmount));
    }

}