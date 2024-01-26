import java.util.Stack;

public class History {
    private final Stack<Memento> mementos = new Stack<>();

    public void save(Memento memento){
        mementos.push(memento);
    }

    public Memento restore(){
        if(!mementos.isEmpty()){
            return mementos.pop();
        }
        return null;
    }

}
