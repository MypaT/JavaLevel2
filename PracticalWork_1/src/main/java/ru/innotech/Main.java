package ru.innotech;

// В текущем классе отладка на момент разработки. Отдельно разработаны необходимые модульные тесты в классе Tests
public class Main {
    public static void main(String[] args) {
        String name = "AAAAA";
        Account acc = new Account(name);
        System.out.println(acc);
        //printHisroty(acc);

        acc.setCurrencyBalance(Currency.RUB, 100);
        System.out.println(acc);
        //printHisroty(acc);

        //printManualHisroty(acc);

        acc.setName("BBBBB");
        System.out.println(acc);
        //printHisroty(acc);

        acc.setCurrencyBalance(Currency.RUB, 500);
        System.out.println(acc);
        //printHisroty(acc);

        acc.setCurrencyBalance(Currency.EUR, 100);
        System.out.println(acc);
        //printHisroty(acc);

        //printManualHisroty(acc);

        System.out.println("   ");
        System.out.println("-= Отмена обновлений =-");

        for (int i = 0; i < 4; i++) {
            acc.undo();
            System.out.println(acc);
            //printHisroty(acc);
        }
    }
/*
    public static void printManualHisroty(Account account) {
//        System.out.println("acc = " + account);
        System.out.println("   ");
        System.out.println("-= ManualHisroty =-");
        account.saveManualHisroty();
        for (Snapshot linkState : account.getManualHisrotyStates()) {
            System.out.println(linkState);
        }
        System.out.println("-========================-");
        System.out.println("   ");
    }

    public static void printHisroty(Account account) {
//        System.out.println("acc = " + account);
        System.out.println("   ");
        System.out.println("-= Hisroty =-");
        for (Snapshot linkState : account.getHisrotyStates()) {
            System.out.println(linkState);
        }
        System.out.println("-========================-");
        System.out.println("   ");
    }
 */
}