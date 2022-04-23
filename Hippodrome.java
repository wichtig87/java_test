package hippodrome;
//package com.javarush.task.task21.task2113;
import java.util.List;
        import java.util.*;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;
    public Hippodrome(List<Horse> horses){
        this.horses = horses;


    }
    public List<Horse> getHorses(){
        return horses;
    }
    public void run() throws InterruptedException{
        for(int i = 0;i<100;i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for(Horse horse : horses){
            horse.move();
        }
    }
    public void print(){
        for(Horse horse : horses){
            horse.print();

        }
        for(int i = 0;i<10;i++){
            System.out.println("");
        }

    }
    public Horse getWinner(){
        Horse winner = new Horse("Winner", 0.0, 0.0);
        for(Horse horse : horses){
            if(horse.getDistance()>winner.getDistance())
                winner = horse;
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");

    }
    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<Horse>();

        Horse horse1 = new Horse("Звезда", 3.0, 0.0);
        Horse horse2 = new Horse("Молния", 3.0, 0.0);
        Horse horse3 = new Horse("Птица", 3.0, 0.0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
