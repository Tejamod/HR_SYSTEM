package HR_system;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static HR_system.HRService.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        HRService hrService = new HRService();
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do?");
        while (true) {
            System.out.print("1 ");
            Thread.sleep(400);
            System.out.println("-> Show all the employees");
            Thread.sleep(300);
            System.out.print("2 ");
            Thread.sleep(300);
            System.out.println("-> Add an employee to a company");
            Thread.sleep(300);
            System.out.print("3 ");
            Thread.sleep(400);
            System.out.println("-> Remove an employee from a company");
            Thread.sleep(300);
            System.out.print("4 ");
            Thread.sleep(400);
            System.out.println("-> Search for an employee from a company");
            Thread.sleep(300);
            System.out.print("5 ");
            Thread.sleep(400);
            System.out.println("-> Quit");

            int chosen = sc.nextInt();
            if (chosen == 1) {
                System.out.println("Enter the Company ID for the company you want to see the employees of: ");
                int CompId = sc.nextInt();
                HRService.showEmployersOfCompany(CompId);

            }
            if (chosen == 2) {
                System.out.println("Enter the following information");
                System.out.println("Enter companyId of the company where the employer will work");
                int companyId = sc.nextInt();
                String CompanyName = HRService.getCompanyName(companyId);
                System.out.println("The company ID you entered corresponds to " + CompanyName);
                sc.nextLine();
                System.out.println("Enter the employeeId");
                int employeeId = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the employee firstName");
                String firstName = sc.nextLine();
                System.out.println("Enter the employee lastName");
                String lastName = sc.nextLine();
                System.out.println("Choose employee type:"+"\n"+ "1. Contract" +"\n"+ "2. FullTime");
                int employeeTypeChoice = sc.nextInt();
                Employee employeeToBeAdded;
                if (employeeTypeChoice == 1) {
                    System.out.println("Enter start date of employee");
                    DateTime start = JodaTimeInput.jodaTimeInput();
                    System.out.println("Enter end date (expected end date, if unknown) of employee");
                    DateTime end = JodaTimeInput.jodaTimeInput();
                    System.out.println("Enter hourly billing rate of employee");
                    float hourlyRate = sc.nextFloat();
                    employeeToBeAdded = new Contractor(employeeId, firstName, lastName, start, end, hourlyRate);
                } else if (employeeTypeChoice == 2) {
                    System.out.println("Enter start date of employee");
                    DateTime start = JodaTimeInput.jodaTimeInput();
                    System.out.println("Enter yearly base salary of employee");
                    float baseSalaryPerYear = sc.nextFloat();
                    System.out.println("Enter yearly bonus of employee");
                    float bonusPerYear = sc.nextFloat();
                    employeeToBeAdded = new FullTime(employeeId, firstName, lastName, start, baseSalaryPerYear, bonusPerYear);
                } else {
                    System.out.println("That's not right, Try again.");
                    continue;
                }
                System.out.println("Enter the address details:");
                System.out.print("Zip Code: ");
                String zip = sc.nextLine();
                sc.nextLine();
                System.out.print("Country: ");
                String country = sc.nextLine();
                System.out.print("State: ");
                String state = sc.nextLine();
                System.out.print("City: ");
                String city = sc.nextLine();
                System.out.print("Address Line 1: ");
                String line1 = sc.nextLine();
                System.out.print("Address Line 2: ");
                String line2 = sc.nextLine();

                Address address = new Address(employeeId, zip, country, state, city, line1, line2  );

                System.out.println("Enter the phone details:");
                System.out.print("Country Code: ");
                String countryCode = sc.next();
                System.out.print("Area Code: ");
                String areaCode = sc.next();
                System.out.print("Number: ");
                String number = sc.next();

                Phone phone = new Phone(employeeId, areaCode, number, countryCode );

                System.out.println("Enter the roles of this employee :");
                List<Role> roles = new ArrayList<>();
                while (true) {
                    System.out.print("Role ID: ");
                    int roleId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Role Name: ");
                    String roleName = sc.next();
                    roles.add(new Role(roleId, roleName));
                    System.out.print("Do you want to add another role? (yes/no): ");
                    String anotherRole = sc.next().toLowerCase();
                    if (anotherRole.equals("no")) {
                        break;
                    }
                }
                employeeToBeAdded.getRoles().addAll(roles);
                employeeToBeAdded.setAddress(address);
                employeeToBeAdded.setPhone(phone);
                Status status = HRService.addEmployee(companyId, employeeToBeAdded);
                if (status == Status.SUCCESS) {
                    System.out.println("Employee added successfully.");
                } else {
                    System.out.println("Failed to add employee, an employee with the same ID probably exists.");
                }
            }
            if (chosen == 3) {
                System.out.println("Enter the CompanyId");
                Integer companyId = sc.nextInt();
                System.out.println("Enter the employeeId");
                Integer employeeId = sc.nextInt();
                String empName = HRService.getEmployeeName(employeeId,companyId);
                System.out.println(empName +" was fired");
                HRService.removeEmployee( companyId , employeeId);
                Thread.sleep(800);
                System.out.println("This is sad 😢");
                Thread.sleep(800);
            }
            if (chosen == 4) {
                System.out.println("Enter the company ID where you want to search the employee");
                int compId = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the employee's first name");
                String firstName = sc.nextLine();
                System.out.println("Enter the employee's last name");
                String lastName = sc.nextLine();
                List<Employee> result = HRService.search(compId,firstName,lastName);
                if (result.isEmpty()){
                    System.out.println("No employees were found");
                }
                else {
                    System.out.println("--------------------------------------");
                    System.out.println("Company    " + "\t" + HRService.getCompanyName(compId));
                    for (Employee e : result) {
                        Thread.sleep(300);
                        System.out.println("ID        " + "\t" + e.getId());
                        System.out.println("First Name" + "\t" + e.getFirstName());
                        System.out.println("Last Name" + "\t" + e.getLastName());
                        System.out.println("Roles    " + "\t"+ getRolesFromEmployee(e));
                        System.out.println("Phone Number " + "+" + getPhoneFromEmployeeId(e));
                        System.out.println("Address    " + "\t"+getAddressFromEmployeeId(e));
                        Thread.sleep(500);
                        System.out.println("--------------------------------------");

                    }
                }
            }
            if (chosen == 5) {
                System.out.println("Bye 👋");
                break;
            }
            System.out.println("Do you want to do anything else?");
            Thread.sleep(500);
        }
    }
}