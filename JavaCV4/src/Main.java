import cz.fit.cvut.portniagin.java.school.student.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class Main {
    static String [] surnamesMale = {"Novak", "Chmela", "Dostal", "Pospisil", "Pycha"};
    static String [] surnamesFemale = {"Tekulova", "Marketova", "Gromova", "Mormontova", "Kondova"};
    static String [] namesMale = {"Igor", "Alex", "Marek", "Karel", "George"};
    static String [] namesFemale = {"Anna", "Olga", "Maria", "Sasha", "Helga"};
    private final static Random random = new Random();
    public static void main(String[] args) {

        School czu = createSchool("ČZU", 24);
        System.out.println(czu);




    }
    public static Student createStudents (boolean isMale, String personalID){
        if(isMale){
            return new Student(namesMale[random.nextInt(namesMale.length)],
                    surnamesMale[random.nextInt(surnamesMale.length)],
                    random.nextInt(1, 4),
                    random.nextDouble(1,5),
                    new PersonalID(personalID));
        }
        else {
            return new Student(namesFemale[random.nextInt(namesFemale.length)],
                    surnamesFemale[random.nextInt(surnamesFemale.length)],
                    random.nextInt(1,4),
                    random.nextDouble(1,5),
                    new PersonalID(personalID));
        }
    }
    public static School createSchool(String name, int studentsCount)  {
        int numOfBoys = studentsCount/2;
        School school = new School(name);
        for (int i = 0; i < studentsCount; i++)  {
            if (i % 2 == 0) {
                Student student = createStudents(true, "rc" + i);
                school.addStudents(student);
            }  else  {
                Student student = createStudents(false, "rc" + i);
                school.addStudents(student);
            }
        }
        return school;
    }

}