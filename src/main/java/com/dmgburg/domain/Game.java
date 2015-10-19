package com.dmgburg.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Game {
    String name;
    Date date;
    List<Player> field;
    List<Player> hq;

    public Game(String name, Date date) {
        this.name = name;
        this.date = date;
        field = new ArrayList<>();
        hq = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Player> getField() {
        return field;
    }

    public void setField(List<Player> field) {
        this.field = field;
    }

    public List<Player> getHq() {
        return hq;
    }

    public void setHq(List<Player> hq) {
        this.hq = hq;
    }

    public void addField(Player player){
        field.add(player);
    }

    public void addHq(Player player){
        hq.add(player);
    }
}
