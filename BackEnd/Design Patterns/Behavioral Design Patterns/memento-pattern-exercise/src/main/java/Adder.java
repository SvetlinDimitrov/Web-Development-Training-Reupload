public class Adder {

    private int result;

    public void add(int newNumber) {
        result += newNumber;
    }

    public int getResult() {
        return result;
    }

    public void save(History history) {
        history.save(new Memento(getResult()));
    }

    public void undo(Memento memento) {
        if (memento != null) {
            result = memento.getResult();
        }
    }
}
