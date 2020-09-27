package lesson1.Boxes;

import lesson1.Fruits.Type.Fruits;
import java.util.ArrayList;

public class BoxForFruits<T extends Fruits> {

    private ArrayList<T> BoxWithFruits = new ArrayList<>();

    public BoxForFruits(T fruit) {
        this.BoxWithFruits.add(fruit) ;
    }

    public BoxForFruits() {

    }

    public void add(Fruits fruit) {
        this.BoxWithFruits.add((T) fruit);
    }


    public float getWeight() {
        float Weight = 0;
        for (Fruits fruit : this.BoxWithFruits) {
            Weight += fruit.getWeight();
        }
        return Weight;
    }

    public boolean compareWeight(BoxForFruits<? extends Fruits> box) {
        return this.getWeight() == box.getWeight();
    }

    public void moveFruitToAnotherBox(BoxForFruits<T> box) {
        if(this == box) return;
        box.BoxWithFruits.addAll(this.BoxWithFruits);
        this.BoxWithFruits.clear();
    }

}
