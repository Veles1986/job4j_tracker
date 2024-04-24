package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс является моделью данных для клиента банка
 * Хранит в себе паспортные данные и имя клиента
 * @author Veles1986
 * @version 1.0
 */
public class User {
    /**
     * Хранение паспортнных данных в {@link String}
     */
    private String passport;
    /**
     * Хранение имени клиента в {@link String}
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить паспортные данные клиента
     * @return возвращаются паспортные данные клиента в {@link String}
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет изменять паспортные данные клиента
     * @param passport на вход принимаются новые паспортные данные в {@link String}
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить имя клиента
     * @return возвращается имя клиента в {@link String}
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет изменять имя клиента
     * @param username на вход принимаются новое имя в {@link String}
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
