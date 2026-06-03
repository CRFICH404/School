import cz.fit.cvut.portniagin.java.school.student.*;
import java.time.YearMonth;
import java.util.Random;

public class Main {
    static String[] surnamesMale   = {"Novak", "Chmela", "Dostal", "Pospisil", "Pycha"};
    static String[] surnamesFemale = {"Tekulova", "Marketova", "Gromova", "Mormontova", "Kondova"};
    static String[] namesMale      = {"Igor", "Alex", "Marek", "Karel", "George"};
    static String[] namesFemale    = {"Anna", "Olga", "Maria", "Sasha", "Helga"};
    private static final Random random = new Random();

    public static void main(String[] args) {
        School czu = createSchool("ČZU", 24);
        System.out.println(czu);
    }

    private static String randomDateOfBirth() {
        int year   = 1998 + random.nextInt(9);  // 1998–2006
        int month  = 1 + random.nextInt(12);
        int maxDay = YearMonth.of(year, month).lengthOfMonth();
        int day    = 1 + random.nextInt(maxDay);
        return day + "." + month + "." + year;
    }

    public static Student createStudents(boolean isMale, String dateOfBirth) {
        String[] names    = isMale ? namesMale    : namesFemale;
        String[] surnames = isMale ? surnamesMale : surnamesFemale;
        return new Student(
                names[random.nextInt(names.length)],
                surnames[random.nextInt(surnames.length)],
                random.nextInt(1, 4),
                random.nextDouble(1, 5),
                isMale,
                dateOfBirth);
    }

    public static School createSchool(String name, int studentsCount) {
        School school = new School(name);
        for (int i = 0; i < studentsCount; i++) {
            Student student = createStudents(i % 2 == 0, randomDateOfBirth());
            school.addStudents(student);
        }
        return school;
    }
}