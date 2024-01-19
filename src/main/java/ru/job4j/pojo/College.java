package ru.job4j.pojo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Bekhzod Rakhmonkulov");
        student.setGroupNumber(192);
        LocalDate dateOfAdmission = LocalDate.of(2019, 9, 3);
        student.setDateOfAdmission(dateOfAdmission);
        System.out.println("Name of student: " + student.getName() + System.lineSeparator()
                            + "Group number: " + student.getGroupNumber() + System.lineSeparator()
                            + "Date of Admission: " + student.getDateOfAdmission());
    }
}
