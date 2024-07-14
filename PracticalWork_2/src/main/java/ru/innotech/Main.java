package ru.innotech;

// В текущем классе отладка на момент разработки. Отдельно разработаны необходимые модульные тесты в классе Tests
public class Main {
    public static void main(String... args) {
        Fraction fr= new Fraction(2,3);
        Fractionable num =Utils.cache(fr);
        num.doubleValue();// sout сработал
        num.doubleValue();// sout молчит
        num.doubleValue();// sout молчит
        num.setNum(5);
        num.doubleValue();// sout сработал
        num.doubleValue();// sout молчит

    }
}