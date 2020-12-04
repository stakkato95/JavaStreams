package com.stakkato95;

import java.util.Date;

public class Person implements Comparable<Person> {

    public int id;
    public String firstName;
    public String lastName;
    public Date birthDate;
    public int salary;
    public double coeficient;

    public int compareTo(Person otherPerson) {
        int compareLastNames = this.lastName.compareTo(otherPerson.lastName);
        if (compareLastNames != 0) {
            return compareLastNames;
        } else {
            return this.firstName.compareTo(otherPerson.firstName);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coefficient) {
        this.coeficient = coefficient;
    }
}
