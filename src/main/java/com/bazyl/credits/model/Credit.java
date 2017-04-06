package com.bazyl.credits.model;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;

public class Credit {
    public static int freeID = 0;

    private Currency currency;
    private GregorianCalendar expirationDate;
    private GregorianCalendar registrationDate;
    private BigDecimal debt;
    private double percentage;
    private int id;


    public Credit() {
        registrationDate = new GregorianCalendar();
        this.id = freeID;
        freeID++;
    }

    public Credit(Currency currency, GregorianCalendar expirationDate, BigDecimal debt, double percentage) {
        this();
        this.currency = currency;
        this.expirationDate = expirationDate;
        this.debt = debt;
        this.percentage = percentage;
    }

    public void increaseDebt(BigDecimal delta) {
        debt = debt.add(delta);
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public BigDecimal getTotalAmountOfDebt() {
        int years = getTimeDuration();
        debt = debt.add(debt.multiply(new BigDecimal(percentage)));
        debt = debt.multiply(new BigDecimal(years));
        return debt;
    }

    public int getId() {
        return id;
    }

    public int getTimeDuration() {
        return expirationDate.get(Calendar.YEAR) - registrationDate.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Credit{");
        DateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
        sb.append("\n id=").append(id);
        sb.append("\n currency=").append(currency);
        sb.append("\n expirationDate=").append(formatter.format(expirationDate.getTime()));
        sb.append("\n registrationDate=").append(formatter.format(registrationDate.getTime()));
        sb.append("\n debt=").append(debt);
        sb.append("\n percentage=").append(percentage);
        sb.append("}\n");
        return sb.toString();
    }
}
