package cz.fit.cvut.portniagin.java.school.student;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private String surname;
    private int yearOfStudy;
    private double GPA;
    private final PersonalID personalID;

    public Student (String name, String surname, int yearOfStudy, double GPA, PersonalID personalID){
        this.name = name;
        this.surname = surname;
        this.yearOfStudy = yearOfStudy;
        this.GPA = GPA;
        this.personalID = personalID;
    }

    public PersonalID getPersonalID() {
        return personalID;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        if(!surname.equals(o.surname)){
            return Objects.compare(surname, o.surname, String::compareTo);
        }if(!name.equals(o.name)){
            return Objects.compare(name, o.name, String::compareTo);
        }if(yearOfStudy != o.yearOfStudy){
            return Integer.compare(yearOfStudy, o.yearOfStudy);
        }
        return Objects.compare(personalID.getPersonalID(), o.personalID.getPersonalID(), String::compareTo);
    }

    @Override
    public String toString(){
        return "Student{" +
                this.name + " " +
                this.surname + "\n" +
                this.yearOfStudy + "\n" +
                "GPA: " + this.GPA + "\n" +
                "PersonalID: " + this.personalID.getPersonalID() + "}\n";
    }
}
