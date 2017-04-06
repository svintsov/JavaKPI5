package com.bazyl.credits.controller;

import com.bazyl.credits.model.Credit;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class DBController {
    class DebtComparator implements Comparator<Credit> {
        @Override
        public int compare(Credit c1, Credit c2) {
            return c1.getDebt().compareTo(c2.getDebt());
        }
    }

    Connection connection;
    Statement query;
    PreparedStatement deleteQuery;
    PreparedStatement updateDebtQuery;

    public DBController() {
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" +
                    "new_schema", "root", "йцфыяч45");
            query = connection.createStatement();
            deleteQuery = connection.prepareStatement("DELETE FROM credits " +
                    "WHERE id = ?");
            updateDebtQuery = connection.prepareStatement("UPDATE credits " +
                    "SET debt = ? WHERE id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Set<Credit> retreiveAllCredits() {
        ResultSet resultSet;
        Set<Credit> newSet = new TreeSet<>(new DebtComparator());
        try {
            resultSet = query.executeQuery("SELECT * FROM credits");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                BigDecimal debt = resultSet.getBigDecimal("debt");
                double percentage = resultSet.getDouble("percentage");
                GregorianCalendar expirationDate = new GregorianCalendar();
                expirationDate.setTime(resultSet.getDate("expiration_date"));
                newSet.add(new Credit(Currency.getInstance(Locale.US), expirationDate, debt, percentage));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newSet;
    }

    public void closeCredit(int id) {
        try {
            deleteQuery.setInt(1, id);
            deleteQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void increaseDebt(BigDecimal debt, int id) {
        try {
            updateDebtQuery.setBigDecimal(1, debt);
            updateDebtQuery.setInt(2, id);
            updateDebtQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
