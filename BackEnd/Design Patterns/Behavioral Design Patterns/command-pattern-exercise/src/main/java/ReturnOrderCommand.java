public class ReturnOrderCommand extends Command{
    public ReturnOrderCommand(Jacket jacket) {
        super(jacket);
    }

    @Override
    void execute() {
        jacket.returnOrder();
    }
}
