package cz.fit.cvut.portniagin.java.school.student;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class PersonalID {
    protected final String personalID;
    private static final Random RANDOM = new Random();

    public PersonalID(String dateOfBirth, boolean male) {
        this.personalID = calculatePersonalID(dateOfBirth, male);
    }

    private static String calculatePersonalID(String dateOfBirth, boolean male) {
        String[] parts = dateOfBirth.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid date format, expected D.M.YYYY: " + dateOfBirth);
        }

        int day, month, year;
        try {
            day   = Integer.parseInt(parts[0].trim());
            month = Integer.parseInt(parts[1].trim());
            year  = Integer.parseInt(parts[2].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Non-numeric date components: " + dateOfBirth, e);
        }

        if (day <= 0 || month <= 0 || year <= 0) {
            throw new IllegalArgumentException("Date components must be positive: " + dateOfBirth);
        }

        // Validates month range, day-in-month, and leap-year rules
        try {
            LocalDate.of(year, month, day);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date: " + dateOfBirth, e);
        }

        // Women have 50 added to the month (e.g. June → 56)
        int encodedMonth = male ? month : month + 50;
        int yy = year % 100;
        // %02d zero-pads single-digit values: 1.5.1977 → "770501"
        String datePart = String.format("%02d%02d%02d", yy, encodedMonth, day);
        String suffix = generateSuffix(year, datePart);

        return datePart + "/" + suffix;
    }

    private static String generateSuffix(int year, String datePart) {
        if (year < 1954) {
            // 3-digit suffix only, no check digit
            return String.format("%03d", RANDOM.nextInt(1000));
        }

        // From 1954: 4-digit suffix where the last digit is a check digit.
        // Check digit = (9-digit number YYMMDDXXX) % 11.
        // Exception: if that remainder equals 10, use 0 instead (number won't be divisible by 11).
        int first3 = RANDOM.nextInt(1000);
        long nineDigits = Long.parseLong(datePart) * 1000 + first3;
        long remainder = nineDigits % 11;
        int checkDigit = (remainder == 10) ? 0 : (int) remainder;

        return String.format("%03d%d", first3, checkDigit);
    }

    @Override
    public String toString() {
        return personalID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalID)) return false;
        PersonalID other = (PersonalID) o;
        return Objects.equals(personalID, other.personalID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalID);
    }

    public String getPersonalID() {
        return personalID;
    }
}
