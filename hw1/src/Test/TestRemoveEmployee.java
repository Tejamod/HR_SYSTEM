import HR_system.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TestRemoveEmployee {

    private static HashMap<Integer, Company> storage = new HashMap<>();

    @Test
    public void testRemoveEmployee() {
        int companyId = 1;
        List<Employee> riotEmployees = new ArrayList<>();
        Employee emp1 = new Employee(1, "King", "Bob");
        Address a = new Address(1,"12345","England","Surrey","Redhill","test street","Apt 3");
        emp1.setAddress(a);
        Phone p1 = new Phone(1,"345", "3452345","1");
        emp1.setPhone(p1);

        riotEmployees.add(emp1);
        Employee emp2 = new Employee(2, "Kevin", "Hart");
        Address a2 = new Address(2,"75342","USA","Texas","Dallas","test Street","Apt 4");
        emp2.setAddress(a2);
        Phone p2 = new Phone(2,"335", "3452345","1");
        emp2.setPhone(p2);
        riotEmployees.add(emp2);
        storage.put(1, new Company(1, "Riot Games", riotEmployees));

        List<Employee> epicEmployees = new ArrayList<>();
        Employee emp3 = new Employee(1, "Tim", "Sweeney");
        Address a3 = new Address(3,"75123","USA","California","Los Angeles","test road","Apt 1");
        emp3.setAddress(a3);
        Phone p3 = new Phone(3,"335", "3452345","1");
        emp3.setPhone(p3);
        epicEmployees.add(emp3);

        Employee emp4 = new Employee(1, "Epic", "Guy");
        Address a4 = new Address(4,"75342","Canada","Vancouver","Vancouver","test road","Apt 2");
        emp4.setAddress(a4);
        Phone p4 = new Phone(4,"335", "3452345","1");
        emp4.setPhone(p4);
        epicEmployees.add(emp4);
        storage.put(2, new Company(2, "Epic Games", epicEmployees));
        HRService hrService = new HRService();
        int employeeId = 2;
        Status status = HRService.removeEmployee(companyId, employeeId);
        assertEquals(Status.SUCCESS, status);
    }
}
