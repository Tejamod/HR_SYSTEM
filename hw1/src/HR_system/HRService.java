package HR_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HRService {

    private static HashMap<Integer, Company> storage = new HashMap<>();

    public HRService() {
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
    }

    public static String getCompanyName(int companyId) {
        return storage.get(companyId).getName();
    }
    public static String getEmployeeName(int EmployeeId, int CompanyId) {
        Company company = storage.get(CompanyId);
        for (Employee e : company.getEmployees()) {
            if (e.getId() == EmployeeId) {
                return e.getFirstName() + " " + e.getLastName();
            }
        }
        return "Employee not found";
    }
    public static Status addEmployee(int companyId, Employee employee) {

        Company company = storage.get(companyId);
        List<Employee> employees = company.getEmployees();
        for (Employee e : employees) {
            if(e.getId()==employee.getId()){
                return Status.FAILURE;
            }
        }
        employees.add(employee);

        return Status.SUCCESS;
    }

    public static Status removeEmployee(int companyId, int employeeID) {

        Company company = storage.get(companyId);
        List<Employee> employees = company.getEmployees();
        for (Employee e : employees) {
            if(e.getId()==employeeID){
                employees.remove(e);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    public static void showEmployersOfCompany(int companyId) throws InterruptedException {

        Company company = storage.get(companyId);
        List<Employee> employees = company.getEmployees();
        System.out.println("---------------------------------------------------------------------");
        for (Employee e : employees) {
            Thread.sleep(300);
            System.out.println("ID        " + "\t" + e.getId());
            System.out.println("First Name" + "\t" + e.getFirstName());
            System.out.println("Last Name" + "\t" + e.getLastName());
            System.out.println("Roles    " + "\t"+getRolesFromEmployee(e));
            System.out.println("Phone Number " + "+" + getPhoneFromEmployeeId(e));
            System.out.println("Address    " + "\t"+getAddressFromEmployeeId(e));
            Thread.sleep(500);
            System.out.println("---------------------------------------------------------------------");

            }
        }

    public static String getRolesFromEmployee(Employee e) {
        List<Role> roles = e.getRoles();
        if (roles.isEmpty() == false) {
            String rolesString = "";
            for (Role role : roles) {
                rolesString += role.getName() + " ";
            }
            return rolesString;
        }
        return "No roles were assigned to this employee!";
    }

        public static String getAddressFromEmployeeId(Employee e){
        String line1 = e.getAddress().getLine1();
        String line2 = e.getAddress().getLine2();
        String city = e.getAddress().getCity();
        String state = e.getAddress().getState();
        String country = e.getAddress().getCountry();
        String zip = e.getAddress().getZip();
            return line1 + ", " + line2 + ", " + city + ", " +  state + ", " + country + ", " + zip;
        }

    public static String getPhoneFromEmployeeId(Employee e){
        String countryCode = e.getPhone().getCountryCode();
        String areaCode = e.getPhone().getAreaCode();
        String number = e.getPhone().getNumber();
        return countryCode + " " + areaCode + number;
    }

    public static List<Employee> search(int companyId, String firstName, String lastName) {
        List<Employee> result = new ArrayList<>();
        Company company = storage.get(companyId);
        if (company != null) {
            for (Employee employee : company.getEmployees()) {
                if (employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
                    result.add(employee);
                }
            }
        }
        return result;
    }

}
