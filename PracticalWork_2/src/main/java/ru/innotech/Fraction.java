package ru.innotech;

import lombok.Getter;

public class Fraction implements Fractionable{
    private int num;
    private int denum;

    @Getter
    private int counter = 0;

    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }

    @Mutator
    public void setNum(int num) {
        this.num = num;
    }

    @Mutator
    public void setDenum(int denum) {
        this.denum = denum;
    }

    @Override
    @Cache
    public double doubleValue() {
        counter++;
        System.out.println("invoke double value");
        return (double) num/denum;
    }
}

