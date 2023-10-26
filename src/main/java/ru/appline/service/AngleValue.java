package ru.appline.service;

public class AngleValue {

    private final Integer leftVal;

    private final Integer rightVal;

    public AngleValue(Integer leftVal, Integer rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public Integer getLeftVal() {
        return leftVal;
    }

    public Integer getRightVal() {
        return rightVal;
    }
}
