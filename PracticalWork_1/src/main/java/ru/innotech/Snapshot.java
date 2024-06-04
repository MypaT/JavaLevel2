package ru.innotech;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@ToString
public class Snapshot {
    private final String name;
    private final HashMap<Currency, Integer> balance;

    public Snapshot(String name, HashMap<Currency, Integer> balance) {
        this.name = name;
        this.balance = balance;
    }
}
