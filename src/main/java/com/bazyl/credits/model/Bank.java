package com.bazyl.credits.model;


import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Bank {
    class DebtComparator implements Comparator<Credit> {

        @Override
        public int compare(Credit c1, Credit c2) {
            return c1.getDebt().compareTo(c2.getDebt());
        }
    }

    public static int freeID = 0;
    private String name;
    private Set<Credit> credits;
    private int id;

    public Bank(String name) {
        this.name = name;
        this.id = freeID;
        freeID++;
        credits = new TreeSet<>(new DebtComparator());
    }

    public void addCredit(Credit credit) {
        credits.add(credit);
    }

    public void deleteCredit(Credit credit) {
        credits.remove(credit);
    }

    public int getId() {
        return id;
    }

    public Set<Credit> getCredits() {
        return credits;
    }

    public String getName() {
        return name;
    }

    public Credit getCreditByID(int id) throws ItemNotFoundException {
        for (Credit credit : credits) {
            if (credit.getId() == id)
                return credit;
        }
        throw new ItemNotFoundException();
    }

    public void sortCredits() {
        Set<Credit> newSet = new TreeSet<>(new DebtComparator());
        newSet.addAll(credits);
        credits = newSet;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bank{");
        sb.append("name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append(", credits=").append(credits);
        sb.append('}');
        return sb.toString();
    }
}
