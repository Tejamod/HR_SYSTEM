package HR_system;

import org.joda.time.DateTime;

public class Contractor extends Employee{
    private DateTime start;
    private DateTime end;
    private float hourlyRate;

    public Contractor(int id, String firstName, String lastName, DateTime start, DateTime end, float hourlyRate) {
        super(id, firstName, lastName);
        this.start = start;
        this.end = end;
        this.hourlyRate = hourlyRate;
    }


}
