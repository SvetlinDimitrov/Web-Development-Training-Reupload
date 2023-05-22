
public class BoardImpl implements Board {

    public BoardImpl() {

    }

    @Override
    public void draw(Card card) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Boolean contains(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void play(String attackerCardName, String attackedCardName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeDeath() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Card> getBestInRange(int start, int end) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Card> listCardsByPrefix(String prefix) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Card> searchByLevel(int level) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void heal(int health) {
        throw new UnsupportedOperationException();
    }
}
