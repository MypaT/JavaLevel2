package ru.innotech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Tests {
    @Test
    public void createFractionNotRunCache() {
        Fraction fr = new Fraction(2,3);
        Fractionable num = Utils.cache(fr);
        int cacheCounter = fr.getCounter();
        num.doubleValue();
        Assertions.assertEquals(cacheCounter+1, fr.getCounter());
    }
    @Test
    public void setNumNotRunCache() {
        Fraction fr = new Fraction(2,3);
        Fractionable num = Utils.cache(fr);
        num.doubleValue();
        int cacheCounter = fr.getCounter();
        num.setNum(5);
        num.doubleValue();
        Assertions.assertEquals(cacheCounter+1, fr.getCounter());
    }

    @Test
    public void setDenumNotRunCache() {
        Fraction fr = new Fraction(2,3);
        Fractionable num = Utils.cache(fr);
        num.doubleValue();
        int cacheCounter = fr.getCounter();
        num.setDenum(5);
        num.doubleValue();
        Assertions.assertEquals(cacheCounter+1, fr.getCounter());
    }

    @Test
    public void runCache() {
        Fraction fr = new Fraction(2,3);
        Fractionable num = Utils.cache(fr);
        num.doubleValue();
        int cacheCounter = fr.getCounter();
        num.doubleValue();
        Assertions.assertEquals(cacheCounter, fr.getCounter());
    }
}

