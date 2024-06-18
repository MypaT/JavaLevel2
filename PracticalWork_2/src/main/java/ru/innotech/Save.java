package ru.innotech;

import java.util.Map;

public interface Save {
    String getName();
    Map<Currency, Integer> getBalance();
    void createSave();
}
