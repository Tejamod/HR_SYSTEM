package HR_system;

import org.joda.time.DateTime;

public class FullTime extends Employee{

    private DateTime start;
    private float baseSalaryPerYear;
    private float bonusPerYear;

    public FullTime(int id, String firstName, String lastName, DateTime start, float baseSalaryPerYear, float bonusPerYear) {
        super(id, firstName, lastName);
        this.start = start;
        this.baseSalaryPerYear = baseSalaryPerYear;
        this.bonusPerYear = bonusPerYear;
    }
}
