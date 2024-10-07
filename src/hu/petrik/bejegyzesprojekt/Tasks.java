package hu.petrik.bejegyzesprojekt;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Tasks {
    List<Bejegyzes> myList = new ArrayList<>();

    public Tasks() {
    }



    public void newPost()
    {
        System.out.print("Hány bejegyzést szeretne felvenni?: ");
        Scanner scan = new Scanner(System.in);

        int myNum = 0;
        try{
             myNum = Integer.parseInt(scan.nextLine()) ;
        }
        catch (Exception e)
        {
            System.out.println("A megadott szám nem lehet tört");
        }


        if(myNum < 0)
        {
            System.out.println("A megadátt szám nem lehet negatív");
            return;
        }


        for(int i = 0 ; i < myNum; i++ )
        {
            System.out.print("Szerző: ");
            String author = scan.nextLine();
            System.out.print("Tartalom");
            String content = scan.nextLine();

            myList.add(new Bejegyzes(author,content));

        }

    }


    public void ReadFile(String path)
    {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line = reader.readLine();
            while(line != null && !line.isEmpty())
            {

                String[] segment = line.split(";");

                myList.add(new Bejegyzes(segment[0],segment[1]));
                line = reader.readLine();

            }

            reader.close();
            }
            catch(IOException e){
                throw new RuntimeException(e);
        }

    }


    public void randomLikes()
    {
        Random rng = new Random();
        int likeAmount = myList.size() * 20;

        for(int i = 0; i < likeAmount; i++)
        {
           int myNum = rng.nextInt(myList.size() - 1 + 1) + 0;
           myList.get(myNum).like();
        }





    }

    public void changeSecondPost()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Adj meg egy szöveget: ");
        String myText = scan.nextLine();
        myList.get(1).setTartalom(myText);


    }


    public void findMostPopular()
    {
        int highestLikes = 0;
        int highestIndex = 0;

        for(int i = 0; i < myList.size(); i++)
        {
            if(myList.get(i).getLikeok() > highestLikes)
            {
                highestLikes = myList.get(i).getLikeok();
                highestIndex = i;
            }

        }

        System.out.println("A legtöbb like egy bejegyzésen: " + highestLikes);

    }

    public void moreThanThirtyFiveLikes()
    {
        boolean higher = false;

        for(Bejegyzes item: myList)
        {
            if(item.getLikeok() > 35)
            {
                higher = true;
            }
        }

        if(higher)
        {
            System.out.println("Van olyan bejegyzés ami több mint 35 likeot kapott");
        }
        else
        {
            System.out.println("Nincs olyan bejegyzés ami több mint 35 likeot kapott");
        }

    }

    public void lessThanFifteen()
    {
        int counter = 0;

        for(Bejegyzes item: myList)
        {
            if(item.getLikeok() > 35)
            {
                counter++;
            }
        }

        System.out.println(counter + " darab olyan bejegyzés van ami kevesebb mint 15 likeot kapott");
    }


    public void sortMyList()
    {
        Collections.sort(myList, new Comparator<Bejegyzes>() {
            @Override
            public int compare(Bejegyzes o1 , Bejegyzes o2) {
                return o2.getLikeok().compareTo(o1.getLikeok());
            }
        });

        for(Bejegyzes item: myList)
        {
            System.out.println(item.getLikeok());
        }

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("bejegyzések_rendezett.txt"));

            for(Bejegyzes item: myList)
            {
                bw.write(item.toString() + "\n");
            }


            bw.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }



    }




}
