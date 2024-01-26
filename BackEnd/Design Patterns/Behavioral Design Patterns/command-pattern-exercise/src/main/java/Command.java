public abstract class Command {

    protected final Jacket jacket;

    public Command(Jacket jacket){
        this.jacket = jacket;
    }

    abstract void execute();
}
