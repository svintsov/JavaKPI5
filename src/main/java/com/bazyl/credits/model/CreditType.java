package com.bazyl.credits.model;

public enum CreditType {
    LIGHT(5),LONG(2),FRIENDLY(1);

    private final double percentage;

    CreditType(double percentage){
        this.percentage=percentage;
    }

    public double getPercentage(){
        return percentage;
    }

}
