package lesson1;

import java.util.ArrayList;
import java.util.Collections;

public class GenericArray<T> {
    T[] obj;

    public GenericArray(T[] obj) {
        this.obj = obj;
    }

    public ArrayList<T> arrayToList() {
        ArrayList<T> arrayList = new ArrayList<T>();
        Collections.addAll(arrayList, this.obj);
        return arrayList;
    }

    public T[] replaceElements(int sourceElementIndex, int targetElementIndex) {
        T[] array = this.obj;
        if (array.length >= sourceElementIndex && array.length > targetElementIndex) {
            T dummy = this.obj[sourceElementIndex];
            array[sourceElementIndex] = array[targetElementIndex];
            array[targetElementIndex] = dummy;
        }
        return array;
    }
}
