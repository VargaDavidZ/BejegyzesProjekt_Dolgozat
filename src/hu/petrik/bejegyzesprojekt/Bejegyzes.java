package hu.petrik.bejegyzesprojekt;

import java.time.LocalDateTime;

public class Bejegyzes {

    private String szerzo;
    private String tartalom;
    private Integer likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;


    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = letrejott;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.szerkesztve = LocalDateTime.now();
    }

    public Integer getLikeok() {
        return likeok;
    }

    public void setLikeok(Integer likeok) {
        this.likeok = likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public void setLetrejott(LocalDateTime letrejott) {
        this.letrejott = letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void setSzerkesztve(LocalDateTime szerkesztve) {
        this.szerkesztve = szerkesztve;
    }

    public void like()
    {
        this.likeok++;
    }


    @Override
    public String toString() {
        if(this.letrejott == this.szerkesztve)

        {
            return this.szerzo + " - " + this.likeok + " - "  + this.letrejott  +  "\n" + this.tartalom;

        }
        else
        {
            return this.szerzo + " - " + this.likeok + " - "  + this.letrejott  +"\n" + "Szerkesztve: " + this.szerkesztve + "\n" + this.tartalom;

        }
    }


}
