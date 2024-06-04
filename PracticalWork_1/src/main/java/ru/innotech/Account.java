package ru.innotech;

import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.LinkedList;

@Getter
@EqualsAndHashCode
@ToString
public class Account {
    private String name;
    private HashMap<Currency, Integer> balance = new HashMap<>();
    private LinkedList<Snapshot> hisrotyStates = new LinkedList<>();
    private LinkedList<Snapshot> manualHisrotyStates = new LinkedList<>();

    public Account(String name) {
        this.name = checkName(name);
        saveState(hisrotyStates);
    }

    public void setName(String name) {
        this.name = checkName(name);
        saveHisroty();
    }

    public void setCurrencyBalance(Currency currency, Integer sum) {
        if (sum < 0) throw new IllegalArgumentException("Ошибка! Введена отрицательная сумма");

        balance.put(currency, sum);
        saveHisroty();
    }

    private String checkName (String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Ошибка! Введено пустое имя");
        return name;
    }

    public Snapshot saveState(LinkedList<Snapshot> states) {
        HashMap<Currency, Integer> curBalance = new HashMap<>();

        for (Currency currency : balance.keySet()) {
            curBalance.put(currency, balance.get(currency));
        }

        Snapshot snapshot = new Snapshot(name, curBalance);
        states.add(snapshot);
        return snapshot;
    }

    private void saveHisroty() {
        saveState(hisrotyStates);
    }

    public Snapshot saveManualHisroty() {
        return saveState(manualHisrotyStates);
    }

    public void undo() {
        if (hisrotyStates.size() <= 1) throw new IllegalArgumentException("Отмена обновления невозможна. Данный объект не имеет обновлений!");

        hisrotyStates.removeLast();

        Snapshot last = hisrotyStates.getLast();

        name = last.getName();
        balance = last.getBalance();
    }
}
