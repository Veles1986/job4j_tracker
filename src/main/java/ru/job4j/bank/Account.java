package ru.job4j.bank;

import java.util.Objects;

/**
 *  Класс является моделью данных для карты банка
 *  Хранит в себе номер карты и баланс карты
 *  @author Veles1986
 *  @version 1.0
 */
public class Account {
    /**
     * Хранение номер карты в {@link String}
     */
    private String requisite;
    /**
     * Хранение баланса карты в double
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Позволяет получить номер карты
     * @return Возвращается номер карты в String
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Позволяет задать новый номер карты
     * @param requisite Задаётся номер карты в String
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Позволяет получить баланс карты
     * @return Возвращается баланс карты в double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Позволяет задать новый баланс карты
     * @param balance Задаётся баланс карты в double
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
