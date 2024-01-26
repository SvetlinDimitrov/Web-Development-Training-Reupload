public class SalesOrderClient {

  private static Jacket jacket = new Jacket();

  public static void main(String[] args) {

    OrderHandler orderHandler = new OrderHandler();

    orderHandler.invoke(new PlaceOrderCommand(jacket));
    orderHandler.invoke(new ReturnOrderCommand(jacket));
  }


}
