package ru.innotech;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Tests {
    @Test
    public void createAccountWithName () {
        String name = "Vasya";
        Account account = new Account(name);
        if (!account.getName().equals(name) || account.getBalance().size() > 0)
            throw new RuntimeException("Test error!");
    }

    @Test
    public void createAccountNameIsNull () {
        String name = new String();
        try {
            Account account = new Account(name);
        } catch (IllegalArgumentException e) {return;}
            throw new RuntimeException("Test error!");
    }

    @Test
    public void setName () {
        Account account = new Account("Vasya");
        try {
            account.setName(" ");
        } catch (IllegalArgumentException e) {return;}
        throw new RuntimeException("Test error!");
    }

    @Test
    public void createAccountNameIsSpace () {
        String name = " ";
        try {
            Account account = new Account(name);
        } catch (IllegalArgumentException e) {return;}
        throw new RuntimeException("Test error!");
    }

    @Test
    public void addPositiveSum () {
        Account account = new Account("Vasya");
        Currency currency = Currency.RUB;
        int sum = 100;
        account.setCurrencyBalance(currency, sum);
        int savedSum = account.getBalance().get(currency);
        if (savedSum <= 0 || savedSum != sum)
            throw new RuntimeException("Test error!");
    }

    @Test
    public void addNegativeSum () {
        Account account = new Account("Vasya");
        Currency currency = Currency.RUB;
        int sum = -100;
        try {
            account.setCurrencyBalance(currency, sum);
        } catch (IllegalArgumentException e) {return;}
        throw new RuntimeException("Test error!");
    }

    @Test
    public void undoAccount () {
        String name = "Vasya";
        Currency currencyRUB = Currency.RUB;
        int sum = 100;
        Account account = new Account(name);
        account.setCurrencyBalance(currencyRUB, sum);
        account.setCurrencyBalance(currencyRUB, 200);

        account.undo();
        if (!account.getName().equals(name) || account.getBalance().size() != 1 ||
                !account.getBalance().containsKey(currencyRUB) || !account.getBalance().get(currencyRUB).equals(sum))
            throw new RuntimeException("Test error!");

        account.undo();
        if (!account.getName().equals(name) || account.getBalance().size() != 0)
            throw new RuntimeException("Test error!");
    }

    @Test
    public void undoAccountImpossible () {
        Account account = new Account("Vasya");
        try {
            account.undo();
        } catch (IllegalArgumentException e) {return;}
        throw new RuntimeException("Test error!");
    }

    @Test
    public void save () {
        String name = "Vasya";
        Currency currencyRUB = Currency.RUB;
        int sum = 100;
        Account account = new Account(name);
        account.setCurrencyBalance(currencyRUB, sum);
        Save save = account.save();
        account.setCurrencyBalance(currencyRUB, 200);

        if (!save.getName().equals(name) || save.getBalance().size() != 1 ||
                !save.getBalance().containsKey(currencyRUB) || !save.getBalance().get(currencyRUB).equals(sum))
            throw new RuntimeException("Test error!");
    }
}

