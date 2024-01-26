public class PlaceOrderCommand extends Command{
    public PlaceOrderCommand(Jacket jacket) {
        super(jacket);
    }

    @Override
    public void execute() {
           jacket.placeOrder();
    }
}
