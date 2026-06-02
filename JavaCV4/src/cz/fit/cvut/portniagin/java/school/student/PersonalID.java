package cz.fit.cvut.portniagin.java.school.student;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Calendar;

public class PersonalID {
    protected final String personalID;

    public PersonalID (String dateOfBirth){

        this.personalID = personalID;
    }
    static calculatePersonalID(String dateOfBirth){
        Date tmpDateOfBirth = new Date();
        DateFormat tmpDateFormat = new DateFormat() {
            @Override
            public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
                return null;
            }

            @Override
            public Date parse(String source, ParsePosition pos) {
                return null;
            }
        }

    }

    public String getPersonalID() {
        return personalID;
    }
}
