package JavaAdvance.Workshop_Custom_Data_Structures;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

public class SmartArray {
    private int [] saveStorage;
    private int index ;
    private int length;

    public SmartArray (){
        index = 0;
        length=4;
        saveStorage = new  int [length];
    }

    private void grow(int[] saveStorage) {
        int newLength = length * 2;
        int [] newArr = new int [newLength];
        for (int i = 0; i < length; i++) {
            newArr[i] = saveStorage[i];
        }
        this.saveStorage = Arrays.stream(newArr).toArray();
        length = newLength;
    }

    private boolean ValidIndex(int index) {
        return index >= 0 && index<=this.index -1;
    }

    public void remove(int indexToRemove){
        if(!ValidIndex(indexToRemove)) {
            throw new IndexOutOfBoundsException();
        }
        saveStorage[indexToRemove] = 0;
        for (int i = indexToRemove; i <index-1 ; i++) {
            saveStorage[i] = saveStorage[i+1];
        }
        index--;

    }

    public void add(int num){
        if(index == saveStorage.length){
            grow(saveStorage);
        }
        saveStorage[index] = num;
        index++;
    }

    public void add(int elementToAdd , int indexAt){
        if(!ValidIndex(indexAt)){
            throw new IndexOutOfBoundsException();
        }
        if(index == saveStorage.length){
            grow(saveStorage);
        }
        index++;

        int [] addArrNew = new int [saveStorage.length];
        for (int i = 0; i < indexAt; i++) {
            addArrNew[i] = saveStorage[i];
        }
        addArrNew[indexAt] = elementToAdd;
        for (int i = indexAt+1; i < saveStorage.length; i++) {
            addArrNew[i] = saveStorage[i-1];
        }
        this.saveStorage = Arrays.stream(addArrNew).toArray();
    }

    public int get(int index){
        if(!ValidIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        return saveStorage[index];
    }

    public boolean contains(int indexToCheck){
        return ValidIndex(indexToCheck);
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < index; i++) {
            consumer.accept(saveStorage[i]);
        }
    }
}
