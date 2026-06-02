package cz.fit.cvut.portniagin.java.school.student;

import java.util.HashSet;
import java.util.Set;

public class School {
    private final String name;
    protected Set<Student> students = new HashSet<>();
    public School (String name){
        this.name = name;
    }
    public void addStudents (Student ... students){
        for (Student student : students) {
            this.students.add(student);
        }
    }

    @Override
    public String toString() {
        return  name + '\n' +
                students;
    }
}
