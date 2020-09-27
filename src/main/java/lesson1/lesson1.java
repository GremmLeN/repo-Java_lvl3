package lesson1;

import lesson1.Boxes.BoxForFruits;
import lesson1.Fruits.Apple;
import lesson1.Fruits.Banana;
import lesson1.Fruits.Orange;
import java.util.Arrays;


public class lesson1 {


    public static void main(String[] args) {

        Array();
        FruitsBoxes();

    }

    public static void Array() {

        GenericArray<Integer> genericArray = new GenericArray<>(new Integer[]{1, 2, 3, 4, 5,});
        GenericArray<String> genericArray1 = new GenericArray<>(new String[]{"Test1", "Test2", "Test3", "Test4"});

        System.out.println(genericArray.arrayToList());
        System.out.println(genericArray1.arrayToList());
        System.out.println(Arrays.toString(genericArray.replaceElements(1, 4)));
        System.out.println(Arrays.toString(genericArray1.replaceElements(1,3)));

    }

    public static void FruitsBoxes() {

        BoxForFruits<Apple> boxWithApples = new BoxForFruits<>();
        BoxForFruits<Orange> boxWithOranges = new BoxForFruits<>();

        for (int i = 0; i < 5; i++) {
            boxWithApples.add(new Apple());
            boxWithOranges.add(new Orange());
        }

        BoxForFruits<Orange> newBoxForOrange = new BoxForFruits<>();
        boxWithOranges.moveFruitToAnotherBox(newBoxForOrange);

        System.out.println(boxWithApples.getWeight());
        System.out.println(boxWithOranges.getWeight());

        System.out.println(boxWithApples.compareWeight(boxWithOranges));


    }

}
