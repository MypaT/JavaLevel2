package ru.innotech;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@AllArgsConstructor
@ToString
public class Snapshot {
    private final String name;
    private final HashMap<Currency, Integer> balance;
}
