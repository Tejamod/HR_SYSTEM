package HR_system;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private Phone phone;
    private Address address;
    private List<Role> roles;


    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = new ArrayList<>();
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Phone getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    public List<Role> getRoles() {
        return roles;
    }
}

