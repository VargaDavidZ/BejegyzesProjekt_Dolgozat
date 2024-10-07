package hu.petrik.bejegyzesprojekt;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Bejegyzes b1 = new Bejegyzes("Dávid","tartalom");
        Bejegyzes b2 = new Bejegyzes("Bob","Bob bejegyzése");

        System.out.println(b1);


       /*  b1.like();
        b1.setTartalom("asd");
        System.out.println(b1);*/


       Tasks T1 = new Tasks();
        T1.myList.add(b1);
        T1.myList.add(b2);

        /*  System.out.println(T1.myList.get(0));*/

        T1.newPost();

        T1.ReadFile("bejegyzesek.csv");

        T1.randomLikes();
        T1.changeSecondPost();

        for(Bejegyzes item: T1.myList)
        {
            System.out.println(item);
        }

        T1.findMostPopular();
        T1.moreThanThirtyFiveLikes();
        T1.lessThanFifteen();
        T1.sortMyList();






    }
}