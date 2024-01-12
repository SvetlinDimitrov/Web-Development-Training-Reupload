package JavaAdvance.Exercises_Iterators_and_Comparators.Froggy_04;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Froggy implements Iterable<Integer>{
    private List<Integer> elements;


    public Froggy(Integer...elements){
        this.elements = Arrays.asList(elements);
    }


    @Override
    public Iterator<Integer> iterator() {
        return new FrogIterator();
    }

    private class FrogIterator implements Iterator<Integer>{

        List<Integer> copyEven = elements;
        List<Integer> copyOdd = elements;
        boolean isTrue =false;
        int index=0;

        @Override
        public boolean hasNext() {
            if(!isTrue){
                if(index <= copyEven.size()-1){
                    return true;
                }else{
                    index = 1;
                    isTrue =true;
                }
            }
            if(index <= copyOdd.size()-1){
                return true;
            }
            return false;
        }

        @Override
        public Integer next() {
            if(!isTrue){
                Integer toReturn = copyEven.get(index);
                index+=2;
                return toReturn;
            }else{
                Integer toReturn = copyOdd.get(index);
                index+=2;
                return toReturn;
            }
        }
    }
}
