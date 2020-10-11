package lesson5;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cyclicBarrier;
    static Object monitor=new Object();
    static boolean winner = false;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cyclicBarrier) {

        this.race = race;
        this.speed = speed;
        this.cyclicBarrier=cyclicBarrier;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
            cyclicBarrier.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);}

            synchronized (monitor){
                if (!winner){
                    winner=true;
                    System.out.println(this.name + " WIN");

                }


            }
            cyclicBarrier.await();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }}
