package ru.innotech;

import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.*;

class Manager {
    List<Save> saves;
}


@EqualsAndHashCode
@ToString
public class Account {
    @Getter private String name;
    private HashMap<Currency, Integer> balance = new HashMap<>();
    private Deque<Command> saves = new ArrayDeque<>();

    public Account(String name) {
        setName(name);
    }

    public void setName(String name) {
        String curAcc = Account.this.name;
        saves.push(() -> Account.this.name = curAcc);
        this.name = checkName(name);
    }

    public HashMap<Currency, Integer> getBalance() {
        return new HashMap<>(balance);
    }

    public void setCurrencyBalance(Currency currency, Integer sum) {
        if (currency == null) throw new IllegalArgumentException("Ошибка! Введена пустая валюта");
        if (sum < 0) throw new IllegalArgumentException("Ошибка! Введена отрицательная сумма");
        if (balance.containsKey(currency)) {
            int curSum = balance.get(currency);
            saves.push(() -> balance.put(currency, curSum));
        } else {
            saves.push(() -> balance.remove(currency));
        }
        balance.put(currency, sum);
    }

    private String checkName (String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Ошибка! Введено пустое имя");
        return name;
    }

    public Save save() {
        return new AccountSave();
    }

    public void undo() {
        if (saves.size() <= 1) throw new IllegalArgumentException("Отмена обновления невозможна. Данный объект не имеет обновлений!");
        saves.pop().make();
    }


    private class AccountSave implements Save {
        private String name = Account.this.name;
        private final Map<Currency, Integer> balance = new HashMap<>(Account.this.balance);

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Map<Currency, Integer> getBalance() {
            return new HashMap<>(balance);
        }

        @Override
        public void createSave() {
            Account.this.name = name;
            Account.this.balance.clear();
            Account.this.balance.putAll(balance);
        }
    }
}
